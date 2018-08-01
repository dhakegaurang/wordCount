package wordCount.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
* InputProcessor program is responsible for parsing input line by line
*
* @author  Gaurang Dhake,Manu Sharma
* @version 1.0
* @since   08/03/2018
*/
public class FileProcessor {
	private String inputFilePath;
	private BufferedReader bReaderObj;
	private MyLogger.DebugLevel var;
	public FileProcessor(String inputFilePath) {
		this.inputFilePath = inputFilePath;
		try {
			this.var = MyLogger.DebugLevel.FILE_PROCESSOR;
			bReaderObj = new BufferedReader(new FileReader(inputFilePath));
			MyLogger.writeMessage("In File processor class:",var);
		} 
		catch (FileNotFoundException e) {
			System.err.println("Exception: File not found!!");
			System.err.println("Exiting...");
			System.exit(0);
		}
	}
	/**
	   * This is readLine method reads input file line by line
	   * @return String returns one String per line each time
	 * 	using any whitespace as the criteria to delimit words
	   */
	public String readLine() {
		try{
		    String line;
		    while ((line = bReaderObj.readLine()) != null) {
		       return line;
		    }
		}
		catch(IOException  e) { //handling in case of bufferedReader goes wrong
			System.err.println("Exception: while reading input file");
			System.err.println("Exiting...");
			System.exit(0);
		}
		catch(NumberFormatException e) { //handling in case integer is not found in input
			System.err.println("Exception: Please enter only integers in the input file");
			System.err.println("Exiting...");
			System.exit(0);
		}
		return null;
	}
}
