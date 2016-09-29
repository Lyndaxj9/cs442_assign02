package registrationScheduler.store;

import registrationScheduler.util.Logger;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {
    // appropriate data structure as private data member
    
    private static Logger log;
    private int maxClasses = 5;
    private int totalStudents = 80;
    public char[][] schedule = new char[totalStudents][maxClasses];
    //take up less space take less time to printer out values

    public Results(Logger i_log){
        this.log = i_log;
        log.writeMessage("CONSTRUCTOR: Results() called.", Logger.DebugLevel.CONSTRUCTOR);
    }

    // appropriate method to save prime number to the data structure

    public void writeSchedulesToScreen() {
	// ..
        System.out.println("writeSchedulesToScreen()");
    }

    public void writeSchedulesToFile() {
        //...
        System.out.println("writeSchedulesToFile()");
    }

    public void updateSchedule(int studentId, int courseNum, int currentLine) {
        switch(courseNum) {
            case 1:
                schedule[studentId][currentLine] = 'A';
                break;
            case 2:
                schedule[studentId][currentLine] = 'B';
                break; 
            case 3:
                schedule[studentId][currentLine] = 'C';
                break;
            case 4:
                schedule[studentId][currentLine] = 'D';
                break; 
            case 5:
                schedule[studentId][currentLine] = 'E';
                break; 
            case 6:
                schedule[studentId][currentLine] = 'F';
                break; 
            case 7:
                schedule[studentId][currentLine] = 'G';
                break; 
        }
    }
} 


