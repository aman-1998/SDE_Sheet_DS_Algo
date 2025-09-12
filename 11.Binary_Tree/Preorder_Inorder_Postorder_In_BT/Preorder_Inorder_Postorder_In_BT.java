package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Preorder_Inorder_Postorder_In_BT {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 4);
		root = Insertion_In_BST.insert(root, 6);
		root = Insertion_In_BST.insert(root, 9);
		root = Insertion_In_BST.insert(root, 14);
		root = Insertion_In_BST.insert(root, 11);
		
		preorder(root);
		
		System.out.println("\n=====================================");
		
		inorder(root);
		
		System.out.println("\n=====================================");
		
		postorder(root);
	}
	
	/*
	 * In average case:
	 * ----------------
	 * T = O(n) ; n = no. of nodes
	 * S = O(h) = O(log n) => average case or in case of BBST
	 * 
	 * 
	 * In worst case: (Left or right skewed BT => as good as LinkedList)
	 * ------------------------------------------------------------------
	 * T = O(n) ; n = no. of nodes
	 * S = O(n)
	 */
	public static void preorder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	/*
	 * In average case:
	 * ----------------
	 * T = O(n) ; n = no. of nodes
	 * S = O(h) = O(log n) => average case or in case of BBST
	 * 
	 * 
	 * In worst case: (Left or right skewed BT => as good as LinkedList)
	 * ------------------------------------------------------------------
	 * T = O(n) ; n = no. of nodes
	 * S = O(n)
	 */
	public static void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	/*
	 * In average case:
	 * ----------------
	 * T = O(n) ; n = no. of nodes
	 * S = O(h) = O(log n) => average case or in case of BBST
	 * 
	 * 
	 * In worst case: (Left or right skewed BT => as good as LinkedList)
	 * ------------------------------------------------------------------
	 * T = O(n) ; n = no. of nodes
	 * S = O(n)
	 */
	public static void postorder(Node root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
}
