package algorithms;

import algorithms.utility.ListNode;

public class Startng_Point_Of_Loop_In_A_Linked_List {
	
	public static void main(String[] args) {
		
	}
	
	public static ListNode startingPointOfCycle(ListNode start) {
		
		if(start == null) {
			return null;
		}
		
		ListNode fast = start;
		ListNode slow = start;
		
		do {
			if(fast.link == null || fast.link.link == null) {
				return null;
			}
			fast = fast.link.link;
			slow = slow.link;
		} while(fast != slow);
		
		ListNode meet = slow;
		ListNode t = start;
		
		while(t != meet) {
			t = t.link;
			meet = meet.link;
		}
		
		return t;
	}
}
