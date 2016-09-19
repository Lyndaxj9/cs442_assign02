package registrationScheduler.threadMgmt;

import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterface;

public class WorkerThread implements Runnable  {

    //have data members for
    FileProcessor filePro;
    StdoutDisplayInterface results;
    // Students
    // Results
    //

    // createWorkers
    public WorkerThread(FileProcessor i_filePro, StdoutDisplayInterface i_results){
        this.filePro = i_filePro;
        this.results = i_results;
        //use logger to print
    }

    public void run() {
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
