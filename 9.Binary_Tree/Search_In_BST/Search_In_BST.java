package practice.dsa.sheet.part6;

import practice.dsa.sheet.part6.utility.Node;

public class Search_In_BST {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static Node searchBST(Node root, int val) {
        
        if(root == null) {
            return root;
        } else if(val > root.data) {
            return searchBST(root.right, val);
        } else if(val < root.data) {
            return searchBST(root.left, val);
        } else {
            return root;
        }
    }
}
