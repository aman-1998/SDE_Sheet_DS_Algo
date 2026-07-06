package practice.dsa.sheet.part8;

public class No_Of_Provinces {
	
	public static void main(String[] args) {

	 // Usual convention
	 // int[][] G = {{0, 1, 0},
     //			     {1, 0, 0},
     //				 {0, 0, 1}};
		
		
	 // Leetcode convention
		int[][] G = {{1, 1, 0},
			     	 {1, 1, 0},
			     	 {0, 0, 1}};
		
		int provinces = noOfProvinces(G);
		
		System.out.println(provinces);
	}
	
	/*
	 * Using Disjoint set. We can also do it using BFS/DFS
	 * 
	 * T = O(n^2)
	 * S = O(n)
	 * 
	 */
	public static int noOfProvinces(int[][] G) {
		
		int n = G.length;
		
		DisjointSet ds = new DisjointSet(n);
		
		for(int i = 0; i <= n-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				if(i != j && G[i][j] == 1) {
					ds.unionBySize(i, j);
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i <= n-1; i++) {
			if(ds.findSet(i) == i) {
				count++;
			}
		}
		
		return count;
	}
}
