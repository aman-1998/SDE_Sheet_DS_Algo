package practice.dsa.sheet.part6;

import java.util.ArrayList;

import practice.dsa.sheet.part6.utility.Node;

public class InorderPredecessor_InorderSuccessor_In_BST {

	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 50);
		root = Insertion_In_BST.insert(root, 30);
		root = Insertion_In_BST.insert(root, 70);
		root = Insertion_In_BST.insert(root, 20);
		root = Insertion_In_BST.insert(root, 40);
		root = Insertion_In_BST.insert(root, 60);
		root = Insertion_In_BST.insert(root, 80);
		
		ArrayList<Node> res = findPreSuc(root, 65);
		
		System.out.println(res.toString());
	}
		
	private static int inorderSucc = Integer.MAX_VALUE;
	private static Node inorderSuccNode = null;
	private static int inorderPred  = Integer.MIN_VALUE;
	private static Node inorderPredNode = null;
    
	/*
	 * T = O(n)
	 * S = O(n)
	 */
    public static ArrayList<Node> findPreSuc(Node root, int key) {
        
        inorder(root, key);
        
        ArrayList<Node> res = new ArrayList<>();
        res.add(inorderPredNode);
        res.add(inorderSuccNode);
        
        return res;
        
    }
    
    public static void inorder(Node root, int key) {
        
        if(root != null) {
            
            inorder(root.left, key);
            
            if(root.data > key && root.data < inorderSucc) {
                inorderSucc = root.data;
                inorderSuccNode = root;
            }
            
            if(root.data < key && root.data > inorderPred) {
                inorderPred = root.data;
                inorderPredNode = root;
            }
            
            inorder(root.right, key);
        }
    }	
}
