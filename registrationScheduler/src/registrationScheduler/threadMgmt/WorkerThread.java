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
<<<<<<< HEAD
import registrationScheduler.store.Results;
=======
import registrationScheduler.algo.Scheduler;
>>>>>>> 1c6e60b2b74dd954de37e58bcd3706f99869bf60

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
            aStudent = ((StudentObjectPool)studentpool).borrowObject(79);
            if(aStudent!=null){
                aStudent.printSchedule();
            }
            //printStudentsSchedules();

        } catch(InterruptedException e) {
// ...
        }
     
    }

    
    //-- METHODS ----------------------------------------------------
	public synchronized void storeStudentInfo(){
				while( (getLine())!= null){
				}
	}

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
                ((StudentObjectPool)studentpool).returnObject(lineCount);
                //students[lineCount] = aStudent;
                Thread currentThread = Thread.currentThread();			
            }
		
		}
	
		return line;

    }

<<<<<<< HEAD
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
        

    
    public synchronized int lowestPref(StudentObjectPool s_pool, int n){
        Student currentStudent = s_pool.borrowObject(n);    
        if(currentStudent != null) {
            return currentStudent.getLowestPref();
        }
        return -1;
    }

    public synchronized boolean updateCourse(CourseObjectPool c_pool, int c) {
        Course selectedCourse = c_pool.borrowObject(c);
        boolean updated = false;
        if (selectedCourse != null && selectedCourse.getTotalStudents() < selectedCourse.getCapacity()) {
            selectedCourse.incrementStudentCount();
            c_pool.returnObject(c);
            updated = true;
        }
        return updated;
    }

    public void assignClasses(CourseObjectPool c_pool, StudentObjectPool s_pool, StdoutDisplayInterface r_store) {
	//r_store = new Results(log);
	//Results results = (Results) r_store;
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

		   //results.addToDataStruct(currentStudent);
                   //System.out.printf("Student %d, Low %d, Thread %d\n", currentStuNum, studentCourse, currT.getId());

                }
            }
            
            s_pool.returnAllObjects();

        }
    }

    

=======
>>>>>>> 1c6e60b2b74dd954de37e58bcd3706f99869bf60
    public synchronized void printStudentsSchedules() {
        while(((StudentObjectPool)studentpool).getCurrentObjectNum() < ((StudentObjectPool)studentpool).capacity) {
            aStudent = ((StudentObjectPool)studentpool).loopObjects();
            int studentnum = ((StudentObjectPool)studentpool).getCurrentObjectNum();
            if(aStudent != null) {
                //System.out.printf("Student %d  ", studentnum);
                aStudent.printSchedule();
            }
        
        }
    }


}
