package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFT_Using_Matrix {
	
	public static void main(String[] args) {
		
		int[][] G = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
				     {0, 0, 1, 1, 0, 0, 0, 0, 0},
				     {0, 1, 0, 0, 1, 0, 0, 0, 0},
				     {0, 1, 0, 0, 1, 0, 0, 0, 0},
				     {0, 0, 1, 1, 0, 1, 1, 1, 0},
				     {0, 0, 0, 0, 1, 0, 0, 0, 1},
				     {0, 0, 0, 0, 1, 0, 0, 0, 1},
				     {0, 0, 0, 0, 1, 0, 0, 0, 1},
				     {0, 0, 0, 0, 0, 1, 1, 1, 0}};
		
		List<List<Integer>> res = bft(G, 1);
		
		System.out.print(res);
	}
	
	/*
	 * T = O(n + n*n) = O(n*n) = O(v^2) ; v = no. of vertices
	 * S = O(n + n) = O(v + v) = O(v)
	 */
	public static List<List<Integer>> bft(int[][] G, int start) {
		
		int n = G.length;
		
		int[] visited = new int[n];
		Arrays.fill(visited, 0); // O(n)
		visited[start] = 1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		List<List<Integer>> res = new ArrayList<>();
		res.add(Arrays.asList(start));
		
		while(!queue.isEmpty()) { // O(n*n)
			int popped = queue.poll();
			List<Integer> temp = new ArrayList<>();
			for(int i = 1; i <= n-1; i++) {
				if(G[popped][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					temp.add(i);
					queue.add(i);
				}
			}
			
			if(!temp.isEmpty()) {
				res.add(temp);
			}
		}
		
		return res;
	}
}
