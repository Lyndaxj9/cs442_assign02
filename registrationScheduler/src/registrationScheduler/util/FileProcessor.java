package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	private String line;
	private File file;
	private FileReader filereader;
	private BufferedReader bufferedReader;
	private String lines[] = new String [100];
	private int lineCount = -1;
    private static Logger log;
	
	//Constructor
	public FileProcessor(String fileNameIn, Logger i_log){
        this.log = i_log;
		

		try{
			file = new File(fileNameIn);
			filereader = new FileReader(file);
			bufferedReader = new BufferedReader (filereader);
			storeLines();

            log.writeMessage("CONSTRUCTOR: FileProcessor() called.", Logger.DebugLevel.CONSTRUCTOR);
			
		} catch (IOException e) {
			e.printStackTrace();
            System.exit(1);
		}
	    	
	
	}
    
	/*
     * @return a line number
     */
	public synchronized int getLineCount(){
		return this.lineCount;

	}

	public synchronized void storeLines() throws IOException {
		int numLines = 0;
		
		try {
			while((line = bufferedReader.readLine()) !=null){
					lines[numLines] = line;
					numLines++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			filereader.close();
		}

	}
	
    /*
     * @return a line
     */
	public synchronized String getNextLine(){
		this.lineCount++;
		return lines[lineCount];	
	}
			
}	
