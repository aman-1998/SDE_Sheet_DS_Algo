package algorithms.part3;

public class Longest_Common_Prefix {
	
	public static void main(String[] args) {
		
		String[] strArray = {"flower", "flow", "flight"};
		
		String longestCommonPrefix = longestCommonPrefix(strArray);
		
		System.out.println(longestCommonPrefix);
	}
	
	/*
	 * T = O(min(strArray) * n) where n = no. of elements in array and min(strArray) = min length among strArray[0], strArray[1], ... strArray[n-1]
	 *
     * S = O(1)
	 */
	public static String longestCommonPrefix(String[] strArray) {
		
		StringBuilder commonPrefix = new StringBuilder();
		
		for(int i = 0; i < strArray[0].length(); i++) {
			for(String str : strArray) {
				if(i < str.length()) {
					if(str.charAt(i) != strArray[0].charAt(i)) {
						return commonPrefix.toString();
					}
				} else {
					return commonPrefix.toString();
				}
			}
			commonPrefix.append(strArray[0].charAt(i));
		}
		
		return commonPrefix.toString();
	}
}
