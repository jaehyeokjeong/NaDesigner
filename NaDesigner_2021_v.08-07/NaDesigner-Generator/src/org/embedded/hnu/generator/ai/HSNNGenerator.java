package org.embedded.hnu.generator.ai;

import org.embedded.hnu.generator.HGenerator;
import org.embedded.hnu.generator.HGenerator;
import org.embedded.hnu.ioconfig.ai.HSNNIOConfig;
import org.embedded.hnu.ioconfig.ai.HSNNLayerConfig;

public class HSNNGenerator extends HGenerator{
    
    public static final int H_DATA_SET_TRAINING = 0;   
    public static final int H_DATA_SET_TEST = 1;        
    
    public int dataSetOpt=-1;
    
    private HSNNIOConfig hSCfg = new HSNNIOConfig();
    private HSNNLayerConfig[] hSLCfg;
    
    public String modelName="";
    public String modelDir="";
    public String componentName="";
    
    public String loadDataFile="";
    public String dataFileDelimiter=""; 
    int numLayer = 0;
    String addLayerSource = "";
    String[] inp;
    
    public HSNNGenerator(){
        super();
    }
    public void initConfig(HSNNIOConfig hSNNIOConfig, String mName, String mDir){
        modelName=mName;
        modelDir=mDir;       
        String componentNameT[] =mDir.split("\\\\");
        for(int i=0; i<componentNameT.length; i++){
            if(i+1==componentNameT.length)
                componentName = componentNameT[i];
        }
        hSCfg = hSNNIOConfig;
        dataSetOpt = hSCfg.getData_opt();
    }
    
    public void setNumLayer(int numLayer){
        hSLCfg = new HSNNLayerConfig[numLayer];
        this.numLayer = numLayer;
    }
    
    public void initLayerConfig(int layerN, HSNNLayerConfig hSNNLayerConfig){
        hSLCfg[layerN] = hSNNLayerConfig;
        int cnt=0; 
        for(int i=0; i<numLayer; i++){
            if(hSLCfg[i] != null){
                cnt+=1;
            }
        }
        if(cnt >= numLayer){
            addLayerSource = setAddLayer(hSLCfg);
        }
    }

    public void setInputData(String input){
        String[] inputD = input.split(",");
        inp = inputD;
    }
    
    public void writeSNNGen(){
        writeFile(importLibrary());
        writeFile(setParameter());
        if(!(loadDataFile.equals("")))
            writeFile(setInput());
        writeFile(setNetwork());
        writeFile(setTimestep());
        writeFile(defAccuracy());
        writeFile(setCompileFit());
        writeFile(accuracyAfterTraining());
    }
    
     public void writeSNNSingleGen(){
        String source = "";
        source += importLibrary();
        source += setParameter();
        source += setInput();
        source += setNetwork();
        source += setTimestep();
        writeFile(source);
    }
    
    public String importLibrary(){
        String source = "import os\r\n" + 
                        "import numpy as np\r\n" + 
			"import tensorflow as tf\r\n" + 
			"import matplotlib.pyplot as plt\r\n" + 
			"import nengo\r\n" + 
			"import nengo_dl\r\n" +
                        "from urllib.request import urlretrieve\r\n\r\n";
        return source;
    }
    
    public String setParameter(){
        String source = "amp = "+hSCfg.getAmplitude()+" \r\n" +
                "max_rates = "+ hSCfg.getMax_rates() + "\r\n"+
                "intercepts = "+hSCfg.getIntercepts() + "\r\n"+
                "synapse = "+hSCfg.getSynapse()+ "\r\n" + 
		"learning_rate = "+hSCfg.getLearning_rate() + "\r\n"+
                "minibatch_size = "+hSCfg.getBatch_size() + "\r\n\r\n";
        if(dataSetOpt ==H_DATA_SET_TRAINING)
            source += "epochs = "+hSCfg.getEpoch()+"\r\n";
        else
            source += "seed = 1";
        return source;
    }
    
    public void setData(String dataFileDir, String delimiter){
        loadDataFile = dataFileDir; 
        dataFileDelimiter = delimiter;
        
    }
    
