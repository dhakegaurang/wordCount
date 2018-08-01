package wordCount.driver;

import wordCount.modules.populateTree.PopulateTree;
import wordCount.modules.wordOperations.TotalCharacters;
import wordCount.modules.wordOperations.TotalWords;
import wordCount.modules.wordOperations.UniqueWords;
import wordCount.treesForStrings.TreeBuilder;
import wordCount.util.FileProcessor;
import wordCount.util.Results;

public class Driver {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		for(int i=1;i<5;i++) {
			Results resultObj = new Results("output.txt");
			FileProcessor fp = new FileProcessor("input.txt");
			TreeBuilder tb = new TreeBuilder();
			
			PopulateTree pTree = new PopulateTree(fp,tb);
			pTree.populateMyTree();
			
			TotalWords tw = new TotalWords(resultObj);
			UniqueWords uw = new UniqueWords(resultObj);
			TotalCharacters tc = new TotalCharacters(resultObj);
			tb.accept(tw);
			tb.accept(uw);
			tb.accept(tc);
			resultObj.writeToFile(resultObj.getResultStr());
		}
		long finishTime = System.currentTimeMillis();
		long total_time = (finishTime-startTime)/5;
		System.out.println("Total Time:" + total_time +"ms");
		
	}

}
