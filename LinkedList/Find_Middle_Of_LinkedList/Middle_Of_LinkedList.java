package algorithms;

import algorithms.utility.ListNode;

public class Middle_Of_LinkedList {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * T = O(n/2)
	 * S = O(1)
	 */
	public ListNode middleNode(ListNode start) {
	        
	        if(start.link == null) {
	            return start;
	        }
	
	        if(start.link.link == null) {
	            return start.link;
	        }
	
	        ListNode fast = start;
	        ListNode slow = start;
	        ListNode middle = null;
	
	        while(fast.link != null && fast.link.link != null) {
	            fast = fast.link.link;
	            slow = slow.link;
	            if(fast.link == null) {
	                middle = slow;
	                break;
	            } else if(fast.link.link == null) {
	                middle = slow.link;
	                break;
	            }
	        }
	
	        return middle;
	    }
}
