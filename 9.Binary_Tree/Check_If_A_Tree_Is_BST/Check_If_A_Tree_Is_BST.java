package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.List;

import practice.dsa.sheet.part6.utility.Node;

public class Check_If_A_Tree_Is_BST {
	
	private static long max = Long.MIN_VALUE;
	
	private static long min = Long.MAX_VALUE;
	
	public static void main(String[] args) {
		
//		Node root = new Node(8);
//		
//		root.left = new Node(5);
//		root.right = new Node(10);
//		
//		root.left.left = new Node(1);
//		root.left.right = new Node(7);
//		root.right.right = new Node(12);
		
		Node root = new Node(1);
		
		root.left = new Node(1);
		
		System.out.println(isValidBST_3rd(root));
	}
	
	/*
	 * Brute Force
	 * 
	 * T = O(n*n)
	 * S = O(n)
	 */
	public static boolean isValidBST_1st(Node root) {
		
		if(root == null) {
			return true;
		}
		
		if(root.left == null && root.right == null) {
			return true;
		}
		
		max = Long.MIN_VALUE;
		preorder(root.left);
		long leftMax = max;
		
		min = Long.MAX_VALUE;
		preorder(root.right);
		long rightMin = min;
		
		if (leftMax < root.data && root.data < rightMin) {
			return isValidBST_1st(root.left) && isValidBST_1st(root.right);
		} else {
			return false;
		}
	}
	
	public static void preorder(Node root) {
		
		if(root != null) {
			
			if(root.data > max) {
				max = root.data;
			}
			
			if(root.data < min) {
				min = root.data;
			}
			
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	// ================================================================ //
	
	private static List<Integer> inorder = new ArrayList<>();
	
	/*
	 * Better approach
	 * 
	 * T = O(2n) = O(n)
	 * S = O(n)
	 */
	public static boolean isValidBST_2nd(Node root) {
		
		inorder(root);
		
		for(int i = 0; i <= inorder.size()-2; i++) {
			if(inorder.get(i) >= inorder.get(i+1)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void inorder(Node root) {
		
		if(root != null) {
			inorder(root.left);
			
			inorder.add(root.data);
			
			inorder(root.right);
		}
	}
	
	// ================================================================ //
	
	private static long prev = Long.MIN_VALUE;
	
	/*
	 * Best approach (Optimal)
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	public static boolean isValidBST_3rd(Node root) {
		return inorder_modified(root);
	}
	
	public static boolean inorder_modified(Node root) {
		
		if(root != null) {
			boolean checkLST = inorder_modified(root.left);
			
			if(checkLST == false) {
				return false;
			}
			
			if(prev >= root.data) {
				return false;
			}
			
			prev = root.data;
			
			boolean checkRST = inorder_modified(root.right);
			
			if(checkRST == false) {
				return false;
			}
		}
		
		return true;
	}
	
}
