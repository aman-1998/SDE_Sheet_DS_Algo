package algorithms;

import algorithms.utility.ListNode;

public class Remove_Nth_Node_From_End_Of_LinkedList {
	
	public static void main(String[] args) {
		
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null) {
            return head;
        }

        ListNode fast = head;
        for(int i = 1; i <= n-1; i++) {

            if(fast.link != null) {
                fast = fast.link;
            } else {
                return head;
            }
        }

        ListNode slow = head;
        ListNode prev = null;
        while(fast.link != null) {
            fast = fast.link;
            prev = slow;
            slow = slow.link;
        }

        if(prev == null) {
            head = head.link;
        } else {
            prev.link = slow.link;
            slow.link = null;
            slow = null;
        }

        return head;

    }
}
