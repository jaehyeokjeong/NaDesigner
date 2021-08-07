package org.embedded.hnu.generator.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.embedded.hnu.ioconfig.HComponentConfig;

public class HManifestGenerator {
        
    public static final int H_SNN = 1;  
    public static final int H_ANN = 2;   
    public static final int H_IoT = 3;    
    
    public static final int HNUM_PRJ = 1;
    public static final int HNUM_DIAL = 2; 
    
    private int hState = 0;
    private int hNum = 0;
    
    private HComponentConfig hCompCfg;
    
    public String hProjectDirectory; 
    public String hComponentName;
    public FileWriter hFW;
    public BufferedWriter hBW;
    public PrintWriter hPW;
    public FileReader hFR;
    public BufferedReader hBR;
    
    public String beforeSource;
    public String afterSource;
    
    public String originalString; 
    public String replaceString;
    
    public HManifestGenerator(HComponentConfig hComponentConfig, int state, int num, String dir){
        hCompCfg = hComponentConfig;
        hState = state;
        hNum = num;
        if(hNum == HNUM_PRJ){
            loadFile(dir, hCompCfg.getComponentName());
            initFile();
            writeFile(createFile());
        }
        else{
            hProjectDirectory = dir;
            loadFile(dir, null);
            initReadFile();
        }
    }
    
    public void identifyComponent(String hDir){
        File hAnnDirectory = new File(hDir + File.separatorChar + "ann");
        File hSnnDirectory = new File(hDir + File.separatorChar + "snn");
                
        if (hAnnDirectory.isDirectory())
            hState = H_ANN;
        else if (hSnnDirectory.isDirectory())
            hState = H_SNN;
        else
            hState = H_IoT;
        
    }
    
    public void loadFile(String hDir, String hCompName){
        hComponentName = hCompName;
        hProjectDirectory = hDir+"\\src\\"+"package.json"; 
        
        hCompCfg.setComponentName(hComponentName);
        hCompCfg.setComponentDir(hDir);
    }
    
    public void componentNameReplace(String cName){
        if(cName == null)
            originalString = "%COMPONENTNAME%";
        else
            originalString = cName;
        replaceString = hCompCfg.getComponentName();
        replaceSource();
    }
    
    public void componentAuthorReplace(String cAuthor){
        if(cAuthor == null)
            originalString = "%USERNAME%";
        else
            originalString = cAuthor;
        replaceString = hCompCfg.getAuthor();
        replaceSource();
    }
    
    public void keywordReplace(String cKeyword){
        if(cKeyword == null){
            originalString = "%KEYWORD%";
        }
        else
            originalString = cKeyword;
        
        String temp = hCompCfg.getKeyword();
        String tempD[] = temp.split(";");
        temp = "";
        for(int i=0; i<tempD.length; i++){
            if(i!=0 && (i<tempD.length))
                temp = temp+"\",\r\n    \"";
            temp = temp+tempD[i];
        }
        replaceString = temp;
        
        replaceSource();
    }
    public void descriptionReplace(String cDescription){
        if(cDescription == null)
            originalString = "%DESCRIPTION%";
        else
            originalString = cDescription;
        replaceString = hCompCfg.getDescription();
        replaceSource();
    }
    
    public void replaceSource(){
        if(hBR ==null)
            initReadFile();
        try{
        while((beforeSource = hBR.readLine()) != null){
            afterSource = beforeSource.replaceAll(originalString, replaceString);
            writeFile(afterSource+"\r\n");
        }
        if(hNum != HNUM_PRJ )
            renameFile();
        }
        catch(IOException ex){
            
        }
    }
    
    public String createFile(){
        String functionJS = "iot-component";
        if(hState == H_ANN)
            functionJS = "ann-component";
        else if(hState == H_SNN)
            functionJS = "snn-component";
        
        String source="";
        source = "{\r\n" +
"  \"name\": \""+hCompCfg.getComponentName()+"\",\r\n" +
"  \"version\": \"1.0.0\",\r\n" +
"  \"description\": \"%DESCRIPTION%\",\r\n" +
"  \"main\": \"index.js\",\r\n" +
"  \"scripts\": {\r\n" +
"    \"test\": \""+hCompCfg.getComponentName()+"\"\r\n" +
"  },\r\n" +
"  \"node-red\": {\r\n" +
"    \"nodes\": {\r\n" +
"      \""+hCompCfg.getComponentName()+"\": \"src/hnu/"+functionJS+".js\"\r\n" +
"    }\r\n" +
"  },\r\n" +
"  \"keywords\": [\r\n" +
"    \"%KEYWORD%\"\r\n" +
"  ],\r\n" +
"  \"author\": \""+System.getProperty("user.name")+"\",\r\n" +
"  \"license\": \"UNLICENSED\"\r\n" +
"}";
        return source;
        
    }
    
    public void initFile(){
        initReadFile();
        initWriteFile();
    }
    
    public void initWriteFile(){
        String compDir = hProjectDirectory;
        if(hNum == HNUM_DIAL)
            compDir = hProjectDirectory+".temp";
                
        try{
        if(compDir!=null&&hFW==null){    
            
                hFW = new FileWriter(compDir, false);
                hBW = new BufferedWriter(hFW);
                hPW = new PrintWriter(hBW);
            } 
        }
        catch(IOException ex) {
        }
    }
    
    public void initReadFile(){
        try{
            if(hProjectDirectory!=null&&hFR==null){    
                hFR = new FileReader(hProjectDirectory);
                hBR = new BufferedReader(hFR);
            }
        }
        catch(IOException ex) {
        }
    }
    
    public void renameFile(){ 
        destroy();
        File rFile = new File(hProjectDirectory);
        File wFile = new File(hProjectDirectory+".temp");
        rFile.delete();
        wFile.renameTo(new File(hProjectDirectory));
    }
    
    public void writeFile(String contents){
        if(hPW==null)
            initWriteFile();
        
        if(hPW!=null){
            hPW.print(contents);
            hPW.flush();
        }       
    }
    
    public void destroy(){
        try{
        if(hFR!=null && hBR!=null){
            hBR.close(); hBR = null;
            hFR.close(); hFR = null;
        }
        if(hPW!=null && hBW!=null && hFW!=null){
         
            hPW.close(); hPW = null;
            hBW.close(); hBW = null;
            hFW.close(); hFW = null;
        } 
        }
        catch (IOException ex) {
        }
    }
}
