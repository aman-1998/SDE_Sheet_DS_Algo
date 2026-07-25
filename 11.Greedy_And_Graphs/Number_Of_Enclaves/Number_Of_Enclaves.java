package practice.dsa.sheet.part7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Number_Of_Enclaves {
	
	public static void main(String[] args) {
		
		int[][] grid = {{0, 0, 0, 1, 1},
						{0, 0, 1, 1, 0},
						{0, 1, 0, 0, 0},
						{0, 1, 1, 0, 0},
						{0, 0, 0, 1, 1}};
		
		int count = numEnclaves_Using_BFS_2nd(grid);
		
		System.out.println(count);
	}
	
	/*
	 * I am using BFS but it can also be done using DFS
	 * 
	 * T = O(m*n) + O(m*n) + O(m*n)
	 * S = O(m*n)
	 */
	public static int numEnclaves_Using_BFS_1st(int[][] grid) {
        int m = grid.length;
		int n = grid[0].length;
		
		int[][] visited = new int[m][n];
		
		Queue<List<Integer>> queue = new LinkedList<>();
		
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				if((i == 0 || i == m-1 || j == 0 || j == n-1) && grid[i][j] == 1) {
					visited[i][j] = 1;
					queue.add(Arrays.asList(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			
			List<Integer> popped = queue.poll();
			
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0 ,-1, 1};
			
			for(int i = 0; i <= 3; i++) {
				int adjx = popped.get(0) + dx[i];
				int adjy = popped.get(1) + dy[i];
				if(isValid(m, n, adjx, adjy) && grid[adjx][adjy] == 1 && visited[adjx][adjy] == 0) {
					visited[adjx][adjy] = 1;
					queue.add(Arrays.asList(adjx, adjy));
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				if(grid[i][j] == 1 && visited[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	/*
	 * I am using BFS but it can also be done using DFS
	 * 
	 * T = O(m*n) + O(m*n)
	 * S = O(m*n)
	 */
	public static int numEnclaves_Using_BFS_2nd(int[][] grid) {
        
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] visited = new int[m][n];
		
		Queue<List<Integer>> queue = new LinkedList<>();
		
		int countTotal1 = 0;
		int countBoundary1 = 0;
		
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				if((i == 0 || i == m-1 || j == 0 || j == n-1) && grid[i][j] == 1) {
					visited[i][j] = 1;
					queue.add(Arrays.asList(i, j));
					countBoundary1++;
				}
				
				if(grid[i][j] == 1) {
					countTotal1++;
				}
			}
		}
		
		int enclave = countTotal1 - countBoundary1;
		
		while(!queue.isEmpty()) {
			
			List<Integer> popped = queue.poll();
			
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0 ,-1, 1};
			
			for(int i = 0; i <= 3; i++) {
				int adjx = popped.get(0) + dx[i];
				int adjy = popped.get(1) + dy[i];
				if(isValid(m, n, adjx, adjy) && grid[adjx][adjy] == 1 && visited[adjx][adjy] == 0) {
					visited[adjx][adjy] = 1;
					queue.add(Arrays.asList(adjx, adjy));
					enclave--;
				}
			}
		}
		
		return enclave;
    }
	
	private static boolean isValid(int m, int n, int adjx, int adjy) {
		if(adjx < 0 || adjx >= m || adjy < 0 || adjy >= n) {
			return false;
		}
		return true;
	}
}
