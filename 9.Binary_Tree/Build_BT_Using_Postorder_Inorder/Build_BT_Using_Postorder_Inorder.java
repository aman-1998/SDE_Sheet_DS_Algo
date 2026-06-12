package practice.dsa.sheet.part6;

import java.util.HashMap;
import java.util.Map;

import practice.dsa.sheet.part6.utility.Node;

public class Build_BT_Using_Postorder_Inorder {
	
	public static void main(String[] args) {
		
		int[] postorder = {5, 15, 21, 9, 14, 13, 8, 17};
		int[] inorder = {5, 9, 15, 21, 17, 8, 14, 13};
		
		Node root = buildTree(postorder, inorder);
		
		Preorder_Inorder_Postorder_In_BT.preorder(root);
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static Node buildTree(int[] postorder, int[] inorder) {
		
		int m = postorder.length;
		int n = inorder.length;
		
		Map<Integer, Integer> hmapIn = new HashMap<>();
		
		for(int i = 0; i <= n-1; i++) {
			hmapIn.put(inorder[i], i);
		}
		
		Node root = solve(postorder, 0, m-1, inorder, 0, n-1, hmapIn);
		
		return root;
	}
	
	public static Node solve(int[] postorder, int postStart, int postEnd,
							 int[] inorder, int inStart, int inEnd,
							 Map<Integer, Integer> hmapIn) {
		
		if(postStart > postEnd || inStart > inEnd)  {
			return null;
		}
		
		Node root = new Node(postorder[postEnd]);
		
		int inRoot = hmapIn.get(root.data);
		int leftLength = inRoot - inStart;
		
		root.left = solve(postorder, postStart, postStart+leftLength-1,
						  inorder, inStart, inRoot-1, hmapIn);
		
		root.right = solve(postorder, postStart+leftLength, postEnd-1,
				          inorder, inRoot+1, inEnd, hmapIn);
		
		return root;
	}
}
