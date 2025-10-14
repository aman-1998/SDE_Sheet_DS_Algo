package practice.dsa.sheet.part4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Online_Stock_Span {
	
	public static void main(String[] args) {
		
		StockSpanner1 stockSpanner = new StockSpanner1();
		System.out.println(stockSpanner.next(7));
		System.out.println(stockSpanner.next(2));
		System.out.println(stockSpanner.next(1));
		System.out.println(stockSpanner.next(3));
		System.out.println(stockSpanner.next(3));
		System.out.println(stockSpanner.next(1));
		System.out.println(stockSpanner.next(8));
		 
	}
	
}


/*
 * T = O(2n)
 * S = O(2n)
 */
class StockSpanner {
	
	Stack<Integer> stack = new Stack<>();
	List<Integer> priceList = new ArrayList<>();
	List<Integer> pgeList = new ArrayList<>(); // previous greater element list

    public StockSpanner() {}
    
    public int next(int price) {
        
    	priceList.add(price);
    	
    	int index = -1;
    	if(!stack.isEmpty()) {
    		index = stack.peek();
    		while(priceList.get(index) <= price) {
    			stack.pop();
    			if(stack.isEmpty()) {
    				index = -1;
    				break;
    			}
    			index = stack.peek();
    		}
    	}
    	pgeList.add(index);
    	stack.push(priceList.size()-1);
    	
    	return pgeList.size()-1 - pgeList.get(pgeList.size()-1);
    }
    
}


/*
 * T = O(2n)
 * S = O(2n)
 */
class StockSpanner1 {
	
	private Stack<Integer> stack = new Stack<>();
	
	private List<Integer> priceList = new ArrayList<>();
	
	public int next(int price) {
    	
		priceList.add(price);
		
		int index = -1;
		
		if(!stack.isEmpty()) {
			index = stack.peek();
			while(price >= priceList.get(index)) {
				stack.pop();
				if(stack.isEmpty()) {
					index = -1;
					break;
				}
				index = stack.peek();
			}
		}
		
		stack.push(priceList.size() - 1);
		return priceList.size() - 1 - index;
    }
}
