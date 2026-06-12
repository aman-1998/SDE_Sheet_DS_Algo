package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.List;

import practice.dsa.sheet.part6.utility.Node;

public class Two_Sum_In_BST {
	
	public static void main(String[] args) {
		
//		Node root = null;
//		root = Insertion_In_BST.insert(root, 10);
//		root = Insertion_In_BST.insert(root, 5);
//		root = Insertion_In_BST.insert(root, 13);
//		root = Insertion_In_BST.insert(root, 3);
//		root = Insertion_In_BST.insert(root, 6);
//		root = Insertion_In_BST.insert(root, 11);
//		root = Insertion_In_BST.insert(root, 14);
//		root = Insertion_In_BST.insert(root, 2);
//		root = Insertion_In_BST.insert(root, 4);
//		root = Insertion_In_BST.insert(root, 9);
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 0);
		root = Insertion_In_BST.insert(root, -1);
		root = Insertion_In_BST.insert(root, 2);
		root = Insertion_In_BST.insert(root, -3);
		root = Insertion_In_BST.insert(root, 4);
		
		System.out.println(findTarget(root, -4));
	} 
	
	private static List<Integer> inorderArr = new ArrayList<>();
	
	/*
	 * T = O(2n)
	 * S = O(2n)
	 */
	public static boolean findTarget(Node root, int k) {
        
		inorder(root); // T = O(n)
		
		return twoSum(inorderArr, k); // T = O(n)
    }
	
	private static boolean twoSum(List<Integer> inorderArr, int k) {
		
		// inorderArr is already sorted
		
		int n = inorderArr.size();
		
		int i = 0;
		int j = n-1;
		
		while(i < j) {
			if(inorderArr.get(i) + inorderArr.get(j) < k) {
				i++;
			} else if(inorderArr.get(i) + inorderArr.get(j) > k) {
				j--;
			} else {
				return true;
			}
		}
		
		return false;
	}

	public static void inorder(Node root) {
        
        if(root != null) {
        	
            inorder(root.left);
            
            inorderArr.add(root.data);
            
            inorder(root.right);
        }
    }
}
