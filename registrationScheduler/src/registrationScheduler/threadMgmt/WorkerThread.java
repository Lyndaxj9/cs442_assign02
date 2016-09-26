package registrationScheduler.threadMgmt;

import registrationScheduler.util.Logger;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.StudentObjectPool;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.Student;
import registrationScheduler.store.Course;

public class WorkerThread implements Runnable  {

    FileProcessor filePro;
    StdoutDisplayInterface results;
    private static Logger log;
    private static CourseObjectPool coursepool;
    private static StudentObjectPool studentpool;
    Student[] students;
    int counter;
    String [] parsedString = new String [8];
    int [] prefArray = new int [7];
    String delim = "\\s+";
    Student aStudent;
    String line;
	

    // createWorkers
    public WorkerThread(FileProcessor i_filePro, StdoutDisplayInterface i_results, StudentObjectPool s_pool, CourseObjectPool c_pool, Logger i_log){
    //public WorkerThread(FileProcessor i_filePro, StdoutDisplayInterface i_results, Student[] i_student, CourseObjectPool i_pool, Logger i_log){
        this.filePro = i_filePro;
        this.studentpool = s_pool;
        this.results = i_results;
        this.coursepool = c_pool;
        this.log = i_log;
        log.writeMessage("CONSTRUCTOR: WorkerThread() called.", Logger.DebugLevel.CONSTRUCTOR);
    }

    public void run() {
        log.writeMessage("METHOD: run() called.", Logger.DebugLevel.THREAD_RUN);
	storeStudentInfo();
    
        storeStudentInfo();
        studentpool.returnAllObjects();
        assignClasses(coursepool, studentpool, results);
     
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
        }
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
            System.out.println("Tobetrue");
            selectedCourse.incrementStudentCount();
            c_pool.returnObject(c);
            updated = true;
        }
        return updated;
    }

    public synchronized void assignClasses(CourseObjectPool c_pool, StudentObjectPool s_pool, StdoutDisplayInterface r_store) {
        for(int i=0; i<5; i++){
            while(s_pool.getCurrentObjectNum() < s_pool.capacity) {
               Student currentStudent = s_pool.loopObjects(); 
               int currentStuNum = s_pool.getCurrentObjectNum();
               int studentCourse = currentStudent.getLowestPref();
               while(!updateCourse(c_pool, studentCourse)) {
                   studentCourse = currentStudent.getLowestPref();
               }

//               updateSchedule(results, currentStuNum, studentCourse, i);

               
               Thread currT = Thread.currentThread();
               System.out.printf("Student %d, Low %d, Thread %d\n", currentStuNum, studentCourse, currT.getId());
            }

        }
    }


    /*
    public void updateSchedule(StdoutDisplayInterface r_store, int studentID, int courseNum, int currentIter) {
         switch(courseNum) {
             case 1:
                 (Results)r_store.schedule[studentID][currentIter] = 'A';
                 break;
             case 2:
                 r_store.schedule[studentID][currentIter] = 'B';
                 break;
             case 3:
                 r_store.schedule[studentID][currentIter] = 'C';
                 break;
             case 4:
                 r_store.schedule[studentID][currentIter] = 'D';
                 break;
             case 5:
                 r_store.schedule[studentID][currentIter] = 'E';
                 break;
             case 6:
                 r_store.schedule[studentID][currentIter] = 'F';
                 break;
             case 7:
                 r_store.schedule[studentID][currentIter] = 'G';
                 break;
             
        }

    }*/

    
    // method{Store results at everystep or at the end into Results class
    //read from file and store preferences in student

    // - ALGO METHODS



}
