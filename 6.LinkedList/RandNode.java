package algorithms.utility;

public class RandNode {
	
	public int data;
	public RandNode next;
	public RandNode random;
	
	public RandNode(int data, RandNode next, RandNode random) {
		this.data = data;
		this.next = next;
		this.random = random;
	}
	
	public RandNode() {}
}
