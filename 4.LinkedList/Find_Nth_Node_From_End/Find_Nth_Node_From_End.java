package algorithms.part1;

import algorithms.utility.ListNode;

public class Find_Nth_Node_From_End {
	
	public static void main(String[] args) {
		
	}
	
	private static int getNthFromEnd(ListNode start, int n) {
        // Your code here
        if(start == null) {
            return -1;
        }
        
        ListNode f = start;
        for(int i = 1; i <= n-1; i++) {
            if(f.link == null) {
                return -1;
            }
            f = f.link;
        }
        
        ListNode s = start;
        while(f.link != null) {
            s = s.link;
            f = f.link;
        }
        
        return s.data;
    }
}
