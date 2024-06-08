package algorithms.part3;

public class Remove_Duplicates_And_Return_Sorted_String {
	
	public static void main(String[] args) {
		
		String str = "bcbcbabba";
		String output = removeDuplicates(str);
		
		System.out.println(output);
	}
	
	public static String removeDuplicates(String str) {
		
		int n = str.length();
		int[] letters = new int[26];
		
		for(int i = 0; i <= n-1; i++) {
			int index = str.charAt(i) - 'a';
			letters[index]++;
		}
		
		String output = "";
		for(int i = 0; i <= 25; i++) {
			if(letters[i] != 0) {
				output = output + (char)(i + 'a');
			}
		}
		
		return output;
		
	}
}
