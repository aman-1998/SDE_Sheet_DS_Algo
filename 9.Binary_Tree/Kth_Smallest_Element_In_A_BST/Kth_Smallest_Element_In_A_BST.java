package practice.dsa.sheet.part6;

import java.util.Comparator;
import java.util.PriorityQueue;

import practice.dsa.sheet.part6.utility.Node;

public class Kth_Smallest_Element_In_A_BST {
	
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
		
		int ans = kthSmallest_2nd(root, 3);
		
		System.out.println(ans);
	}
	
	/*
	 * T = O(n*log k)
	 * S = O(n+k)
	 */
	public static int kthSmallest_1st(Node root, int k) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		preorder(root, k, maxHeap);
		
		return maxHeap.poll();
    }

	private static void preorder(Node root, int k, PriorityQueue<Integer> maxHeap) {
		
		if(root != null) {
			
			maxHeap.add(root.data);
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
			
			preorder(root.left, k, maxHeap);
			preorder(root.right, k, maxHeap);
		}
	}
	
	private static int res = -1;
	private static int count = 0;
	
	/*
	 * Best approach (hint : inorder of a BST is always increasing order)
	 * 
	 * T = O(k)
	 * S = O(n)
	 */
	public static int kthSmallest_2nd(Node root, int k) {
		
		inorder(root, k);
		
		return res;
    }
	
	public static void inorder(Node root, int k) {
        
        if(root != null) {
        	
            inorder(root.left, k);
            
            if(res != -1) {
        		return;
        	}
            
            if(count == k-1) {
            	res = root.data;
            	return;
            }
            count++;
            
            inorder(root.right, k);
        }
    }
	
}
