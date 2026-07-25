package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Detect_Cycle_In_Undirected_Graph_Using_DFS {
	
	public static void main(String[] args) {
		
		List<List<Integer>> G = new ArrayList<>();
		
		G.add(null); //0
		
		G.add(Arrays.asList(2, 3)); //1
		
		G.add(Arrays.asList(1, 5)); //2
		
		G.add(Arrays.asList(1, 4, 6)); //3
		
		G.add(Arrays.asList(3)); //4
		
		G.add(Arrays.asList(2, 7)); //5
		
		G.add(Arrays.asList(3, 7)); //6
		
		G.add(Arrays.asList(5, 6)); //7
		
		boolean check = detectCycleUsingDFS(G, 1);
		
		System.out.println(check);
	}
	
	/*
	 * T = O(V + E)
	 * S = O(V)
	 */
	public static boolean detectCycleUsingDFS(List<List<Integer>> G, int start) {
		
		int n = G.size();
		
		int[] visited = new int[n+1];
		Arrays.fill(visited, 0);
		
		boolean isCycle = solve(G, start, -1, visited);
		
		return isCycle;
	}

	private static boolean solve(List<List<Integer>> G, int start, int parent, int[] visited) {
		
		visited[start] = 1;
		
		List<Integer> adjacentVertices = G.get(start);
		
		for(int i = 0; i <= adjacentVertices.size()-1; i++) {
			if(visited[adjacentVertices.get(i)] == 0) {
				visited[adjacentVertices.get(i)] = 1;
				boolean isCycle = solve(G, adjacentVertices.get(i), start, visited);
				if(isCycle) {
					return true;
				}
			} else {
				if(adjacentVertices.get(i) != parent) {
					return true;
				}
			}
		}
		
		return false;
	}
}
