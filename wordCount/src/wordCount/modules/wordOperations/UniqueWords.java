package wordCount.modules.wordOperations;

import java.util.LinkedList;

import wordCount.treesForStrings.TreeBuilder;

public class UniqueWords implements VisitorI {
	
	public UniqueWords() {
		 
	}

	@Override
	public void visit(TreeBuilder tb) {
		tb.countUniqueNodes(tb.getOriginalNode());
		System.out.println("Unique Words"+tb.getUniqueWords());
	}
	
	
}
