package algorithms.part3;

public class Compare_Version_Numbers {
	
	public static void main(String[] args) {
		String version1 = "00400.002.1";
		String version2 = "400.02.000001...3";
		
		int result = compareVersion(version1, version2);
		
		System.out.println(result);
	}
	
	/*
	 * T = O(m + n)
	 * S = O(1)
	 */
	public static int compareVersion(String version1, String version2) {
		
		
		int m = version1.length(); 
		int i = 0;// For version1
		int n = version2.length(); 
		int j = 0;// For version2
		
		while(i < m || j < n) {
			// For version1
			while(i < m && version1.charAt(i) == '0') { // ignore leading zeroes
				i++;
			}
			
			int ver1 = 0;
			while(i < m && version1.charAt(i) != '.') {
				ver1 = ver1*10 + version1.charAt(i) - '0';
				i++;
			}
			i++;
			
			// For version2
			while(j < n && version2.charAt(j) == '0') { // ignore leading zeroes
				j++;
			}
			
			int ver2 = 0;
			while(j < n && version2.charAt(j) != '.') {
				ver2 = ver2*10 + version2.charAt(j) - '0';
				j++;
			}
			j++;
			
			if(ver1 < ver2) {
				return -1;
			} else if(ver1 > ver2) {
				return 1;
			}
		}
		
		return 0;
	}
}
