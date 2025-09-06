package practice.dsa.sheet.part5;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Video Link : https://www.youtube.com/watch?v=1zktEppsdig
 */
public class Merge_K_Sorted_LinkedLists {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * Best Solution : Using minHeap of size k
	 * 
	 * T = O(n*k*log k) ; Assuming each linkedList is of length n
	 * S = O(k)
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
        
		int k = lists.length;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparing(node -> node.val));
		
		for(int i = 0; i <= k-1; i++) { // T = O(k*log k)
			if(lists[i] != null) {
				minHeap.add(lists[i]);
			}
		}
		
		ListNode head = null;
		ListNode last = null;
		while(!minHeap.isEmpty()) { // T = O((n*k-k)*2*log k) + O(k*log k)
			if(head == null) {
				head = minHeap.poll();
				last = head;
				if(last.next != null) {
					minHeap.add(last.next);
				}
			} else {
				last.next = minHeap.poll();
				last = last.next;
				if(last.next != null) {
					minHeap.add(last.next);
				}
			}
		}
		
		return head;
    }
}

class ListNode {
	
	int val;
	
	ListNode next;
	
	ListNode() {}
	
	ListNode(int val) { 
		this.val = val; 
	}
	
	ListNode(int val, ListNode next) { 
		this.val = val; this.next = next;
	}
}
