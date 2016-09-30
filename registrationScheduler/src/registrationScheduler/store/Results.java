package registrationScheduler.store;

import registrationScheduler.util.Logger;
import java.io.PrintWriter;
import java.io.IOException;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {



   // appropriate data structure as private data member
    private PrintWriter writer;
    private static Logger log;
    private int maxClasses = 5;
    private int totalStudents = 80;
    public char[][] schedule = new char[totalStudents][maxClasses+1];
    //take up less space take less time to printer out values

    public Results(Logger i_log){
        this.log = i_log;
        log.writeMessage("CONSTRUCTOR: Results() called.", Logger.DebugLevel.CONSTRUCTOR);
    }





    // appropriate method to save prime number to the data structure

    public void writeSchedulesToScreen() {
	for(int i = 0; i<totalStudents;i++){
			System.out.print(schedule[i][0]);
			for(int j = 1; j <= maxClasses;j++){
				System.out.print(" " + schedule[i][j]);
			}
			System.out.print("\n");
	}
	System.out.print("The average preference value is X.Y");
    }

    public void writeSchedulesToFile(String fileName) {
        try {	
		writer = new PrintWriter(fileName);
		for(int i = 0; i<totalStudents;i++){
			writer.print(schedule[i][0]);
			for(int j = 1; j <= maxClasses;j++){
				writer.print(" " + schedule[i][j]);
			}
			writer.print("\n");
		}
		writer.print("The average preference value is X.Y");

	}catch(IOException e){
			e.printStackTrace();

   	}finally{
		writer.close();
	}
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


