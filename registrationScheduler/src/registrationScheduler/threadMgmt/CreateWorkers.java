package registrationScheduler.threadMgmt;

import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.Student;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.StudentObjectPool;
import registrationScheduler.util.Logger;

public class CreateWorkers  {

    Student[] students;
    private static CourseObjectPool coursepool;
    private static StudentObjectPool studentpool;
    FileProcessor filePro;
    // member for Results
    StdoutDisplayInterface results;
    private static Logger log; 

    public CreateWorkers(FileProcessor i_filePro, StdoutDisplayInterface i_results, StudentObjectPool s_pool, CourseObjectPool c_pool, Logger i_log) {
        this.filePro = i_filePro;
        this.studentpool = s_pool;
        this.coursepool = c_pool;
        this.results = i_results;
        this.log = i_log;
        log.writeMessage("CONSTRUCTOR: CreateWorkers() called.", Logger.DebugLevel.CONSTRUCTOR);
    }

    // this class has the method startWokers(...)
    public void startWorkers(int numThreads) {
        for (int i = 0; i<numThreads; i++) {
            Thread thread = new Thread(new WorkerThread(filePro, results, studentpool, coursepool, log));
            thread.start();
        } 
    }

}
