package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Maximum_Path_Sum {
	
	private static int maxSum = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		
		Node root = new Node(-10);
		
		root.left = new Node(9);
		root.right = new Node(20);
		
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		
		int maximumSum = maxPathSum(root);
		System.out.println(maximumSum);
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static int maxPathSum(Node root) {
		
		solve(root);
		return maxSum;
	}
	
	public static int solve(Node root) {
		
		if(root == null) {
			return 0;
		} else if(root.left == null && root.right == null) {
			if(root.data > maxSum) {
                maxSum = root.data;
            }
            return root.data;
		} else {
			int ls = Math.max(0, solve(root.left));
			int rs = Math.max(0, solve(root.right));
			
			maxSum = Math.max(maxSum, root.data + ls + rs);
			
			return root.data + Math.max(ls, rs);
		}
	}
}
