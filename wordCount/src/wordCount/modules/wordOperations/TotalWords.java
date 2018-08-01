package wordCount.modules.wordOperations;

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
		resultObj.storeNewResult("Total Number of words: "+tb.size()+"\n");
	}
	
}
