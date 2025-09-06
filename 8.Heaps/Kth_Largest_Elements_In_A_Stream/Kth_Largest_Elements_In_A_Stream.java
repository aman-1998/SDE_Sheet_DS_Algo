package practice.dsa.sheet.part5;

import java.util.PriorityQueue;

public class Kth_Largest_Elements_In_A_Stream {
	
	public static void main(String[] args) {
		
		int[] arr = {57, 69, 81, 120, 100, 92, 73, 67, 85}; // Initial student's marks submitted
		int k = 3; // Only 3 seats in university
		
		KthLargest kthLargest = new KthLargest(k, arr);
		int cutOff = kthLargest.add(48); // kth largest element at this moment
		cutOff = kthLargest.add(110); // kth largest element at this moment
		cutOff = kthLargest.add(92); // kth largest element at this moment
		cutOff = kthLargest.add(105); // kth largest element at this moment
		
		System.out.println("Cutoff = " + cutOff);
	}
	
}


class KthLargest {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
    private int k;

    public KthLargest(int k, int[] arr) {
        
    	int n = arr.length;
    	for(int i = 0; i <= n-1; i++) {
    		minHeap.add(arr[i]);
    		if(minHeap.size() > k) {
    			minHeap.poll();
    		}
    	}
    	
    	this.k = k;
    }
    
    public int add(int val) {
        
    	minHeap.add(val);
    	if(minHeap.size() > k) {
    		minHeap.poll();
    	}
    	
    	return minHeap.peek();
    }
}
