package algorithms.part4;

import java.util.Stack;

public class Remove_K_Digits {
	
	public static void main(String[] args) {
		
		//String num = "1432219";
		//int k = 3;
		//String smallNum = removeKdigits(num, k);
		//System.out.println(smallNum);
		
		//String num = "164345";
		//int k = 3;
		//String smallNum = removeKdigits(num, k);
		//System.out.println(smallNum);
		
		//String num = "3020562";
		//int k = 3;
		//String smallNum = removeKdigits(num, k);
		//System.out.println(smallNum);
		
		//String num = "112";
		//int k = 1;
		//String smallNum = removeKdigits(num, k);
		//System.out.println(smallNum);
		
		//String num = "10200";
		//int k = 1;
		//String smallNum = removeKdigits(num, k);
		//System.out.println(smallNum);
		
		String num = "1432219";
		int k = 2;
		String smallNum = removeKdigits(num, k);
		System.out.println(smallNum);
		
		//String num = "1107";
		//int k = 1;
		//String smallNum = removeKdigits(num, k);
		//System.out.println(smallNum);
		
		//String num = "10001";
		//int k = 1;
		//String smallNum = removeKdigits(num, k);
		//System.out.println(smallNum);
	}
	
	/*
	 * T = O(3n - k) = O(n - k)
	 * S = O(n)
	 */
	public static String removeKdigits(String num, int k) {
        
		int n = num.length();
		
		if(k >= n) {
			return "0";
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(num.charAt(0) - '0');
		for(int i = 1; i <= n-1; i++) { // T = O(n) + O(k-x)
			int element = num.charAt(i) - '0';
			int val = stack.peek();
			while(element < val && k != 0) {
				stack.pop();
				k--;
				if(stack.isEmpty()) {
					break;
				}
				val = stack.peek();
			}
			stack.push(element);
		}
		
		while(!stack.isEmpty() && k != 0) { // T = O(x)
			stack.pop();
			k--;
		}
		
		StringBuilder result = new StringBuilder();
		while(!stack.isEmpty()) { // T = O(n-k)
			result = result.append(stack.pop());
		}
		
		for(int j = result.length()-1; j >= 0; j--) { // T = O(y)
			if(result.charAt(j) == '0') {
				result.deleteCharAt(j);
			} else {
				break;
			}
		}
		
		result.reverse(); // T = O(n-k-y)
		
		if(result.length() == 0) {
			return "0";
		}
		
		return result.toString();
    }
}
