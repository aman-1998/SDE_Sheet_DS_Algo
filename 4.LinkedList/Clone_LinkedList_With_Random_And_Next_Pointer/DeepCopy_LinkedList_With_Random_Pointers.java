package algorithms;

import java.util.HashMap;

class ListNode {
	int data;
	ListNode next;
    ListNode random;

	ListNode (int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

public class DeepCopy_LinkedList_With_Random_Pointers {
	
	public static void main(String[] args) {
		ListNode head = createLinkedList();
		
		ListNode head2 = cloneTheLinkedList_method2(head);
	}
	
	private static ListNode createLinkedList() {
		// TODO Auto-generated method stub
		return null;
	}

	// T = O(2n) = O(n)
	// S = O(n)
	private static ListNode cloneTheLinkedList_method1(ListNode head) {
		
		if(head == null) {
            return null;
        }
		
		ListNode t = head;
		ListNode prev = null;
		ListNode head2 = null;
		HashMap<ListNode, ListNode> hMap = new HashMap<>();
		while(t != null) {
			
			ListNode t1 = new ListNode(t.data);
			hMap.put(t, t1);
			
			if(prev != null) {
				prev.next = t1;
			} else {
				head2 = t1;
			}
			prev = t1;
			t = t.next;
		}
		
		ListNode t1 = head;
		ListNode t2 = head2;
		
		while(t1 !=null && t2!= null) {
			
			t2.random = hMap.get(t1.random);
			t1 = t1.next;
			t2 = t2.next;
		}
		return head2;
	}
	
	// T = O(4n) = O(n)
	// S = O(1)
	private static ListNode cloneTheLinkedList_method2(ListNode head) {
		
		if(head == null) {
            return null;
        }
		
		ListNode t = head;
		ListNode prev = null;
		ListNode head2 = null;
		while(t != null) {
			
			ListNode t1 = new ListNode(t.data);
			
			if(prev != null) {
				prev.next = t1;
			} else {
				head2 = t1;
			}
			prev = t1;
			t = t.next;
		}
		
		ListNode t1 = head;
		ListNode t2 = head2;
		ListNode nextLink1;
		ListNode nextLink2;
		
		while(t1 !=null && t2!= null) {
			
			nextLink1 = t1.next;
			t1.next = t2;
			nextLink2 = t2.next;
			t2.next = nextLink1;
			
			t1 = nextLink1;
			t2 = nextLink2;
		}
		
		t1 = head;
		t2 = head.next;
		
		while(t2.next != null) {
			
			if(t1.random == null) {
				t2.random = null;
			} else {
				t2.random = t1.random.next;
			}
			
			t1 = t1.next.next;
			t2 = t2.next.next;
		}
		
		if(t1.random == null) {
			t2.random = null;
		} else {
			t2.random = t1.random.next;
		}
		
		t1 = head;
		t2 = head2;
		
		while(t2.next != null) {
			
			t1.next = t1.next.next;
			t2.next = t2.next.next;
			
			t1 = t1.next;
			t2 = t2.next;
		}
		
		t1.next = null;
		t2.next = null;
		
		return head2;
	}
}
