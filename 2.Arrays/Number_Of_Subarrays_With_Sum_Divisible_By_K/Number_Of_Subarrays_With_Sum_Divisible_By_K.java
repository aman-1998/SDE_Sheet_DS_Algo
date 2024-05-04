package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Number_Of_Subarrays_With_Sum_Divisible_By_K {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * Brute Force solution will take O(n^2) where we find all subarrays.
	 * And check if sum % k == 0 for all subarrays.
	 * 
	 * 
	 * Best Solution : Using hashMap. 
	 * In hashMap, key = remainder & value = count of remainder
	 * 
	 * 				  s1 % k = r
	 * |<----------------------------------->|
	 * |<-------------->|<------------------>|
	 * 	   s2 % k = r         s3 % k = 0
	 * 
	 * 
	 * T = O(n) * O(hashMap search) = O(n) * O(1) = O(n)
	 * S = O(n)
	 * 
	 */
	public int subarraysDivByK(int[] arr, int k) {
		
        int n = arr.length;
		Map<Integer, Integer> hashMap = new HashMap<>(); // (sum , no. of times we have seen this sum) = (sum ,count)
		int sum = 0;
		int count = 0;
		
		for(int i = 0; i <= n-1; i++) {

            if(arr[i] < 0) {
                arr[i] = arr[i] % k + k;
            }
			
			sum = sum + arr[i];
            int remainder = sum % k;
			if(remainder == 0) {
				count++;
			}
			
			Integer frequency = hashMap.get(remainder);
			if(frequency != null) {
				count = count + frequency;
			}
			
			if(hashMap.get(remainder) == null) {
				hashMap.put(remainder, 1);
			} else {
				hashMap.put(remainder, hashMap.get(remainder) + 1);
			}
		}
		
		return count;
    }
}
