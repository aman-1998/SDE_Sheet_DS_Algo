package practice.dsa.sheet.part6;

import java.util.Comparator;
import java.util.PriorityQueue;

import practice.dsa.sheet.part6.utility.Node;

public class Kth_Largest_Element_In_A_BST {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 13);
		root = Insertion_In_BST.insert(root, 3);
		root = Insertion_In_BST.insert(root, 6);
		root = Insertion_In_BST.insert(root, 11);
		root = Insertion_In_BST.insert(root, 14);
		root = Insertion_In_BST.insert(root, 2);
		root = Insertion_In_BST.insert(root, 4);
		root = Insertion_In_BST.insert(root, 9);
		
		int ans = kthLargest_2nd(root, 3);
		
		System.out.println(ans);
	}
	
	/*
	 * T = O(n*log k)
	 * S = O(n+k)
	 */
	public static int kthLargest_1st(Node root, int k) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		preorder(root, k, minHeap);
		
		return minHeap.poll();
    }

	private static void preorder(Node root, int k, PriorityQueue<Integer> minHeap) {
		
		if(root != null) {
			
			minHeap.add(root.data);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
			
			preorder(root.left, k, minHeap);
			preorder(root.right, k, minHeap);
		}
	}
	
	private static int res = -1;
	private static int count = 0;
	
	/*
	 * Best approach (hint : reverse of inorder of a BST is always decreasing order)
	 * 
	 * T = O(k)
	 * S = O(n)
	 */
	public static int kthLargest_2nd(Node root, int k) {
		
		inorder_reversed(root, k);
		
		return res;
    }
	
	public static void inorder_reversed(Node root, int k) {
        
        if(root != null) {
        	
        	inorder_reversed(root.right, k);
            
            if(res != -1) {
        		return;
        	}
            
            if(count == k-1) {
            	res = root.data;
            	return;
            }
            count++;
            
            inorder_reversed(root.left, k);
        }
    }
	
}
