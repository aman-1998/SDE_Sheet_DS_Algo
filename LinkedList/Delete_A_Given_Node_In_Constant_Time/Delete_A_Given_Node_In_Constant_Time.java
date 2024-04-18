package algorithms;

import algorithms.utility.ListNode;

public class Delete_A_Given_Node_In_Constant_Time {
	
	public static void main(String[] args) {
		
	}
	
	public static void deleteGivenNode(ListNode node) {
		
		if(node == null) {
			return;
		}
		
		if(node.link != null) {
			ListNode temp = node.link;
			node.data = temp.data;
			node.link = temp.link;
			temp.link = null;
			temp = null;
		} else {
			return;
		}
	}
}
