package registrationScheduler.util;

import registrationScheduler.store.Student;

public class StudentObjectPool{
    private static StudentObjectPool objPool = new StudentObjectPool();

    public static int capacity = 80;
    public static int currentStudent = 0;
    public static Student[] students = new Student[capacity];
    public static int[] check = new int[capacity];

    public static StudentObjectPool getObjectPool() {
        createObjects();
        return objPool;
    }

    public static void createObjects(){
        for (int i = 0; i<capacity; i++) {
            students[i] = new Student();
            check[i] = 0;
        } 
    }

    public static synchronized Student borrowObject(int item){
        if(check[item] == 0) {
            check[item] = 1;
            return students[item];
        } 
        return null;
    }

    public static synchronized void returnAllObjects(){
        for (int i = 0; i<capacity; i++) {
            check[i] = 0;
        } 
        currentStudent = 0;
    }

    public synchronized static int getCurrentObjectNum(){
        return currentStudent;
    }

    public synchronized static Student loopObjects(){
        while(check[currentStudent] != 0 && currentStudent<capacity) {
            currentStudent++;
        }
        if(check[currentStudent] == 0) {
            check[currentStudent] = 1;
            int retStu = currentStudent;
            currentStudent++;
            students[retStu].setStudentid(retStu);
            return students[retStu]; 
        } 
        
        return null;
    }
    //Have methods to:
    //validate
    //borrow
    //return

}