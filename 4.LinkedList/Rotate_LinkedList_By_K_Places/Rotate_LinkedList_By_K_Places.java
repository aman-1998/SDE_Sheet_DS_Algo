package algorithms;

import algorithms.utility.ListNode;

public class Rotate_LinkedList_By_K_Places {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * Time complexity:
     * If k = 0 then T = O(1)
     * If k < n then T = O(k) + O(n - k)
     * If k > n and k%n != 0 then T = O(n + k%n) + O(n - k%n)
     * If k > n and k%n != 0 then T = O(n)
     * If k == n then T = O(n)
     * So, the worst case here is when k > n and k%n != 0.
     * Hence, T = O(n + k%n) + O(n - k%n)
     * Approximately, T = O(n)
     * 
     * Space complexity:
     * S = O(1)
     * 
	 */
	public ListNode rotateRight(ListNode start, int k) {

        if(k == 0 || start == null) {
            return start;
        }
        
        ListNode l = start;
        ListNode r = start;
        int count = 0;
        for(int i = 1; i <= k; i++) { // T = O(n + k%n)
            if(r == null) {
                
                k = k % count;
                if(k == 0) {
                    return start;
                }
                i = 1;
                r = start;
            }
            r = r.link;
            count++;
        }

        if(r == null) {
            return start;
        }

        while(r.link != null) { // T = O(n - k%n)
            r = r.link;
            l = l.link;
        }

        r.link = start;
        start = l.link;
        l.link = null;

        return start;
    }
}
