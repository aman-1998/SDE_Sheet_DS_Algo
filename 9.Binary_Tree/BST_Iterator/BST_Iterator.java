package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import practice.dsa.sheet.part6.utility.Node;

public class BST_Iterator {
	
	private List<Integer> inorderArr = new ArrayList<>();
	private int index = 0;
	
	public static void main(String[] args) {
		 
		Node root = null;
		root = new Node(50);
		
		root.left = new Node(30);
		root.right = new Node(70);
		
		root.left.left = new Node(20);
		root.left.right = new Node(45);
		root.right.right = new Node(75);
		
		root.left.left.left = new Node(10);
		root.left.right.left = new Node(40);
		root.right.right.left = new Node(72);
		root.right.right.right = new Node(80);
		
		root.left.left.left.left = new Node(5);
		root.left.right.left.left = new Node(32);
		root.right.right.left.left = new Node(71);
		
		//BST_Iterator ob = new BST_Iterator(root);
		BST_Iterator2 ob = new BST_Iterator2(root);
		
		System.out.println(ob.next());
		System.out.println(ob.next());
		System.out.println(ob.next());
		System.out.println(ob.hasNext());
		System.out.println(ob.next());
		System.out.println(ob.next());
		System.out.println(ob.next());
		System.out.println(ob.hasNext());
		System.out.println(ob.hasNext());
		System.out.println(ob.next());
		System.out.println(ob.next());
		System.out.println(ob.next());
		System.out.println(ob.next());
		System.out.println(ob.next());
		System.out.println(ob.next());
		System.out.println(ob.next());
		System.out.println(ob.hasNext());
		System.out.println(ob.next());
		
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public BST_Iterator(Node root) {
		inorder(root);
	}
	
	public void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			inorderArr.add(root.data);
			inorder(root.right);
		}
	}
	
	/*
	 * T = O(1)
	 * S = O(n)
	 */
	public int next() {
		if(index < inorderArr.size()) {
			return inorderArr.get(index++);
		}
		return -1;
	}
	
	/*
	 * T = O(1)
	 * S = O(n)
	 */
	public boolean hasNext() {
		return index < inorderArr.size();
	}
}

/*
 * Here, we are using iterative inorder traversal
 * It is slightly better
 */
class BST_Iterator2 {
	
	private Stack<Node> stack = new Stack<>();
	
	/*
	 * T = O(h) , where h = height of the tree
	 * S = O(h)
	 */
	public BST_Iterator2(Node root) {
		if(root != null) {
			Node t = root;
			while(t != null) {
				stack.add(t);
				t = t.left;
			}
		}
	}
	
	/*
	 * T = O(h) but in average case T = O(1)
	 * S = O(h)
	 */
	public int next() {
		if(!stack.isEmpty()) {
			Node t = stack.pop();
			if(t.right != null) {
				Node p = t.right;
				while(p != null) {
					stack.add(p);
					p = p.left;
				}
			}
			return t.data;
		}
		return -1;
	}
	
	/*
	 * T = O(1)
	 * S = O(h)
	 */
	public boolean hasNext() {
		return !stack.isEmpty();
	}
}
