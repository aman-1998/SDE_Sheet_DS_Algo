package algorithms.part1;

import algorithms.utility.ListNode;

public class Remove_Nth_Node_From_End_Of_LinkedList {
	
	public static void main(String[] args) {
		
	}
	
	private static ListNode removeNthFromEnd(ListNode start, int n) {
        
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
}
