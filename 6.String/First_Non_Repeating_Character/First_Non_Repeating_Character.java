package algorithms.part3;

import java.util.HashMap;
import java.util.Map;

public class First_Non_Repeating_Character {
	
	public static void main(String[] args) {
		
		String str = "abdca";
		int index = firstUniqChar(str);
		
		System.out.println(index);
	}
	
	private static int firstUniqChar(String str) {
        
        int n = str.length();
        Map<Character, Integer> hMap = new HashMap<>();

        for(int i = 0; i <= n-1; i++) {
            Integer freq = hMap.get(str.charAt(i));
            if(freq == null) {
                hMap.put(str.charAt(i), 1);
            } else {
                hMap.put(str.charAt(i), freq + 1);
            }
        }

        for(int i = 0; i <= n-1; i++) {
            Integer freq = hMap.get(str.charAt(i));
            if(freq == 1) {
                return i;
            }
        }

        return -1;
    }
}
