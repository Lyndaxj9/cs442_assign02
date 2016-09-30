import registrationScheduler.util.FileProcessor;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.store.Results;
import registrationScheduler.store.Student;
import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.StudentObjectPool;
import registrationScheduler.algo.Scheduler;
import registrationScheduler.store.StdoutDisplayInterface;
public class Driver{

    public static void main(String[] args) {

        // TODO : get command line inputs
        String inputFile = "";
        String outputFile = "";
        int numThreads;
        int debugValue;
        // How to handle exceptions

        if(args.length == 4) {
            inputFile = args[0];
            outputFile = args[1];
            numThreads = Integer.parseInt(args[2]);
            debugValue = Integer.parseInt(args[3]);

            /*
            if(numThreads < 0 || numThreads > 3){
                Syste
            }
            */
        }
        Logger log = Logger.getInstance();
        log.setDebugValue(3);
        CourseObjectPool coursePool = CourseObjectPool.getObjectPool();
        StudentObjectPool studentPool = StudentObjectPool.getObjectPool();

        FileProcessor fileProcessor = new FileProcessor(log);
        StdoutDisplayInterface storeResults = new Results(log);
        Scheduler scheduler = new Scheduler();
        Student[] students = new Student[80];

        CreateWorkers workerGenerate = new CreateWorkers(fileProcessor, storeResults, studentPool, coursePool, log, scheduler);

        workerGenerate.startWorkers(3);
	((Results)storeResults).writeSchedulesToScreen();
	((Results)storeResults).writeSchedulesToFile("output.txt");
	

    }
}
