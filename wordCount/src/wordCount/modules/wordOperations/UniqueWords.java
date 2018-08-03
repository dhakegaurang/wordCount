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
public class UniqueWords implements VisitorI {
	private Results resultObj;
	private MyLogger.DebugLevel var;
	private int uniqueWords;
	
	public UniqueWords(Results resultObj) {
		this.var = MyLogger.DebugLevel.UniqueWords;
		this.resultObj = resultObj;
		this.uniqueWords = 0;
		MyLogger.writeMessage("In Unique Words class",var);
	}
	/**
	 * This Visit method writes result to output file
	 * @param tb this parameter is the treebuilder
	 * The function is used to calculate and display unique words
	 * @return None since return type is void
	 */
	@Override
	public void visit(TreeBuilder tb) {
		countUniqueNodes(tb.getOriginalNode());
		resultObj.storeNewResult("Total Number of unique words: "+uniqueWords+"\n");
	}
	
	/**
	 * This method calls countUniqueNodes in Node class to Number of unique nodes
	 * @param root This is root of original tree
	 * @return None Since this method has void return type
	 */
	public void countUniqueNodes(Node root){
		
		if(root!=null){
			countUniqueNodes(root.getLeft());
			if(root.getCount() == 1) {
				uniqueWords++;
			}
			countUniqueNodes(root.getRight());	
		}
	}
}
