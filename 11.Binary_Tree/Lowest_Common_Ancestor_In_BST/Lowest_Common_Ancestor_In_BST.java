package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Lowest_Common_Ancestor_In_BST {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 11);
		root = Insertion_In_BST.insert(root, 2);
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 12);
		root = Insertion_In_BST.insert(root, 7);
		root = Insertion_In_BST.insert(root, 9);
		root = Insertion_In_BST.insert(root, 1);
		
		Node p = root.left;
		Node q = root.right.right;
		
		//Node p = root.left.left.left;
		//Node q = root.left.right.left;
		
		//Node p = root.left.left.left;
		//Node q = root.right.right;
		
		Node resNode = lowestCommonAncestor(root, p, q);
		
		System.out.println(resNode.data);
	}
	
	private static boolean found = false;
	
	/*
	 * LCA in a Binary Tree
	 * 
	 * T = O(n)
	 * S = O(n)
	*/
	public static Node lowestCommonAncestor(Node root, Node p, Node q) {
		
		if(root != null) {
			
			if(root.data == p.data || root.data == q.data) {
				return root;
			}
			
			Node x = lowestCommonAncestor(root.left, p, q);
			
			if(found) {
				return x;
			}
			
			Node y = lowestCommonAncestor(root.right, p, q);
			
			if(found) {
				return y;
			}
			
			if(x != null && y != null) {
				found = true;
				return root;
			} else if(x == null && y == null) {
				return null;
			} else if(x != null && y == null) {
				return x;
			} else if(x == null && y != null) {
				return y;
			}
		}
		
		return null;
	}
	
	
	private static boolean found1 = false;

	private static boolean found2 = false;
	
	/*
	 * For specifically BST
	 * 
	 * T = O(n)
	 * S = O(n)
	*/
	public static Node lowestCommonAncestorBST(Node root, Node p, Node q) {
		
		if(root != null) {
			
			Node x = null;
			if(!found1) {
				if(root.data == p.data) {
					found1 = true;
					x = root;
				} else if(p.data < root.data) {
					x = lowestCommonAncestorBST(root.left, p, q);
				} else if(p.data > root.data) {
					x = lowestCommonAncestorBST(root.right, p, q);
				}
			}
			
			Node y = null;
			if(!found2) {
				if(root.data == q.data) {
					found2 = true;
					y = root;
				} else if(q.data < root.data) {
					y = lowestCommonAncestorBST(root.left, p, q);
				} else if(q.data > root.data) {
					y = lowestCommonAncestorBST(root.right, p, q);
				}
			}
			
			if(x != null && y != null) {
				return root;
			} else if(x == null && y == null) {
				return null;
			} else if(x != null && y == null) {
				return x;
			} else if(x == null && y != null) {
				return y;
			}
		}
		
		return null;
	}
}
