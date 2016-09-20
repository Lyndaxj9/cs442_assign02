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
	private String lines[] = new String [80];
    private static Logger log;
	
	//Constructor
	public FileProcessor(Logger i_log){
        this.log = i_log;
		
		try{
			file = new File("input.txt");
			filereader = new FileReader(file);
			bufferedReader = new BufferedReader (filereader);
			storeLines();

            log.writeMessage("CONSTRUCTOR: FileProcessor() called.", Logger.DebugLevel.CONSTRUCTOR);
			
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	    	
	
	}

	public void storeLines() throws IOException {
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
	
	public String getLine(int i){
		return lines[i];
	}
			
}	
