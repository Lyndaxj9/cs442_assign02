package registrationScheduler.threadMgmt;

import registrationScheduler.util.Logger;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.Student;

public class WorkerThread implements Runnable  {

    FileProcessor filePro;
    StdoutDisplayInterface results;
    private static Logger log;
    private static CourseObjectPool objpool;
    Student[] students;
    int counter;
    // Students
    // Results
    //

    // createWorkers
    public WorkerThread(FileProcessor i_filePro, StdoutDisplayInterface i_results, Student[] i_student, CourseObjectPool i_pool, Logger i_log){
        this.filePro = i_filePro;
        this.students = i_student;
        this.results = i_results;
        this.objpool = i_pool;
        this.log = i_log;
        log.writeMessage("CONSTRUCTOR: WorkerThread() called.", Logger.DebugLevel.CONSTRUCTOR);
    }

    public void run() {
        log.writeMessage("METHOD: run() called.", Logger.DebugLevel.THREAD_RUN);
        //
	//FileProcessor fileprocessor = new FileProcessor();
	/*	int countLines = 0;
		String line;
		String delim = "\\s+";
		Student studentArray[] = new Student[80];
		String [] parsedString = new String [8];
		int [] prefArray = new int [7];
		Student aStudent;

		while( (line = filePro.getLine(countLines)) != null){
			parsedString = line.split(delim);
			aStudent = new Student();
			aStudent.setName(parsedString[0]);
			for(int i = 1;i<8;i++){
				prefArray[i-1] = Integer.parseInt(parsedString[i]);
			}
			aStudent.setPreference(prefArray);
			studentArray[countLines] = aStudent;
			countLines++;
		}
        */

        int[] prefs = {4,2,3,1,5,6,7};
        for (int i = 0; i<80; i++) {
            students[i] = new Student();
            students[i].setPreference(prefs);
        }
         
        for (counter = 0; counter<80; counter++) {
            System.out.printf("Student %d\n", counter);
            System.out.println(students[counter].getLowestPref());
        }
        
        //
	// ...
    // Read lines from file using fileProcessor
    // Create all course objects in ObjectPool
    // Create Student objects
    // ...
    // Run the algorithm 
    // method{Get student and get top priority class}
    // method{Check if top class has available seats and if so assign the seat, using ObjectPool}
    // method{Store results at everystep or at the end into Results class
    }

    //read from file and store preferences in student

    // - ALGO METHODS
    

    

}
