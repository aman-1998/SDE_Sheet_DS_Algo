
public class Longest_Uniform_Substring {
	
	public static void main(String[] args) {
		
		String str = "";
		int[] res = longestUniformSubstring_2nd(str);

		System.out.println(res[0]);
		System.out.println(res[1]);
	}

	private static int[] longestUniformSubstring_2nd(String str) {
		
		int n = str.length();
		int[] res = {-1, 0};
		if(n == 0) {
			return res;
		}
		int maxLen = 0;
		int start = 0;
		int count = 0;
		char ch = str.charAt(0);

		for(int i = 0; i <= n-1; i++) {
			if(str.charAt(i) == ch) {
				count++;
				if(count > maxLen) {
					maxLen = count;
					res[0] = start;
					res[1] = maxLen;
				}
			} else {
				start = i;
				ch = str.charAt(i);
				count = 1;
			}
		}

		return res;
	}
}
