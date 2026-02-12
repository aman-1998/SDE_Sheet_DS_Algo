import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 
Majority Elements(>N/3 times) | Find the elements that appears more than N/3 times in the array
------------------------------------------------------------------------------------------------
Problem Statement: Given an array of N integers. Find the elements that appear more than N/3 
times in the array. If no such element exists, return an empty vector.

Pre-requisite: Majority Element(>N/2 times)

Examples
Example 1:
Input Format: N = 5, array[] = {1,2,2,3,2}
Result: 2
Explanation: Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.

Example 2:
Input Format:  N = 7, array[] = {11,33,33,11,33,11,14}
Result: 11 33
Explanation: Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore, the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.
 * 
 */

public class Majority_Element_More_Than_n_By_3_Times {
	 
	public static void main(String[] args) {
		//int[] arr = {2, 1, 1, 3, 1, 4, 5, 6};
		int[] arr = {4, 8, 6, 6, 8, 6, 8, 5};
		List<Integer> elementsList = majorityElement_byNeetCode_2(arr);

		elementsList.stream().forEach(t -> System.out.print(t + " "));
	}
	
	// T = O(n + n) = O(2n) = O(n)
	//S = O(n)
	private static List<Integer> majorityElementMoreThan_n_by_3_times_1(int[] arr) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		List<Integer> res = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			if(map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		
		// Iterating over the hashmap
		Iterator<Map.Entry<Integer, Integer>> ite = map.entrySet().iterator();
		while(ite.hasNext()) {
			Map.Entry<Integer, Integer> entry = ite.next();
			if(entry.getValue() > n/3) {
				res.add(entry.getKey());
			}
		}
		
		return res;
	}
	
	// Better Approach
	// T = O(n)
	// S = O(n)
	private static List<Integer> majorityElementMoreThan_n_by_3_times_2(int[] arr) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		List<Integer> res = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			if(map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i])+1);
				if(map.get(arr[i]) > n/3) {
					res.add(arr[i]);
				}
			}
		}
		
		return res;
	}
	
	// Best Approach
	// Moore's Voting Algorithm
	// T = O(n) + O(n) = O(2n) = O(n)
	// S = O(1)
	private static List<Integer> majorityElementMoreThan_n_by_3_times_3(int[] arr) {
		
		int n = arr.length;
		
		int ele1 = Integer.MAX_VALUE;
		int count1 = 0;
		
		int ele2 = Integer.MAX_VALUE-1;
		int count2 = 0;
		
		for(int i = 0; i <= n-1; i++) {
			
			if(count1 == 0 && arr[i] != ele2) {
				ele1 = arr[i];
				count1 = 1;
			} else if(count2 == 0 && arr[i] != ele1) {
				ele2 = arr[i];
				count2 = 1;
			} else if(ele1 == arr[i]) {
				count1++;
			} else if(ele2 == arr[i]) {
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		
		List<Integer> res = new ArrayList<>();
		
		count1 = 0;
		count2 = 0;
		for(int i = 0; i <= n-1; i++) {
			
			if(arr[i] == ele1) {
				count1++;
			} else if(arr[i] == ele2) {
				count2++;
			}
		}
		
		
		if(count1 > n/3) {
			res.add(ele1);
		}
		
		if(count2 > n/3) {
			res.add(ele2);
		}
		
		return res;
	}
	
	
	/*
	 * Best Approach : By Neet Code (Easy to understand)
	 * 
	 * Moore's Voting Algorithm
	 * T = O(n)
	 * S = O(1)
	 */
	private static List<Integer> majorityElement_byNeetCode(int[] arr) {
		
		int n = arr.length;
		Map<Integer, Integer> hMap = new HashMap<>();
		
		for(int i = 0; i <= n-1; i++) {
			Integer count = hMap.get(arr[i]);
			if(count != null) {
				hMap.put(arr[i], count + 1);
			} else {
				if(hMap.size() == 2) {
					int element1=0, count1=0;
					int element2=0, count2=0;
					int x = 0;
                    for(Map.Entry<Integer, Integer> entry: hMap.entrySet()) {
                    	if(x == 0) {
                    		element1 = entry.getKey();
                        	count1 = entry.getValue();
                    	} else {
                    		element2 = entry.getKey();
                        	count2 = entry.getValue();
                    	}
                    	x++;
                    }
                    
                    if(count1 == 1) {
                    	hMap.remove(element1);
                    } else {
                    	hMap.put(element1, count1 - 1);
                    }
                    
                    if(count2 == 1) {
                    	hMap.remove(element2);
                    } else {
                    	hMap.put(element2, count2 - 1);
                    }
                    
                    
				} else {
					hMap.put(arr[i], 1);
				}
			}
		}
		
		Integer possibleResult1 = Integer.MIN_VALUE; // Default value if majority element does not exist
		Integer possibleResult2 = Integer.MIN_VALUE; // Default value if majority element does not exist
		int x = 0;
		for(Map.Entry<Integer, Integer> entry: hMap.entrySet()) {
        	if(x == 0) {
        		possibleResult1 = entry.getKey();
        	} else {
        		possibleResult2 = entry.getKey();
        	}
        	x++;
        }
		
		List<Integer> result = new ArrayList<>();
		
		int count1 = 0;
		int count2 = 0;
		for(int i = 0; i <= n-1; i++) {
			if(arr[i] == possibleResult1) {
				count1++;
			} else if(arr[i] == possibleResult2) {
				count2++;
			}
		}
		
		if(count1 > n/3) {
			result.add(possibleResult1);
		}
		
		if(count2 > n/3) {
			result.add(possibleResult2);
		}
		
		return result;
	}

	/*
	 * Another Approach : By Neet Code (Easy to understand)
	 * 
	 * Moore's Voting Algorithm
	 * T = O(2n) = O(n)
	 * S = O(1)
	 */
	private static List<Integer> majorityElement_byNeetCode_2(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> hMap = new HashMap<>();
        
        for(int i = 0; i <= n-1; i++) {
            Integer count = hMap.get(arr[i]);
            if(count != null) {
                hMap.put(arr[i], count + 1);
            } else {
                hMap.put(arr[i], 1);
                if(hMap.size() > 2) {
                    Set<Integer> toBeRemovedSet = new HashSet<>();
                    for(Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
                        int element = entry.getKey();
                        int currentCount = entry.getValue();
						entry.setValue(--currentCount);
                        
                        if(currentCount == 0) {
                            toBeRemovedSet.add(element);
                        }
                    }
                    
                    for(int elem : toBeRemovedSet) {
                        hMap.remove(elem);
                    }
                }
            }
        }
        
        if(hMap.isEmpty()) {
            return new ArrayList<>();
        } 
        
        Integer possibleResult1 = Integer.MIN_VALUE;
        Integer possibleResult2 = Integer.MIN_VALUE;
        int x = 0;
        for(Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
			if(x == 0) {
				possibleResult1 = entry.getKey();
			} else {
				possibleResult2 = entry.getKey();
			}
			x++;
        }
        
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i <= n-1; i++) {
            if(arr[i] == possibleResult1) {
                count1++;
            } else if(arr[i] == possibleResult2) {
				count2++;
			}
        }
        
        List<Integer> result = new ArrayList<>();
        if(count1 > n/3) {
            result.add(possibleResult1);
        }
        if(count2 > n/3) {
            result.add(possibleResult2);
        }
		
        return result;
    }
}
