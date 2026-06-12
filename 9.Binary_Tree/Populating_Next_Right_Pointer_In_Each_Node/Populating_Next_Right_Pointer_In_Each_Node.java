package practice.dsa.sheet.part6;

import java.util.LinkedList;
import java.util.Queue;

public class Populating_Next_Right_Pointer_In_Each_Node {
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		
		root = connect(root);
		
		Verify(root);

	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static TreeNode connect(TreeNode root) {
		
		Queue<TreeNode> queue = new LinkedList<>();
		if(root == null) {
			return root;
		}
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			 int size = queue.size();
			 TreeNode prev = null;
			 for(int i = 1; i <= size; i++) {
				 
				 if(prev == null) {
					 prev = queue.poll();
					 
					 if(prev.left != null) {
						 queue.add(prev.left);
					 }
					 
					 if(prev.right != null) {
						 queue.add(prev.right);
					 }
					 
				 } else {
					 TreeNode popped = queue.poll();
					 prev.next = popped;
					 prev = popped;
					 
					 if(popped.left != null) {
						 queue.add(popped.left);
					 }
					 
					 if(popped.right != null) {
						 queue.add(popped.right);
					 }
				 }
			 }
		}
		
		return root;
	}
	
	private static void Verify(TreeNode root) {
		
		System.out.print(root.val + " ");
		
		System.out.print(root.left.val + " ");
		System.out.print(root.left.next.val + " ");
		
		System.out.print(root.left.left.val + " ");
		System.out.print(root.left.left.next.val + " ");
		System.out.print(root.left.left.next.next.val + " ");
		System.out.print(root.left.left.next.next.next.val + " ");
		
	}
}

class TreeNode {
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;
	
	public TreeNode(int val) {
		this.val = val;
	}
}
