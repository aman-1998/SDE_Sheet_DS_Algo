package algorithms;

import algorithms.utility.ListNode;

public class Add_Two_Numbers_As_Linked_List {
	
public static void main(String[] args) {
		
		ListNode head1 = createLinkedList();
		ListNode head2 = createLinkedList();
		
		ListNode sumHead = addTwoNumbers(head1, head2);
	}
	
	private static ListNode createLinkedList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		
		ListNode t1 = head1;
		ListNode t2 = head2;
		ListNode sumHead = null;
		ListNode last = null;
		
		int carry = 0;
		
		while(t1 != null || t2 != null || carry != 0) {
			
			int sum = 0;
			
			if(t1 != null) {
				sum = sum + t1.data;
				t1 = t1.link;
			}
			
			if(t2 != null) {
				sum = sum + t2.data;
				t2 = t2.link;
			}
			
			sum = sum + carry;
			carry = sum / 10;
			if(sumHead == null) {
				sumHead = new ListNode();
				sumHead.data = sum % 10;
				sumHead.link = null;
				last = sumHead;
			} else {
				last.link = new ListNode();
				last.link.data = sum % 10;
				last.link.link = null;
				last = last.link;
			}
			
		}
		
		return sumHead;
	}
}
