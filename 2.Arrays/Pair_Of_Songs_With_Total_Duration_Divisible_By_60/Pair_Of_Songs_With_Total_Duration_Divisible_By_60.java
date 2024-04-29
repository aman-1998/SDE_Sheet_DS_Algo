package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Pair_Of_Songs_With_Total_Duration_Divisible_By_60 {
	
	public static void main(String[] args) {
		int[] arr = new int[] {15,63,451,213,37,209,343,319};
		int target = 10;
		
		int count = numPairsDivisibleBy60_2(arr);
		
		System.out.println(count);
	}
	
	/*
	 * Better solution: Using hashMap
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	public static int numPairsDivisibleBy60_1(int[] time) {
        
        int n = time.length;
        for(int i = 0; i <= n-1; i++) {
            time[i] = time[i] % 60;
        }
        
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        for(int i = 0; i <= n-1; i++) {
        	Integer frequency = hashMap.get(time[i]);
        	if(frequency != null) {
        		hashMap.put(time[i], frequency + 1);
        	} else {
        		hashMap.put(time[i], 1);
        	}
        }
        
        int count = 0;
        for(int i = 0; i <= n-1; i++) {
        	Integer frequency = hashMap.get(time[i]);
        	if(frequency != null) {
        		if(time[i] >= 1 && time[i] < 30) {
            		
            		Integer frequency2 = hashMap.get(60 - time[i]);
            		
            		if(frequency2 != null) {
            			count = count + frequency*frequency2;
                		hashMap.remove(time[i]);
            		}
            	} else if(time[i] == 0 || time[i] == 30) {
            		if(frequency > 1) {
            			count = count + (frequency)*(frequency-1)/2;
            			hashMap.remove(time[i]);
            		}
            	}
        	}
        	
        }
        
        return count;
    }
	
	/*
	 * Best solution : Using DAT (Direct Access Table)
	 * 
	 * T = O(n)
	 * S = O(60) = O(1)
	 */
	public static int numPairsDivisibleBy60_2(int[] time) {
		
		int n = time.length;
		int[] remainder = new int[60];
		
		for(int i = 0; i <= n-1; i++) {
			remainder[time[i]%60]++;
		}
		int count = 0;
		count  = count + remainder[0]*(remainder[0]-1)/2;
		count = count + remainder[30]*(remainder[30]-1)/2;
		for(int i = 1; i <= 29; i++) {
			count = count + remainder[i]*remainder[60-i];
		}
		
		return count;
	}
}
