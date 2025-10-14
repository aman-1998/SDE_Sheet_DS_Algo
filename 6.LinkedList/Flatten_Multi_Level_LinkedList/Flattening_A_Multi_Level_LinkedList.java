package algorithms.part1;

import java.util.LinkedList;
import java.util.Queue;

import algorithms.utility.Node;

public class Flattening_A_Multi_Level_LinkedList {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * Using Queue
	 * 
	 * T = O(n)
	 * S = O(n)
	 * 
	 */
	public static Node flattenUsingQueue_1st(Node start) {
		
		if(start == null) {
			return null;
		}
		
		Queue<Node> queue = new LinkedList<>();
		
		Node t = start;
		while(t != null) {
			
			if(t.down != null) {
				queue.add(t.down);
				t.down = null;
			}
			
			if(t.next == null) {
				if(!queue.isEmpty()) {
					Node val = queue.remove();
					t.next = val;
				} 
			}
			t = t.next;
		}
		
		return start;
	}
	
	/*
	 * Using Queue
	 * 
	 * T = O(n)
	 * S = O(n)
	 * 
	 */
	public static Node flattenUsingQueue_2nd(Node root) {
        // code here
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        Node last = null;
        
        while(!queue.isEmpty()) {
            Node t = queue.remove();
            while(t != null) {
                if(last == null) {
                    last = t;
                } else {
                    last.next = t;
					last = last.next;
                }
                
                if(t.down != null) {
                    queue.add(t.down);
                }
                
                t = t.next;
            }
        }
        
        return root;
    }
	
	/*
	 * Best approach
	 * 
	 * Repeat till curr == null {
	 * 		Move last pointer to the end i.e., till last.next == null
	 * 		Then move current pointer and check if down child available or not
	 * 		If down child is available then stop and do last.next = curr.down
	 * 		And then move current one step.
	 * }
	 * 
	 * T = O(2n) => T = O(n)
	 * S = O(1)
	 */
	public static Node flatten(Node start) {
		
		if(start == null) {
			return start;
		}
		
		Node curr = start;
		Node last = start;
		
		while(curr != null) {
			
			while(last.next != null) {
				last = last.next;
			}
			
			while(curr.down == null) {
				curr = curr.next;
				
				if(curr == null) {
					return start;
				}
			}
			
			last.next = curr.down;
			curr = curr.next;
			
		}
		
		return start;
	}
}
