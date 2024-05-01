package algorithms;

import algorithms.utility.ListNode;

public class Intersection_Of_Two_Linked_Lists {
	
	public static void main(String[] args) {
		
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
