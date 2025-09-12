package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.dsa.sheet.part6.utility.Node;

public class Level_Order_Traversal_BFS {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 50);
		root = Insertion_In_BST.insert(root, 15);
		root = Insertion_In_BST.insert(root, 62);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 20);
		root = Insertion_In_BST.insert(root, 58);
		root = Insertion_In_BST.insert(root, 91);
		root = Insertion_In_BST.insert(root, 3);
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 37);
		root = Insertion_In_BST.insert(root, 60);
		root = Insertion_In_BST.insert(root, 24);
		
		List<Integer> res1 = levelOrderTraversal_ver1(root);
		res1.stream().forEach(t -> System.out.print(t + " "));
		
		System.out.println("\n==================================================");
		
		List<List<Integer>> res2 = levelOrderTraversal_ver2(root);
		res2.stream().forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static List<Integer> levelOrderTraversal_ver1(Node root) {
		Queue<Node> queue = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		if(root != null) {
			queue.add(root);
			while(!queue.isEmpty()) {
				Node popped = queue.poll();
				if(popped.left != null) {
					queue.add(popped.left);
				}
				
				if(popped.right != null) {
					queue.add(popped.right);
				}
				
				res.add(popped.data);
			}
		}
		
		return res;
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static List<List<Integer>> levelOrderTraversal_ver2(Node root) {
		
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
		
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
				
				res.add(temp);
			}
		}
		
		return res;
    }
}
