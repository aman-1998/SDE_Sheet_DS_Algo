package algorithms.part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Pair_Of_Songs_With_Total_Duration_Divisible_By_60 {
	
	public static void main(String[] args) {
		//int[] arr = new int[] {15,63,451,213,37,209,343,319};
		int[] arr = new int[] {30, 20, 150, 100, 40};
		int target = 10;
		
		//int count = numPairsDivisibleBy60_3(arr);
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
	 * Better solution: Using hashSet => Number of pairs with sum k. Here k is 60
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	private static int numPairsDivisibleBy60_2(int[] time) {
		
		int n = time.length;
        for(int i = 0; i <= n-1; i++) {
            time[i] = time[i] % 60;
        }
        
        Set<Integer> hSet = new HashSet<>(); // Size of hashSet can never go beyond 60
		Set<List<Integer>> pairSet = new HashSet<>();
		
		for(int i = 0; i <= n-1; i++) {
			if(hSet.contains(60 - time[i])) {
				List<Integer> pair = new ArrayList<>();
				pair.add(time[i]);
				pair.add(60-time[i]);
				pair = pair.stream().sorted().collect(Collectors.toList());
				pairSet.add(pair);
			} 
			
			hSet.add(time[i]);
		}
		
		return pairSet.size();
	}
	
	
	/*
	 * Best solution : Using DAT (Direct Access Table)
	 * 
	 * T = O(n)
	 * S = O(60) = O(1)
	 */
	public static int numPairsDivisibleBy60_3(int[] time) {
		
		int n = time.length;
		int[] frequency = new int[60];
		
		for(int i = 0; i <= n-1; i++) {
			frequency[time[i]%60]++;
		}
		int count = 0;
		count  = count + frequency[0]*(frequency[0]-1)/2;
		count = count + frequency[30]*(frequency[30]-1)/2;
		for(int i = 1; i <= 29; i++) {
			count = count + frequency[i]*frequency[60-i];
		}
		
		return count;
	}
	
}
