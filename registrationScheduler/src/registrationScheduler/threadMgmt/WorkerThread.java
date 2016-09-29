package registrationScheduler.threadMgmt;

import registrationScheduler.util.Logger;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.StudentObjectPool;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.store.Student;
import registrationScheduler.store.Course;
import registrationScheduler.algo.Scheduler;

public class WorkerThread implements Runnable  {

    FileProcessor filePro;
    StdoutDisplayInterface results;
    //Results results;
    private static Logger log;
    private static CourseObjectPool coursepool;
    private static StudentObjectPool studentpool;
    private Scheduler scheduler;
    int counter;
    String [] parsedString = new String [8];
    int [] prefArray = new int [7];
    String delim = "\\s+";
    Student aStudent;
    String line;
	

    // createWorkers
    public WorkerThread(FileProcessor i_filePro, StdoutDisplayInterface i_results, StudentObjectPool s_pool, CourseObjectPool c_pool, Logger i_log, Scheduler i_schedule){
    //public WorkerThread(FileProcessor i_filePro, StdoutDisplayInterface i_results, Student[] i_student, CourseObjectPool i_pool, Logger i_log){
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
            studentpool.returnAllObjects();
            //assignClasses(coursepool, studentpool, results);
            Thread.sleep(1000);
            aStudent = studentpool.borrowObject(79);
            if(aStudent!=null){
                aStudent.printSchedule();
            }
            //printStudentsSchedules();

        } catch(InterruptedException e) {
// ...
        }
     
        /*
        while(studentpool.getCurrentObjectNum() < 80) {
            aStudent = studentpool.loopObjects();
            int stunum = studentpool.getCurrentObjectNum();
            System.out.printf("Student_%d ", stunum);
            int[] prf = aStudent.getPreference();
            for(int i = 0; i<7; i++) {
                System.out.printf("%d ", prf[i]);
            }
            System.out.printf("\n");

        */
        
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
			aStudent = studentpool.borrowObject(lineCount);
            if(aStudent != null) {
                aStudent.setName(parsedString[0]);
                for(int i = 1;i<8;i++){
                    prefArray[i-1] = Integer.parseInt(parsedString[i]);
                }
                aStudent.setPreference(prefArray);
                scheduler.assignFive(aStudent, coursepool);
                studentpool.returnObject(lineCount);
                //students[lineCount] = aStudent;
                Thread currentThread = Thread.currentThread();			
            }
		
		}
	
		return line;

    }

/*
        Thread currentThread = Thread.currentThread();

        int[] prefs = {4,2,3,1,5,6,7};
        for (int i = 0; i<80; i++) {
            //students[i] = new Student();
            Student doSo = studentpool.borrowObject(i);
            if(doSo != null) {
                doSo.setPreference(prefs);
                System.out.printf("Pref'd Student %d\n", i);
                System.out.println(currentThread.getId());
            }
            //students[i].setPreference(prefs);
        }

        studentpool.returnAllObjects();

        assignClasses(coursepool, studentpool, results);
        */
         
        /*
        for (counter = 0; counter<80; counter++) {
            int course = lowestPref(studentpool, counter);
            boolean gotT = false;
            if(course != -1) {
                gotT = updateCourse(coursepool, course);
            }
            System.out.printf("Student %d, Low %d ", counter, course);
            System.out.println(gotT);
        }
        */
        

    

    /*
    public void assignClasses(CourseObjectPool c_pool, StudentObjectPool s_pool, StdoutDisplayInterface r_store) {
//        for(int i=0; i<5; i++){
        counter = 0;
        for(; c_pool.getCurrentSchedule() < c_pool.maxClasses; c_pool.incrementCurrentSchedule()) {
            int i = c_pool.getCurrentSchedule();
            System.out.printf("LOOP ITER #%d\n", i);
            while(s_pool.getCurrentObjectNum() < s_pool.capacity) {
                Student currentStudent = s_pool.loopObjects(); 
//                int currentStuNum = s_pool.getCurrentObjectNum();
                int currentStuNum = currentStudent.getStudentid();
                
                if(currentStudent != null) {
                    int studentCourse = currentStudent.getLowestPref();
                    while(studentCourse != -1 && !updateCourse(c_pool, studentCourse)) {
                        studentCourse = currentStudent.getLowestPref();
                    }

                    if(studentCourse != -1) {
                        if(currentStuNum == 59) {
                            System.out.printf("Class: %d\n", studentCourse);
                        }
                        currentStudent.scheduleCourse(studentCourse+1);
                    }
                    
                   Thread currT = Thread.currentThread();
                   System.out.printf("Student %d, Low %d, Thread %d\n", currentStuNum, studentCourse, currT.getId());

                }
            }
            
            s_pool.returnAllObjects();

        }
    }
*/
    

    public synchronized void printStudentsSchedules() {
        while(studentpool.getCurrentObjectNum() < studentpool.capacity) {
            aStudent = studentpool.loopObjects();
            int studentnum = studentpool.getCurrentObjectNum();
            if(aStudent != null) {
                System.out.printf("Student %d  ", studentnum);
                aStudent.printSchedule();
            }
        
        }
  }


}
