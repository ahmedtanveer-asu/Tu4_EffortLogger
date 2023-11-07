package effortLogger.LogDataTypes;

public class Projects {

	String projectName;
	DataLog dataLog;
	
	public Projects(String pName, DataLog data){
		
		projectName = pName;
		dataLog = data;
		
	}
	
	public String getName() {
		return this.projectName;
	}
	
	public DataLog getDataLog() {
		return this.dataLog;
	}
	
}
