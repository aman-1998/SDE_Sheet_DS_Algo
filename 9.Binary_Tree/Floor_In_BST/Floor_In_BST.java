package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Floor_In_BST {
	
	private static Node res = null;
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 15);
		root = Insertion_In_BST.insert(root, 2);
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 13);
		root = Insertion_In_BST.insert(root, 17);
		root = Insertion_In_BST.insert(root, 6);
		
		floorInBST(root, 9);
		
		System.out.println(res);
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static Node floorInBST(Node root, int key) {
		find(root, key);
		return res;
	}
	
	public static void find(Node root, int key) {
		
		if(root == null) {
			return;
		} else if(root.data <= key) {
			res = root;
			find(root.right, key);
		} else {
			find(root.left, key);
		}
	}
}
