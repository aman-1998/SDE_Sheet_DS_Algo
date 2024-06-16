package algorithms.part3;

public class Aanagram {
	
	public static void main(String[] args) {
		
		String str1 = "LISTEN";
		String str2 = "SILENT";
		
		boolean check = isAnagram(str1, str2);
		
		System.out.println(check);
	}
	
	/*
	 * T = O(m) + O(n) + O(256) = O(m + n)
	 * S = O(256) = O(1)
	 */
	public static boolean isAnagram(String str1, String str2) {
		
		int m = str1.length();
		int n = str2.length();
		
		if(m != n) {
			return false;
		}
		
		int[] DAT = new int[256];
		
		for(int i = 0; i <= m-1; i++) {
			DAT[str1.charAt(i)]++;
		}
		
		for(int i = 0; i <= n-1; i++) {
			DAT[str2.charAt(i)]--;
		}
		
		for(int i = 0; i <= 255; i++) {
			if(DAT[i] != 0) {
				return false;
			}
		}
		
		return true;
	}
}
