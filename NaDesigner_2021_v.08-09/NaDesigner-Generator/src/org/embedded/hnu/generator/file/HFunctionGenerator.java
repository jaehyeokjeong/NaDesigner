package org.embedded.hnu.generator.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.embedded.hnu.ioconfig.HComponentConfig;

public class HFunctionGenerator {
    
    public static final int H_SNN = 1;    
    public static final int H_ANN = 2;    
    public static final int H_IoT = 3;   
    
    public static final int HNUM_PRJ = 1; 
    public static final int HNUM_DIAL = 2; 
    
    public static int board = 0;
    public static final int rspi = 1;
    public static final int nano = 2;
    public static final int coral = 3;
    public static final int tinker =4;
    public static final int panda = 5; 
    
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
    
    String nnFile ="";
    
    public HFunctionGenerator(HComponentConfig hComponentConfig, int state, int num, String dir){
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
            initFile();
        }
    }
    
        
    
    public void loadFile(String hDir, String hCompName){
        
        nnFile ="iot-component";
        if(hState == H_SNN)
            nnFile = "snn-component";
        else if(hState == H_ANN)
            nnFile = "ann-component";
        hProjectDirectory = hDir+"\\src\\hnu\\"+nnFile+".js"; 
    }
    
    public void componentNameReplace(String cName){
        if(cName == null)
            originalString = "%COMPONENTNAME%";
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
        String source="";
        source += "module.exports = function(RED) {\r\n" +
"    function "+hCompCfg.getComponentName()+"(config) {\r\n" +
"       RED.nodes.createNode(this, config);\r\n" +
"        var component = this;\r\n" +
"        var callPython = function(msg) {\r\n";
        if(hState == H_IoT){
            source = source + "            const data = msg.payload;\r\n";
        }
        source = source + 
"//rspi && jetson nano && panda\r\n"+
"            const spawn = require(\"child_process\").spawn;\r\n" +
"            const pythonProcess = spawn('python3',[\"nodes/"+hCompCfg.getComponentName()+"/src/hnu/"+nnFile+".py\"";
        if(hState == H_IoT){
            source = source + ",data";
        }
        source = source +"]);\r\n" +
"            pythonProcess.stdout.on('data', function(data) {\r\n" +
"                sendFunction(Buffer.from(data, 'utf-8').toString());\r\n" +
"            });\r\n" +
"        }\r\n" +
"//coral && tinker\r\n"+
"//npm install sudo-js --save 필요\r\n"+
"//            const sudo = require('sudo-js);\r\n"+
"//            sudo.setPassword('1234');//board password \r\n"+
"//            sudo.exec([\"python3\",`${__dirname}/"+nnFile+".py`,data],function(err,pid,data){\r\n"+
"//                sendFunction(Buffer.from(data, 'uft-8).toString)());\r\n"+
"//            });\r\n"+
"//           }\r\n"+
"        var sendFunction = (data) => {\r\n" +
"                var msg = {};\r\n" +
"                msg.payload = data.replace('\\r\\n', '').toString();\r\n" +
"                split_data = data.split(\"|\", 2);\r\n" +
"                msg.select_number = Number(split_data[0]);\r\n" +
"                this.send(msg);\r\n" +
"            };\r\n" +
"        component.on('input', function(msg) {\r\n" +
"            callPython(msg);\r\n" +
"        });\r\n" +
"    }\r\n" +
"    RED.nodes.registerType(\""+hCompCfg.getComponentName()+"\","+hCompCfg.getComponentName()+");\r\n" +
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
                hBR.close();
                hFR.close();
            }
            if(hPW!=null && hBW!=null && hFW!=null){
                hPW.close();
                hBW.close();
                hFW.close(); 
            } 
        }
        catch (IOException ex) {
        }
    }
    
}
