package practice.dsa.sheet.part8;

import java.util.ArrayList;
import java.util.List;

public class No_Of_Islands_2 {
	
	public static void main(String[] args) {
		
		int rows = 4;
		int cols = 5;
		int[][] operators = {{0, 0},
				             {0, 0},
				             {1, 1},
				             {1, 0},
				             {0, 1},
				             {0,3},
				             {1, 3},
				             {0, 4},
				             {3, 2},
				             {2, 2},
				             {1, 2},
				             {0, 2}};
				             
		List<Integer> res = numOfIslands(rows, cols, operators);
		
		System.out.println(res);
	}
	
	public static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
		
		DisjointSet ds = new DisjointSet(rows*cols);
		
		int[][] visited = new int[rows][cols];
		
		int count = 0;
		
		List<Integer> res = new ArrayList<>();
		
		for(int[] pair : operators) {
			int x = pair[0];
			int y = pair[1];
			if(visited[x][y] == 0) {
				visited[x][y] = 1;
				count++;
				
				// x, y-1
				// x, y+1
				// x-1, y
				// x+1, y
				int[] dx = {0, 0, -1, 1};
				int[] dy = {-1, 1, 0, 0};
				for(int i = 0; i <= 3; i++) {
					int adjr = x + dx[i];
					int adjc = y + dy[i];
					if(isValid(rows, cols, adjr, adjc) && visited[adjr][adjc] == 1) {
						int nodeVal = x*cols + y;
						int adjNoceVal = adjr*cols + adjc;
						if(ds.findSet(nodeVal) != ds.findSet(adjNoceVal)) {
							count--;
							ds.unionBySize(nodeVal, adjNoceVal);
						}
					}
				}
			}
			res.add(count);
		}
		
		return res;
	}

	private static boolean isValid(int rows, int cols, int adjr, int adjc) {
		
		if(adjr < 0 || adjr >= rows || adjc < 0 || adjc >= cols) {
			return false;
		}
		
		return true;
	}
	
}
