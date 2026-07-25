package practice.dsa.sheet.part8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Rotten_Oranges {
	
	public static void main(String[] args) {
		
//		int[][] grid = {{0, 1, 2},
//						{0, 1, 1},
//						{2, 1, 1}};
		
//		int[][] grid = {{1, 2, 1},
//						{1, 1, 0},
//						{0, 0, 1}};
		
//		int[][] grid = {{2, 1, 1},
//						{1, 1, 0},
//						{0, 1, 1}};
		
//		int[][] grid = {{0, 1}};
		
		int[][] grid = {{0, 2}};
		
		int time = orangesRotting(grid);
		
		System.out.println(time);
	}
	
	/*
	 * Breadth First Search (BFS)
	 * 
	 * T = O(m*n)
	 * S = O(m*n)
	 */
	public static int orangesRotting(int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] visited = new int[m][n];
		
		Queue<List<Integer>> queue = new LinkedList<>();
		
		int count1 = 0;
		
		
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				if(grid[i][j] == 2) {
					visited[i][j] = 2;
					queue.add(Arrays.asList(i,j,0));
				}
				
				if(grid[i][j] == 1) {
					count1++;
				}
			}
		}
		
		int count2 = 0;
		int time = 0;
		
		while(!queue.isEmpty()) {
			
			List<Integer> popped = queue.poll();
			time = popped.get(2);
			//(x, y)
			//(x-1, y)
			//(x+1, y)
			//(x, y-1)
			//(x, y+1)
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0 ,-1, 1};
			for(int i = 0; i <= 3; i++) {
				int adjx = popped.get(0) + dx[i];
				int adjy = popped.get(1) + dy[i];
				if(isValid(m, n, adjx, adjy) && grid[adjx][adjy] == 1 && visited[adjx][adjy] == 0) {
					visited[adjx][adjy] = 2;
					count2++;
					queue.add(Arrays.asList(adjx, adjy, time+1));
				}
			}
		}
		
		return count1 == count2 ? time : -1;
	}

	private static boolean isValid(int m, int n, int adjx, int adjy) {
		if(adjx < 0 || adjx >= m || adjy < 0 || adjy >= n) {
			return false;
		}
		return true;
	}
}
