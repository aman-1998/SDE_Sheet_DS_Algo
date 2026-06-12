package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Same_BT {
	
	private static boolean isSame = true;
	
	public static void main(String[] args) {
		
		Node root1 = null;
		root1 = Insertion_In_BST.insert(root1, 5);
		root1 = Insertion_In_BST.insert(root1, 3);
		root1 = Insertion_In_BST.insert(root1, 8);
		root1 = Insertion_In_BST.insert(root1, 2);
		root1 = Insertion_In_BST.insert(root1, 7);
		
		Node root2 = null;
		root2 = Insertion_In_BST.insert(root2, 5);
		root2 = Insertion_In_BST.insert(root2, 3);
		root2 = Insertion_In_BST.insert(root2, 8);
		root2 = Insertion_In_BST.insert(root2, 2);
		root2 = Insertion_In_BST.insert(root2, 7);
		
		boolean check = isSameTree(root1, root2);
		
		System.out.println(check);
		
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static boolean isSameTree(Node root1,Node root2) {
        
		if(root1 == root2) {
			return true;
		}
		
		preorder_modified(root1, root2);
		
		return isSame;
		
    }
	
	public static void preorder_modified(Node root1, Node root2) {
		
		if(root1 == null && root2 != null) {
			isSame = false;
		}
		
		if(root1 != null && root2 == null) {
			isSame = false;
		}
		        
		if(root1 != null && root2 != null) {
			
			if(root1.data != root2.data) {
				isSame = false;
			}
			
			preorder_modified(root1.left, root2.left);
			preorder_modified(root1.right, root2.right);
		}
	}
}
