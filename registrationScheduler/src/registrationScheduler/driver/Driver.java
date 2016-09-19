import registrationScheduler.util.FileProcessor;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.store.Results;
import registrationScheduler.util.Logger;

public class Driver{

    public static void main(String[] args) {
        System.out.println("CS442 Assignment02");

        FileProcessor fileProcessor = new FileProcessor();
        Results storeResults = new Results();

        //instantiated properly not with new
        Logger log = new Logger();
        log.setDebugValue(4);

        System.out.println(log);

        CreateWorkers workerGenerate = new CreateWorkers(fileProcessor, storeResults, log);
        // Create ObjectPool here

    }
}
