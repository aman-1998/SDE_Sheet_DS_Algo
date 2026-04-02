package practice.dsa.sheet.part1;

import practice.dsa.sheet.utility.ListNode;

public class Find_Nth_Node_From_End {
	
	public static void main(String[] args) {
		
		ListNode start = new ListNode();
		start.data = 1;
		start.link = new ListNode();
		
		start.link.data = 2;
		start.link.link = new ListNode();
		
		start.link.link.data = 3;
		start.link.link.link = new ListNode();
		
		start.link.link.link.data = 4;
		start.link.link.link.link = new ListNode();
		
		start.link.link.link.link.data = 5;
		start.link.link.link.link.link = new ListNode();
		
		start.link.link.link.link.link.data = 6;
		
		ListNode nthNode = findNthNodeFromEnd(start, 1);
		if(nthNode == null) {
			System.out.println("-1");
		} else {
			System.out.println(nthNode.data);
		}
		
	}
	
	/*
	 * T = O(1)
	 * S = O(1)
	 */
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
	
	
	private static ListNode findNthNodeFromEnd(ListNode start, int n) {
		
		if(start == null) {
			return null;
		}
		
		ListNode t1 = start;
		
		for(int i = 1; i <= n; i++) {
			if(t1 == null) {
				return null;
			}
			t1 = t1.link;
		}
		
		ListNode t2 = start;
		
		while(t1 != null) {
			t1 = t1.link;
			t2 = t2.link;
		}
		
		return t2;
	}
}
