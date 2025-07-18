package algorithms.part4;

import java.util.Stack;

public class Balanced_Parantheses {
	
	public static void main(String[] args) {
		
		String str1 = "()[{()}]";
		System.out.println(isValid(str1));
		
		String str2 = "()[{()}(])";
		System.out.println(isValid(str2));
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	private static boolean isValid(String str) {
		
		int n = str.length();
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i <= n-1; i++) {
			if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
				stack.push(str.charAt(i));
			} else if(str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']') {
				if(stack.isEmpty()) {
                    return false;
                }
				Character openParanthesis = stack.pop();
				if(!isMatch(openParanthesis, str.charAt(i))) {
					return false;
				}
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		
		return false;
	}

	private static boolean isMatch(Character openParanthesis, char closesParanthesis) {
		
		if(openParanthesis == '(' && closesParanthesis == ')') {
			return true;
		} else if(openParanthesis == '{' && closesParanthesis == '}') {
			return true;
		} else if(openParanthesis == '[' && closesParanthesis == ']') {
			return true;
		}
		return false;
	}
}
