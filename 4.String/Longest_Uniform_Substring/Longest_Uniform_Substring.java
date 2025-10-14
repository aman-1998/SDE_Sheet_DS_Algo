package practice.dsa.sheet.part3;

public class Longest_Uniform_Substring {
	
	public static void main(String[] args) {
		
		String str = "aabbbc";
		longestUniformSubstring(str);
	}
	
	private static void longestUniformSubstring(String str) {
		
		int n = str.length();
		int max = Integer.MIN_VALUE;
		int maxStart = 0;
		int count = 1;
		int start = 0;
		for(int i = 0; i <= n-2; i++) {
			
			if(str.charAt(i) == str.charAt(i+1)) {
				count++;
			} else {
				if(count > max) {
					max = count;
					maxStart = start;
				}
				count = 1;
				start = i+1;
			}
		}
		
		if(count > max) {
			max = count;
			maxStart = start;
		}
		
		System.out.println("index: " + maxStart + ", length: " + max);
	}
}
