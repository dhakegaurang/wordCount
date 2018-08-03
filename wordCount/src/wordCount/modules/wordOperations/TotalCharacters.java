package wordCount.modules.wordOperations;

import wordCount.treesForStrings.Node;
import wordCount.treesForStrings.TreeBuilder;
import wordCount.util.MyLogger;
import wordCount.util.Results;
/**
 * The  program implements an application that
 * helps in calculating unique words from module 1 result
 * @author  Gaurang Dhake,Manu Sharma
 * @version 1.0
 * @since   08-03-2018
 */
public class TotalCharacters implements VisitorI {
	private Results resultObj;
	private MyLogger.DebugLevel var;
	private int totalCharacters;
	
	public TotalCharacters(Results resultObj) {
		this.var = MyLogger.DebugLevel.TotalCharacters;
		this.resultObj = resultObj;
		this.totalCharacters = 0;
		MyLogger.writeMessage("In TotalCharacter class",var);
	}
	/**
	 * This Visit method writes result to output file
	 * @param tb this parameter is the treebuilder
	 * The function is used to calculate and display Total characters
	 * @return None since return type is void
	 */
	@Override
	public void visit(TreeBuilder tb) {
		countCharacters(tb.getOriginalNode());
		resultObj.storeNewResult("Total Number of characters: "+totalCharacters);
	}

	/**
	 * This method calls countCharacters in Node class to Number of charcters for all nodes
	 * @param root This is root of original tree
	 * @return None Since this method has void return type
	 */
	public void countCharacters(Node root) {
		if(root!=null){
			countCharacters(root.getLeft());
			String []word = root.getWord().split("");
			totalCharacters += word.length;
			countCharacters(root.getRight());	
		}
	}
}
