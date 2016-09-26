package registrationScheduler.store;

public class Student {

	//An array to store four preferences of a student
	private int[] preference = new int [7];
	
	//An array to store the final schedule of a student
	private int[] schedule = new int [7];
	
	//The name of the student
	private String name;
	
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

        preference[minLocation] = 10;
        return minLocation;
    }

	public void setPreference(int[] preferenceIn) {
		for(int i = 0;i < 7;i++)
			this.preference[i] = preferenceIn[i];
	}

	public int[] getSchedule() {
		return schedule;
	}

	public void setSchedule(int[] scheduleIn) {
		for(int i = 0;i < 7;i++)
			this.schedule[i] = scheduleIn[i];
	}

	public String getName() {
		return name;
	}

	public void setName(String nameIn) {
		this.name = nameIn;
	}

	public boolean isScheduleCheck() {
		return isValidSchedule;
	}

	public void setScheduleCheck(boolean scheduleCheckIn) {
		this.isValidSchedule = scheduleCheckIn;
	}
	
}	
