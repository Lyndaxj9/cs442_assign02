package registrationScheduler.algo;

//imports
import registrationScheduler.store.Student;
import registrationScheduler.store.Course;
import registrationScheduler.util.ObjectPool;
import registrationScheduler.util.CourseObjectPool;


public class Scheduler {
    private Student student;
    private ObjectPool coursepool;
    private int backtrack = 0;
    //private Results;

    public synchronized void assignFive(Student student, ObjectPool coursepool) {
        int assignedCourses = 0;
        int coursesTried = 0;
        while(assignedCourses < 5 && coursesTried < 7) {
            int course = student.getRandomPref();
            //int course = student.getLowestPref();
            if(course != -1) {
                Course selectedcourse = ((CourseObjectPool)coursepool).borrowObject(course);

                while(selectedcourse == null && coursesTried < 7){
                    course = student.getRandomPref();
                    if(course != -1) {
                        selectedcourse = ((CourseObjectPool)coursepool).borrowObject(course);
                    } else {
                        coursesTried++;
                    }
                }
                    //System.out.println("Out of the while loop again?");
                if(selectedcourse != null){
                    if(checkCourse(selectedcourse, course)){
                        student.scheduleCourse(course+1);
                        assignedCourses++;
                    }
                    student.voidPreference(course);
                    coursesTried++;
                }
            }
        }
        //if(assignedCourses < 5)
    } 

    private synchronized void reassignCourses(Student fullStu, Student partStu, CourseObjectPool coursepool){
        for(int i = 0; i<7; i++) {
            Course availCourse = coursepool.borrowObject(i);
            while(availCourse == null) {
                availCourse = coursepool.borrowObject(i);
            }
            if(availCourse.getTotalStudents()<availCourse.getCapacity()) {
                Course fullCourse = coursepool.borrowObject(fullStu.getCourse(0));
                while(fullCourse == null);

            }
        }
    }

    private boolean checkCourse(Course aCourse, int courseid) {
        boolean updated = false;
        if(aCourse.getTotalStudents() < aCourse.getCapacity()) {
            aCourse.incrementStudentCount();
            ((CourseObjectPool)coursepool).returnObject(courseid);
            updated = true;
        }
        return updated;
    }
}
