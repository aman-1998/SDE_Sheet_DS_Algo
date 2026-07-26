package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Check_If_BT_Is_Balanced {
	
	private static boolean isBalanced = true;
	
	public static void main(String[] args) {
		
		Node root = null;
		
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 5);
		//root = Insertion_In_BST.insert(root, 3);
		root = Insertion_In_BST.insert(root, 20);
		root = Insertion_In_BST.insert(root, 25);
		root = Insertion_In_BST.insert(root, 22);
		root = Insertion_In_BST.insert(root, 15);
		
		//preorder_modified(root);
		
		isBalanced = isBalanced(root);
		
		System.out.println(isBalanced);
	}
	
	/*
	 * T = O(n*n)
	 * S = (n)
	 */
	public static void preorder_modified(Node root) {
		
		if(root != null) {
			int lh = height(root.left);
			int rh = height(root.right);
			if(Math.abs(lh - rh) > 1) {
				isBalanced = false;
			}
			
			preorder_modified(root.left);
			preorder_modified(root.right);
		}
	}
	
	public static int height(Node root) {
		
		if(root == null) {
			return 0;
		} else if(root.left == null && root.right == null) {
			return 1;
		} else {
			return 1 + Math.max(height(root.left), height(root.right));
		}
	}
	
	public static boolean isBalanced(Node root) {
		
		int h = height_modified(root); // T = O(n)
		
		if(h == -1) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static int height_modified(Node root) {
		
		if(root == null) {
			return 0;
		} else if(root.left == null && root.right == null) {
			return 1;
		} else {
			int lh = height_modified(root.left);
			int rh = height_modified(root.right);
			
			if(lh == -1 || rh == -1) {
				return -1;
			}
			
			if(Math.abs(lh - rh) > 1) {
				return -1;
			}
			
			return 1 + Math.max(lh, rh);
		}
	}
}