    public String setInput(){
        int yRange_temp = 0;
            
        String source ="";
        
        if (numLayer == 0) {
            source += "x_data = np.array([[input_x]]).T # sepal width  #(150, 1)\r\n"
                    + "y_data = np.array([[res_y]]).T # petal width #(150, 1)\r\n"
                    + "\r\n"
                    + "x_test = x_data[0] # setosa test  #(15, 1)\r\n"
                    + "y_test = y_data[0] # setosa test  #(15, 1)\r\n\r\n";
        } else {
            if (dataSetOpt == H_DATA_SET_TRAINING) {
                source = source + "data = np.loadtxt(\"../DataSets/" + loadDataFile + "\", delimiter=\"" + dataFileDelimiter + "\", dtype = np.float32)\r\n"
                        + "train_images = data[:," + (hSCfg.getxRange1() - 1) + ":" + hSCfg.getxRange2() + "]\r\n";
                if (hSCfg.getyRange2() - hSCfg.getyRange1() == 1 && hSCfg.getyRange1() == 0) {
                    source = source + "train_labels = data[:," + yRange_temp + "]\r\n\r\n";
                } else {
                    source = source + "train_labels = data[:," + (hSCfg.getyRange1() - 1) + ":" + hSCfg.getyRange2() + "]\r\n\r\n";
                }
            } else {
                source = source + "data = np.loadtxt(\"nodes/" + componentName + "/src/DataSets/" + loadDataFile + "\", delimiter=\"" + dataFileDelimiter + "\", dtype = np.float32)\r\n"
                        + "test_images = data[:," + (hSCfg.getxRange1() - 1) + ":" + hSCfg.getxRange2() + "]\r\n";
                if (hSCfg.getyRange2() - hSCfg.getyRange1() == 1 && hSCfg.getyRange1() == 0) {
                    source = source + "test_labels = data[:," + yRange_temp + "]\r\n\r\n";
                } else {
                    source = source + "test_labels = data[:," + (hSCfg.getyRange1() - 1) + ":" + hSCfg.getyRange2() + "]\r\n\r\n";
                }
            }
        }
        return source;
    }
    public String setNetwork(){
        
        String source = "";
        if (numLayer == 0) {
            source += "with nengo.Network(seed=seed) as net:\r\n"
                    + "    net.config[nengo.Ensemble].max_rates = nengo.dists.Choice([max_rates])\r\n"
                    + "    net.config[nengo.Ensemble].intercepts = nengo.dists.Choice([intercepts])    \r\n"
                    + "    neuron_type=nengo.LIF(amplitude=amp, tau_rc=tau_rc)\r\n"
                    + "    inp = nengo.Node([0] * 1)    \r\n"
                    + "    ens = nengo.Ensemble(1, 1, neuron_type=neuron_type)\r\n"
                    + "    x = nengo.Connection(inp, ens.neurons, transform=nengo_dl.dists.Glorot(), synapse=None)\r\n"
                    + "    inp_p = nengo.Probe(inp)\r\n"
                    + "    out_p = nengo.Probe(x)\r\n"
                    + "    out_p_filt = nengo.Probe(x, synapse=noise_filter)\r\n"
                    + "sim = nengo_dl.Simulator(net, minibatch_size=minibatch_size)\r\n"
                    + "\r\n"
                    + "sim.load_params(\"nodes/iris_python/iris_train_data/train\")\r\n\r\n";
        } else {
            source = "with nengo.Network(seed=0) as net:\r\n"
                    + "    net.config[nengo.Ensemble].max_rates = nengo.dists.Choice([max_rates])\r\n"
                    + "    net.config[nengo.Ensemble].intercepts = nengo.dists.Choice([intercepts])\r\n"
                    + "    net.config[nengo.Connection].synapse = None\r\n"
                    + "    neuron_type = nengo." + hSCfg.getNeuron_type() + "(amplitude=amp)\r\n"
                    + "\r\n"
                    + "    nengo_dl.configure_settings(stateful=False)\r\n"
                    + "    \r\n"
                    + "    inp = nengo.Node(np.zeros(" + inp[0] + "*" + inp[1] + "))  \r\n" + //2020.09.07 SyKim
                    "\r\n"
                    + addLayerSource
                    + "\r\n    out = nengo_dl.Layer(tf.keras.layers.Dense(units=" + hSCfg.getOutput() + "))(layer)\r\n"
                    + "\r\n"
                    + "    out_p = nengo.Probe(out, label=\"out_p\")\r\n"
                    + "    out_p_filt = nengo.Probe(out, synapse=synapse, label=\"out_p_filt\")\r\n"
                    + "\r\n"
                    + "sim = nengo_dl.Simulator(net, minibatch_size=minibatch_size)\r\n\r\n";
        }
        return source;
    }
    
    public String setTimestep(){
        String source = "";
        if (numLayer == 0 && dataSetOpt==H_DATA_SET_TEST){
            source += "n_steps = 300\r\n"
                    + "test_data = {\r\n"
                    + "        inp: np.tile(np.reshape(x_test, (x_test.shape[0], 1, 1)), (1, n_steps, 1)),\r\n"
                    + "        out_p_filt: np.tile(np.reshape(y_test, (y_test.shape[0], 1, 1)), (1, n_steps, 1))\r\n"
                    + "    }\r\n"
                    + "sim.run_steps(n_steps, data={inp: test_data[inp][:minibatch_size]})\r\n\r\n";
        }else if(!(numLayer == 0) && dataSetOpt==H_DATA_SET_TRAINING){
            source += "n_steps = 30\r\n"
                    + "train_images = train_images[:, None, :]\r\n"
                    + "train_labels = train_labels[:, None, None]\r\n"
                    + "\r\n";
        }
        else{
            
            source= source+"test_images = np.tile(test_images[:, None, :], (1, n_steps, 1))\r\n" +
            "test_labels = np.tile(test_labels[:, None, None], (1, n_steps, 1))\r\n\r\n";
        }
        return source;
    }
    
