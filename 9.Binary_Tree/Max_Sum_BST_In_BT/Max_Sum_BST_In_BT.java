package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Max_Sum_BST_In_BT {
	
public static void main(String[] args) {
		
//		Node root = new Node(20);
//		
//		root.left = new Node(15);
//		root.right = new Node(25);
//		
//		root.left.left = new Node(10);
//		root.left.right = new Node(17);
//		root.right.right = new Node(18);
		
		
//		Node root = new Node(20);
//		
//		root.left = new Node(15);
//		root.right = new Node(40);
//		
//		root.left.left = new Node(14);
//		root.left.right = new Node(18);
//		root.right.left = new Node(30);
//		root.right.right = new Node(60);
//		
//		root.left.left.right = new Node(17);
//		root.left.right.left = new Node(16);
//		root.left.right.right = new Node(19);
//		root.right.right.left = new Node(50);
		
		
		Node root = new Node(7);
		
		root.left = new Node(4);
		root.right = new Node(6);
		
		root.left.right = new Node(9);
		
		System.out.println(maxSumBST_2nd(root));
	}
	
	// =================================================================== //
	
	private static int max = Integer.MIN_VALUE;
	
	/*
	 * T = O(n*n)
	 * S = O(n)
	 */
	public static int maxSumBST_1st(Node root) {
        
		if(root != null) {
			
			boolean check = isValidBST(root);
			if(check) {
				int sumOfNodes = sumOfNodes(root);
				if(sumOfNodes > max) {
					max = sumOfNodes;
				}
				return max;
			}
			
			int sum1 = maxSumBST_1st(root.left);
			int sum2 = maxSumBST_1st(root.right);
			
			if(sum1 > sum2) {
				return sum1;
			}
			
			return sum2;
		}
		
		return 0;
    }

	private static int sumOfNodes(Node root) {
		if(root == null) {
			return 0;
		} else if(root.left == null && root.right == null) {
			return root.data;
		} else {
			return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
		}
	}

	private static long prev;
	
	public static boolean isValidBST(Node root) {
		prev = Long.MIN_VALUE;
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
	
	// =================================================================== //
	
	private static int maxSum = Integer.MIN_VALUE;
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static int maxSumBST_2nd(Node root) {
		
		postorder_modified(root);
		
		return maxSum < 0 ? 0 : maxSum;
	}
	
	public static int[] postorder_modified(Node root) {
		
		if(root == null) {
			
			return new int[] {0, Integer.MIN_VALUE, Integer.MAX_VALUE};
			
		} else if(root.left == null && root.right == null) {
			
			if(root.data > maxSum) {
                maxSum = root.data;
            }
			
			return new int[] {root.data, root.data, root.data};
			
		} else {
			
			int[] leftRes = postorder_modified(root.left);
			
			int[] rightRes = postorder_modified(root.right);
			
			if(leftRes[1] < root.data && root.data < rightRes[2]) {
				
				int sum = root.data + leftRes[0] + rightRes[0];
				
				if(sum > maxSum) {
					maxSum = sum;
				}
				
				int largest = Integer.MIN_VALUE;
				if(leftRes[1] > rightRes[1]) {
					largest = leftRes[1];
				} else {
					largest = rightRes[1];
				}
				
				if(root.data > largest) {
					largest = root.data;
				}
				
				int smallest = Integer.MAX_VALUE;
				if(leftRes[2] < rightRes[2]) {
					smallest = leftRes[2];
				} else {
					smallest = rightRes[2];
				}
				
				if(root.data < smallest) {
					smallest = root.data;
				}
				
				return new int[] {sum, largest, smallest};
			}
		} 
		
		return new int[] {0, Integer.MAX_VALUE, Integer.MIN_VALUE};
	}
}
