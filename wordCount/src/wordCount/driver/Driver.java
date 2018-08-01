package wordCount.driver;

import wordCount.modules.populateTree.PopulateTree;
import wordCount.modules.wordOperations.TotalCharacters;
import wordCount.modules.wordOperations.TotalWords;
import wordCount.modules.wordOperations.UniqueWords;
import wordCount.treesForStrings.TreeBuilder;
import wordCount.util.FileProcessor;

public class Driver {

	public static void main(String[] args) {
		
		FileProcessor fp = new FileProcessor("input.txt");
		TreeBuilder tb = new TreeBuilder();
		
		PopulateTree pTree = new PopulateTree(fp,tb);
		pTree.populateMyTree();
		
		tb.printNodes(tb.getOriginalNode());
		
		TotalWords tw = new TotalWords();
		UniqueWords uw = new UniqueWords();
		TotalCharacters tc = new TotalCharacters();
		tb.accept(tw);
		tb.accept(uw);
		tb.accept(tc);
	}

}
