package algorithms;

import algorithms.utility.ListNode;

public class Merge_Two_Sorted_Linked_List {
	
	public static void main(String[] args) {
		
		ListNode list1 = null;
		ListNode list2 = new ListNode();
		list2.data = 0;
		list2.link = null;
		
		ListNode head = mergeTwoSotedLists(list1, list2);
		
		ListNode t = head;
		while(t != null) {
			System.out.print(t.data + " ");
			t = t.link;
		}
	}
	
	/*
	 * T = O(m + n)
	 * S = O(1)
	 */
	public static ListNode mergeTwoSotedLists(ListNode list1, ListNode list2) {
        
		ListNode head = merge(list1, list2);
		return head;
    }

	private static ListNode merge(ListNode list1, ListNode list2) {
		
		if(list1 != null && list2 == null) {
			return list1;
		}
		
		if(list1 == null && list2 != null) {
			return list2;
		}
		
		ListNode t1 = list1;
		ListNode t2 = list2;
		
		ListNode head = null;
		ListNode last = null;
		
		
		
		while(t1 != null && t2 != null) {
			
				if(head == null) {
					head = new ListNode();
					if(t1.data < t2.data) {
						head.data = t1.data;
						t1 = t1.link;
					} else {
						head.data = t2.data;
						t2 = t2.link;
					}
					head.link = null;
					last = head;
				} else {
					last.link = new ListNode();
					if(t1.data < t2.data) {
						last.link.data = t1.data;
						t1 = t1.link;
					} else {
						last.link.data = t2.data;
						t2 = t2.link;
					}
					last.link.link = null;
					last = last.link;
				}
		}
		
		while(t1 == null && t2 != null) {
			last.link = new ListNode();
			last.link.data = t2.data;
			t2 = t2.link;
			last = last.link;
		}
		
		while(t1 != null && t2 == null) {
			last.link = new ListNode();
			last.link.data = t1.data;
			t1 = t1.link;
			last = last.link;
		}
		
		return head;
	}
}
