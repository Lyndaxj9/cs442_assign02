package registrationScheduler.store;

import java.util.Random;

public class Student {

	//An array to store four preferences of a student
	private int[] preference = new int [7];
	
	//An array to store the final schedule of a student
	private int[] schedule = new int [7];
    
	//An array to store the final schedule of a student
	private char[] Cschedule = new char[5];
	
	//The name of the student
	private String name;

    //Position of student in StudentObjectPool
    private int studentId;

    private int amntClasses = 0;

    private double totalPreference = 0;
	
	//Validates whether a student can have a valid schedule
	private boolean isValidSchedule = false;
	
	
	
	public int[] getPreference() {
		return preference;
	}

    public synchronized int getLowestPref() {
        int minValue = 10;
        int minLocation = -1;
        for (int i = 0; i<7;i++) {
            if(minValue > this.preference[i]) {
                minValue = this.preference[i];
                minLocation = i;
            }
        }

        /*
        if(minLocation != -1) {
            preference[minLocation] = 10;
        }
        */
        return minLocation;
    }

    public synchronized int getHighestPref() {
        int maxValue = 0;
        int maxLocation = -1; 
        for(int i = 0; i<7;i++) {
            if(maxValue < this.preference[i]) {
                maxValue = this.preference[i];
                maxLocation = i;
            } 
        }

        return maxLocation;
    }

    public synchronized int getRandomPref() {
        int selectedCourse = -1;
        int attempts = 0;
        Random rand = new Random();
        int randomNum = rand.nextInt(7);
        
        while(this.preference[randomNum] == 10 && attempts < 7) {
            randomNum = rand.nextInt(7);
            attempts++;
        }
        if(this.preference[randomNum] != 10) {
            selectedCourse = randomNum;
        }

        //System.out.printf("Random int course: %d", randomNum);

        return selectedCourse;
    }

	public void setPreference(int[] preferenceIn) {
		for(int i = 0;i < 7;i++)
			this.preference[i] = preferenceIn[i];
	}

    public void voidPreference(int courseLoc) {
        this.preference[courseLoc] = 10;
    }

	public int[] getSchedule() {
		return schedule;
	}

    public int getCourse(int courseLoc) {
        return schedule[courseLoc];
    }

	public void setSchedule(int[] scheduleIn) {
		for(int i = 0;i < 7;i++)
			this.schedule[i] = scheduleIn[i];
	}

	public void setSchedule(char[] scheduleIn) {
		for(int i = 0;i < 5;i++)
			this.Cschedule[i] = scheduleIn[i];
	}

    public synchronized void scheduleCourse(int courseid) {
        if(amntClasses < 5) {
            this.Cschedule[amntClasses] = getCourseName(courseid);
            this.schedule[amntClasses] = courseid-1;
            this.totalPreference += this.preference[courseid-1];
            amntClasses++;
        }
    }

	public String getName() {
		return name;
	}

	public void setName(String nameIn) {
		this.name = nameIn;
	}

    public void setStudentid(int id) {
        this.studentId = id;
    }

    public int getStudentid() {
        return studentId;
    }

    public double getTotalPref() {
        return totalPreference;
    }

	public boolean isScheduleCheck() {
		return isValidSchedule;
	}

	public void setScheduleCheck(boolean scheduleCheckIn) {
		this.isValidSchedule = scheduleCheckIn;
	}
    
    public synchronized void printSchedule(){
        for(int i = 0; i<5; i++) {
            System.out.printf("%c ", Cschedule[i]);
        }
        System.out.printf("\n");
    }
	
	public char getCourseName(int courseID) {
        char courseName = ' ';
		switch(courseID){
			case 1:
                courseName = 'A';
			    break;
			case 2:
                courseName = 'B';
			    break;
			case 3:
                courseName = 'C';
			    break;
			case 4:
                courseName = 'D';
			    break;
			case 5:
                courseName = 'E';
			    break;
			case 6:
                courseName = 'F';
			    break;
			case 7:
                courseName = 'G';
			    break;
		}
    return courseName;

	}
	
}	
