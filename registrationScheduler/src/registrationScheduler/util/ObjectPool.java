package registrationScheduler.util;

public interface ObjectPool {

    public static void createObjects(){};

    public static void borrowObject(int item){};

    public static void returnObject(int item){};

    public static void returnAllObjects(){};

    //Have methods to:
    //validate
    //borrow
    //return

}
