package registrationScheduler.threadMgmt;

import registrationScheduler.util.Logger;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterface;

public class WorkerThread implements Runnable  {

<<<<<<< HEAD
    //have data members forc
=======
    //have data members for
>>>>>>> d79629e53d864c62b737cb4790992faed233ddab
    FileProcessor filePro;
    StdoutDisplayInterface results;
    private static Logger log;
    // Students
    // Results
    //

    // createWorkers
    public WorkerThread(FileProcessor i_filePro, StdoutDisplayInterface i_results, Logger i_log){
        this.filePro = i_filePro;
        this.results = i_results;
        this.log = i_log;
        log.writeMessage("CONSTRUCTOR: WorkerThread() called.", Logger.DebugLevel.CONSTRUCTOR);
    }

    public void run() {
        log.writeMessage("METHOD: run() called.", Logger.DebugLevel.THREAD_RUN);
<<<<<<< HEAD
	//FileProcessor fileprocessor = new FileProcessor();
		int countLines = 0;
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
=======
>>>>>>> d79629e53d864c62b737cb4790992faed233ddab
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
    //get

    

}
