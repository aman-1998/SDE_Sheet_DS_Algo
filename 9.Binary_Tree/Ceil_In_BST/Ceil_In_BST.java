package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Ceil_In_BST {
	
	private static Node res = null;
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 13);
		root = Insertion_In_BST.insert(root, 3);
		root = Insertion_In_BST.insert(root, 6);
		root = Insertion_In_BST.insert(root, 11);
		root = Insertion_In_BST.insert(root, 14);
		root = Insertion_In_BST.insert(root, 2);
		root = Insertion_In_BST.insert(root, 4);
		root = Insertion_In_BST.insert(root, 9);
		
		ceilInBST(root, 8);
		
		System.out.println(res);
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static Node ceilInBST(Node root, int key) {
		find(root, key);
		return res;
	}
	
	public static void find(Node root, int key) {
		
		if(root == null) {
			return;
		} else if(root.data >= key) {
			res = root;
			find(root.left, key);
		} else {
			find(root.right, key);
		}
	}
}
