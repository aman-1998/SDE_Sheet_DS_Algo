package practice.dsa.sheet.part1;

import java.util.HashSet;
import java.util.Set;

public class Find_The_Town_Judge {
	
	public static void main(String[] args) {
		
		int[][] trust = {{1, 3},
						 {2, 3},
						 {1, 2},
						 {1, 3}};
		
		int judge = findJudge(3, trust);
		System.out.println("Town judge = " + judge);
	}
	
	/*
	 * T = O(m) + O(n*m) ; n = no. of people in town, m = trust matrix rows
	 * S = O(2n)
	 */
	public static int findJudge(int n, int[][] trust) {

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
}
