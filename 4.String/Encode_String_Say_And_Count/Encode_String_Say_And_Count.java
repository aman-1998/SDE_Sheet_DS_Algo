package practice.dsa.sheet.part3;

import java.util.stream.IntStream;

public class Encode_String_Say_And_Count {
	
	public static void main(String[] args) {
		
		String str = "aabbccc";
		String ans = encode(str);
		
		System.out.println(ans);
	}
	
	public static String encode(String str) {
        
        int n = str.length();
        int count = 1;
        char prev = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n-1; i++) {
            if(str.charAt(i) == prev) {
                count++;
            } else {
            	sb.append(prev).append(count);
            	count = 1;
                prev = str.charAt(i);
            }
        }
        
    	sb.append(prev).append(count);
        
        return sb.toString();
    }
}
