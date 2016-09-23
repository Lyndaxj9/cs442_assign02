package registrationScheduler.util;

import registrationScheduler.store.Course;

public class CourseObjectPool{
    private static CourseObjectPool objPool = new CourseObjectPool();

    public static int capacity = 7;
    public static Course[] courses = new Course[capacity];

    public static CourseObjectPool getObjectPool() {
        createObjects();
        return objPool;
    }

    public static void createObjects(){
        for (int i = 0; i<capacity; i++) {
            courses[i] = new Course();
        } 
    }
    //Have methods to:
    //validate
    //borrow
    //return

}
