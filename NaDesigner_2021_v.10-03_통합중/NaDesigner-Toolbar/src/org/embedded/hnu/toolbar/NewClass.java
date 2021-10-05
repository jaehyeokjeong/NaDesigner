/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.embedded.hnu.toolbar;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Stream;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openide.util.Exceptions;

/**
 *
 * @author jjh
 */
public class NewClass extends Application{
    
    @Override
    public void start(Stage stage) { 
        Parameters params = getParameters();
        String path = params.getNamed().get("path");
        System.out.println(path);
         stage.setTitle("Line Chart Sample");
        //defining the axes
        ArrayList output = new ArrayList<>();
        ArrayList current_time = new ArrayList<>();;
        JSONParser parser = new JSONParser();
        double[][]output_arr = null;
        
        try{
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject)obj;
            JSONArray dataArray = (JSONArray) jsonObject.get("debugInfo");
            for(int i = 0; i<dataArray.size();i++){
                JSONObject data = (JSONObject) dataArray.get(i);
                output.add(data.get("OUTPUT"));
                current_time.add(data.get("C_TIME"));
                //current_time.add(data.get("SIM_TIME")); //데이터 여러개의 경우
            } 
        System.out.println(dataArray);
        System.out.println(output.getClass().getName());
        System.out.println(current_time.getClass().getName());
        int cut = output.size()-1;
        int count = 0;
        output.remove(cut);
        current_time.remove(cut); 

        while(output.remove(null)) {
            count++;
            current_time.remove(0);
        }
        //System.out.println(((JSONArray)output.get(15)).get(0));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ArrayList<String> sampleLabel = new ArrayList<>();
        double[][] value = new double[((JSONArray)output.get(0)).size()][output.size()];
        //double[] value1 = new double[current_time.size()];
        for(int i =0;i<current_time.size();i++){
            sampleLabel.add(String.format("%.3f", current_time.get(i)));
        }
        
       for(int i =0;i<((JSONArray)output.get(i)).size();i++){
            sampleLabel.add(String.format("%.3f", current_time.get(i)));
            for(int j = 0; j<output.size();j++){
                value[i][j] = (double)((JSONArray)output.get(j)).get(i);
            }
        }       
        //라인 차트 시작
        stage.setTitle("Debug");
        final CategoryAxis xAxis = new CategoryAxis();
        final CategoryAxis xAxis1 = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Current_Time");
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
        String[] name = {"0","1","2","3","4","5","6","7","8","9","10"};
        XYChart.Series<String, Number>[] seriesArray = Stream.<XYChart.Series<String, Number>>generate(XYChart.Series::new).limit(((JSONArray)output.get(0)).size()).toArray(XYChart.Series[]::new);
       
        if(((JSONArray)output.get(0)).size()==10){
            Platform.runLater(()
                -> {
            Set<Node> nodes = lineChart.lookupAll(".series" + 8);
            
            for (Node n : nodes) {
                n.setStyle("-fx-background-color: #33FFFF, white;\n"
                        + "    -fx-background-insets: 0, 2;\n"
                        + "    -fx-background-radius: 5px;\n"
                        + "    -fx-padding: 5px;");
            }
            seriesArray[8].getNode().lookup(".chart-series-line").setStyle("-fx-stroke: #33FFFF;");
            });
         
         Platform.runLater(()
                -> {
            Set<Node> nodes = lineChart.lookupAll(".series" + 9);
            
            for (Node n : nodes) {
                n.setStyle("-fx-background-color: black, white;\n"
                        + "    -fx-background-insets: 0, 2;\n"
                        + "    -fx-background-radius: 5px;\n"
                        + "    -fx-padding: 5px;");
            }
            seriesArray[9].getNode().lookup(".chart-series-line").setStyle("-fx-stroke: black;");
            });
        }
         
        for(int i = 0; i < ((JSONArray)output.get(0)).size();i++){
          seriesArray[i].setName(name[i]);
      }
        lineChart.setTitle("H/W Information"); 
        for(int i = 0; i<((JSONArray)output.get(0)).size();i++){ 
            for(int j = 0; j<output.size();j++){
                 seriesArray[i].getData().add(new XYChart.Data(sampleLabel.get(j), value[i][j]));
            }
            lineChart.getData().addAll(seriesArray[i]);
        }        
        Scene scene  = new Scene(lineChart,1024,768);             
        /*
        final MenuItem resizeItem = new MenuItem("Info");
        resizeItem.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent event) {
            for(int i =0;i<((JSONArray)output.get(i)).size();i++){
                for(int j = 0; j<output.size();j++){
                    System.out.print(value[i][j]+" ");
            }System.out.println();
        }       
            System.out.println(sampleLabel);

          }
        });

        final ContextMenu menu = new ContextMenu(
          resizeItem
        );

        lineChart.setOnMouseClicked(new EventHandler<MouseEvent>() {
          @Override public void handle(MouseEvent event) {
            if (MouseButton.SECONDARY.equals(event.getButton())) {
              menu.show(stage, event.getScreenX(), event.getScreenY());
            }  
          }
        });  */  
         
        stage.setScene(scene);
        stage.show();
        
        for(int i = 0; i<((JSONArray)output.get(0)).size();i++){ 
            for (final XYChart.Data<String, Number> data : seriesArray[i].getData()){
                       data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, new EventHandler<MouseEvent>() {
                           @Override
                           public void handle(MouseEvent event) {
                               //System.out.println("X : "+data.getXValue()+"\nY : "+String.valueOf(data.getYValue()));
                               //lbl.setText("X : "+data.getXValue()+"\nY : "+String.valueOf(data.getYValue()));
                               //Tooltip.install(data.getNode(), new Tooltip("X : "+data.getXValue()+"\nY : "+String.valueOf(data.getYValue())));
                               Tooltip tooltip = new Tooltip();
                               tooltip.setText("Current_Time : "+data.getXValue()+"\nWeights : "+String.valueOf(data.getYValue()));
                               Tooltip.install(data.getNode(), tooltip);
                           }
                       });
                   }
         }
        
    }    
    }   