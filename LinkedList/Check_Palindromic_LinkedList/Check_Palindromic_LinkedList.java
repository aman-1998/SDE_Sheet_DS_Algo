package algorithms;

import algorithms.utility.ListNode;

public class Check_Palindromic_LinkedList {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * T = O(n/2 + n/2 + n/2) = O(3n/2) = O(n)
	 * S = O(1)
	 */
	public static boolean isPalindrome(ListNode start) {
		
		if(start == null) {
			return false;
		}
		
		ListNode fast = start;
		ListNode slow = start;
		
		while(fast.link != null && fast.link.link != null) { // T = O(n/2)
			fast = fast.link.link;
			slow = slow.link;
		}
		
		ListNode next = slow;
		ListNode prev = null;
		
		while(next != null) { // T = O(n/2)
			ListNode temp = next.link;
			next.link = prev;
			prev = next;
			next = temp;
		}
		
		ListNode t1 = start;
		ListNode t2 = prev;
		
		while(t1 != null && t2 != null) { // T = O(n/2)
			
			if(t1.data != t2.data) {
				return false;
			}
			t1 = t1.link;
			t2= t2.link;
		}
		
		return true;
	}
}
