package registrationScheduler.util;

import registrationScheduler.store.Student;

public class StudentObjectPool{
    private static StudentObjectPool objPool = new StudentObjectPool();

    public static int capacity = 80;
    public static Student[] students = new Student[capacity];

    public static StudentObjectPool getObjectPool() {
        createObjects();
        return objPool;
    }

    public static void createObjects(){
        for (int i = 0; i<capacity; i++) {
            students[i] = new Student();
        } 
    }
    //Have methods to:
    //validate
    //borrow
    //return

}
