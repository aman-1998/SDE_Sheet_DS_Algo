package algorithms.utility;

public class Node {
	public int data;
	public Node down;
	public Node next;
	
	public Node() {
		
	}
	
	Node(int data, Node down, Node next) {
		this.data = data;
		this.down = down;
		this.next = next;
	}
}
