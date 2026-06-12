package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.List;

import practice.dsa.sheet.part6.utility.Node;

public class Root_To_Node_Path {
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		
		root.right = new Node(3);
		
		root.right.right = new Node(8);
		
		List<Integer> res = rootToNodePath(root, 7);
		res.stream().forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static List<Integer> rootToNodePath(Node root, int val) {
		
		List<Integer> res = new ArrayList<>();
		find_1st(root, val, res);
		return res;
	}
	
	public static boolean find_1st(Node root, int val, List<Integer> res) {
		
		if(root != null) {
			res.add(root.data);
			if(root.data == val) {
				return true;
			}
			
			boolean foundInLST = find_1st(root.left, val, res);
			
			if(foundInLST) {
				return true;
			} else {
				boolean foundInRST = find_1st(root.right, val, res);
				
				if(foundInRST) {
					return true;
				} else {
					res.remove(res.size() - 1);
				}
			}
		}
		
		return false;
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static boolean find_2nd(Node root, int val, List<Integer> res) {
		
		if(root != null) {
			res.add(root.data);
			if(root.data == val) {
				return true;
			}
			
			boolean found = find_2nd(root.left, val, res) 
								|| find_2nd(root.right, val, res);
			
			if(found) {
				return true;
			}
			
			res.remove(res.size() - 1);
		}
		
		return false;
	}
}
