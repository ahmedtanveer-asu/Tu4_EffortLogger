package effortLogger;

import java.util.ArrayList;
import java.util.Collections;

import effortLogger.LogDataTypes.Projects;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DisplayLogs {

	//Class simply to show all Logs
	DisplayLogs(Stage primaryStage, ArrayList<Projects> arrayProjects){
		
		ArrayList<Projects> arrProj = arrayProjects;
		//Collections.sort(arrProj);
		
		//Buttons to go back to EffortLogger
		Button btnEffort = new Button("Effort Log Console");
		Button btnEdit = new Button("Effort Log Editor");
		Button btnDefect = new Button("Defect Log Console");
		
		VBox vPane = new VBox();
		
		for(int i = 0; i < arrProj.size(); i++) {
			
			Label lbl1 = new Label(("" + arrProj.get(i).getDataLog().getID()));
			Label lbl2 = new Label(arrProj.get(i).getDataLog().getProject());
			Label lbl3 = new Label(arrProj.get(i).getDataLog().getDate());
			Label lbl4 = new Label(arrProj.get(i).getDataLog().getStartTime());
			Label lbl5 = new Label(arrProj.get(i).getDataLog().getEndTime());
			Label lbl6 = new Label("" + arrProj.get(i).getDataLog().getDeltaTime());
			Label lbl7 = new Label(arrProj.get(i).getDataLog().getLifeCycle());
			Label lbl8 = new Label(arrProj.get(i).getDataLog().getEffortCategory());
			Label lbl9 = new Label(arrProj.get(i).getDataLog().getPlan());
			HBox hbox = new HBox(lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9);
			
			vPane.getChildren().add(hbox);
			
		}
		
		

		//Set stage
		primaryStage.setScene(new Scene(vPane, 1000, 600));
		primaryStage.show();
		
	}
	
	
}
