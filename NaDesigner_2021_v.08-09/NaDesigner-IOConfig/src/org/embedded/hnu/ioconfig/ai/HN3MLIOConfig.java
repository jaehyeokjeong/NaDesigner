/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.embedded.hnu.ioconfig.ai;

/**
 *
 * @author SeoyeonKim
 */
public class HN3MLIOConfig extends HSNNIOConfig{
    
    private int numofClasses;
    //private int batchSize; //HIOConfig: int batch_size
    private int simulationTime;
    private double timeSteps;
    private double timeFrames;
    //private double learningRate; //HIOConfig: double learning_rate

    public int getNumofClasses() {
        return numofClasses;
    }

    public void setNumofClasses(int numofClasses) {
        this.numofClasses = numofClasses;
    }

    public int getSimulationTime() {
        return simulationTime;
    }

    public void setSimulationTime(int simmulationTime) {
        this.simulationTime = simmulationTime;
    }

    public double getTimeSteps() {
        return timeSteps;
    }

    public void setTimeSteps(double timeSteps) {
        this.timeSteps = timeSteps;
    }

    public double getTimeFrames() {
        return timeFrames;
    }

    public void setTimeFrames(double timeFrames) {
        this.timeFrames = timeFrames;
    }
}
