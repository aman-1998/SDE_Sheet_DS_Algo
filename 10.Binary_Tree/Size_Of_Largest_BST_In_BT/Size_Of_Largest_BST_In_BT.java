package practice.dsa.sheet.part6;

import java.util.List;

import practice.dsa.sheet.part6.utility.Node;

public class Size_Of_Largest_BST_In_BT {
	
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
		
		System.out.println(largestBST_2nd(root));
	}
	
	// =================================================================== //
	
	private static int max = Integer.MIN_VALUE;
	
	/*
	 * T = O(n*n)
	 * S = O(n)
	 */
	public static int largestBST_1st(Node root) {
        
		if(root != null) {
			
			boolean check = isValidBST(root);
			if(check) {
				int noOfNodes = countNodes(root);
				if(noOfNodes > max) {
					max = noOfNodes;
				}
				return max;
			}
			
			int count1 = largestBST_1st(root.left);
			int count2 = largestBST_1st(root.right);
			
			if(count1 > count2) {
				return count1;
			}
			
			return count2;
		}
		
		return 0;
    }

	private static int countNodes(Node root) {
		if(root == null) {
			return 0;
		} else if(root.left == null && root.right == null) {
			return 1;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
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
	
	private static int maxSize = Integer.MIN_VALUE;
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static int largestBST_2nd(Node root) {
		
		postorder_modified(root);
		
		return maxSize;
	}
	
	public static int[] postorder_modified(Node root) {
		
		if(root == null) {
			
			return new int[] {0, Integer.MIN_VALUE, Integer.MAX_VALUE};
			
		} else if(root.left == null && root.right == null) {
			
			if(maxSize < 1) {
		        maxSize = 1;
		    }
			
			return new int[] {1, root.data, root.data};
			
		} else {
			
			int[] leftRes = postorder_modified(root.left);
			
			int[] rightRes = postorder_modified(root.right);
			
			if(leftRes[1] < root.data && root.data < rightRes[2]) {
				
				int size = 1 + leftRes[0] + rightRes[0];
				
				if(size > maxSize) {
					maxSize = size;
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
				
				return new int[] {size, largest, smallest};
			}
		} 
		
		return new int[] {0, Integer.MAX_VALUE, Integer.MIN_VALUE};
	}
}
