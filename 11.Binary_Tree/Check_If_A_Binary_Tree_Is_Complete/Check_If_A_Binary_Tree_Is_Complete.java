package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Check_If_A_Binary_Tree_Is_Complete {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 50);
		root = Insertion_In_BST.insert(root, 15);
		root = Insertion_In_BST.insert(root, 62);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 20);
		root = Insertion_In_BST.insert(root, 58);
		root = Insertion_In_BST.insert(root, 91);
		root = Insertion_In_BST.insert(root, 3);
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 37);
		root = Insertion_In_BST.insert(root, 60);
		root = Insertion_In_BST.insert(root, 24);
		
		System.out.println(isComplete(root));
		
		root = null;
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 4);
		root = Insertion_In_BST.insert(root, 6);
		root = Insertion_In_BST.insert(root, 9);
		root = Insertion_In_BST.insert(root, 14);
		root = Insertion_In_BST.insert(root, 11);
		root = Insertion_In_BST.insert(root, 15);
		
		System.out.println(isComplete(root));
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
	public static boolean isComplete(Node root) {
		if(root == null) {
			return false;
		} else if(root.left == null && root.right == null) {
			return true;
		} else if(root.left != null && root.right != null) {
			return isComplete(root.left) && isComplete(root.right);
		} else {
			return false;
		}
 	}
}
