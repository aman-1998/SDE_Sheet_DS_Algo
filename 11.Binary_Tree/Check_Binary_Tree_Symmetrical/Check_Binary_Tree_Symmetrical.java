package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Check_Binary_Tree_Symmetrical {
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(2);
		
		root.left.left = new Node(5);
		root.right.right = new Node(5);
		
		root.left.left.left = new Node(7);
		root.left.left.right = new Node(8);
		root.right.right.right = new Node(7);
		root.right.right.left = new Node(8);
		
		System.out.println(isSymmetric(root));
	}
	
	public static boolean isSymmetric(Node root) {
        
		return check(root.left, root.right);
    }
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static boolean check(Node root1, Node root2) {
		if(root1 != null && root2 != null) {
			
			return (root1.data == root2.data) 
					&& check(root1.left, root2.right)
					&& check(root1.right, root2.left);
			
		} else if(root1 == null && root2 == null) {
			return true;
		}
		
		return false;
	}
}
