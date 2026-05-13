package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.dsa.sheet.part6.utility.Node;

public class Zig_Zag_Traversal_Of_BT {
	
	public static void main(String[] args) {
		
		Node root = null;
		
		root = Insertion_In_BST.insert(root, 50);
		root = Insertion_In_BST.insert(root, 30);
		root = Insertion_In_BST.insert(root, 60);
		root = Insertion_In_BST.insert(root, 15);
		root = Insertion_In_BST.insert(root, 35);
		root = Insertion_In_BST.insert(root, 55);
		root = Insertion_In_BST.insert(root, 70);
		root = Insertion_In_BST.insert(root, 25);
		root = Insertion_In_BST.insert(root, 65);
		root = Insertion_In_BST.insert(root, 20);
		root = Insertion_In_BST.insert(root, 28);
		root = Insertion_In_BST.insert(root, 63);
		root = Insertion_In_BST.insert(root, 68);
		
		List<List<Integer>> res = zigzagLevelOrder(root);
		
		res.stream().forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static List<List<Integer>> zigzagLevelOrder(Node root) {
		
		List<List<Integer>> res = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		
		int flag = 0; // 0 -> left to right, 1 -> right to left
		
		if(root != null) {
			queue.add(root);
			while(!queue.isEmpty()) {
				
				int size = queue.size();
				List<Integer> temp = new ArrayList<>();
				
				for(int i = 1; i <= size; i++) {
					Node popped = queue.poll();
					
					if(popped.left != null) {
						queue.add(popped.left);
					}
					
					if(popped.right != null) {
						queue.add(popped.right);
					}
					
					temp.add(popped.data);
				}
				
				if(flag == 1) {
					Collections.reverse(temp);
					flag = 0;
				} else {
					flag = 1;
				}
				res.add(temp);
			}
		}
		
		return res;
	}
}
