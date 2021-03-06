package registrationScheduler.store;

public class Course {
	
	private int totalStudents=0;
    private int capacity=60;
	
	/*
	 * @return int -Returns total number of students in this course
	 */
	public int getTotalStudents(){
		return totalStudents;
	}

	/*
	 * @return int - Returns the maximum capacity of the course 
	 */
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
