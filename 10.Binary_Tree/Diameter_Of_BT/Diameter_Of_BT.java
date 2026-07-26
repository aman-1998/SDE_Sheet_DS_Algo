package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Diameter_Of_BT {
	
	private static int max = 0;
	
	public static void main(String[] args) {
		
		Node root = null;
		
//		root = Insertion_In_BST.insert(root, 50);
//		root = Insertion_In_BST.insert(root, 60);
//		root = Insertion_In_BST.insert(root, 45);
//		root = Insertion_In_BST.insert(root, 30);
//		root = Insertion_In_BST.insert(root, 10);
//		root = Insertion_In_BST.insert(root, 5);
//		root = Insertion_In_BST.insert(root, 32);
//		root = Insertion_In_BST.insert(root, 34);
//		root = Insertion_In_BST.insert(root, 40);
//		root = Insertion_In_BST.insert(root, 43);
//		root = Insertion_In_BST.insert(root, 20);
//		root = Insertion_In_BST.insert(root, 25);
//		root = Insertion_In_BST.insert(root, 18);
//		root = Insertion_In_BST.insert(root, 15);
//		root = Insertion_In_BST.insert(root, 12);
		
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 2);
		root = Insertion_In_BST.insert(root, 4);
		root = Insertion_In_BST.insert(root, 1);
		root = Insertion_In_BST.insert(root, 6);
		
		diameter_2nd(root);
		
		System.out.println(max);
	}
	
	/*
	 * T = O(n*n)
	 * S = O(n)
	 */
	public static int diameter_1st(Node root) {
        
		preorder_traversal(root);

        return max;
    }
	
	public static void preorder_traversal(Node root) {
		
		if(root != null) {
			int len = 1 + height(root.left) + height(root.right); // plus 1 can be avoided as per the definition of diameter
			if(len > max) {
				max = len;
			}
			preorder_traversal(root.left);
			preorder_traversal(root.right);
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
	
	
	//=============================================================//
	
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static int diameter_2nd(Node root) {
        
		height_modified(root);

        return max;
    }
	
	public static int height_modified(Node root) {
		
		if(root == null) {
			return 0;
		} else if(root.left == null && root.right == null) {
			return 1;
		} else {
			int lh = height_modified(root.left);
			int rh = height_modified(root.right);
			
			int len = 1 + lh + rh; // plus 1 can be avoided as per the definition of diameter
			if(len > max) {
				max = len;
			}
			
			return 1 + Math.max(lh, rh);
		}
	}
}
