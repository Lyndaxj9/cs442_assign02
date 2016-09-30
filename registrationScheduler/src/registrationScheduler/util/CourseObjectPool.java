package registrationScheduler.util;

import registrationScheduler.store.Course;

public class CourseObjectPool implements ObjectPool {
    private static CourseObjectPool objPool = new CourseObjectPool();

    public static int capacity = 7;
    public static int currentCourse = 0;
    public static Course[] courses = new Course[capacity];
    public static int[] check = new int[capacity];

    /*
     * @return CourseObjectPool object
     */
    public static CourseObjectPool getObjectPool() {
        createObjects();
        return objPool;
    }

    public static void createObjects(){
        for (int i = 0; i<capacity; i++) {
            courses[i] = new Course();
        } 
    }

    /*
     * @return a Course object
     */
    public static synchronized Course borrowObject(int item) {
        if(check[item] == 0){
            check[item] = 1;
            return courses[item];
        } 
        return null;
    }

    public static synchronized void returnObject(int item) {
        check[item] = 0;
    }


}
