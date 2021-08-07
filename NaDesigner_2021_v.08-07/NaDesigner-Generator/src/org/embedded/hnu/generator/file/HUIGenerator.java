package org.embedded.hnu.generator.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.embedded.hnu.ioconfig.HComponentConfig;

public class HUIGenerator {
    public static final int H_SNN = 1;  
    public static final int H_ANN = 2;   
    public static final int H_IoT = 3;  
    
    public static final int HNUM_PRJ = 1; 
    public static final int HNUM_DIAL = 2;
    
    private int hState = 0;
    private int hNum = 0;  
    
    private HComponentConfig hCompCfg;
    
    public String hProjectDirectory;

    public FileWriter hFW;
    public BufferedWriter hBW;
    public PrintWriter hPW;
    public FileReader hFR;
    public BufferedReader hBR;
    
    public String beforeSource; 
    public String afterSource;
    
    public String originalString;
    public String replaceString; 
    
    public HUIGenerator(HComponentConfig hComponentConfig, int state, int num, String dir){
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
    
    public void loadFile(String hDir, String hCompName){
        
        String nnFile ="component";
        if(hState == H_SNN)
            nnFile = "snn-component";
        else if(hState == H_ANN)
            nnFile = "ann-component";
        else
            nnFile = "iot-component";
        hProjectDirectory = hDir+"\\src\\hnu\\"+nnFile+".html"; 
    }
    
    public void componentNameReplace(String cName){
        if(cName == null)
            originalString = "snn-component";
        else
            originalString = cName;
        replaceString = hCompCfg.getComponentName();
        replaceSource();
        
    }
    
    public void componentDirReplace(String cDir){
        if(cDir == null)
            originalString = "%COMPONENTDIR%";
        else
            originalString = cDir;
        replaceString = hCompCfg.getComponentDir();
        replaceSource();
    }
    
    public void componentInputReplace(int cInput){
        if(cInput == 0)
            originalString = "%COMPONENTINPUT%";
        else
            originalString = Integer.toString(cInput);
        replaceString = Integer.toString(hCompCfg.getComponentInput());
        replaceSource();
    }
    
    public void componentOutputReplace(int cOutput){
        if(cOutput == 0)
            originalString = "%COMPONENTOUTPUT%";
        else
            originalString = Integer.toString(cOutput);
        replaceString = Integer.toString(hCompCfg.getComponentOutput());
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
        String categoryTemp="";
        if(hCompCfg.getCategory()==null){
            if(hState==H_SNN || hState == H_ANN)
                categoryTemp="Neuromorphic";
            else
                categoryTemp = "IoT";
        }
        else
            categoryTemp=hCompCfg.getCategory();
        
        String source="";
        source = "<script type=\"text/x-red\" data-template-name=\""+hCompCfg.getComponentName()+"\">\r\n" +
"    <div class=\"form-row\">\r\n" +
"        <label for=\"component-input-name\"><i class=\"icon-tag\"></i> name</label>\r\n" +
"        <input type=\"text\" id=\"component-input-name\" placeholder=\"input name\">\r\n" +
"    </div>\r\n" +
"</script>\r\n" +
"\r\n" +
"<script type=\"text/x-red\" data-help-name=\""+hCompCfg.getComponentName()+"\">\r\n" +
"    <p>%DESCRIPTION%</p>\r\n" +
"</script>\r\n" +
"\r\n" +
"<script type=\"text/javascript\">\r\n" +
"    RED.nodes.registerType('"+hCompCfg.getComponentName()+"',{\r\n" +
"        category: '"+categoryTemp+"',\r\n" +
"        color: '#999999',\r\n" +
"        defaults: {\r\n" +
"            name: {value: \"\"}\r\n" +
"        },\r\n" +
"        inputs:1,\r\n" +
"        outputs:1,\r\n" +
"        icon: \"file.png\",\r\n" +
"        label: function() {\r\n" +
"            return this.name||\""+hCompCfg.getComponentName()+"\";\r\n" +
"        },\r\n" +
"        oneditprepare: function() {\r\n" +
"        },\r\n" +
"        oneditsave: function() {\r\n" +
"        }\r\n" +
"    });\r\n" +
"</script>";
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
