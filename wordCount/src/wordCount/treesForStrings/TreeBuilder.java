package wordCount.treesForStrings;

import wordCount.modules.wordOperations.VisitorI;

public class TreeBuilder {
	
	private Node originalNode;
	
	public TreeBuilder() {
		this.originalNode = null;
	}
	
	/**
	   * This method searched required node with bNumber specified or null if not found
	   * @param id This is bNumber to be searched in the node
	   * @return None Since this method has void return type
	   */
	public Node searchNode(String word){
		
		Node current = originalNode;
		while(current!=null){
			if(word.compareTo(current.getWord()) == 0){	
				return current;
			}else if(word.compareTo(current.getWord()) > 0){
				current = current.getLeft();
			}else if(word.compareTo(current.getWord()) < 0){
				current = current.getRight();
			}
		}
		return null;	
	}
	
	public void insert(String word){
		Node newNode = new Node(word);
		if(originalNode==null){
			originalNode = newNode;
			return;
		}
		Node current = originalNode;
		Node parent = null;
		while(true){
			parent = current;
			if(word.compareTo(current.getWord()) < 0) { // if(id<current.data){				
				current = current.getLeft();
				if(current==null){
					parent.setLeft(newNode); //parent.left = newNode;
					return;
				}
			}else{
				current = current.getRight();
				if(current==null){
					parent.setRight(newNode); //parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public int size(){
        return size(originalNode);
    }
 
    /* computes number of nodes in tree */
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
