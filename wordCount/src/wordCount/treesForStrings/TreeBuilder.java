package wordCount.treesForStrings;

import wordCount.modules.wordOperations.VisitorI;
import wordCount.util.MyLogger;
/**
 * InputProcessor program is responsible for building tree
 *
 * @author  Gaurang Dhake,Manu Sharma
 * @version 1.0
 * @since   08/03/2018
 */
public class TreeBuilder {
	private MyLogger.DebugLevel var;
	private Node originalNode;
	
	public TreeBuilder() {
		this.var = MyLogger.DebugLevel.TreeBuilder;
		this.originalNode = null;
		MyLogger.writeMessage("In TreeBuilder class",var);
	}
	
	/**
	   * This method searched required node with bNumber specified or null if not found
	   * @param word This is bNumber to be searched in the node
	   * @return boolean returns true if node is found otherwise returns false
	   */
	public boolean searchMyNode(String word){
		Node current = originalNode;
		while(current!=null){
			if(word.compareTo(current.getWord()) == 0){	
				return true;
			}else if(word.compareTo(current.getWord()) > 0){
				current = current.getRight();
			}else if(word.compareTo(current.getWord()) < 0){
				current = current.getLeft();
			}
		}
		return false;
	}

	public void insert(String word){
		
		Node newNode = new Node(word);
		if(searchMyNode(word)) {
			newNode.setCount(0);
		}
		if(originalNode==null){
			originalNode = newNode;
			return;
		}
		Node current = originalNode;
		Node parent = null;
		while(true){
			parent = current;
			if(word.compareTo(current.getWord()) < 0) { 
				current = current.getLeft();
				if(current==null){
					parent.setLeft(newNode);
					return;
				}
			}else{
				current = current.getRight();
				if(current==null){
					parent.setRight(newNode);
					return;
				}
			}
		}
	}
	
	/**
	   * This method calls printData in Node class to print nodes in inorder
	   * @param root This is root of original tree
	   * @return None Since this method has void return type
	   */
	public void printNodes(Node root){
		if(root!=null){
			printNodes(root.getLeft());
			System.out.println(root.getWord());
			printNodes(root.getRight());	
		}
	}
	
	public void accept(VisitorI visitor) {
		visitor.visit(this);
	}
	
	public Node getOriginalNode() {
		return originalNode;
	}

	public void setOriginalNode(Node originalNode) {
		this.originalNode = originalNode;
	}

}
