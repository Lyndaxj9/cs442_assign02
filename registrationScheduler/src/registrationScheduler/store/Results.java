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
    public String[][] schedule = new String[totalStudents+1][2];
    private String scheduleClass;
	private int dataStructIndex = -1;
	
    //take up less space take less time to printer out values

    public Results(Logger i_log){
        this.log = i_log;
        log.writeMessage("CONSTRUCTOR: Results() called.", Logger.DebugLevel.CONSTRUCTOR);
    }


    // appropriate method to save prime number to the data structure

    public void writeSchedulesToScreen() {
	for(int i = 0; i<totalStudents;i++){
			System.out.println(schedule[i][0] + " " +  schedule[i][1]);
	}
	System.out.print("The average preference value is X.Y");
    }

    public void writeSchedulesToFile(String fileName) {
        try {	
		writer = new PrintWriter(fileName);
		for(int i = 0; i<totalStudents;i++){
			writer.println (schedule[i][0]+ " " + schedule[i][1]);
		}
		writer.print("The average preference value is X.Y");

	}catch(IOException e){
			e.printStackTrace();

   	}finally{
		writer.close();
	}
	// ..
        System.out.println("writeSchedulesToScreen()");
    }

    public synchronized void addToDataStruct(Student student){
        scheduleClass = "";
        dataStructIndex++;
        //System.out.println("This is the Student's name" + student.getName());
        schedule[dataStructIndex][0] = student.getName();

        for(int j = 0;j<5;j++){
            scheduleClass = scheduleClass + " " + student.getCschedule()[j];

        }
        schedule[dataStructIndex][1] = scheduleClass;
        //System.out.println( schedule[dataStructIndex][0] + schedule[dataStructIndex][1] );

    }

    public synchronized void addToDataStruct(Double avg) {
        schedule[totalStudents][0] = Double.toString(avg);
    }

} 
