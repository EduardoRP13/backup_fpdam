/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tresenrayaapp;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author yoli
 */


public class TresEnRayaAppFMXL extends Application {

     public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
                
        Parent root= FXMLLoader.load(getClass().getResource("/tresenrayaapp/vista/TresEnRaya_testFXML.fxml"));
        
        Scene scene= new Scene(root);
        primaryStage.setTitle("Tres en Raya JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    
    
}