package wordCount.modules.wordOperations;

import wordCount.treesForStrings.TreeBuilder;
import wordCount.util.Results;

public class TotalCharacters implements VisitorI {
	private Results resultObj;
	
	public TotalCharacters(Results resultObj) {
		this.resultObj = resultObj;
	}

	@Override
	public void visit(TreeBuilder tb) {
		
		tb.countCharacters(tb.getOriginalNode());
		resultObj.storeNewResult("Total Number of characters: "+tb.getTotalCharacters());
	}

}
