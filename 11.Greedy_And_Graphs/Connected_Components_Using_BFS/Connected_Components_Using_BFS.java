package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Connected_Components_Using_BFS {
	
	public static void main(String[] args) {
		
		int[][] G = {{0, 0, 0, 0, 0, 0, 0},
				     {0, 0, 1, 0, 1, 0, 0},
				     {0, 1, 0, 0, 0, 0, 0},
				     {0, 0, 0, 0, 0, 1, 0},
				     {0, 1, 0, 0, 0, 0, 0},
				     {0, 0, 0, 1, 0, 0, 0},
				     {0, 0, 0, 0, 0, 0, 0}};
		
		int count = noOfConnectedComponents(G);
		
		System.out.println(count);
	}
	
	/*
	 * T = O(n^3)
	 * S = O(n)
	 */
	public static int noOfConnectedComponents(int[][] G) {
		
		int n = G.length;
		
		int[] visited = new int[n];
		
		Arrays.fill(visited, 0); // O(n)
		
		int count = 0;
		for(int i = 1; i <= n-1; i++) { // O(n)
			if(visited[i] == 0) {
				BFTUsingMatrix(G, visited, i); // O(n*n)
				count++;
			}
		}
		
		return count;
	}
	
	public static void BFTUsingMatrix(int[][] G, int[] visited, int start) {
		
		int n = G.length;
		
		visited[start] = 1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		List<List<Integer>> res = new ArrayList<>();
		res.add(Arrays.asList(start));
		
		while(!queue.isEmpty()) { // O(n*n)
			int popped = queue.poll();
			for(int i = 1; i <= n-1; i++) {
				if(G[popped][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					queue.add(i);
				}
			}
		}
	}
}
