package wordCount.driver;

import wordCount.modules.populateTree.PopulateTree;
import wordCount.treesForStrings.TreeBuilder;
import wordCount.util.FileProcessor;

public class Driver {

	public static void main(String[] args) {
		
		FileProcessor fp = new FileProcessor("input.txt");
		TreeBuilder tb = new TreeBuilder();
		
		PopulateTree pTree = new PopulateTree(fp,tb);
		pTree.populateMyTree();
		
		tb.printNodes(tb.getOriginalNode());
	}

}
