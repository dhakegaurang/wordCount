package wordCount.modules.wordOperations;

import wordCount.treesForStrings.Node;
import wordCount.treesForStrings.TreeBuilder;
import wordCount.util.MyLogger;
import wordCount.util.Results;
/**
 * The  program implements an application that
 * helps in calculating Totals words from module 1 result
 * @author  Gaurang Dhake,Manu Sharma
 * @version 1.0
 * @since   08-03-2018
 */
public class TotalWords implements VisitorI {
	private Results resultObj;
	private MyLogger.DebugLevel var;
	private TreeBuilder tb;
	public TotalWords(Results resultObj) {
		this.var = MyLogger.DebugLevel.TotalWords;
		this.resultObj = resultObj;
		MyLogger.writeMessage("In Totalwords class",var);
	}
	/**
	 * This Visit method writes result to output file
	 * @param tb this parameter is the treebuilder
	 * The function is used to calculate and display Total words
	 * @return None since return type is void
	 */
	@Override
	public void visit(TreeBuilder tb) {
		this.tb = tb;
		resultObj.storeNewResult("Total Number of words: "+size()+"\n");
	}
	/**
	 * This method calls size in Node class to number of nodes
	 * @return int this method returns final size of the tree
	 */
	public int size(){
        return size(tb.getOriginalNode());
    }

	/**
	 * This method calls size in Node class to number of nodes
	 * @param node This is root of original tree
	 * @return int Since this method has int return type
	 */
    public int size(Node node){
        if (node == null)
            return 0;
        else
            return(size(node.getLeft()) + 1 + size(node.getRight()));
    }
}
