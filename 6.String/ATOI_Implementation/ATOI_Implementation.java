package algorithms.part3;

public class ATOI_Implementation {

	public static void main(String[] args) {
		
		String str = "-6147483648";
		int value = myAtoi(str);
		
		System.out.println(value);
	}
	
	/*
	 * T = O(n)
	 * S = O(1)
	 */
	public static int myAtoi(String str) {
		
		int n = str.length();
		int i = 0;
		while(i < n && str.charAt(i) == ' ') {
			i++;
		}
		
		int sign = 1;
		if(i < n && str.charAt(i) == '-') {
			sign = -1;
			i++;
		} else if(i < n && str.charAt(i) == '+') {
			sign = 1;
			i++;
		}
		
		int result = 0;
		int prevResult = 0;
		while(i < n && str.charAt(i)-'0' >= 0 && str.charAt(i)-'0' <= 9) {
			result = result * 10 + (str.charAt(i)-'0');
			if(result/10 != prevResult) {
				if(sign == 1) {
					return (1 << 31) - 1;
				} else {
					return -1*(1 << 31);
				}
			}
			prevResult = result;
			i++;
		}
		
		return sign*result;
	}
}
