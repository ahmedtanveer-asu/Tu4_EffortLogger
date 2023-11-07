package effortLogger;

import java.util.ArrayList;
import java.util.Date;

import effortLogger.LogDataTypes.DataLog;
import effortLogger.LogDataTypes.Projects;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditLog{

	//Instantiate timer
	Date startTime;
	Date endTime;
	
	//Instantiate drop down lists
	ChoiceBox<String> ddlProject;
	ChoiceBox<String> ddlSelect;
	ChoiceBox<String> ddlLifeCycle;
	ChoiceBox<String> ddlEffortCategory;
	ChoiceBox<String> ddlPlan;

	//ArrayList for projects
	ArrayList<Projects> arrProj = new ArrayList<Projects>();
	
	//Prepare Life Cycle Steps for the drop down lists
	String[] arrBPLifeCycle = 
		{"Planning", "Information Gathering","Information Understanding",
				"Verifying","Outlining","Drafting","Finalizing",
				"Team Meeting","Coach Meeting","Skateholder Meeting"};
	
	String[] arrDPLifeCycle = 
		{"Problem Understanding","Conceptual Design Plan","Requirements","Conceptual Design",
				"Conceptual Design Review","Detailed Design Plan","Detailed Design/Prototype","Detailed Design Review",
				"Implementation Plan", "Test Case Generation","Solution Specification","Solution Review",
				"Unit/System Test","Reflection","Repository Update"};
	
	
	EditLog(Stage primaryStage, ArrayList<Projects> arrayProject){
		
		arrProj = arrayProject;

		ddlProject = new ChoiceBox<String>();
		ddlSelect = new ChoiceBox<String>();
		ddlLifeCycle = new ChoiceBox<String>();
		ddlEffortCategory = new ChoiceBox<String>();
		ddlPlan = new ChoiceBox<String>();
		
		fillProject();
		fillSelect();
		fillLifeCycle();
		fillEffortCategory();
		
		//set up event handlers for drop down lists
		ddlProject.setOnAction((event) -> {
			fillLifeCycle();
		});
		
		//Life Cycle Event
		ddlLifeCycle.setOnAction((event) -> {
			ddlLifeCycleChangedIndex();
		});
		
		
		//Create Labels
		Label lblTop = new Label("Effort Log Editor");
		lblTop.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lbl1 = new Label("1. Select the Project in order to edit its Effort Log.");
		lbl1.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lbl2a = new Label("2.a. Clear this Project's Effort Log.");
		lbl2a.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lbl2b = new Label("2.b. Select the Effort Log Entry to be modified and make it the Current Log Entry.");
		lbl2b.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lbl3a = new Label("3.a. Modify the Current Effort Log Entry's aatributes and press 'Update this Entry' when finished.");
		lbl3a.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lblDate = new Label("Date: ");
		lblDate.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lblStart = new Label("Start Time: ");
		lblStart.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lblStop = new Label("Stop Time: ");
		lblStop.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lblLifeCycle = new Label("Life Cycle Step: ");
		lblLifeCycle.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lblEffort = new Label("Effort Category: ");
		lblEffort.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lblSaved = new Label("This attributes have been saved.");
		lblSaved.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lbl3b = new Label("3.b. Delete the current Effort Log Entry");
		lbl3b.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lbl3c = new Label("Split the Current Effort Log Entry into two entries");
		lbl3c.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		Label lbl4 = new Label("4. Proceed to the Effort Log Console");
		lbl4.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		
		//Create TextFields
		TextField txtDate = new TextField();
		TextField txtStart = new TextField();
		TextField txtStop = new TextField();
		TextField txtOther = new TextField();
		
		//Create Buttons
		Button btnClear = new Button("Clear This Effort Log");
		Button btnUpdate = new Button("Update This Entry");
		Button btnDelete = new Button("Delete This Entry");
		Button btnSplit = new Button("Split This Entry into Two Entries");
		Button btnEffort = new Button("Proceed to the Effort Log Console");
		
		//Scenes
		
		//A ton of formatting stuff
		VBox v1 = new VBox(lbl1, ddlProject);
		VBox v2a = new VBox(lbl2a, btnClear);
		VBox v2b = new VBox(lbl2b,ddlSelect);
		
		//Entire 3a section
		HBox h3a1 = new HBox(lblDate, txtDate, lblStart, txtStart, lblStop, txtStop);
		VBox vLife = new VBox(lblLifeCycle,ddlLifeCycle);
		VBox vEffort = new VBox(lblEffort, new HBox(ddlEffortCategory, ddlPlan));
		HBox h3a2 = new HBox(lblSaved, btnUpdate);
		//
		
		VBox v3a = new VBox(lbl3a, h3a1, vLife, vEffort, h3a2);
		VBox v3b = new VBox(lbl3b, btnDelete);
		HBox hBot = new HBox(new VBox(lbl3c,btnSplit), new VBox(lbl4, btnEffort));
		
		HBox rowHeader = new HBox(lblTop);
		HBox row0 = new HBox(v1,v2a);
		HBox row1 = new HBox(v2b);
		HBox row2 = new HBox(v3a);
		HBox row3 = new HBox(v3b);
		HBox rowFooter = new HBox(hBot);
		
		
		//Formatting
		rowHeader.setAlignment(Pos.TOP_CENTER);
		row0.setAlignment(Pos.CENTER);
		row1.setAlignment(Pos.CENTER);
		row1.setSpacing(10);
		row1.setStyle("-fx-padding: 10 10 10 10");
		row2.setAlignment(Pos.CENTER);
		row2.setSpacing(10);
		row2.setStyle("-fx-padding: 10 10 25 10");
		row3.setAlignment(Pos.CENTER_LEFT);
		row3.setStyle("-fx-padding: 10 10 10 40");
		rowFooter.setAlignment(Pos.CENTER);
		rowFooter.setStyle("-fx-padding: 10 10 10 40");
		

		VBox vPane = new VBox(lblTop,rowHeader,row0,row1,row2, row3, rowFooter);
		
		//Set stage
		primaryStage.setScene(new Scene(vPane, 600, 600));
		
		primaryStage.show();
		
	}
	
	public void fillProject(){
		
		//Fill Project
		for(int i = 0; i < arrProj.size(); i++) {
			if(!ddlProject.getItems().contains(arrProj.get(i).getDataLog().getProject())) {
				System.out.println(arrProj.get(i).getDataLog().getProject());
				ddlProject.getItems().add(arrProj.get(i).getDataLog().getProject());
			}
		}
		
		if(arrProj.size() > 0) {
			ddlProject.setValue(arrProj.get(0).getDataLog().getProject());
		}
		
	}
	
	public void fillSelect() {
		
		String selectedValue = (String)ddlProject.getValue();
		
		for(int i = 0; i < arrProj.size(); i++) {
			if(selectedValue.equals(arrProj.get(i).getDataLog().getProject())){
				String toAdd = (i+1) + ". " 
						+ arrProj.get(i).getDataLog().getDate() + " " 
						+ arrProj.get(i).getDataLog().getLifeCycle() + ", "
						+ arrProj.get(i).getDataLog().getEffortCategory() + "; "
						+ arrProj.get(i).getDataLog().getPlan();
				
				ddlSelect.getItems().add(toAdd);
 			}
		}
		
	}
	
	public void fillLifeCycle() {
		
		String selectedValue = (String)ddlProject.getValue();
		
		if(selectedValue.equals("Business Project")) {
			ddlLifeCycle.getItems().clear();
			ddlLifeCycle.getItems().addAll(arrBPLifeCycle);
		} else if(selectedValue.equals("Development Project")){
			ddlLifeCycle.getItems().clear();
			ddlLifeCycle.getItems().addAll(arrDPLifeCycle);
		}
		
	}
	
	public void fillEffortCategory() {
		
		ddlEffortCategory.getItems().addAll("Plans","Deliverables","Interruptions","Defects","Others");
		
	}
	
	public void ddlLifeCycleChangedIndex() {

		String sV = (String)ddlLifeCycle.getValue();
		
		if(sV == null) {
			ddlEffortCategory.setValue("");
			ddlPlan.setValue("");
		}else if (sV.equals("Planning")) {
			
			ddlEffortCategory.setValue("Plans");
			ddlPlan.setValue("Project Plan");
			
		} else if(sV.equals("Conceptual Design Plan")) {
			
			ddlEffortCategory.setValue("Plans");
			ddlPlan.setValue("Conceptual Design Plan");
			
		} else if(sV.contains("Information") || sV.equals("Verifying") 
			|| sV.contains("Meeting") || sV.equals("Problem Understanding")
			|| sV.equals("Requirements") || sV.contains("Conceptual Design")) {

			ddlEffortCategory.setValue("Deliverables");
			ddlPlan.setValue("Conceptual Design");
		
		}else if(sV.equals("Outlining")) {
		
			ddlEffortCategory.setValue("Deliverables");
			ddlPlan.setValue("Outline");
		
		}else if(sV.equals("Drafting")) {
		
			ddlEffortCategory.setValue("Deliverables");
			ddlPlan.setValue("Draft");
		
		}else if(sV.equals("Finalizing")) {
	
			ddlEffortCategory.setValue("Deliverables");
			ddlPlan.setValue("Report");
	
		}else if(sV.equals("Detailed Design Plan")) {
	
			ddlEffortCategory.setValue("Plans");
			ddlPlan.setValue("Detailed Design Plan");
	
		}else if(sV.equals("Detailed Design/Prototype") || sV.equals("Detailed Design Review")) {
			
			ddlEffortCategory.setValue("Deliverables");
			ddlPlan.setValue("Detailed Design");
			
		}else if(sV.equals("Implementation Plan")) {
			
			ddlEffortCategory.setValue("Plans");
			ddlPlan.setValue("Implementation Plan");
			
		}else if(sV.equals("Test Case Generation")) {
			
			ddlEffortCategory.setValue("Deliverables");
			ddlPlan.setValue("Test Cases");
			
		}else if(sV.contains("Solution") || sV.equals("Unit/System Test")) {
			
			ddlEffortCategory.setValue("Deliverables");
			ddlPlan.setValue("Solution");
			
		}
		
		
	}

	
}
