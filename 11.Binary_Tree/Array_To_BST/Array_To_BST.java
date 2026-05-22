package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Array_To_BST {
	
	public static void main(String[] args) {
		
		int[] arr = {0, -10, 5, -3, 9};
		
		Node root = arrayToBST(arr);
		
		System.out.print("Preorder : ");
		Preorder_Inorder_Postorder_In_BT.preorder(root);
		
		System.out.print("\nInorder : ");
		Preorder_Inorder_Postorder_In_BT.inorder(root);
	}
	
	public static Node arrayToBST(int[] arr) {
        
		Node root = null;
		for(int i = 0; i <= arr.length-1; i++) {
			root = insert(root, arr[i]);
		}
		
		return root;
    }
	
	public static Node insert(Node root, int data) {
		
		if(root == null) {
			root = new Node(data);
			return root;
		} else if(data <= root.data) {
			root.left = insert(root.left, data);
		} else if(data > root.data) {
			root.right = insert(root.right, data);
		}
		
		return root;
	}
}
