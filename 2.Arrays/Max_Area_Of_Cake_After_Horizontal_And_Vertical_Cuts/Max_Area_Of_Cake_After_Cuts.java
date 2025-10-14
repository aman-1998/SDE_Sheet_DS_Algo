package practice.dsa.sheet.part1;

import java.util.Arrays;

public class Max_Area_Of_Cake_After_Cuts {
	
	public static void main(String[] args) {
		
		int h = 5;
		int w = 4;
		int[] horizontalCuts = {1, 2, 4};
		int[] verticalCuts = {1, 3};
		
		int maxArea = maxArea(h, w, horizontalCuts, verticalCuts);
		
		System.out.println(maxArea);
	}
	
	/*
	 * T = O(n*log(n)) + O(n) + O(m*log(m)) + O(m)
	 * where, n = size of horizontalCuts; m = size of verticalCuts
	 * 
	 * S = O(1)
	 */
	public static int maxArea(int h, int w, int[]  horizontalCuts, int[] verticalCuts) {

        long maxHorizontalDiff = maxDiff(horizontalCuts, h);
		long maxVerticalDiff = maxDiff(verticalCuts, w);
		
		//return maxHorizontalDiff*maxVerticalDiff;
		
		return (int)(maxHorizontalDiff% 1000000007*maxVerticalDiff% 1000000007) % 1000000007;
    }

    public static int maxDiff(int[] arr, int length) {
    	
    	int n = arr.length;
    	int maxDiff = Integer.MIN_VALUE;
    	int prev = 0;
    	for(int i = 0; i <= n-1; i++) {
    		int diff = arr[i] - prev;
    		if(diff > maxDiff) {
    			maxDiff = diff;
    		}
    		prev = arr[i];
    	}
    	
    	int diff = length - arr[n-1];
    	if(diff > maxDiff) {
			maxDiff = diff;
		}
    	
    	return maxDiff;
    }
}
