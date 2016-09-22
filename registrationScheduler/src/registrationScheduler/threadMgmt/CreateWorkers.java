package registrationScheduler.threadMgmt;

import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.util.Logger;

public class CreateWorkers  {

    // member for FileProcessor
    FileProcessor filePro;
    // member for Results
    StdoutDisplayInterface results;
    private static Logger log; 

    public CreateWorkers(FileProcessor i_filePro, StdoutDisplayInterface i_results, Logger i_log) {
        this.filePro = i_filePro;
        this.results = i_results;
        this.log = i_log;
        log.writeMessage("CONSTRUCTOR: CreateWorkers() called.", Logger.DebugLevel.CONSTRUCTOR);
    }

    // this class has the method startWokers(...)
    public void startWorkers(int numThreads) {
        for (int i = 0; i<numThreads; i++) {
            Thread thread = new Thread(new WorkerThread(filePro, results, log));
            thread.start();
        } 
    }

}
