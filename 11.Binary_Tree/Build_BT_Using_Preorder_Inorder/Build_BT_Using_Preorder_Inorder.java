package practice.dsa.sheet.part6;

import java.util.HashMap;
import java.util.Map;

import practice.dsa.sheet.part6.utility.Node;

public class Build_BT_Using_Preorder_Inorder {
	
	public static void main(String[] args) {
		
		int[] preorder = {17, 9, 5, 21, 15, 8, 13, 14};
		int[] inorder = {5, 9, 15, 21, 17, 8, 14, 13};
		
		Node root = buildTree(preorder, inorder);
		
		Preorder_Inorder_Postorder_In_BT.postorder(root);
	}
	
	public static Node buildTree(int[] preorder, int[] inorder) {
		
		int m = preorder.length;
		int n = inorder.length;
		
		Map<Integer, Integer> hmapIn = new HashMap<>();
		
		for(int i = 0; i <= n-1; i++) {
			hmapIn.put(inorder[i], i);
		}
		
		Node root = solve(preorder, 0, m-1, inorder, 0, n-1, hmapIn);
		
		return root;
	}
	
	public static Node solve(int[] preorder, int preStart, int preEnd,
							 int[] inorder, int inStart, int inEnd,
							 Map<Integer, Integer> hmapIn) {
		
		if(preStart > preEnd || inStart > inEnd)  {
			return null;
		}
		
		Node root = new Node(preorder[preStart]);
		
		int inRoot = hmapIn.get(root.data);
		int leftLength = inRoot - inStart;
		
		root.left = solve(preorder, preStart+1, preStart+leftLength,
						  inorder, inStart, inRoot-1, hmapIn);
		
		root.right = solve(preorder, preStart+leftLength+1, preEnd,
				          inorder, inRoot+1, inEnd, hmapIn);
		
		return root;
		
	}
}
