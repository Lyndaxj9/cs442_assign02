
package registrationScheduler.util;

public class Logger{


    //Do we need to write a constructor for Logger in the enum?
    public static enum DebugLevel { CONSTRUCTOR 
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public static void writeOutput() {
        System.out.println("Print something that is passed as an argument");
    }

    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
