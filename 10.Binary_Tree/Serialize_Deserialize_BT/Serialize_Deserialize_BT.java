package practice.dsa.sheet.part6;

import java.util.LinkedList;
import java.util.Queue;

import practice.dsa.sheet.part6.utility.Node;

public class Serialize_Deserialize_BT {
	
	public static void main(String[] args) {
		
//		Node root = new Node(1);
//		
//		root.left = new Node(2);
//		root.right = new Node(-13);
//		
//		root.right.left = new Node(4);
//		root.right.right = new Node(5);
		
		
		Node root = new Node(-1);
		
		root.left = new Node(0);
		root.right = new Node(1);
		
		
		String serializedStr = serialize(root);
		
		System.out.println(serializedStr);
		
		Node droot = deserialize(serializedStr);
		
		Preorder_Inorder_Postorder_In_BT.preorder(droot);
		
	}
	
	public static String serialize(Node root) {
		
		Queue<Node> queue = new LinkedList<>();
		StringBuilder res = new StringBuilder();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node popped = queue.poll();
			
			if(popped != null) {
				res.append(popped.data + ",");
				
				queue.add(popped.left);
				queue.add(popped.right);
			} else {
				res.append("N,");
			}
		}
		
		res.deleteCharAt(res.length()-1);
		
		return res.toString();
	}
	
	public static Node deserialize(String str) {
		
		Queue<Node> queue = new LinkedList<>();
		
		if(str.charAt(0) == 'N') {
			return null;
		}
		
		int firstComma = str.indexOf(',');
		int rootVal = Integer.parseInt(str.substring(0, firstComma));
		
		Node root = new Node(rootVal);
		
		queue.add(root);
		
		int index = firstComma + 1;
			
		while(!queue.isEmpty() && index < str.length()) {
			
			Node popped = queue.poll();
			
			int childrenToBePopulated = 2;
			while(childrenToBePopulated != 0) {
				int num = 0;
				boolean isNull = false;
				int signed = 1;
				while(index < str.length() && str.charAt(index) != ',') {
					char c = str.charAt(index);
				    if (c == 'N') { 
				    	isNull = true; 
				    }
				    else if (c == '-') { 
				    	signed = -1; 
				    }
				    else { 
				    	num = num * 10 + (c - '0'); 
				    }   // accumulate unsigned
				    index++;
				}
				
				num = num*signed;
				
				index ++;
				
				if(!isNull && childrenToBePopulated == 2) {
					popped.left = new Node(num);
					queue.add(popped.left);
				} else if(!isNull && childrenToBePopulated == 1) {
					popped.right = new Node(num);
					queue.add(popped.right);
				}
				
				childrenToBePopulated--;
			}
			
		}
		
		return root;
	}
}
