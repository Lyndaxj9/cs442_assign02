package registrationScheduler.algo;

//imports
import registrationScheduler.store.Student;
import registrationScheduler.store.Course;
import registrationScheduler.util.ObjectPool;
import registrationScheduler.util.CourseObjectPool;


/*
 * This class contains the logic and methods for assigning students 
 * to classes
 */
public class Scheduler {
    //Current student being scheduled
    private Student student;

    //Object pool to get courses
    private ObjectPool coursepool;

    //Double value containing the total average of all the student 
    //preferences
    private double averagePref = 0;

    /*
     * Assigns a student classes randomlly
     */
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

        averagePref += student.getTotalPref()/5;
    } 

    /*
     * Checks if a course is available
     * @return boolean true if course is available
     */
    private boolean checkCourse(Course aCourse, int courseid) {
        boolean updated = false;
        if(aCourse.getTotalStudents() < aCourse.getCapacity()) {
            aCourse.incrementStudentCount();
            ((CourseObjectPool)coursepool).returnObject(courseid);
            updated = true;
        }
        return updated;
    }

    /*
     * @return double the average preference score for all the student's assigned classes
     */
    public double getAvgPref() {
        return averagePref/80;
    }
}
