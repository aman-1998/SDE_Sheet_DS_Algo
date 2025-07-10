package algorithms;

import algorithms.utility.ListNode;

public class Intersection_Of_Two_Linked_Lists {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * 
	 * T = O(2m + n)
	 * S = O(1)
	 */
	public static ListNode getIntersectionNode_BF(ListNode headA, ListNode headB) {
		
		if(headA == null || headB == null) {
			return null;
		}
		
		ListNode t1 = headA;
		ListNode t2 = headB;
		int count1 = 1;
		int count2 = 1;
		while(t1 != null) {
			t1 = t1.link;
			count1++;
		}
		
		while(t2 != null) {
			t2 = t2.link;
			count2++;
		}
		
		int diff = Math.abs(count1 - count2);
		if(count1 > count2) {
			t1 = headA;
			for(int i = 1; i <= diff; i++) {
				t1 = t1.link;
			}
			t2 = headB;
		} else {
			t2 = headB;
			for(int i = 1; i <= diff; i++) {
				t2 = t2.link;
			}
			t1 = headA;
		}
		
		while(t1 != t2) {
			if(t1 != null) {
				t1 = t1.link;
			}
			
			if(t2 != null) {
				t2 = t2.link;
			}
			
			if(t1 == null || t2 == null) {
				return null;
			}
		}
		
		return t1;
	}
	
	// T = O(m + n)
	// S = O(1)
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
		ListNode t1 = headA;
		ListNode t2 = headB;
		
		while(t1 != t2) {
			
			if(t1 == null) {
				t1 = headB;
			} else {
				t1 = t1.link;
			}
			
			
			if(t2 == null) {
				t2 = headA;
			} else {
				t2 = t2.link;
			}
		}
		
		return t1;
    }
}
