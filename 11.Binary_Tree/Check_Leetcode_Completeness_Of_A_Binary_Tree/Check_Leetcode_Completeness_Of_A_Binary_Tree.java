package practice.dsa.sheet.part6;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.dsa.sheet.part6.utility.Node;

/*
 * Given the root of a binary tree, determine if it is a complete binary tree.
 *
 * In a complete binary tree, every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2^h
 * nodes inclusive at the last level h.
 * 
 * Video Link : https://www.youtube.com/watch?v=olbiZ-EOSig
 * Video Link : https://www.youtube.com/watch?v=EoAsWbO7sqg
 */
public class Check_Leetcode_Completeness_Of_A_Binary_Tree {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 20);
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 30);
		root = Insertion_In_BST.insert(root, 7);
		root = Insertion_In_BST.insert(root, 15);
		root = Insertion_In_BST.insert(root, 25);
		root = Insertion_In_BST.insert(root, 35);
		root = Insertion_In_BST.insert(root, 4);
		root = Insertion_In_BST.insert(root, 9);
		//root = Insertion_In_BST.insert(root, 17);
		root = Insertion_In_BST.insert(root, 13);
		
		System.out.println(isCompleteTree(root));
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static boolean isCompleteTree(Node root) {
        
		Queue<Node> queue = new LinkedList<>();
		List<Integer> res = new LinkedList<>();
		
		if(root != null) {
			queue.add(root);
			boolean isFirstNullFound = false;
			while(!queue.isEmpty()) {
				Node popped = queue.poll();
				
				if(popped == null) {
					if(!isFirstNullFound) {
						isFirstNullFound = true;
					}
					continue;
				} else {
					if(isFirstNullFound) {
						return false;
					}
				}
				
				queue.add(popped.left);
				queue.add(popped.right);
			}
		}
		
		return true;
    } 
}
