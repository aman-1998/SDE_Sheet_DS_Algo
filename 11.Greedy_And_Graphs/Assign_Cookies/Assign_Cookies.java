package practice.dsa.sheet.part1;

import java.util.Arrays;

public class Assign_Cookies {
	
	public static void main(String[] args) {
		
		int[] greed = {1, 5, 3, 3, 4};
		int[] size = {4, 2, 1, 2, 1, 3};
		
		int children = assignMaxCookies(greed, size);
		
		System.out.println(children);
	}
	
	public static int assignMaxCookies(int[] greed, int[] size) {
        
		Arrays.sort(greed);
		Arrays.sort(size);
		
		int count = 0;
		
		for(int i = 0; i <= size.length-1; i++) {
			if(count == greed.length) {
				break;
			}
			if(size[i] >= greed[count]) {
				count++;
			}
		}
		
		return count;
    }
}
