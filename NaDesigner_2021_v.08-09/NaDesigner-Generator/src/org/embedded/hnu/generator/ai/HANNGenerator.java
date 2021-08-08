package org.embedded.hnu.generator.ai;

import org.embedded.hnu.generator.HGenerator;
import org.embedded.hnu.ioconfig.ai.HANNIOConfig;

public class HANNGenerator extends HGenerator{
    
    public static final int H_DATA_SET_TRAINING = 0;    
    public static final int H_DATA_SET_TEST = 1;       
    
    public static final int H_MODEL_INIT = 0;          
    public static final int H_MODEL_LINEAR_REGRESSION = 1;         
    public static final int H_MODEL_LOGISTIC_REGRESSION = 2;        
    public static final int H_MODEL_MULTI_LAYER_CLASSIFICATION = 3; 
    
    public int hModelType;
    public HANNIOConfig hACfg = new HANNIOConfig();
    
    int inputXNum=0, outputYNum = 0; 
    
    public HANNGenerator(){
        super();
    }
    
    public HANNGenerator(int modelType){
        if(hModelType == H_MODEL_LINEAR_REGRESSION){
            inputXNum = 1;
            outputYNum = 1;
        }
        else if(hModelType == H_MODEL_LOGISTIC_REGRESSION){
            inputXNum = 7;
            outputYNum = 1;
        }
        else{
            inputXNum = 1;
            outputYNum = 1;
        }
    }
    
    public void defineModel(int modeltype){
        hModelType = modeltype;
        if(hModelType == H_MODEL_LINEAR_REGRESSION){
            inputXNum = 1;
            outputYNum = 1;
        }
        else if(hModelType == H_MODEL_LOGISTIC_REGRESSION){
            inputXNum = 7;
            outputYNum = 1;
        }
        else{
            inputXNum = 1;
            outputYNum = 1;
        }
    }
    
    public void writeANNGen(int opt){
        writeFile(defineModel());
        if(opt == H_DATA_SET_TRAINING){
            writeFile(importLibrary());
            writeFile(defineFuction());
            writeFile(setParameter());
            writeFile(setData());
            writeFile(setTrainingIO());
            writeFile(setInitializer(hACfg.getInitializer(), inputXNum, outputYNum));  
            writeFile(setModel(inputXNum, outputYNum));
            writeFile(setHypothesis());
            writeFile(setLoss(hACfg.getLoss()));
            writeFile(setOptimizer(hACfg.getOptimizer()));
            writeFile(setAccuracy());
            writeFile(setTraining());
        }
        else if(opt == H_DATA_SET_TEST){
            writeFile(importLibrary());
            writeFile(defineFuction());
            writeFile(setParameter());
            writeFile(setData());
            writeFile(setTestIO());
            writeFile(setInitializer(hACfg.getInitializer(), inputXNum, outputYNum));  
            writeFile(setModel(inputXNum, outputYNum));
            writeFile(setHypothesis());
            writeFile(setLoss(hACfg.getLoss()));
            writeFile(setOptimizer(hACfg.getOptimizer()));
            writeFile(setAccuracy());
            writeFile(setTest());
        }
        else{
            writeFile(errorDataSet());
        }
    }
    
    public String defineModel(){
        String source ="define_model = ";
        if(hModelType==H_MODEL_LINEAR_REGRESSION){
            source = source + "\"linearR\"\r\n\r\n";
        }
        else if(hModelType==H_MODEL_LOGISTIC_REGRESSION){
            source = source + "\"logisticR\"\r\n\r\n";
        }
        else if(hModelType==H_MODEL_MULTI_LAYER_CLASSIFICATION){
            source = source + "\"multiL\"\r\n\r\n";
        }
        else{
            source = source + "\"NONE\"\r\n\r\n";
        }
        return source;
    }
    
