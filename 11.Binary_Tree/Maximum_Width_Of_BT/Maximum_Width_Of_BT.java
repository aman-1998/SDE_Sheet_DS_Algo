package practice.dsa.sheet.part6;

import java.util.LinkedList;
import java.util.Queue;
import practice.dsa.sheet.part6.utility.Node;

public class Maximum_Width_Of_A_BT {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 3);
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 2);
		root = Insertion_In_BST.insert(root, 7);
		
		int width = widthOfBinaryTree(root);
		
		System.out.println(width);
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static int widthOfBinaryTree(Node root) {
        
		Queue<Pair> queue = new LinkedList<>();
		int res = 0;
		if(root != null) {
			queue.add(new Pair(root, 0));
			while(!queue.isEmpty()) {
				int size = queue.size();
				int min = queue.peek().id;
				int first = 0;
				int last = 0;
				for(int i = 1; i <= size; i++) {
					Pair popped = queue.poll();
					int currId = popped.id - min;
					if(i == 1) {
						first = currId;
					}
					
					if(i == size) {
						last = currId;
					}
					
					if(popped.node.left != null) {
						queue.add(new Pair(popped.node.left, 2*currId+1));
					}
					
					if(popped.node.right != null) {
						queue.add(new Pair(popped.node.right, 2*currId+2));
					}
				}
				
				if(last-first+1 > res) {
					res = last-first+1;
				}
			}
		}
		
		return res;
    }
}

class Pair {
	
	public Node node;
	public int id;
	
	public Pair(Node node, int id) {
		this.node = node;
		this.id = id;
	}
}

