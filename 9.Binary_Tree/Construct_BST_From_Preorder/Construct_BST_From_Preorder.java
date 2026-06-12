package practice.dsa.sheet.part6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import practice.dsa.sheet.part6.utility.Node;

public class Construct_BST_From_Preorder {
	
	public static void main(String[] args) {
		
//		Node root = new Node(8);
//		
//		root.left = new Node(5);
//		root.right = new Node(10);
//		
//		root.left.left = new Node(1);
//		root.left.right = new Node(7);
//		root.right.right = new Node(12);
		 
		int[] preorder = {8, 5, 1, 7, 10, 12};
		
		Node root = bstFromPreorder_2nd(preorder);
		
		Preorder_Inorder_Postorder_In_BT.preorder(root);
	}
	
	/*
	 * T = O(3n) = O(n)
	 * S = O(3n)
	 */
	public static Node bstFromPreorder_1st(int[] preorder) {
        
		int[] preorderOrig = new int[preorder.length];
		int[] inorderOrig = new int[preorder.length];
		
		for(int i = 0; i <= preorder.length-1; i++) {
			preorderOrig[i] = preorder[i];
			inorderOrig[i] = preorder[i];
		}
		
		Arrays.sort(inorderOrig);
		
		Map<Integer, Integer> hmapIn = new HashMap<>();
		
		for(int i = 0; i <= inorderOrig.length-1; i++) {
			hmapIn.put(inorderOrig[i], i);
		}
		
		Node root = constructBT(preorderOrig, 0, preorderOrig.length-1, 
								inorderOrig, 0, inorderOrig.length-1, hmapIn);
		
		return root;
    }

	private static Node constructBT(int[] preorder, int preStart, int preEnd, 
							 int[] inorder, int inStart, int inEnd, 
							 Map<Integer, Integer> hmapIn) {
		
		if(preStart > preEnd || inStart > inEnd) {
			return null;
		}
		
		Node root = new Node(preorder[preStart]);
		
		int inRoot = hmapIn.get(root.data);
		int inLeft = inRoot - inStart;
		
		root.left = constructBT(preorder, preStart+1, preStart+inLeft, 
								inorder, inStart, inRoot-1, hmapIn);
		
		root.right = constructBT(preorder, preStart+inLeft+1, preEnd,
								 inorder, inRoot+1, inEnd, hmapIn);
		
		return root;
	}
	
	// ================================================================= //
	
	/*
	 * Best approach
	 * 
     * T = O(n)
     * S = O(n)
     */
	public static Node bstFromPreorder_2nd(int[] preorder) {
        
		Node root = null;
        for(int i = 0; i <= preorder.length-1; i++) {
            root = insert(root, preorder[i]);
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
