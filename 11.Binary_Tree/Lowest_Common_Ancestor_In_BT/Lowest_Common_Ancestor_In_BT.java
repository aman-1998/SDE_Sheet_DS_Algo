package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.List;

import practice.dsa.sheet.part6.utility.Node;

public class Lowest_Common_Ancestor_In_BT {
	
	private static Boolean found = false;
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 11);
		root = Insertion_In_BST.insert(root, 2);
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 12);
		root = Insertion_In_BST.insert(root, 7);
		root = Insertion_In_BST.insert(root, 9);
		root = Insertion_In_BST.insert(root, 1);
		
		Node p = root.left.left.left;
		Node q = root.left.right.left;
		
		//Node p = root.left.left.left;
		//Node q = root.right.right;
		
		
		Node resNode = lowestCommonAncestor_1st(root, p, q);
		
		System.out.println(resNode.data);
	}
	
	public static Node lowestCommonAncestor_1st(Node root, Node p, Node q) {
		
		List<Node> path1 = rootToNodePath(root, p.data);
		List<Node> path2 = rootToNodePath(root, q.data);
		
		Node res = null;
		
		for(int i = 0; i <= Math.min(path1.size(), path2.size()) - 1; i++) {
			if(path1.get(i) == path2.get(i)) {
				res = path1.get(i);
			} else {
				break;
			}
		}
		
		return res;
	}
	
	/*
	 * Brute Force
	 * 
	 * T = O(n)
	 * S = O(2n)
	 */
	public static List<Node> rootToNodePath(Node root, int val) {
		
		List<Node> res = new ArrayList<>();
		find_2nd(root, val, res);
		return res;
	}
	
	public static boolean find_2nd(Node root, int val, List<Node> res) {
		
		if(root != null) {
			res.add(root);
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
	
	/*
	 * Best approach
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	public static Node lowestCommonAncestor_2nd(Node root, Node p, Node q) {
        
		Node resNode = find(root, p, q);
		return resNode;
    } 
	
	public static Node find(Node root, Node p, Node q) {
		
		if(root != null) {
			if(root.data == p.data || root.data == q.data) {
				return root;
			}
			
			Node x = find(root.left, p, q);
			
			if(found) {
				return x;
			}
			
			Node y = find(root.right, p, q);
			
			if(found) {
				return y;
			}
			
			if(x != null && y != null) {
				found = true;
				return root;
			} else if(x == null && y == null) {
				return null;
			} else if(x != null && y == null) {
				return x;
			} else if(x == null && y != null) {
				return y;
			}
		}
		
		return null;
	}
}
