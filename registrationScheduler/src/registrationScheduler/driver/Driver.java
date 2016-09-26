import registrationScheduler.util.FileProcessor;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.store.Results;
import registrationScheduler.store.Student;
import registrationScheduler.util.Logger;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.StudentObjectPool;

public class Driver{

    public static void main(String[] args) {

        Logger log = Logger.getInstance();
        log.setDebugValue(3);
        CourseObjectPool coursePool = CourseObjectPool.getObjectPool();
        StudentObjectPool studentPool = StudentObjectPool.getObjectPool();

        FileProcessor fileProcessor = new FileProcessor(log);
        Results storeResults = new Results(log);
        Student[] students = new Student[80];

        CreateWorkers workerGenerate = new CreateWorkers(fileProcessor, storeResults, studentPool, coursePool, log);

        workerGenerate.startWorkers(2);

        // Create ObjectPool here

    }
}
