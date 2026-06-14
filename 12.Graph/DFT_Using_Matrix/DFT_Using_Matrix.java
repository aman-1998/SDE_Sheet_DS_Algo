package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFT_Using_Matrix {
	
	public static void main(String[] args) {
		
		int[][] G = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
				     {0, 0, 1, 1, 0, 0, 0, 0, 0},
				     {0, 1, 0, 0, 1, 1, 0, 0, 0},
				     {0, 1, 0, 0, 0, 0, 1, 1, 0},
				     {0, 0, 1, 0, 0, 0, 0, 0, 1},
				     {0, 0, 1, 0, 0, 0, 0, 0, 1},
				     {0, 0, 0, 1, 0, 0, 0, 0, 1},
				     {0, 0, 0, 1, 0, 0, 0, 0, 1},
				     {0, 0, 0, 0, 1, 1, 1, 1, 0}};
		
		List<Integer> res = dft(G, 1);
		
		System.out.println(res);
	}
	
	/*
	 * 1. And array to keep track of the vertices which are visited and which or not
	 * 2. System stack (recursion)
	 * 
	 * T = O(v^2) ; v = no. of vertices
	 * S = O(v + v) = O(v)
	 */
	public static List<Integer> dft(int[][] G, int start) {
		
		int n = G.length;
		int[] visited = new int[n];
		
		Arrays.fill(visited, 0);
		
		List<Integer> res = new ArrayList<>();
		
		solve(G, res, visited, start);
		
		return res;
	}

	private static void solve(int[][] G, List<Integer> res, int[] visited, int start) {
		
		int n = G.length;
		
		visited[start] = 1;
		
		res.add(start);
		
		for(int i = 1; i <= n-1; i++) {
			if(G[start][i] == 1 && visited[i] == 0) {
				solve(G, res, visited, i);
			}
		}
	}
}
