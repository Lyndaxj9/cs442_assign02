package registrationScheduler.threadMgmt;

import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.util.Logger;

public class CreateWorkers  {

    // member for FileProcessor
    // FileProcessor filePro;
    // member for Results
    StdoutDisplayInterface results;
    private static Logger log; 

    public CreateWorkers(StdoutDisplayInterface i_results, Logger i_log) {
        this.results = i_results;
        this.log = i_log;
        log.writeOutput();
    }

    // this class has the method startWokers(...)
    public void startWorkers() {
        
    }

}
