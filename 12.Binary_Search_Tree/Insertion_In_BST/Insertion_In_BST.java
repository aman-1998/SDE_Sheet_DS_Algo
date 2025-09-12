package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Insertion_In_BST {

	public static void main(String[] args) {
		
		Node root = null;
		root = insert(root, 50);
		root = insert(root, 15);
		root = insert(root, 62);
		root = insert(root, 5);
		root = insert(root, 20);
		root = insert(root, 58);
		root = insert(root, 91);
		root = insert(root, 3);
		root = insert(root, 8);
		root = insert(root, 37);
		root = insert(root, 60);
		root = insert(root, 24);
		
		inorder(root);
	}
	
	/*
	 * In average case:
	 * T = O(h) = O(log n) ; h = height of tree
	 * S = O(h) = O(log n)
	 * 
	 * In worst case: (Left or right skewed BST => as good as LinkedList)
	 * T = O(n)
	 * S = O(n)
	 */
	public static Node insert(Node root, int data) {
		
		if(root == null) {
			root = new Node(data);
			return root;
		} else if(data <= root.data) {
			root.left = insert(root.left, data);
		} else if(data > root.data) {
			root.right = insert(root.right, data);
		}
		
		return root;
	}
	
	public static void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
}
