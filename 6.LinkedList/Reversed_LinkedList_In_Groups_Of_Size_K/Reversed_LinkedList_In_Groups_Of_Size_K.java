package algorithms;

import algorithms.utility.ListNode;

public class Reversed_LinkedList_In_Groups_Of_Size_K {
	
	public static void main(String[] args) {
		ListNode start = new ListNode();
		start.data = 1;
		
		ListNode second = new ListNode();
		second.data = 2;
		
		ListNode third = new ListNode();
		third.data = 3;
		
		ListNode fourth = new ListNode();
		fourth.data = 4;
		
		ListNode fifth = new ListNode();
		fifth.data = 5;
		
		start.link = second;
		second.link = third;
		third.link = fourth;
		fourth.link = fifth;
		fifth.link = null;
		
		ListNode result = reverseKGroup(start, 1);
		
		ListNode t = result;
		while(t != null) {
			System.out.print(t.data + " | ");
			t = t.link;
		}
	}
	
	/*
	 * T = O(n)
	 * S = O(1)
	 */
	public static ListNode reverseKGroup(ListNode start, int k) {
        
		ListNode next = start;
		int flag = 1;
		boolean exist = true;
		
		ListNode temp = null;
		ListNode groupHead = null;
		ListNode groupLast = null;
		
		if(next == null) {
			return null;
		}
		
		do {
			ListNode prev = null;
			groupHead = next;
			int i;
			for(i = 1; i <= k; i++) {
				temp = next.link;
				next.link = prev;
				prev = next;
				next = temp;
			}
			
			if(i == k+1) {
				groupHead.link = next;
				if(flag == 1) {
					start = prev;
					flag++;
				} else {
					groupLast.link = prev;
				}
				
				groupLast = groupHead;
			}
			
			// check if next group of size k exist
			ListNode t = next;
			for(i = 1; i <= k; i++) {
				if(t == null) {
					exist = false;
					break;
				} else {
					t = t.link;
				}
			}
		} while(exist);
		
		return start;
    }
}
