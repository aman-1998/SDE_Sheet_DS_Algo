package algorithms.part4;

import java.util.HashMap;
import java.util.Map;

public class DataStructure_Push_Pop_Peek_Order_1_time {
	
	/*
	 *  Ques 1: Design a data structure with following features:
	 *
	 *	1. Push an element at the end of the data structure (O(1) time complexity) - void push(int element)
	 *	2. Pop the element from the beginning of the data structure( pop the earliest element added, O(1) time complexity) - int pop()
	 *	3. Seek an element at index i at any given state of the data structure. (O(1) time complexity) - int seek(int index)
     *
     *	Elements can be duplicate too. 
	 */
	
	public static void main(String[] args) {
		
		MyCustomDataStructue ds = new MyCustomDataStructue();

        ds.push(1);
        ds.push(2);
        ds.push(3);

        System.out.println(ds);
        System.out.println(ds.peek(0));
        

        ds.pop();
        System.out.println(ds);
        System.out.println(ds.peek(0));

        ds.pop();
        ds.pop();
        System.out.println(ds);

        ds.push(4);
        System.out.println(ds);
        System.out.println(ds.peek(0));
        
        
	}
	
	
}

class MyCustomDataStructue {
	
	// index , element
	private Map<Integer, Integer> hMap = new HashMap<>();
	private int startIndex = -1;
	private int endIndex = -1;
	
	public void push(int element) {
		
		if(startIndex == -1 && endIndex == -1) { // empty map
			startIndex = 0;
			endIndex = 0;
			hMap.put(endIndex, element);
		} else {
			endIndex++;
			hMap.put(endIndex, element);
		}
	}
	
	public int pop() {
		
		if(startIndex == -1 && endIndex == -1) { // empty map
			throw new RuntimeException("Map is empty");
		}
		
		int popped = hMap.remove(startIndex);
		startIndex++;
		
		if(hMap.isEmpty()) { // reset
			startIndex = -1;
			endIndex = -1;
		}
		
		return popped;
	}
	
	public int peek(int index) {
		
		if(startIndex == -1 && endIndex == -1) { // empty map
			throw new RuntimeException("Map is empty");
		}
		
		int actualIndex = index + startIndex;
		
		Integer element = hMap.get(actualIndex); // actualIndex > endIndex
		if(element == null) {
			throw new RuntimeException(index + " does not exist");
		} 
		
		return element;
	}
	
	@Override
	public String toString() {
		return hMap.toString();
	}
}
