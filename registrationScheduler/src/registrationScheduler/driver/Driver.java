import registrationScheduler.util.FileProcessor;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.store.Results;
import registrationScheduler.store.Student;
import registrationScheduler.util.Logger;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.StudentObjectPool;
import registrationScheduler.algo.Scheduler;

public class Driver{

    public static void main(String[] args) {

        // TODO : get command line inputs
        // How to handle exceptions

        Logger log = Logger.getInstance();
        log.setDebugValue(3);
        CourseObjectPool coursePool = CourseObjectPool.getObjectPool();
        StudentObjectPool studentPool = StudentObjectPool.getObjectPool();

        FileProcessor fileProcessor = new FileProcessor(log);
        Results storeResults = new Results(log);
        Scheduler scheduler = new Scheduler();
        Student[] students = new Student[80];

        CreateWorkers workerGenerate = new CreateWorkers(fileProcessor, storeResults, studentPool, coursePool, log, scheduler);

        workerGenerate.startWorkers(3);

        // Create ObjectPool here

    }
}
