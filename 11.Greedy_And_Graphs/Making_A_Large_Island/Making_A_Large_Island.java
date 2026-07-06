package practice.dsa.sheet.part8;

import java.util.HashSet;
import java.util.Set;

public class Making_A_Large_Island {
	
	public static void main(String[] args) {
		
		int[][] grid = {{1, 1, 0, 1, 1},
						{1, 1, 0, 1, 1},
						{1, 1, 0, 1, 1},
						{0, 0, 1, 0, 0},
						{0, 0, 1, 1, 1},
						{0, 0, 1, 1, 1}};
		
		int maxSize = largestIsland(grid);
		
		System.out.println(maxSize);
	}
	
	/*
	 * T = O(m*n) ; m = rows, n = cols
	 * S = O(m*n) ; disjoint set
	 */
	public static int largestIsland(int[][] grid) {
		
        int rows = grid.length;
        int cols = grid[0].length;
        
        DisjointSet ds = new DisjointSet(rows*cols);
        
        for(int i = 0; i <= rows-1; i++) {
        	for(int j = 0; j <= cols-1; j++) {
        		if(grid[i][j] == 1) {
        			int[] dr = {0, 0, 1, -1};
            		int[] dc = {1, -1, 0, 0};
            		
            		for(int k = 0; k <= 3; k++) {
            			int adjr = i+dr[k];
            			int adjc = j+dc[k];
        				if(isValid(rows, cols, adjr, adjc) && grid[adjr][adjc] == 1) {
        					int nodeVal = i*cols + j;
        					int adjNodeVal = adjr*cols + adjc;
        					if(ds.findSet(nodeVal) != ds.findSet(adjNodeVal)) {
        						ds.unionBySize(nodeVal, adjNodeVal);
        					}
        				}
            		}
        		}
        	}
        }
        
        int maxSize = 0;
        
        for(int i = 0; i <= rows-1; i++) {
        	for(int j = 0; j <= cols-1; j++) {
        		if(grid[i][j] == 0) {
        			Set<Integer> set = new HashSet<>();
        			int[] dr = {0, 0, 1, -1};
            		int[] dc = {1, -1, 0, 0};
            		
            		for(int k = 0; k <= 3; k++) {
            			int adjr = i+dr[k];
            			int adjc = j+dc[k];
            			if(isValid(rows, cols, adjr, adjc) && grid[adjr][adjc] == 1) {
            				int adjNodeVal = adjr*cols + adjc;
                			set.add(ds.findSet(adjNodeVal));
            			}
            		}
            		
            		int sum = 1;
            		for(int up : set) {
            			sum = sum + ds.size[up];
            		}
            		
            		if(sum > maxSize) {
            			maxSize = sum;
            		}
        		}
        	}
        }
        
        return maxSize == 0 ? rows*cols : maxSize;
    }
	
	private static boolean isValid(int rows, int cols, int adjr, int adjc) {
		
		if(adjr < 0 || adjr >= rows || adjc < 0 || adjc >= cols) {
			return false;
		}
		
		return true;
	}
}
