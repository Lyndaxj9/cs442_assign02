import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.store.Results;
import registrationScheduler.util.Logger;

public class Driver{

    public static void main(String[] args) {
        System.out.println("CS442 Assignment02");
        // Create FileProcessor and Results first
        Results storeResults = new Results();

        //Logger doesn't seem to be setting the debuglevel
        Logger log = new Logger();
        log.setDebugValue(3);

        System.out.println(log);

        CreateWorkers workerGenerate = new CreateWorkers(storeResults, log);
        // Create ObjectPool here

    }
}
