package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.List;

import practice.dsa.sheet.part6.utility.Node;

public class Morris_Preorder_Traversal {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 4);
		root = Insertion_In_BST.insert(root, 6);
		root = Insertion_In_BST.insert(root, 9);
		root = Insertion_In_BST.insert(root, 14);
		root = Insertion_In_BST.insert(root, 11);
		
		List<Integer> preorder = preorderUsingMorris(root);
		
		preorder.stream().forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * T = o(n)
	 * S = O(1)
	 */
	public static List<Integer> preorderUsingMorris(Node root) {
		
		List<Integer> result = new ArrayList<>();
		Node curr = root;
		
		while(curr != null) {
			if(curr.left == null) {
				result.add(curr.data);
				curr = curr.right;
			} else {
				Node t = curr.left;
				while(t.right != null && t.right != curr) {
					t = t.right;
				}
				
				if(t.right == null) {
					t.right = curr;
					result.add(curr.data);
					curr = curr.left;
				} else {
					t.right = null;
					curr = curr.right;
				}
			}
		}
		
		return result;
	}
}
