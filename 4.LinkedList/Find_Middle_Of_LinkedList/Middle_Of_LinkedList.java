package algorithms.part1;

import algorithms.utility.ListNode;

public class Middle_Of_LinkedList {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * T = O(n/2)
	 * S = O(1)
	 */
	public ListNode middleNode(ListNode start) {
	        
		if(start == null) {
            return start;
        }

        ListNode fast = start;
        ListNode slow = start;
        ListNode middle = null;

        while(true) {
            
            if(fast.link == null) {
                middle = slow;
                break;
            } else if(fast.link.link == null) {
                middle = slow.link;
                break;
            }
            fast = fast.link.link;
            slow = slow.link;
        }

        return middle;
	 }
}
