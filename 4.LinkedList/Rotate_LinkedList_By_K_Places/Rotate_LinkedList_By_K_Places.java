package algorithms.part1;

import algorithms.utility.ListNode;

public class Rotate_LinkedList_By_K_Places {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * Time complexity:
     * T = O(2n) = O(n)
     * 
     * Space complexity:
     * S = O(1)
     * 
	 */
	public ListNode rotateRight(ListNode start, int k) {

		if(start == null) {
            return start;
        }

        int count = 1;
        ListNode t = start;
        while(t.link != null) { // Find length
            t = t.link;
            count++;
        }

        k = k % count;

        if(k == 0) {
            return start;
        }

        ListNode fast = start;
        for(int i = 1; i <= k; i++) {
            fast = fast.link;
        }

        ListNode slow = start;
        while(fast.link != null) {
            slow = slow.link;
            fast = fast.link;
        } // Find k+1 th node from end 

        fast.link = start;
        start = slow.link;
        slow.link = null;
        return start;
    }
	
	/*
	 * T = O(3n) = O(n)  [But it can be done in O(2n) as well.]
	 * S = O(1)
	 * 
	 */
	public ListNode rotateLeft(ListNode start, int k) {

		if(start == null) {
            return start;
        }

        int count = 1;
        ListNode t = start;
        while(t.link != null) { // Find length
            t = t.link;
            count++;
        }
        
        k = k % count;
        
        /*
         * Rotating k elements from right is equals to 
         * rotating count-k elements from left
         */
        return rotateRight(start, count-k);
    }
}
