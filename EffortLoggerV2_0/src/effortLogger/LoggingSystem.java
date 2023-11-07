package effortLogger;

import java.util.ArrayList;
import java.util.Date;

import effortLogger.LogDataTypes.DataLog;
import effortLogger.LogDataTypes.Projects;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoggingSystem {

	//Instantiate timer
	Date startTime;
	Date endTime;
	
	//Instantiate drop down lists
	ChoiceBox<String> ddlProject;
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
	
	
	public void loggingSystem(Stage primaryStage, ArrayList<Projects> arrayProjects) {
		
		arrProj = arrayProjects;
		loggingSystem(primaryStage);
		
	}
	
	public void loggingSystem(Stage primaryStage) {
		
		
		//instantiate labels
		//Setting formatting at the same time
		Label lblHeader = new Label("Effort Logger Console");
		lblHeader.setStyle("-fx-font-size: 20px; -fx-font-weight: bold");
		
		Label lblClockStatus = new Label("Clock is stopped");
		lblClockStatus.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: red");
		lblClockStatus.setPrefWidth(550);
		lblClockStatus.setAlignment(Pos.CENTER);
		
		Label lblNew = new Label("1. When you start a new activity, press the 'Start An Activity' button");
		lblNew.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		
		Label lblSelect = new Label("2. Select the project, life cycle step, effort category, and deliverable from the following lists:");
		lblSelect.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");

		Label lblStop = new Label("3. Press the 'Stop this Activity' to generate an effort log entry using the attributes above.");
		lblStop.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		
		Label lblDone = new Label("4. Unless you are done for the day, it is best to perform steps 1 and 2 above before resuming work.");
		lblDone.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 3 3 3 25");
		
		//instantiate and populate combo boxes
		ddlProject = new ChoiceBox<String>();
		ddlLifeCycle = new ChoiceBox<String>();
		ddlEffortCategory = new ChoiceBox<String>();
		ddlPlan = new ChoiceBox<String>();
		
		ddlProject.setPrefWidth(250);
		ddlLifeCycle.setPrefWidth(250);
		ddlEffortCategory.setPrefWidth(200);
		ddlPlan.setPrefWidth(300);

		//Set ddlLifeCycleBP
		ddlLifeCycle.getItems().addAll(arrBPLifeCycle);
		
		
		//Set Plan
		ddlPlan.getItems().addAll("Conceptual Design","Detailed Design","Test Cases","Solution","Reflection","Outline","Draft","Report","User Defined","Other");
		
		//set up event handlers
		ddlProject.setOnAction((event) -> {
			ddlProjectChangedIndex();
		});
		
		//Life Cycle Event
		ddlLifeCycle.setOnAction((event) -> {
			ddlLifeCycleChangedIndex();
		});
		
		//Effort Category Event
		ddlEffortCategory.setOnAction((event) -> {
			ddlEffortCategoryChangedIndex();
		});
		
		//Add items to Project
		ddlProject.getItems().add("Business Project");
		ddlProject.getItems().add("Development Project");
		//set default value
		ddlProject.setValue("Business Project");
		
		
		//LifeCycle will be changed dynamically
		//see function ddlProjectChangedIndex below for that
		
		//Add items to Effort Category
		ddlEffortCategory.getItems().addAll("Plans","Deliverables","Interruptions","Defects","Others");
		
		//Deliverable will be changed dynamically
		//see function ddlLifeCycleChangedIndex below for that
		
		
		//Instantiate buttons
		Button btnStart = new Button("Start an Activity");
		Button btnStop = new Button("Stop this Activity");
		Button btnEdit = new Button("Effort Log Editor");
		Button btnDefect = new Button("Defect Log Console");
		Button btnDefinitions = new Button("Definitions");
		Button btnLogs = new Button("Effort and Defect Logs");
		
		
		
		//Formatting and displaying everything
		Label lblProject = new Label("Project");
		lblProject.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
		Label lblLifeCycle = new Label("Life Cycle Step:");
		lblLifeCycle.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
		Label lblEffort = new Label("Effort Category:");
		lblEffort.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
		Label lblPlan = new Label("Plan:");
		lblPlan.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");

		
		//Back Button
		Button btnBack = new Button("Back Home");
		
		btnBack.setOnAction((event) -> {
			
			HomeScreen hScreen = new HomeScreen();
			hScreen.homeScreen(primaryStage, arrProj);
			
		});
		
		//Scenes
		
		//A ton of formatting stuff
		VBox vProject = new VBox(lblProject, ddlProject);
		VBox vLifeCycle = new VBox(lblLifeCycle, ddlLifeCycle);
		VBox vEffort = new VBox(lblEffort,ddlEffortCategory);
		VBox vPlan = new VBox(lblPlan,ddlPlan);
		
		HBox rowMenu = new HBox(btnBack);
		HBox rowHeader = new HBox(lblHeader);
		HBox row0 = new HBox(lblClockStatus);
		HBox rowStart = new HBox(btnStart);
		HBox row1 = new HBox(vProject,vLifeCycle);
		HBox row2 = new HBox(vEffort,vPlan);
		HBox rowStop = new HBox(btnStop);
		HBox rowBtn = new HBox(btnEdit,btnDefect,btnDefinitions,btnLogs);

		//more formatting
		rowMenu.setAlignment(Pos.TOP_LEFT);
		rowMenu.setStyle("-fx-padding: 10 10 10 10");
		rowHeader.setAlignment(Pos.TOP_CENTER);
		row0.setAlignment(Pos.CENTER);
		rowStart.setAlignment(Pos.CENTER_LEFT);
		rowStart.setStyle("-fx-padding: 0 0 0 40");
		row1.setAlignment(Pos.CENTER);
		row1.setSpacing(10);
		row1.setStyle("-fx-padding: 10 10 10 10");
		row2.setAlignment(Pos.CENTER);
		row2.setSpacing(10);
		row2.setStyle("-fx-padding: 10 10 25 10");
		rowStop.setAlignment(Pos.CENTER_LEFT);
		rowStop.setStyle("-fx-padding: 10 10 10 40");
		rowBtn.setAlignment(Pos.CENTER);
		rowBtn.setSpacing(10);
		rowBtn.setStyle("-fx-padding: 10 10 10 40");
		
		
		VBox vPane = new VBox(rowMenu,rowHeader,row0,lblNew,rowStart,lblSelect,row1,row2,lblStop,rowStop,lblDone,rowBtn);
		
		
		
		
		//Event Handlers for buttons
		
		Alert alert = new Alert(AlertType.NONE);
		
		//Start button
		btnStart.setOnAction((event)-> {
			
			if(lblClockStatus.getText().equals("Clock is running")) {
				
				alert.setAlertType(AlertType.ERROR);
				alert.setContentText("The clock is already running.");
				alert.show();
				
			} else {
				
				startTime = new Date();
				lblClockStatus.setText("Clock is running");
				lblClockStatus.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: green");
				
			}
			
		});
		
		//Stop button
		btnStop.setOnAction((event)->{
			
			if(lblClockStatus.getText().equals("Clock is running")) {
				
				endTime = new Date();
				System.out.println("StartTime is: " + startTime.toString() + " Endtime is: " + endTime.toString());
				System.out.println("Datediff is: " + Math.abs(startTime.getTime() - endTime.getTime()));
				lblClockStatus.setText("Clock is stopped");
				lblClockStatus.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: red");
				
				//Log the project
				//Might import ArrayList to make this easier for multiple logs
				DataLog newLog = new DataLog(arrProj.size() + 1, startTime, endTime, 
						ddlProject.getValue(), ddlLifeCycle.getValue(), 
						ddlEffortCategory.getValue(), ddlPlan.getValue());
				Projects newProj = new Projects(newLog.getProject(), newLog);
				
				arrProj.add(newProj);
				
			}else {
				
				alert.setAlertType(AlertType.ERROR);
				alert.setContentText("The clock is not running.");
				alert.show();
				
			}
			
		});
		
		btnEdit.setOnAction((event) ->{
			
			if(arrProj.size() > 0) {
				EditLog editLog = new EditLog(primaryStage, arrProj);
			}
			
		});
		
		btnLogs.setOnAction((event) ->{
			
			for (int i = 0 ; i < arrProj.size(); i++) {
				System.out.println("The log number is: " + arrProj.get(i).toString());
				DisplayLogs displayLog = new DisplayLogs(primaryStage, arrProj);
			}
			
		});
		
		//Set stage
		primaryStage.setScene(new Scene(vPane, 600, 600));
		
		
	}
	
	
	public void ddlProjectChangedIndex() {
		
		String selectedValue = (String)ddlProject.getValue();
		
		//Clear drop down list
		ddlLifeCycle.getItems().clear();
		
		if(selectedValue.equals("Business Project")) {
			//populate life cycle with BP items

			//Set ddlLifeCycleDP
			ddlLifeCycle.getItems().addAll(arrBPLifeCycle);
			
			ddlPlan.getItems().clear();
			ddlPlan.getItems().addAll("Conceptual Design","Detailed Design","Test Cases","Solution","Reflection","Outline","Draft","Report","User Defined","Other");
			
			
		} else if(selectedValue.equals("Development Project")) {
			//populate life cycle with DP items

			//Set ddlLifeCycleDP
			ddlLifeCycle.getItems().addAll(arrDPLifeCycle);
			ddlPlan.getItems().clear();
			ddlPlan.getItems().addAll("Project Plan","Risk Management Plan","Conceptual Design Plan","Detailed Design Plan","Implementation Plan");
		}
		
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

	public void ddlEffortCategoryChangedIndex() {
		//I think this isn't necessary
	}
	
	public void logEntry() {
		//Insert code to insert everything into a log
		//Probably create a new class for it
		
		
	}
	
	
	

}
