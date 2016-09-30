package registrationScheduler.threadMgmt;

import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.StudentObjectPool;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.store.Student;
import registrationScheduler.store.Course;
import registrationScheduler.store.Results;
import registrationScheduler.algo.Scheduler;

public class WorkerThread implements Runnable  {

    FileProcessor filePro;
    StdoutDisplayInterface results;
    private static Logger log;
    private static ObjectPool coursepool;
    private static ObjectPool studentpool;
    private Scheduler scheduler;
    int counter;
    String [] parsedString = new String [8];
    int [] prefArray = new int [7];
    String delim = "\\s+";
    Student aStudent;
    String line;
	

    public WorkerThread(FileProcessor i_filePro, StdoutDisplayInterface i_results, ObjectPool s_pool, ObjectPool c_pool, Logger i_log, Scheduler i_schedule){
        this.filePro = i_filePro;
        this.studentpool = s_pool;
        this.results = i_results;
        this.coursepool = c_pool;
        this.log = i_log;
        this.scheduler = i_schedule;
        log.writeMessage("CONSTRUCTOR: WorkerThread() called.", Logger.DebugLevel.CONSTRUCTOR);
    }

    public void run() {

        try{
            log.writeMessage("METHOD: run() called.", Logger.DebugLevel.THREAD_RUN);
        storeStudentInfo();
        
            storeStudentInfo();
            ((StudentObjectPool)studentpool).returnAllObjects();
            Thread.sleep(1000);
            ((Results)results).addToDataStruct(scheduler.getAvgPref());
            //printStudentsSchedules();

        } catch(InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
     
    }

    
    //-- METHODS ----------------------------------------------------
	public synchronized void storeStudentInfo(){
				while( (getLine())!= null){
				}
				//((Results)results).writeSchedulesToScreen();
	}

	/**
	 * @return String - Returns a line that contains a student's name
	 * and course preferences
	 */
	public synchronized String getLine(){

		line = filePro.getNextLine();
		int lineCount = filePro.getLineCount();

		if(line != null){
			parsedString = line.split(delim);
			aStudent = ((StudentObjectPool)studentpool).borrowObject(lineCount);
            if(aStudent != null) {
                aStudent.setName(parsedString[0]);
                for(int i = 1;i<8;i++){
                    prefArray[i-1] = Integer.parseInt(parsedString[i]);
                }
                aStudent.setPreference(prefArray);
                scheduler.assignFive(aStudent, coursepool);
		((Results)results).addToDataStruct(aStudent);
		log.writeMessage("ADD_ENTRY: entry added to Results array", Logger.DebugLevel.ADD_ENTRY);	
                ((StudentObjectPool)studentpool).returnObject(lineCount);
                //Thread currentThread = Thread.currentThread();			
            }
		
		}
		
	
		return line;

    }

    public synchronized void printStudentsSchedules() {
        while(((StudentObjectPool)studentpool).getCurrentObjectNum() < ((StudentObjectPool)studentpool).getCapacity()) {
            aStudent = ((StudentObjectPool)studentpool).loopObjects();
            int studentnum = ((StudentObjectPool)studentpool).getCurrentObjectNum();
            if(aStudent != null) {
                aStudent.printSchedule();
            }
        
        }
    }


}
