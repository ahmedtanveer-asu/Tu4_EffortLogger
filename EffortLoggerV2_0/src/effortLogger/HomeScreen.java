package effortLogger;

import java.util.ArrayList;

import effortLogger.LogDataTypes.Projects;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HomeScreen {


	//ArrayList for projects
	ArrayList<Projects> arrProj = new ArrayList<Projects>();
	
	public void homeScreen(Stage primaryStage, ArrayList<Projects> arrayProject) {
		
		arrProj = arrayProject;
		homeScreen(primaryStage);
		
	}
	
	public void homeScreen(Stage primaryStage) {
		
		//Label for User Stories
		Label lblUserStory = new Label();
		lblUserStory.setText("User Stories: ");
		
		//RadioButton List to choose a story to edit
		ToggleGroup toggleG = new ToggleGroup();
		
		String[] userStories = {"story1","story2","story3"};
		
		VBox vpane = new VBox(lblUserStory);
		
		for(int i = 0; i < userStories.length; i++) {
			RadioButton rblUserStory = new RadioButton(userStories[i]);
			rblUserStory.setToggleGroup(toggleG);
			vpane.getChildren().add(rblUserStory);
		}
		
		
		//Button to EffortLogger Tool
		Button btnEffortLogger = new Button();
		btnEffortLogger.setText("Open EffortLogger");
		
		//Button event
		btnEffortLogger.setOnAction(value -> {
			
			LoggingSystem effortLogger = new LoggingSystem();
			effortLogger.loggingSystem(primaryStage, arrProj);
			
		});
		
		Button btnBack = new Button("Back Home");
		
		btnBack.setOnAction((event) -> {
			
			LoginScreen loginScreen = new LoginScreen();
			loginScreen.loginScreen(primaryStage, arrProj);
			
		});
		
		
		vpane.setAlignment(Pos.CENTER);
		btnBack.setAlignment(Pos.TOP_LEFT);
		
		GridPane gPane = new GridPane();
		
		gPane.add(vpane, 0, 0);
		gPane.add(btnEffortLogger, 1,0);
		
		VBox vPane2 = new VBox(btnBack, gPane);
		

        primaryStage.setScene(new Scene(vPane2, 600, 600));
		primaryStage.show();
		
		
	}
	
}
