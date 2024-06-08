package algorithms.part3;

public class Remove_Duplicates_And_Maintain_Order {
	 
	public static void main(String[] args) {
		
		String str = "bcbcbabba";
		String output = removeDuplicates(str);
		
		System.out.println(output);
	}
	
	public static String removeDuplicates(String str) {
		
		int n = str.length();
		int[] letters = new int[26];
	
		String output = "";
		for(int i = 0; i <= n-1; i++) {
			if(letters[str.charAt(i) - 'a'] == 0) {
				output = output + str.charAt(i);
				letters[str.charAt(i) - 'a'] = 1;
			}
		}
		
		return output;
	}
}
