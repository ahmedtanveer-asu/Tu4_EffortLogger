package effortLogger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 

public class EffortLogger extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
    	
    	System.out.println("It started again!");
        primaryStage.setTitle("EffortLogger V2.0");
        
        LoginScreen login = new LoginScreen();
        
        login.loginScreen(primaryStage);
        
       
        primaryStage.show();
        
    }
}