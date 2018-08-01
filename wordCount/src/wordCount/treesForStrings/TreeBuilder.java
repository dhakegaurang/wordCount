package wordCount.treesForStrings;

import java.util.HashSet;
import java.util.Set;

import wordCount.modules.wordOperations.VisitorI;

public class TreeBuilder {
	
	private Node originalNode;
	private int uniqueWords;
	private int totalCharacters;
	
	public TreeBuilder() {
		this.originalNode = null;
		uniqueWords = 0;
		totalCharacters = 0;
	}
	
	/**
	   * This method searched required node with bNumber specified or null if not found
	   * @param id This is bNumber to be searched in the node
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
	
	public int size(){
        return size(originalNode);
    }
	
    public int size(Node node){
        if (node == null)
            return 0;
        else
            return(size(node.getLeft()) + 1 + size(node.getRight()));
    }
	
	/**
	   * This method calls printData in Node class to print nodes in inorder
	   * @param result result object on respective output file to store result in it
	   * @param root This is root of original tree or any backup trees to start traversing the tree
	   * @return None Since this method has void return type
	   */
	/*public void printNodes(Node root){
		if(root!=null){
			printNodes(root.getLeft());
			System.out.println(root.getWord());
			printNodes(root.getRight());	
		}
	}*/
	
	public void countUniqueNodes(Node root){
		
		if(root!=null){
			countUniqueNodes(root.getLeft());
			if(root.getCount() == 1) {
				uniqueWords++;
			}
			countUniqueNodes(root.getRight());	
		}
	}
	
	public void countCharacters(Node root) {
		if(root!=null){
			countCharacters(root.getLeft());
			String []word = root.getWord().split("");
			totalCharacters += word.length;
			countCharacters(root.getRight());	
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

	public int getUniqueWords() {
		return uniqueWords;
	}

	public void setUniqueWords(int uniqueWords) {
		this.uniqueWords = uniqueWords;
	}

	public int getTotalCharacters() {
		return totalCharacters;
	}

	public void setTotalCharacters(int totalCharacters) {
		this.totalCharacters = totalCharacters;
	}
	
}
