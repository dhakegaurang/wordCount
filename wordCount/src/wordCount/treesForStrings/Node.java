package wordCount.treesForStrings;

public class Node {

	private String word;
	private Node left;
	private Node right;
	private int count;
	
	public Node(String word){
		this.word = word;
		left = null;
		right = null;
		count = 1;
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
