package practice.dsa.sheet.part5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Find_Median_From_Data_Stream {
	
	public static void main(String[] args) {
		
		MedianFinder medianFinder = new MedianFinder();
		/*
		medianFinder.addNum(6);
		medianFinder.addNum(3);
		medianFinder.addNum(1);
		medianFinder.addNum(4);
		medianFinder.addNum(12);
		medianFinder.addNum(9);
		medianFinder.addNum(4);
		
		System.out.println(medianFinder.findMedian());
		
		medianFinder.addNum(5);
		
		System.out.println(medianFinder.findMedian());
		*/
		
		//System.out.println(medianFinder.findMedian());
		
		medianFinder.addNum(1);
		medianFinder.addNum(2);
		
		System.out.println(medianFinder.findMedian());
		
		medianFinder.addNum(3);
		
		System.out.println(medianFinder.findMedian());
	}
	
}

class MedianFinder {
	
	private PriorityQueue<Integer> maxHeap = null;
	private PriorityQueue<Integer> minHeap = null;
	
    public MedianFinder() {
    	maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    	minHeap = new PriorityQueue<>();
    }
    
    /*
     * T = O(log n) ; n = no. of element in stream
     */
    public void addNum(int num) {
    	
        maxHeap.add(num);
        
        if(!minHeap.isEmpty()) {
        	if(maxHeap.peek() > minHeap.peek()) {
            	minHeap.add(maxHeap.poll());
            }
        }
        
        int diff = Math.abs(maxHeap.size() - minHeap.size());
        if(diff > 1) {
        	if(maxHeap.size() > minHeap.size()) {
            	minHeap.add(maxHeap.poll());
            }
        	
        	if(minHeap.size() > maxHeap.size()) {
        		maxHeap.add(minHeap.poll());
        	}
        }
    }
    
    /*
     * T = O(1)
     */
    public double findMedian() {
        if((maxHeap.size() + minHeap.size()) % 2 == 0) {
        	return ((double)maxHeap.peek() + (double)minHeap.peek())/(double)2;
        } else {
        	if(maxHeap.size() > minHeap.size()) {
        		return (double)maxHeap.peek();
        	} else {
        		return (double)minHeap.peek();
        	}
        }
    }
}
