package algorithms.part3;

public class Reverse_Words_In_A_String {
	
	public static void main(String[] args) {
		
		//String str = "  Hello    World! ";
		String str = "Hello";
		String result = reverseWords(str);
		
		System.out.println(result);
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 * 
	 * In Java String is immutable. So, we need to another string to 
	 * store result.
	 */
	public static String reverseWords(String str) {
		
		int n = str.length();
		
		String result = "";
		int i = 0;
		while(i < n) {
			while(i < n && str.charAt(i) == ' ') {
				i++;
			}
			
			if(i >= n) {
				break;
			}
			
			int j = i + 1;
			while(j < n && str.charAt(j) != ' ') {
				j++;
			}
			
			String word = str.substring(i, j);
			result = result.isEmpty() ? word : word + " " + result;
			
			i = j + 1;
		}
		
		return result;
	}
}
