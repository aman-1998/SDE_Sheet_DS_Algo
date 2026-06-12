package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Children_Sum_Property_Of_BT {
	
	public static void main(String[] args) {
		
		Node root = new Node(40);
		
		root.left = new Node(10);
		root.right = new Node(20);
		
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.right.left = new Node(30);
		root.right.right = new Node(40);
		
		convertToChildrenSumProperty(root);
		
		Preorder_Inorder_Postorder_In_BT.preorder(root);
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static void convertToChildrenSumProperty(Node root) {
		
		if(root != null && root.left != null && root.right != null) {
			
			int sumOfLeftAndRight = root.left.data + root.right.data;
			if(sumOfLeftAndRight < root.data) {
				root.left.data = root.data;
				root.right.data = root.data;
			}
			
			convertToChildrenSumProperty(root.left);
			convertToChildrenSumProperty(root.right);
			
			root.data = root.left.data + root.right.data;
		}
	}
}
