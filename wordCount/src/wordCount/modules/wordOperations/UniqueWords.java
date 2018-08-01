package wordCount.modules.wordOperations;

import java.util.LinkedList;

import wordCount.treesForStrings.TreeBuilder;
import wordCount.util.Results;

public class UniqueWords implements VisitorI {
	private Results resultObj;
	
	public UniqueWords(Results resultObj) {
		this.resultObj = resultObj; 
	}

	@Override
	public void visit(TreeBuilder tb) {
		tb.countUniqueNodes(tb.getOriginalNode());
		resultObj.storeNewResult("Total Number of unique words: "+tb.getUniqueWords()+"\n");
	}
	
	
}
