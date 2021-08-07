package org.embedded.hnu.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HGenerator{
    
    public static int hSTATE=0; 
    public static final int H_SNN = 1;   
    public static final int H_ANN = 2;   
    public static final int H_IoT = 3;
    public String hProjectDirectory;
    public FileWriter hFW;
    public BufferedWriter hBW;
    public PrintWriter hPW;
    
    public HGenerator(){      
    }

    public void createFile(String hDir){
        String nnFile="UNTITLED";
        System.out.println("상태:"+hSTATE);
        if(hSTATE != H_SNN && hSTATE != H_ANN && hSTATE != H_IoT)
            return;
        if(hSTATE == H_SNN)
            nnFile = "snn-component";
        else if(hSTATE == H_ANN)
            nnFile = "ann-component";
        else if(hSTATE==H_IoT)
            nnFile = "iot-component";
        hProjectDirectory = hDir+"\\src\\hnu\\"+nnFile+".py";
         System.out.println("파일:"+hProjectDirectory);
        initFile();
    }
    public void createFileArduino(String hDir){
        String nnFile="UNTITLED";
        System.out.println("상태:"+hSTATE);
        if(hSTATE != H_SNN && hSTATE != H_ANN && hSTATE != H_IoT)
            return;
        if(hSTATE == H_SNN)
            nnFile = "snn-component";
        else if(hSTATE == H_ANN)
            nnFile = "ann-component";
        else if(hSTATE==H_IoT)
            nnFile = "iot-component";
        hProjectDirectory = hDir+"\\src\\hnu\\"+nnFile+".ino";
         System.out.println("파일:"+hProjectDirectory);
        initFile();
    }
    public void createFileJS(String hDir){
        String nnFile="UNTITLED";
        System.out.println("상태:"+hSTATE);
        if(hSTATE != H_SNN && hSTATE != H_ANN && hSTATE != H_IoT)
            return;
        if(hSTATE == H_SNN)
            nnFile = "snn-component";
        else if(hSTATE == H_ANN)
            nnFile = "ann-component";
        else if(hSTATE==H_IoT)
            nnFile = "iot-component";
        hProjectDirectory = hDir+"\\src\\hnu\\"+nnFile+".js";
         System.out.println("파일:"+hProjectDirectory);
        initFile();
    }

    public void initFile(){

        if(hProjectDirectory!=null&&hFW==null){    
            try{
                hFW = new FileWriter(hProjectDirectory, false);
                hBW = new BufferedWriter(hFW);
                hPW = new PrintWriter(hBW);
            } catch(IOException ex) {
            }
        }
    }
    
    public void getParameter(){        
    }
    
    public void writeFile(String contents){
        if(hPW!=null){
            hPW.print(contents);
            hPW.flush();
        }
    }
    
    public void destroy(){
        if(hPW!=null && hBW!=null && hFW!=null){
            try { 
                hPW.close();
                hBW.close();
                hFW.close(); 
            } catch (IOException ex) {
            }
        }
    }
    
}
