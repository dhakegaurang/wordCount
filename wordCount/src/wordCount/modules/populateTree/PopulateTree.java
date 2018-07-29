package wordCount.modules.populateTree;

import wordCount.treesForStrings.TreeBuilder;
import wordCount.util.FileProcessor;

public class PopulateTree {

	private FileProcessor fp;
	private TreeBuilder tb;
	
	public PopulateTree(FileProcessor fp, TreeBuilder tb) {
		this.tb = tb;
		this.fp = fp;
	}

	public void populateMyTree() {
		
		String line = fp.readLine();
		while(line != null) {
			String[] words = line.split(" ");
			for(String word : words) {
				tb.insert(word);
			}
			line = fp.readLine();
		}
		
	}

	
}
