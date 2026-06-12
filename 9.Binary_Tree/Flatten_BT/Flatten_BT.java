package practice.dsa.sheet.part6;

import java.util.Stack;

import practice.dsa.sheet.part6.utility.Node;

public class Flatten_BT {
	
	private static Stack<Node> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(5);
		
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		
		root.right.right = new Node(6);
		
		root.right.right.left = new Node(7);
		
		flatten_3rd(root);
		
		PrintRightSkewedBinary(root);
	}
	
	/*
	 * Good
	 * 
	 * T = O(n)
	 * S = O(n) + O(n) [stack + system-stack]
	 * => S = O(n)
	 */
	public static void flatten_1st(Node root) {
		
		if(root != null) {
			if(root.right != null) {
				stack.push(root.right);
				root.right = null;
			}
			Node nodeToBeAdded  = null;
			if(root.left == null) {
				if(stack.isEmpty()) {
					return;
				}
				nodeToBeAdded = stack.pop();
				if(nodeToBeAdded.right != null) {
					stack.push(nodeToBeAdded.right);
					nodeToBeAdded.right = null;
				}
			} else {
				nodeToBeAdded = root.left;
			}
			
			root.right = nodeToBeAdded;
			root.left = null;
			flatten_1st(root.right);
		}
	}
	
	/*
	 * Better
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	public static void flatten_2nd(Node root) {
		
		if(root == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			Node curr = stack.pop();
			
			if(curr.right != null) {
				stack.push(curr.right);
			}
			
			if(curr.left != null) {
				stack.push(curr.left);
			}
			
			if(!stack.isEmpty()) {
				curr.right = stack.peek();
			}
			
			curr.left = null;
		}
	}
	
	/*
	 * Best
	 * 
	 * T = O(n)
	 * S = O(1)
	 */
	public static void flatten_3rd(Node root) {
		
		Node curr = root;
		
		while(curr != null) {
			
			if(curr.left != null) {
				
				Node prev = curr.left;
				while(prev.right != null) {
					prev = prev.right;
				}
				
				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}
			
			curr = curr.right;
		}
 	}
	
	private static void PrintRightSkewedBinary(Node root) {
		
		Node t = root;
		
		while(t != null) {
			System.out.print(t.data + " ");
			t = t.right;
		}
	}
}