    public String importLibrary(){
        String source = "import numpy as np\r\n" + 
			"from sklearn import datasets\r\n" + 
			"import tensorflow as tf\r\n" + 
			"import matplotlib.pyplot as plt\r\n";
        if(hModelType==H_MODEL_LOGISTIC_REGRESSION)
            source = source + "import requests\r\n\r\n";
        else
            source = source + "\r\n";
        return source;
    }
    
    public String defineFuction(){
        String source ="";
        if(hModelType==H_MODEL_LOGISTIC_REGRESSION){
            source ="def normalize_cols(m):\r\n" +
                    "    col_max = m.max(axis=0)\r\n" +
                    "    col_min = m.min(axis=0)\r\n" +
                    "    return (m - col_min) / (col_max - col_min)\r\n";            
        }
        return source;
    }
    
    public String setParameter(){
        String source = "epochs = 10000\n" +
                        "learning_rate = 0.01\r\n";
        if(hModelType==H_MODEL_LINEAR_REGRESSION){
            source = source + "ntrain = 47\r\n" + 
			"ntest = 50 - ntrain \r\n" + 
			"minibatch_size = ntest\r\n"+
                        "sp=0\r\n\r\n";
        }
        else if(hModelType==H_MODEL_LOGISTIC_REGRESSION){
            source = source + "train_data_rate = 0.85\r\n\r\n";
        }
        else
            source = source + "\r\n";
        return source;
    }
    
    public String setData(){
        String source="";
        if(hModelType==H_MODEL_LINEAR_REGRESSION){
            source = source + "iris = datasets.load_iris()\r\n" +
            "x_data = np.array([[x[1] for x in iris.data]]).T \r\n" + 
            "y_data = np.array([[y[3] for y in iris.data]]).T \r\n\r\n";
        }
        else if(hModelType==H_MODEL_LOGISTIC_REGRESSION){
            source = source + 
            "url = 'https://github.com/nfmcclure/tensorflow_cookbook/raw/master/01_Introduction/07_Working_with_Data_Sources/birthweight_data/birthweight.dat'\r\n" +
            "birth_file = requests.get(url)\r\n" +
            "birth_all_data = birth_file.text.split('\\r\\n')\r\n" +
            "birth_header = [x for x in birth_all_data[0].split('\\t') if len(x)>=1]\r\n" +
            "birth_data = [[float(x) for x in y.split('\\t') if len(x)>=1] for y in birth_all_data[1:] if len(y)>=1]\r\n" +
            "data_size = len(birth_data)\r\n\r\n"+
            "y_vals = np.array([y[0] for y in birth_data])\r\n" +
            "x_vals = np.array([x[1:8] for x in birth_data])\r\n\r\n";
        }
        else
            source = source + "\r\n";
        return source;
    }
    
    public String setTrainingIO(){
        String source = "";
        if(hModelType==H_MODEL_LINEAR_REGRESSION){
            source = "x_train = x_data[sp:sp+ntrain]  \r\n" + 
                     "y_train = y_data[sp:sp+ntrain]  \r\n\r\n";
        }
        else if(hModelType==H_MODEL_LOGISTIC_REGRESSION){
            source = "train_indices = np.random.choice(data_size, round(data_size*train_data_rate), replace=False)\r\n" +
                    "x_vals_train = x_vals[train_indices]\r\n" +
                    "y_vals_train = y_vals[train_indices]\r\n"+
                    "x_vals_train = np.nan_to_num(normalize_cols(x_vals_train))\r\n\r\n";
        }
        return source;
    }
    
    public String setTestIO(){
        String source = "";
        if(hModelType==H_MODEL_LINEAR_REGRESSION){
            source = "x_test = x_data[sp+ntrain:sp+50] \r\n" + 
                    "y_test = y_data[sp+ntrain:sp+50] \r\n\r\n";
        }
        else if(hModelType==H_MODEL_LOGISTIC_REGRESSION){
            source = "x_vals_test = x_vals[test_indices]\r\n" +
                    "y_vals_test = y_vals[test_indices]\r\n"+
                    "x_vals_test = np.nan_to_num(normalize_cols(x_vals_test))\r\n\r\n";
        }
        return source;
    }
    
