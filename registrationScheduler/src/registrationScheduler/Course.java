
public class Course {
	
	private int totalStudents=0;
	
	public int getTotalStudents(){
		return totalStudents;
	}
	
	public void setTotalStudents(int totalStudentsIn){
		this.totalStudents = totalStudentsIn;
	}
	
	public void incrementStudentCount(){
		this.totalStudents++;
	}

}
