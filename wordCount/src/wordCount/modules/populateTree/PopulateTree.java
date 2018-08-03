package wordCount.modules.populateTree;

import wordCount.treesForStrings.TreeBuilder;
import wordCount.util.FileProcessor;
import wordCount.util.MyLogger;
/**
 * The  program implements an application that
 * Populate tree with words under module 1
 * @author  Gaurang Dhake,Manu Sharma
 * @version 1.0
 * @since   08-03-2018
 */
public class PopulateTree {
	private MyLogger.DebugLevel var;
	private FileProcessor fp;
	private TreeBuilder tb;
	
	public PopulateTree(FileProcessor fp, TreeBuilder tb) {
		this.var = MyLogger.DebugLevel.PopulateTree;
		this.tb = tb;
		this.fp = fp;
		MyLogger.writeMessage("In Populate tree class:",var);
	}
	/**
	 * This method is used to for populateMyTree method
	 * populates a tree data structure with all the words in the file in module 1
	 */
	public void populateMyTree() {
		
		String line = fp.readLine();
		while(line != null) {
			if(!"".equals(line)) {
				String[] words = line.split(" ");
				for(String word : words) {
					tb.insert(word);
				}
				line = fp.readLine();
			}
		}
		
	}

	
}
