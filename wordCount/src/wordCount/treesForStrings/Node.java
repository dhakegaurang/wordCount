package wordCount.treesForStrings;

import wordCount.util.MyLogger;
/**
 * The  program implements an application that
 * Node ,declartion for tree elements and its structure
 * @author  Gaurang Dhake,Manu Sharma
 * @version 1.0
 * @since   08-03-2018
 */
public class Node {
	private MyLogger.DebugLevel var;
	private String word;
	private Node left;
	private Node right;
	private int count;


	public Node(String word){
		this.var = MyLogger.DebugLevel.Node;
		this.word = word;
		left = null;
		right = null;
		count = 1; // setting value 1 as default considering it is unique node
		MyLogger.writeMessage("In Node class:",var);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Node [" + (word != null ? "word=" + word + ", " : "") + (left != null ? "left=" + left + ", " : "")
				+ (right != null ? "right=" + right : "") + "]";
	}
	
}
