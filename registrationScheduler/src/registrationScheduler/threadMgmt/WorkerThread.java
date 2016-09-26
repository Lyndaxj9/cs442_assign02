package registrationScheduler.threadMgmt;

import registrationScheduler.util.Logger;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.Student;

public class WorkerThread implements Runnable  {

    FileProcessor filePro;
    StdoutDisplayInterface results;
    private static Logger log;
    private static CourseObjectPool objpool;
    Student[] students;
    int counter;
    String [] parsedString = new String [8];
    int [] prefArray = new int [7];
    String delim = "\\s+";
    Student aStudent;
    String line;
	

    public WorkerThread(FileProcessor i_filePro, StdoutDisplayInterface i_results, Student[] i_student, CourseObjectPool i_pool, Logger i_log){
        this.filePro = i_filePro;
        this.students = i_student;
        this.results = i_results;
        this.objpool = i_pool;
        this.log = i_log;
        log.writeMessage("CONSTRUCTOR: WorkerThread() called.", Logger.DebugLevel.CONSTRUCTOR);
    }

    public void run() {
        log.writeMessage("METHOD: run() called.", Logger.DebugLevel.THREAD_RUN);
	storeStudentInfo();
     
        
    // Create all course objects in ObjectPool
    // Run the algorithm 
    // method{Get student and get top priority class}
    // method{Check if top class has available seats and if so assign the seat, using ObjectPool}
    // method{Store results at everystep or at the end into Results class
    }
	public synchronized void storeStudentInfo(){
				while( (getLine())!= null){
				}
	}

	public synchronized String getLine(){

		line = filePro.getNextLine();
		int lineCount = filePro.getLineCount();

		if(line != null){
			parsedString = line.split(delim);
			aStudent = new Student();
			aStudent.setName(parsedString[0]);
			for(int i = 1;i<8;i++){
				prefArray[i-1] = Integer.parseInt(parsedString[i]);
			}
			aStudent.setPreference(prefArray);
			students[lineCount] = aStudent;
			Thread currentThread = Thread.currentThread();			
		
		}
	
		return line;

	}

  

    

}