    public String setInitializer(String init, int inputX, int outputY){
        String source="";
        if(init.equals("Xavier")){
         source ="W = tf.get_variable(\"W\", shape=["+inputX+", 1], initializer=tf.contrib.layers.xavier_initializer())\r\n" +
                    "b = tf.get_variable(\"b\", shape=["+outputY+", 1], initializer=tf.contrib.layers.xavier_initializer())\r\n\r\n";
        }
        return source;
    }
    
    public String setModel(int inputX, int outputY){
        String source = "X = tf.placeholder(shape=[None, "+inputX+"], dtype=tf.float32) \r\n" +
                    "Y = tf.placeholder(shape=[None, "+outputY+"], dtype=tf.float32) \r\n"+
                    "saver = tf.compat.v1.train.Saver()\r\n\r\n";
        return source;
    }
    
    public String setHypothesis(){
        String source = "";
        if(hModelType==H_MODEL_LINEAR_REGRESSION){
            source = "hypothesis = tf.matmul(X, W) + b\r\n";
        }
        else if(hModelType==H_MODEL_LOGISTIC_REGRESSION){
            source = "hypothesis = tf.add(tf.matmul(X, W), b)\r\n";
        }
        return source;
    }
    
    public String setLoss(String lossfunction){
        String source="";
        if(lossfunction.equals("CrossEntropy")){
            if(hModelType==H_MODEL_LINEAR_REGRESSION)
                source = "loss = tf.reduce_mean(tf.square(hypothesis - Y))\r\n";
            else
                source = "loss = tf.reduce_mean(tf.nn.sigmoid_cross_entropy_with_logits(labels=Y, logits=hypothesis))\r\n";
        }
        return source;
    }
    
    public String setOptimizer(String optimizer){        
        String source = "";
        if(optimizer.equals("Adam")){
            source = "train = tf.train.AdamOptimizer(learning_rate).minimize(loss)\r\n";
        }
        else{
            source ="train= tf.train.GradientDescentOptimizer(learning_rate=learning_rate).minimize(cost)\r\n\r\n";
        }
        return source;
    }

    public String setAccuracy(){
        String source ="";
        if(hModelType==H_MODEL_LOGISTIC_REGRESSION){
            source = "prediction = tf.round(tf.sigmoid(hypothesis))\r\n" +
            "predictions_correct = tf.cast(tf.equal(prediction, Y), tf.float32)\r\n" +
            "accuracy = tf.reduce_mean(predictions_correct)\r\n" +
            "batch_size = x_vals_train.shape[0]\r\n\r\n";
        }
        return source;
    }
    
