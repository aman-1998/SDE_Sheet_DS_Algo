package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Count_Full_Nodes_In_BT {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 4);
		root = Insertion_In_BST.insert(root, 6);
		root = Insertion_In_BST.insert(root, 9);
		root = Insertion_In_BST.insert(root, 14);
		
		System.out.println(countFullNodes(root));
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
	public static int countFullNodes(Node root) { // Nodes having two children
		if(root == null) {
			return 0;
		} else if(root.left == null && root.right == null) {
			return 0;
		} else if(root.left != null && root.right != null) {
			return 1 + countFullNodes(root.left) + countFullNodes(root.right);
		} else {
			return countFullNodes(root.left) + countFullNodes(root.right);
		}
	}
}
