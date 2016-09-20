package registrationScheduler.threadMgmt;

import registrationScheduler.util.Logger;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterface;

public class WorkerThread implements Runnable  {

    //have data members for
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
