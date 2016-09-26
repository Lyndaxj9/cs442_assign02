package registrationScheduler.store;

public class Course {
	
	private int totalStudents=0;
    private int capacity=60;
	
	public int getTotalStudents(){
		return totalStudents;
	}

    public int getCapacity(){
        return capacity;
    }
	
	public void setTotalStudents(int totalStudentsIn){
		this.totalStudents = totalStudentsIn;
	}
	
	public void incrementStudentCount(){
		this.totalStudents++;
	}


}
