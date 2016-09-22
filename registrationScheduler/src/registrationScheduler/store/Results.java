package registrationScheduler.store;

import registrationScheduler.util.Logger;

public class Results implements StdoutDisplayInterface {
    // appropriate data structure as private data member
    
    private static Logger log;

    public Results(Logger i_log){
        this.log = i_log;
        log.writeMessage("CONSTRUCTOR: Results() called.", Logger.DebugLevel.CONSTRUCTOR);
    }
    // appropriate method to save prime number to the data structure

    public void writeScheduleToScreen() {
	// ..
    }
} 


