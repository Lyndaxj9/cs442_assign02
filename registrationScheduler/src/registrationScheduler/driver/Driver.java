import registrationScheduler.util.FileProcessor;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.store.Results;
import registrationScheduler.store.Student;
import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.StudentObjectPool;
import registrationScheduler.algo.Scheduler;

public class Driver{

    public static void main(String[] args) {

        String inputFile = "";
        String outputFile = "";
        int numThreads = -1;
        int debugValue = -1;

        //Get the command line arguments and make sure that they
        //are valid
        if(args.length == 4) {
            inputFile = args[0];
            outputFile = args[1];

            try{

                numThreads = Integer.parseInt(args[2]);
                debugValue = Integer.parseInt(args[3]);

                if(numThreads < 0 || numThreads > 3){
                    System.out.println("Incorrect Value for Number of Threads");
                    System.exit(1);
                } else if(debugValue < 0 || debugValue > 4) {
                    System.out.println("Debug Value must be between 0 and 4");
                    System.exit(1);
                }
            } catch(NumberFormatException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        Logger log = Logger.getInstance();
        log.setDebugValue(debugValue);
        CourseObjectPool coursePool = CourseObjectPool.getObjectPool();
        StudentObjectPool studentPool = StudentObjectPool.getObjectPool();

        FileProcessor fileProcessor = new FileProcessor(log);
        Results storeResults = new Results(log);
        Scheduler scheduler = new Scheduler();
        Student[] students = new Student[80];

        CreateWorkers workerGenerate = new CreateWorkers(fileProcessor, storeResults, studentPool, coursePool, log, scheduler);

        workerGenerate.startWorkers(numThreads);

    }
}
