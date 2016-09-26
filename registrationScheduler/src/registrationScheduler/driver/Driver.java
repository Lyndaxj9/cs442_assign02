import registrationScheduler.util.FileProcessor;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.store.Results;
import registrationScheduler.store.Student;
import registrationScheduler.util.Logger;
import registrationScheduler.util.CourseObjectPool;

public class Driver{

    public static void main(String[] args) {

        Logger log = Logger.getInstance();
        log.setDebugValue(3);
        CourseObjectPool objPool = CourseObjectPool.getObjectPool();

        FileProcessor fileProcessor = new FileProcessor(log);
        Results storeResults = new Results(log);
        Student[] students = new Student[80];

        CreateWorkers workerGenerate = new CreateWorkers(fileProcessor, storeResults, students, objPool, log);

        workerGenerate.startWorkers(3);

        // Create ObjectPool here

    }
}
