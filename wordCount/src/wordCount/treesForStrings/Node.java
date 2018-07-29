package wordCount.treesForStrings;

public class Node {

	private String word;
	private Node left;
	private Node right;
	
	public Node(String word){
		this.word = word;
		left = null;
		right = null;
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

	@Override
	public String toString() {
		return "Node [" + (word != null ? "word=" + word + ", " : "") + (left != null ? "left=" + left + ", " : "")
				+ (right != null ? "right=" + right : "") + "]";
	}
	
}
