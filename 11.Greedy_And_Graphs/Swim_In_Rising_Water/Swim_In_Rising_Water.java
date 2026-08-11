package practice.dsa.sheet.part9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Swim_In_Rising_Water {
	
	public static void main(String[] args) {
		
		int[][] grid = {{0,1,2,3,4}, {24,23,22,21,5}, {12,13,14,15,16}, 
						{11,17,18,19,20},{10,9,8,7,6}};
		
		int minimumOfMaxAmongAllRoutes = swimInWater(grid);
		
		System.out.println(minimumOfMaxAmongAllRoutes);
	}
	
	/*
	 * Follow Neetcode tutorial : https://www.youtube.com/watch?v=amvrKlMLuGY
	 * 
	 * Similar to "Path with minimum effort" problem.
	 * 
	 * Find minimum of maximum among all paths from (0,0) to (row-1,col-1)
	 * 
	 * T = O(E * log V) = O(m *n * 4 * log(m*n))
	 * S = O(m*n)
	 * 
	 */
	public static int swimInWater(int[][] grid) {
        
		int rows = grid.length;
		int cols = grid[0].length;
		
		int[][] dis = new int[rows][cols];
		
		for(int i = 0; i <= rows-1; i++) {
			for(int j = 0; j <= cols-1; j++) {
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dis[0][0] = grid[0][0];
		
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(Comparator.comparing((List<Integer> list) -> list.get(2)));
		minHeap.add(Arrays.asList(0, 0, dis[0][0]));
		
		while(!minHeap.isEmpty()) {
			
			List<Integer> popped = minHeap.poll();
			int x = popped.get(0);
			int y = popped.get(1);
			int maxSoFar = popped.get(2);
			
			if(x == rows-1 && y == cols-1) {
				return maxSoFar; // dis[x][y]
			}
			
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, 1, 0, -1};
			for(int i = 0; i <= 3; i++) {
				int adjx = x + dx[i];
				int adjy = y + dy[i];
				
				if(isValid(rows, cols, adjx, adjy)) {
					int newMax = Math.max(maxSoFar, grid[adjx][adjy]);
					if(newMax < dis[adjx][adjy]) {
						dis[adjx][adjy] = newMax;
						minHeap.add(Arrays.asList(adjx, adjy, newMax));
					}
				}
			}
		}
		
		return 0; // dummy value
    }
	
	private static boolean isValid(int rows, int cols, int adjx, int adjy) {
		
		if(adjx < 0 || adjx >= rows || adjy < 0 || adjy >= cols) {
			return false;
		}
		return true;
	} 
}
