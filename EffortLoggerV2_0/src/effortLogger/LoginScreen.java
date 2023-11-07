package effortLogger;

import java.util.ArrayList;

import effortLogger.LogDataTypes.Projects;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen {

	
	//User name and password inputs
	TextField userText = new TextField();
	PasswordField txtPass = new PasswordField();
	BorderPane broot;
	

	//ArrayList for projects
	ArrayList<Projects> arrProj = new ArrayList<Projects>();
	

	public void loginScreen(Stage primaryStage, ArrayList<Projects> arrayProject) {
		arrProj = arrayProject;
		
		loginScreen(primaryStage);
	}
		
	
	public void loginScreen(Stage primaryStage) {
		
		//set label for user name input
		Label userLabel = new Label();
		userLabel.setText("Username: ");
        
        //create label for password
        Label lblPass = new Label();
        lblPass.setText("Password: ");
        
        //create label
        Label lbl = new Label();
        lbl.setText("Welcome to EffortLogger V2.0");
        
        
        //create button
        Button btn = new Button();
        btn.setText("Login");
        btn.setDefaultButton(true);
        btn.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("The Username is: " + getUser());
                System.out.println("The password is: " + getPassword());
                
                if(getUser().equals("Ahmed") || getUser().equals("Max") || getUser().equals("Karina") || getUser().equals("Anish") || getUser().equals("Deniz")) {
                	HomeScreen homeScreen = new HomeScreen();
                	homeScreen.homeScreen(primaryStage, arrProj);
                }
                
            }
        });
        
        
        
        //load page with elements
        
        //Setting scenes
        HBox row0 = new HBox(lbl);
        HBox row1 = new HBox(userLabel,userText);
        HBox row2 = new HBox(lblPass,txtPass);
        HBox row3 = new HBox(btn);

        
        VBox vroot = new VBox(row0,row1,row2,row3);
        
        vroot.setAlignment(Pos.CENTER);
        row0.setAlignment(Pos.BASELINE_CENTER);
        row1.setAlignment(Pos.BASELINE_CENTER);
        row2.setAlignment(Pos.BASELINE_CENTER);
        row3.setAlignment(Pos.BASELINE_CENTER);

        broot = new BorderPane(vroot);
        broot.setCenter(vroot);
        
        //load stage
        primaryStage.setScene(new Scene(broot, 600, 600));
        
		
	}
	
	public String getUser() {
		return userText.getText();
	}
	
	public String getPassword() {
		return txtPass.getText();
	}
	
	
}
