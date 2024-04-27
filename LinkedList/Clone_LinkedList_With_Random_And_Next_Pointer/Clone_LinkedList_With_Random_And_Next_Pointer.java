package algorithms;

import java.util.HashMap;
import java.util.Map;

import algorithms.utility.RandNode;

public class Clone_LinkedList_With_Random_And_Next_Pointer {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * BruteForce: Using hashMap
	 * 
	 * T = O(2n)
	 * S = O(n)
	 */
	public static RandNode deepCopyLinkedList_BF(RandNode start) {
		
		if(start == null) {
			return start;
		}
		
		Map<RandNode, RandNode> hashMap = new HashMap<>();
		RandNode t = start;
		while(t != null) {
			RandNode clonedNode = deepCopyNode(t);
			hashMap.put(t, clonedNode);
			t = t.next;
		}
		
		t = start;
		RandNode t2 = null;
		while(t != null) {
			t2 = hashMap.get(t);
			t2.next = hashMap.get(t.next);
			t2.random = hashMap.get(t.random);
			t = t.next;
		}
		
		RandNode start2 = hashMap.get(start);
		
		return start2;
	}
	
	private static RandNode deepCopyNode(RandNode node) {
		RandNode clonedNode = new RandNode();
		clonedNode.data = node.data;
		clonedNode.next = null;
		clonedNode.random = null;
		return clonedNode;
	}
	
	/*
	 * T = O(4n) = O(n)
	 * S = O(1)
	 */
	public static RandNode deepCopyLinkedList(RandNode start) {
		
		if(start == null) {
			return null;
		}
		
		// Cloning without random pointers
		RandNode t1 = start;
		RandNode t2 = null;
		RandNode prev = null;
		RandNode start2 = null;
		while(t1 != null) {
			t2 = new RandNode();
			t2.data = t1.data;
			t2.next = null;
			t2.random = null;
			if(prev == null) {
				start2 = t2;
			} else {
				prev.next = t2;
			}
			prev = t2;
			t1 = t1.next;
		}
		
		// Breaking bonds and connecting two lists
		t1 = start;
		t2 = start2;
		while(t1 != null) {
			RandNode temp1 = t1.next;
			RandNode temp2 = t2.next;
			
			t1.next = t2;
			t2.next = temp1;
			t1 = temp1;
			t2 = temp2;
		}
		
		// Copying random pointers
		t1 = start;
		t2 = start2;
		while(t1 != null) {
			
			if(t1.random == null) {
				t2.random = null;
			} else {
				t2.random = t1.random.next;
			}
			t1 = t2.next;
			if(t1 != null) {
				t2 = t1.next;
			}
		}
		
		// Disconnecting two lists
		t1 = start;
		t2 = start2;
		while(t2.next != null) {
			t1.next = t2.next;
			t2.next = t2.next.next;
			
			t1 = t1.next;
			t2 = t2.next;
		}
		t1.next = null;
		
		return start2;
		
	}
	
}
