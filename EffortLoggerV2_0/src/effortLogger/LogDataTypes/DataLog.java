package effortLogger.LogDataTypes;

import java.util.Date;

public class DataLog {

	int id;
	Date date;
	Date startTime;
	Date endTime;
	Long deltaTime;
	String project;
	String lifeCycle;
	String effortCategory;
	String plan;
	
	
	//Constructor
	public DataLog(int input_id, Date input_startTime, 
			Date input_endTime, String input_Project, String input_LifeCycle, 
			String input_EffortCategory, String input_Plan) {
		
		id = input_id;
		date = input_startTime;
		startTime = input_startTime;
		endTime = input_endTime;
		deltaTime = Math.abs(startTime.getTime() - endTime.getTime());
		project = input_Project;
		lifeCycle = input_LifeCycle;
		effortCategory = input_EffortCategory;
		plan = input_Plan;
		
		
	}
	
	
	//Getter methods
	public int getID() {
		return id;
	}
	
	public String getDate() {
		
		return date.toString();
	
	}
	
	public String getStartTime() {
		return startTime.toString();
	}
	
	public String getEndTime() {
		return endTime.toString();
	}
	
	public Long getDeltaTime() {
		return deltaTime;
	}
	
	public String getProject() {
		return project;
	}
	
	public String getLifeCycle() {
		return lifeCycle;
	}
	
	public String getEffortCategory() {
		return effortCategory;
	}
	
	public String getPlan() {
		return plan;
	}
	
	public String toString() {
		return this.getID() + " " + this.getDate() + " " + this.getStartTime() + " " + 
				this.getEndTime() + " " + this.getDeltaTime() + " " + this.getProject()+
				" " + this.getLifeCycle() + " " + this.getEffortCategory() +
				" " + this.getPlan();
	}
	
}
