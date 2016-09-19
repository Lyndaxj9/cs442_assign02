import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.store.Results;
import registrationScheduler.util.Logger;

public class Driver{

    public static void main(String[] args) {
        System.out.println("CS442 Assignment02");
        // Create FileProcessor and Results first
        Results storeResults = new Results();

        Logger log = new Logger();

        CreateWorkers workerGenerate = new CreateWorkers();
        // Create ObjectPool here

    }
}
