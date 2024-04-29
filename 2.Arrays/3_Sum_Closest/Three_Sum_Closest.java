package algorithms;

import java.util.Arrays;

public class Three_Sum_Closest {
	
	public static void main(String[] args) {
		int[] arr = {-1,2,1,-4};
		int target = 1; // Target can be anything
		
		int closestSum = threeSumClosest(arr, target);
		
		System.out.println(closestSum);
	}
	
	/*
	 * This is just an extension of 3-Sum problem. We have to do slight modifications in 3-Sum problem.
	 * 
	 * T = O(n*log(n)) + O(n^2)
	 * S = O(1)
	 * 
	 */
	public static int threeSumClosest(int[] arr, int target) {
        
        Arrays.sort(arr); // T = O(n*logn)
		int n = arr.length;
		
        int minDiff = Integer.MAX_VALUE;
        int tempDiff = 0;
        int result = 0;

		int i = 0;
		while(i < n) { // T = O(n)
			
			int j = i+1;
			int k = n-1;
			int newTarget = target - arr[i];
			
			// T = O(n)
			while(j < k) {
				if(arr[j] + arr[k] > newTarget) {
                    tempDiff = (arr[i] + arr[j] + arr[k]) - target;
                    if(tempDiff < minDiff) {
                        minDiff = tempDiff;
                        result = arr[i] + arr[j] + arr[k];
                    }
					k--;
				} else if(arr[j] + arr[k] < newTarget) {
                    tempDiff = target - (arr[i] + arr[j] + arr[k]);
                    if(tempDiff < minDiff) {
                        minDiff = tempDiff;
                        result = arr[i] + arr[j] + arr[k];
                    }
					j++;
				} else {
					return target;
				}
			}
			
			// Increment logic of 'i'
			int temp = arr[i];
			while(arr[i] == temp) {
				i++;
				if(i >= n) {
					break;
				}
			}
		}
		
		return result;
    }
}
