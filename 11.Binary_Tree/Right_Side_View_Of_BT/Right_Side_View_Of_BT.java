package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.dsa.sheet.part6.utility.Node;

public class Right_Side_View_Of_BT {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 25);
		root = Insertion_In_BST.insert(root, 15);
		root = Insertion_In_BST.insert(root, 40);
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 12);
		root = Insertion_In_BST.insert(root, 35);
		root = Insertion_In_BST.insert(root, 45);
		//root = Insertion_In_BST.insert(root, 37);
		
		List<Integer> res = rightSideView_1st(root);
		
		res.stream().forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * Recursive solution : Using Reverse Preorder traversal (Root-Right-Left)
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	public static List<Integer> rightSideView_1st(Node root) {
		
		List<Integer> res = new ArrayList<>();
		reversePreorder(root, res, 0);
		return res;
	}
	
	public static void reversePreorder(Node root, List<Integer> res, int level) {
		
		if(root != null) {
			if(level > res.size() - 1) {
				res.add(root.data);
			}
			
			reversePreorder(root.right, res, level+1);
			reversePreorder(root.left, res, level+1);
		}
	}
	
	/*
	 * Iterative solution : Using level order traversal
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	public static List<Integer> rightSideView_2nd(Node root) {
		
		Queue<Node> queue = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		if(root != null) {
			queue.add(root);
			while(!queue.isEmpty()) {
				int size = queue.size();
				for(int i = 1; i <= size; i++) {
					Node popped = queue.poll();
					if(i == 1) {
						res.add(popped.data);
					}
					
					if(popped.right != null) {
						queue.add(popped.right);
					}
					
					if(popped.left != null) {
						queue.add(popped.left);
					}
				}
			}
		}
		
		return res;
	}
}
