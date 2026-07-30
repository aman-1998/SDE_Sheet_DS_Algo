package practice.dsa.sheet.part9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Shortest_Path_In_Binary_Matrix {
	
	public static void main(String[] args) {
		
//		int[][] grid = {{0, 1, 0, 1, 1},
//				        {0, 0, 1, 0, 1},
//				        {0, 0, 1, 0, 1},
//				        {1, 1, 0, 1, 0},
//				        {1, 1, 0, 0, 0}};
		
		int[][] grid = {{1,0,0},
				        {1,1,0},
				        {1,1,0}};
		
		int shortestDis = shortestPathBinaryMatrix(grid);
		
		System.out.println(shortestDis);
	}
	
	/*
	 * We are using dijkstra's algo but not using MinHeap. Instead
	 * we are using Queue here because the triplets(x, y, dis) that enters
	 * in the queue are already ordered in ascending order.So, they are
	 * popped out of the queue in ascending order. So, no need of MinHeap.
	 * 
	 * T = O(m*n)
	 * S = O(m*n)
	 */
	public static int shortestPathBinaryMatrix(int[][] grid) {
        
		int m = grid.length;
		int n = grid.length;
		
		int[][] dis = new int[m][n];
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int sourcex = 0;
		int sourcey = 0;
		
		int distinationx = m-1;
		int distinationy = n-1;
		
		if(grid[sourcex][sourcey] != 0) {
			return -1;
		}
		
		dis[sourcex][sourcey] = 0;
		
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(sourcex, sourcey, 0));
		
		while(!queue.isEmpty()) {
			
			List<Integer> popped = queue.poll();
			int x = popped.get(0);
			int y = popped.get(1);
			
			int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
			int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
			for(int i = 0; i <= 7; i++) {
				int adjx = x + dx[i];
				int adjy = y + dy[i];
				
				if(isValid(m, n, adjx, adjy) && grid[adjx][adjy] == 0) {
					if(popped.get(2) + 1 < dis[adjx][adjy]) {
						dis[adjx][adjy] = dis[x][y] + 1;
						queue.add(Arrays.asList(adjx, adjy, dis[adjx][adjy]));
					}
				}
				
				if(x == distinationx && y == distinationy) {
					return dis[x][y] + 1; // or popped.get(2);
				}
			}
		}
		
		return -1;
    }

	private static boolean isValid(int m, int n, int x, int y) {
		if(x < 0 || x >= m || y < 0 || y >= n) {
			return false;
		}
		
		return true;
	}
}