    public String setTraining(){
        String source="";
        if(hModelType==H_MODEL_LINEAR_REGRESSION){
            source = "sess = tf.Session()\r\n" + 
            "sess.run(tf.global_variables_initializer())\r\n\r\n"+
            "for step in range(epochs): \r\n" +
            "  sess.run(train, feed_dict={X: x_train, Y:y_train}) \r\n" +
            "  cost = sess.run(loss, feed_dict={X: x_train, Y:y_train}) \r\n" +
            "  if (step+1)%200== 0: \r\n" +
            "     print(step, cost, sess.run(W), sess.run(b)) \r\n" +
            "     saver.save(sess, \"../../../model_\"+define_model+\"/save_model.ckpt\")\r\n\r\n"+
            "plt.plot(x_train, y_train, 'ro')\r\n" +
            "plt.plot(x_data, sess.run(W) * x_data + sess.run(b))\r\n" +
            "plt.xlim(2, 5)\r\n" +
            "plt.ylim(0, 1)\r\n" +
            "plt.show()\r\n";
        }
        else if(hModelType==H_MODEL_LOGISTIC_REGRESSION){
            source = "loss_vec = []\r\n" +
                "train_acc = []\r\n" +
                "maxTrain = 0\r\n" +
                "minloss = 1000\r\n" +
                "for i in range(epochs):\r\n" +
                "    rand_index = np.random.choice(len(x_vals_train), size=batch_size)\r\n" +
                "    rand_x = x_vals_train[rand_index]\r\n" +
                "    rand_y = np.transpose([y_vals_train[rand_index]])\r\n" +
                "    sess.run(train, feed_dict={X: rand_x, Y: rand_y})\r\n" +
                "    temp_loss = sess.run(loss, feed_dict={X: rand_x, Y: rand_y})\r\n" +
                "    loss_vec.append(temp_loss)\r\n" +
                "    temp_acc_train = sess.run(accuracy, feed_dict={X: x_vals_train, Y: np.transpose([y_vals_train])})\r\n" +
                "    train_acc.append(temp_acc_train)\r\n" +
                "    if(minloss > temp_loss):\r\n" +
                "      maxTrain = temp_acc_train\r\n"+
                "saver.save(sess, \"../../../model_\"+define_model+\"/save_model.ckpt\")\r\n\r\n"+
                "plt.plot(train_acc, 'k-', label='Train Set Accuracy')\r\n" +
                "plt.title('Train Accuracy')\r\n" +
                "plt.xlabel('Generation')\r\n" +
                "plt.ylabel('Accuracy')\r\n" +
                "plt.legend(loc='lower right')\r\n" +
                "plt.show()\r\n\r\n";
        }
        return source;
    }
    
    public String setTest(){
        String source="";
        if(hModelType==H_MODEL_LINEAR_REGRESSION){
            source = "with tf.Session() as sess: \r\n" +
            "  ckpt = tf.train.get_checkpoint_state(\"../../../model_\"+define_model+\"/./\")\r\n" +
            "  if ckpt: # and tf.train.checkpoint_exists(ckpt.model_checkpoint_path):\r\n" +
            "    saver = tf.train.import_meta_graph(\"../../../model_\"+define_model+\"/save_model.ckpt.meta\")\r\n" +
            "    saver.restore(sess, tf.train.latest_checkpoint(\"../../../model_\"+define_model+\"/./\"))\r\n" +
            "    sess.run(tf.global_variables_initializer())\r\n" +
            "    sess.run(train, feed_dict={X: x_test, Y:y_test}) \r\n" +
            "    cost = sess.run(loss, feed_dict={X: x_test, Y:y_test}) \r\n"+
            "  else:\r\n" +
            "    print(\"Unable to open model\")";
        }
        else if(hModelType==H_MODEL_LOGISTIC_REGRESSION){
            source = "with tf.Session() as sess: \r\n" +
            "    ckpt = tf.train.get_checkpoint_state(\"../../../model_\"+define_model+\"/./\")\r\n" +
            "    if ckpt:\n" +
            "      saver = tf.train.import_meta_graph(\"../../../model_\"+define_model+\"/save_model.ckpt.meta\")\r\n" +
            "      saver.restore(sess, tf.train.latest_checkpoint(\"../../../model_\"+define_model+\"/./\"))\r\n" +
            "      sess.run(tf.global_variables_initializer())\r\n" +
            "      rand_index = np.random.choice(len(x_vals_test), size=batch_size)\r\n" +
            "      rand_x = x_vals_test[rand_index]\r\n" +
            "      rand_y = np.transpose([y_vals_test[rand_index]])\r\n" +
            "      temp_loss = sess.run(loss, feed_dict={X: rand_x, Y: rand_y})\r\n" +
            "      temp_acc_test = sess.run(accuracy, feed_dict={X: x_vals_test, Y: np.transpose([y_vals_test])})\r\n" +
            "    else:\r\n" +
            "        print(\"Unable to open model\")\r\n";
        }
        return source;
    }
    
    public String errorDataSet(){
        String source = "print(\"Data Set Error!!\")";
        return source;
    }
}
