package practice.dsa.sheet.part6.utility;

public class Node {
	
	public int data;
	public Node left = null;
	public Node right = null;
	
	public Node(int data) {
		this.data = data;
	}
	
	public String toString() {
		return data + "";
	}
}
