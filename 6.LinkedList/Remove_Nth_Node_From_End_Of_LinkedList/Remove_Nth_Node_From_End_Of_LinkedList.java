package practice.dsa.sheet.part1;

import practice.dsa.sheet.utility.ListNode;

public class Remove_Nth_Node_From_End_Of_LinkedList {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * To remove nth node from end we have to find n+1 th node from end
	 * 
	 * T = O(n)
	 * S = O(1)
	 */
	private static ListNode removeNthNodeFromEnd(ListNode start, int n) {
        
        if(start == null) {
            return start;
        }
        
        ListNode f = start;
        for(int i = 1; i <= n; i++) {
            if(f.link == null) {
            	if(i == n) {
            		start = start.link;
            	}
                return start;
            }
            f = f.link;
        }
        
        ListNode s = start;
        while(f.link != null) {
            s = s.link;
            f = f.link;
        }
        
        s.link = s.link.link;
        
        return start;
    }
	
	private static ListNode removeNthNodeFromEnd2nd(ListNode start, int n) {
		
		if(start == null) {
			return null;
		}
		
		ListNode t1 = start;
		
		for(int i = 1; i <= n+1; i++) {
			if(t1 == null) {
				return start;
			}
			
			if(t1.link == null && i == n) {
				start = start.link;
				return start;
			}
			
			t1 = t1.link;
		}
		
		ListNode t2 = start;
		
		while(t1 != null) {
			t1 = t1.link;
			t2 = t2.link;
		}
		
		if(t2.link != null) {
            t2.link = t2.link.link;
        }
		
		return start;
	}
	
}
