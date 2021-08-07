package org.embedded.hnu.ioconfig.ai;

import org.embedded.hnu.ioconfig.ai.HSNNIOConfig;

public class HSNNLayerConfig extends HSNNIOConfig{
    
    private int numofLayer = 0;
    private int filter;
    private int kernel;
    private int stride;
    private String padding;
    
    public HSNNLayerConfig(){
    }
        
    public HSNNLayerConfig(int filter, int kernel, int stride, String padding){
        setFilter(filter);
        setKernel(kernel);
        setStride(stride);
        setPadding(padding);
        System.out.println("f:"+filter+" k:"+kernel+" s:"+stride+" p:"+padding);
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public int getKernel() {
        return kernel;
    }

    public void setKernel(int kernel) {
        this.kernel = kernel;
    }

    public int getStride() {
        return stride;
    }

    public void setStride(int stride) {
        this.stride = stride;
    }

    public String getPadding() {
        return padding;
    }

    public void setPadding(String padding) {
        this.padding = padding;
    }
    

}