    public String defAccuracy(){
        String source ="\r\ndef classification_accuracy(y_true, y_pred):\r\n" +
        "    return tf.metrics.sparse_categorical_accuracy(\r\n" +
        "        y_true[:, -1], y_pred[:, -1])\r\n\r\n" +
        "sim.compile(loss={out_p_filt: classification_accuracy})\r\n" +
        "print(\"accuracy before training:\",\r\n";
        if(dataSetOpt==H_DATA_SET_TRAINING){
          source = source+"      sim.evaluate(train_images, {out_p_filt: train_labels}, verbose=0)[\"loss\"])\r\n\r\n\r\n";
        }
        else{
            source = source+"      sim.evaluate(test_images, {out_p_filt: test_labels}, verbose=0)[\"loss\"])\r\n\r\n\r\n";
        }
        
        return source;
    }
    public String setCompileFit(){
        String modelDir_t = modelDir.replaceAll("\\\\", "/");
        System.out.println("modelDir_t::"+modelDir_t);
        String source = "";
        if(dataSetOpt==H_DATA_SET_TRAINING){
               source = source + 
                "sim.compile(\r\n"+
            "    optimizer=tf.optimizers."+hSCfg.getOptimizer()+"(learning_rate=learning_rate),\r\n"+
            "    loss = {out_p: tf.losses.";
        
            if(hSCfg.getLoss().equals("Cross Entropy")){
                source = source + "SparseCategoricalCrossentropy(from_logits=True)}\r\n";
            }
            source = source +"    )\r\n"+
            "sim.fit(train_images, {out_p: train_labels}, epochs=epochs)\r\n" +      
            "sim.save_params(\""+modelDir_t+"/"+modelName+"\")\r\n";
        }
        else{
            source = source + "if os.path.isfile(\"nodes/"+componentName+"/"+modelName+".npz\"):\r\n" +
            "    sim.load_params(\"nodes/"+componentName+"/"+modelName+"\")\r\n" +
            "    print(\"file load success\")\r\n" +
            "else:\r\n" +
            "    print(\"file does not existed\")\r\n" +
            "    urlretrieve(\r\n" +
            "        \"https://drive.google.com/uc?export=download&\"\r\n" +
            "        \"id=1l5aivQljFoXzPP5JVccdFXbOYRv3BCJR\",\r\n" +
            "        \"nodes/"+componentName+"/"+modelName+".npz\")\r\n\r\n";
        }
 
        return source;
    }
    
    public String accuracyAfterTraining(){
        String source="sim.compile(loss={out_p_filt: classification_accuracy})\r\n\r\n";
        if(dataSetOpt==H_DATA_SET_TRAINING){
         source = source + "print(\"accuracy after training:\", sim.evaluate(train_images, {out_p_filt: train_labels}, verbose=0)[\"loss\"])\r\n";
        }
        else{
            source= source + "print(\"accuracy after training:\", sim.evaluate(test_images, {out_p_filt: test_labels}, verbose=0)[\"loss\"])\r\n";
        }
        source = source + "\r\n" +
        "print(\"finished\")\r\n" +
        "\r\n";
        
        return source;
    }
    
    public String setAddLayer(HSNNLayerConfig[] hSLCfg_p){
        String source = "";
        int i;
        int shape[] = new int[numLayer];
        int filter[] = new int[numLayer];
        int stride[] = new int[numLayer];
        
        for(i=0; i<numLayer; i++){
            filter[i]=hSLCfg_p[i].getFilter();
            source = source + "    layer = nengo_dl.Layer(tf.keras.layers.Conv2D(filters=" + hSLCfg_p[i].getFilter()+", "
            + "kernel_size="+hSLCfg_p[i].getKernel();
            if(i!=0 && (hSLCfg_p[i].getStride() != 0)){
                stride[i] = hSLCfg_p[i].getStride();
                shape[i]=(shape[i-1] - hSLCfg_p[i].getKernel())/(stride[i-1]) + 1;
                source = source + ", strides="+hSLCfg_p[i].getStride()+")) (layer";
            }
            else{
                stride[i] = 1;
                shape[i]=Integer.parseInt(inp[0]); 
                source = source + ")) (inp";
            }
            source = source + ", shape_in=("+shape[i]+", "+shape[i]+", ";
            if(i!=0){
                source = source + filter[i-1];
            }
            else{
                source = source + "1";
            }
            source = source + "))\r\n"
            + "    layer = nengo_dl.Layer(neuron_type)(layer)\r\n";
        }
        
        return source;
    }
    
    public String reAdjustInput(){
        String hIOinput = inp[0]; 
        return hIOinput;
    }
    
    public String errorDataSet(){
        String source = "print(\"Data Set Error!!\")";
        return source;
    }
   
}

