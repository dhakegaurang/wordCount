package wordCount.modules.wordOperations;

import wordCount.treesForStrings.TreeBuilder;
import wordCount.util.Results;

public class TotalWords implements VisitorI {
	private Results resultObj;
	
	public TotalWords(Results resultObj) {
		this.resultObj = resultObj;
	}

	@Override
	public void visit(TreeBuilder tb) {
		resultObj.storeNewResult("Total Number of words: "+tb.size()+"\n");
	}
	
}
