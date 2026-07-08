package practice.dsa.sheet.part8;

import java.util.HashSet;
import java.util.Set;

public class Most_Stones_Removed_With_Same_Row_Or_Column {
	
	public static void main(String[] args) {
		
		//int[][] stones = {{0,0}, {1,1}, {2,2}, {2,3}, {2,4}, {3,2}};
		
		//int[][] stones = {{0,1}, {1,0}, {1,1}};
		
		//int[][] stones = {{0,1}, {1,1}};
		
		int[][] stones = {{0,1}, {0,2}};
		
		int x = removeStones(stones);
		
		System.out.println(x);
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static int removeStones(int[][] stones) {
		
		int n = stones.length;
		
		int maxRow = 0;
		int maxCol = 0;
		
		for(int i = 0; i <= n-1; i++) {
			if(stones[i][0] > maxRow) {
				maxRow = stones[i][0];
			} 
			
			if(stones[i][1] > maxCol) {
				maxCol = stones[i][1];
			}	
		}
		
		DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
		
		for(int i = 0; i <= n-1; i++) {
			int nodeRowVal = stones[i][0];
			int nodeColVal = stones[i][1] + maxRow + 1;
			
			ds.unionBySize(nodeRowVal, nodeColVal);
		}
		
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i <= n-1; i++) {
			int nodeRowVal = stones[i][0];
			ds.findSet(nodeRowVal);
			set.add(ds.findSet(nodeRowVal));
		} 
		
		return n - set.size();
	}
}
