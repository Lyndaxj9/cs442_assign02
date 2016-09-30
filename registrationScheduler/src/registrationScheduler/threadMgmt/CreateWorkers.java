package registrationScheduler.threadMgmt;

import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.Student;
import registrationScheduler.util.ObjectPool;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.StudentObjectPool;
import registrationScheduler.util.Logger;
import registrationScheduler.algo.Scheduler;

public class CreateWorkers  {

    private static ObjectPool coursepool;
    private static ObjectPool studentpool;
    private Scheduler scheduler;
    FileProcessor filePro;
    StdoutDisplayInterface results;
    private static Logger log; 

    public CreateWorkers(FileProcessor i_filePro, StdoutDisplayInterface i_results, StudentObjectPool s_pool, CourseObjectPool c_pool, Logger i_log, Scheduler i_schedule) {
        this.filePro = i_filePro;
        this.studentpool = s_pool;
        this.coursepool = c_pool;
        this.results = i_results;
        this.log = i_log;
        this.scheduler = i_schedule;
        log.writeMessage("CONSTRUCTOR: CreateWorkers() called.", Logger.DebugLevel.CONSTRUCTOR);
    }

    public void startWorkers(int numThreads) {
        for (int i = 0; i<numThreads; i++) {
            Thread thread = new Thread(new WorkerThread(filePro, results, studentpool, coursepool, log, scheduler));
            thread.start();
        } 
        //Are the threads also joined here I guess so?
    }

}
