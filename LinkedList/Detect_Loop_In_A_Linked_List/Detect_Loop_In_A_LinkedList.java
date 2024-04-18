package algorithms;

import algorithms.utility.ListNode;

public class Detect_Loop_In_A_LinkedList {
	
	public static void main(String[] args) {
		
	}
	
	public static boolean detectLoop(ListNode start) {
		
		if(start == null) {
			return false;
		}
		
		ListNode fast = start;
		ListNode slow = start;
		
		do {
			if(fast.link == null || fast.link.link == null) {
				return false;
			}
			fast = fast.link.link;
			slow = slow.link;
		} while(fast != slow);
		
		return true;
	}
}
