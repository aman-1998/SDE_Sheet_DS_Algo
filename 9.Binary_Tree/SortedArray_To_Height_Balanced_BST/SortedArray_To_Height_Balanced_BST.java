package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class SortedArray_To_Height_Balanced_BST {
	
	public static void main(String[] args) {
		
		int[] arr = {-10, -3, 0, 5, 9};
		
		Node root = sortedArrayToBalancedBST(arr);
		
		System.out.print("Preorder : ");
		Preorder_Inorder_Postorder_In_BT.preorder(root);
		
		System.out.print("\nInorder : ");
		Preorder_Inorder_Postorder_In_BT.inorder(root);
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static Node sortedArrayToBalancedBST(int[] arr) {
        
		Node root = helper(arr, 0, arr.length-1);
		
		return root;
    }
	
	public static Node helper(int[] arr, int left, int right) {
		
		if(left > right) {
			return null;
		}
		
		int mid = (left + right)/2;
		
		Node root = new Node(arr[mid]);
		
		root.left = helper(arr, left, mid-1);
		root.right = helper(arr, mid+1, right);
		
		return root;
	}
}
