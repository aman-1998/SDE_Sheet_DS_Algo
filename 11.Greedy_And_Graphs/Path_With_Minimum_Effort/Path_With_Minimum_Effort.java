package practice.dsa.sheet.part9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Path_With_Minimum_Effort {
	
	public static void main(String[] args) {
		
		int[][] heights = {{1, 2, 2},
						   {3, 8, 2},
						   {5, 3, 5}};
		
		int minEffort = minimumEffortPath(heights);
		
		System.out.println(minEffort);
	}
	
	public static int minimumEffortPath(int[][] heights) {
        
		int rows = heights.length;
		int cols = heights[0].length;
		
		//(x,y,diff)
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(Comparator.comparing((List<Integer> triplet) -> triplet.get(2)));
		
		int[][] dis = new int[rows][cols];
		
		for(int i = 0; i <= rows-1; i++) {
			for(int j = 0; j <= cols-1; j++) {
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dis[0][0] = 0;
		
		minHeap.add(Arrays.asList(0, 0, 0));
		
		while(!minHeap.isEmpty()) {
			
			List<Integer> popped = minHeap.poll();
			int x = popped.get(0);
			int y = popped.get(1);
			
			if(x == rows-1 && y == cols-1) {
				return popped.get(2); // dis[x][y]
			}
			
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, 1, 0, -1};
			for(int i = 0; i <= 3; i++) {
				int adjx = x + dx[i];
				int adjy = y + dy[i];
				
				if(isValid(rows, cols, adjx, adjy)) {
					int diff = Math.abs(heights[x][y] - heights[adjx][adjy]);
					int maxEffortSoFar = Math.max(dis[x][y], diff);
					if(maxEffortSoFar < dis[adjx][adjy]) {
						dis[adjx][adjy] = maxEffortSoFar;
						minHeap.add(Arrays.asList(adjx, adjy, maxEffortSoFar));
					}
				}
			}
		}
		
		return 0; // dummy
    }

	private static boolean isValid(int rows, int cols, int adjx, int adjy) {
		
		if(adjx < 0 || adjx >= rows || adjy < 0 || adjy >= cols) {
			return false;
		}
		return true;
	} 
}
