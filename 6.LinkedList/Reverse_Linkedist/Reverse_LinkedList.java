package algorithms;
import algorithms.utility.ListNode;

public class Reverse_LinkedList {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * T = O(n)
	 * S = O(1)
	 */
	public ListNode reverseList(ListNode start) {
        ListNode prev = null;
        ListNode next = start;

        while(next != null) {
            ListNode temp = next.link;
            next.link = prev;
            prev = next;
            next = temp;
        }

        start = prev;
        return start;
    }
}
