package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Maximum_And_Minimum_In_A_BST {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 4);
		root = Insertion_In_BST.insert(root, 6);
		root = Insertion_In_BST.insert(root, 9);
		root = Insertion_In_BST.insert(root, 14);
		
		int max = maxInBST(root);
		
		System.out.println(max);
		
		int min = minInBST(root);
		
		System.out.println(min);
	}
	
	/*
	 * T = O(n) ; in worst case (for right skewed)
	 * S = O(1)
	 */
	public static int maxInBST(Node root) {
		
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		
		Node t = root;
		while(t.right != null) {
			t = t.right;
		}
		
		return t.data;
	}
	
	/*
	 * T = O(n) ; in worst case (for left skewed)
	 * S = O(1)
	 */
	public static int minInBST(Node root) {
		
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		Node t = root;
		while(t.left != null) {
			t = t.left;
		}
		
		return t.data;
	}
}
