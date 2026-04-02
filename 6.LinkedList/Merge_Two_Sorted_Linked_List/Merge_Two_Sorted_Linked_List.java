package practice.dsa.sheet.part1;

import practice.dsa.sheet.utility.ListNode;

public class Merge_Two_Sorted_Linked_List {
	
	public static void main(String[] args) {
		
//		ListNode list1 = null;
//		ListNode list2 = new ListNode();
//		list2.data = 0;
//		list2.link = null;
//		
//		ListNode head = mergeTwoSotedLists(list1, list2);
//		
//		ListNode t = head;
//		while(t != null) {
//			System.out.print(t.data + " ");
//			t = t.link;
//		}
	
		
		ListNode list1 = new ListNode();
		list1.data = 1;
		list1.link = new ListNode();
		list1.link.data = 2;
		list1.link.link = new ListNode();
		list1.link.link.data = 4;
		
		ListNode list2 = new ListNode();
		list2.data = 1;
		list2.link = new ListNode();
		list2.link.data = 3;
		list2.link.link = new ListNode();
		list2.link.link.data = 4;
		
		ListNode head = mergeTwoSortedLL(list1, list2);
		
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
	
	
	/*
	 * Best solution solution
	 * 
	 * T = O(m + n)
	 * S = O(1)
	 */
	private static ListNode mergeTwoSortedLL(ListNode start1, ListNode start2) {
	
		if(start1 != null && start2 == null) {
			return start1;
		} else if(start2 != null && start1 == null) {
			return start2;
		} else if(start1 == null && start2 == null) {
			return null;
		}
		
		ListNode t1 = start1;
		ListNode t2 = start2;
		ListNode start = null;
		ListNode last = null;
		
		while(t1 != null && t2 != null) {
			if(t1.data <= t2.data) {
				if(start == null) {
					start = t1;
					last = t1;
					t1 = t1.link;
				} else {
					last.link = t1;
					last = last.link;
					t1 = t1.link;
				}
			} else if(t2.data < t1.data) {
				if(start == null) {
					start = t2;
					last = t2;
					t2 = t2.link;
				} else {
					last.link = t2;
					last = last.link;
					t2 = t2.link;
				}
			}
		}
		
		while(t1 == null && t2 != null) {
			last.link = t2;
			last = last.link;
			t2 = t2.link;
		}
		
		while(t2 == null && t1 != null) {
			last.link = t1;
			last = last.link;
			t1 = t1.link;
		}
	
		return start;
	}
}
