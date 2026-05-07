package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import practice.dsa.sheet.part6.utility.Node;

public class Boundary_Traversal_Of_BT {
	
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
		
		List<Integer> res = boundaryTraversal(root);
		
		res.stream().forEach(t -> System.out.print(t + " "));
	}
	
	public static List<Integer> boundaryTraversal(Node root) {
		
		List<Integer> res = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		
		if(root == null) {
			return res;
		}
		
		addLeftNodes(root, res); // left traversal except leaves
		addLeaves(root, res); // preorder and add only leaves
		addRightNodes(root.right, stack); // right traversal except leaves
		
		int stackSize = stack.size();
		
		for(int i = 1; i <= stackSize; i++) {
			res.add(stack.pop());
		}
		
		return res;
	}
	
	/*
	 * T = O(n)
	 * S = (n)
	 */
	public static void addLeftNodes(Node root, List<Integer> res) {
		
		if(root != null) {
			if(root.left != null) {
				res.add(root.data);
				addLeftNodes(root.left, res);
			} else if(root.right != null) {
				res.add(root.data);
				addLeftNodes(root.right, res);
			}
		}
	}
	
	/*
	 * T = O(n)
	 * S = (n)
	 */
	// preorder
	public static void addLeaves(Node root, List<Integer> res) {
		
		if(root != null) {
			if(root.left == null && root.right == null) {
				res.add(root.data);
			}
			addLeaves(root.left, res);
			addLeaves(root.right, res);
		}
	}
	
	/*
	 * T = O(n)
	 * S = (n)
	 */
	public static void addRightNodes(Node root, Stack<Integer> stack) {
		
		if(root != null) {
			if(root.right != null) {
				stack.push(root.data);
				addRightNodes(root.right, stack);
			} else if(root.left != null) {
				stack.push(root.data);
				addRightNodes(root.left, stack);
			}
		}
	}
}