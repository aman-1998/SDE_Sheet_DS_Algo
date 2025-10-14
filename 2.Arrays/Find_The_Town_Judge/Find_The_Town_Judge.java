package practice.dsa.sheet.part1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Find_The_Town_Judge {
	
	public static void main(String[] args) {
		
		
		int[][] trust = {{1, 3},
						 {2, 3},
						 {1, 2},
						 {1, 3}};
		
		int judge = findJudge_best(1, trust);
		System.out.println("Town judge = " + judge);
		
		/*
		int[][] trust = {};
		
		int judge = findJudge_best(1, trust);
		System.out.println("Town judge = " + judge);
		*/
	}
	
	/*
	 * T = O(m) + O(n*m) ; n = no. of people in town, m = trust matrix rows
	 * S = O(2n)
	 */
	public static int findJudge_1st_approach(int n, int[][] trust) {

        int m = trust.length;
        Set<Integer> iTrustSet = new HashSet<>();
		for(int i = 0; i <= m-1; i++) {
            iTrustSet.add(trust[i][0]);
        }

        for(int i = 1; i <= n; i++) {
            if(!iTrustSet.contains(i)) {
                Set<Integer> trustMeSet = new HashSet<>();
                for(int j = 0; j <= m-1; j++) {
                    if(trust[j][1] == i) {
                        trustMeSet.add(trust[j][0]);
                    }
                }

                if(trustMeSet.size() == n-1) {
                    return i;
                }
            }
        }
        
        return -1;
    }
	
	/*
	 * T = O(2*m) = O(m) ; n = no. of people in town, m = trust matrix rows
	 * S = O(2n)
	 * 
	 * In worst case:
	 * T = O(m) + O(m*n) ; when hashSet time complexity is considered O(n)
	 */
	public static int findJudge_best(int n, int[][] trust) {

        int m = trust.length;
        
        if(m == 0 && n == 1) {
        	return 1;
        }
        
        Set<Integer> iTrustSet = new HashSet<>();
		for(int i = 0; i <= m-1; i++) {
            iTrustSet.add(trust[i][0]);
        }
		
		Map<Integer, HashSet<Integer>> trustMeMap = new HashMap<>();
		
        for(int i = 0; i <= m-1; i++) {
            if(!iTrustSet.contains(trust[i][1])) {
            	HashSet<Integer> hSet = trustMeMap.get(trust[i][1]);
            	if(hSet == null) {
            		hSet = new HashSet<>();
            		hSet.add(trust[i][0]);
            		trustMeMap.put(trust[i][1], hSet);
            		if(hSet.size() == n-1) {
            			return trust[i][1];
            		}
            	} else {
            		hSet.add(trust[i][0]);
            		if(hSet.size() == n-1) {
            			return trust[i][1];
            		}
            	}
            }
        }
        
        return -1;
    }
}
