package wordCount.driver;

import wordCount.util.FileProcessor;

public class Driver {

	public static void main(String[] args) {
		
		FileProcessor fp = new FileProcessor("input.txt");
		
		String line = fp.readLine();
		while(line != null) {
			System.out.println(line);
			line = fp.readLine();
		}

	}

}
