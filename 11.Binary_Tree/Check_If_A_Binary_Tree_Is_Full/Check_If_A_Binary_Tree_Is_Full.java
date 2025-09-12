package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Check_If_A_Binary_Tree_Is_Full {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 4);
		root = Insertion_In_BST.insert(root, 6);
		root = Insertion_In_BST.insert(root, 9);
		root = Insertion_In_BST.insert(root, 14);
		//root = Insertion_In_BST.insert(root, 11);
		//root = Insertion_In_BST.insert(root, 15);
		
		System.out.println(isFull(root));
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
	public static boolean isFull(Node root) {
		if(isComplete(root)) {
			int countNodes = countNodes(root);
			int height = heightOfBT(root);
			if(countNodes == (int)Math.pow(2, height) - 1) {
				return true;
			}
		}
		
		return false;
	}
	
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
	
	public static int countNodes(Node root) {
		if(root == null) {
			return 0;
		} else if(root.left == null && root.right == null) {
			return 1;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
	}
	
	public static int heightOfBT(Node root) {
		if(root == null) {
			return 0;
		} else if(root.left == null && root.right == null) {
			return 1;
		} else {
			return Math.max(heightOfBT(root.left), heightOfBT(root.right)) + 1;
		}
	}
}
