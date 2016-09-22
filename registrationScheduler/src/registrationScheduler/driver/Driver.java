import registrationScheduler.util.FileProcessor;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.store.Results;
import registrationScheduler.util.Logger;

public class Driver{

    public static void main(String[] args) {

        Logger log = Logger.getInstance();
        log.setDebugValue(4);

        FileProcessor fileProcessor = new FileProcessor(log);
        Results storeResults = new Results(log);

        CreateWorkers workerGenerate = new CreateWorkers(fileProcessor, storeResults, log);

        workerGenerate.startWorkers(2);

        // Create ObjectPool here

    }
}
