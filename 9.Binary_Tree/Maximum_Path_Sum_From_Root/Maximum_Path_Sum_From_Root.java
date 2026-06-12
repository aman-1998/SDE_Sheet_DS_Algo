package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Maximum_Path_Sum_From_Root {
	
	private static int maxSum = Integer.MIN_VALUE;
	private static int tempSum = 0;
	
	public static void main(String[] args) {
		
		Node root = new Node(2);
		
		root.left = new Node(3);
		root.right = new Node(7);
		
		root.left.left = new Node(5);
		root.left.right = new Node(8);
		root.right.left = new Node(9);
		root.right.right = new Node(4);
		
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(2);
		
		//maxPathSumFromRoot_1st(root);
		//System.out.println(maxSum);
		
		int maximumSum = maxPathSumFromRoot_2nd(root);
		System.out.println(maximumSum);
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static int maxPathSumFromRoot_1st(Node root) {
		solve(root);
		return maxSum;
	}
	
	public static void solve(Node root) {
		
		if(root != null) {
			tempSum = tempSum + root.data;
			if(tempSum > maxSum) {
				maxSum = tempSum;
			}
			
			solve(root.left);
			solve(root.right);
			
			tempSum = tempSum - root.data;
		}
	}
	
	/*
	 * Best approach
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	public static int maxPathSumFromRoot_2nd(Node root) {
		
		if(root == null) {
			return 0;
		} else if(root.left == null && root.right == null) {
			return root.data;
		} else {
			int ls = maxPathSumFromRoot_2nd(root.left);
			int rs = maxPathSumFromRoot_2nd(root.right);
			
			return root.data + Math.max(ls, rs);
		}
	}
}
