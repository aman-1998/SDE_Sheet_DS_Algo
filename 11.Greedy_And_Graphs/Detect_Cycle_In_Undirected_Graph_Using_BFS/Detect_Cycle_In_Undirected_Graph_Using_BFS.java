package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Detect_Cycle_In_Undirected_Graph_Using_BFS {
	
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
		
		boolean check = detectCycleUsingBFS(G, 1);
		
		System.out.println(check);
	}
	
	/*
	 * T = O(V + E)
	 * S = O(V)
	 */
	public static boolean detectCycleUsingBFS(List<List<Integer>> G, int start) {
		
		int n = G.size();
		
		//List<Integer> res = new ArrayList<>();
		
		int[] visited = new int[n+1];
		Arrays.fill(visited, 0);
		
		Queue<List<Integer>> queue = new LinkedList<>();
		
		// Assume -1 is parent of start
		queue.add(Arrays.asList(start, -1)); // Assume we have come to start from -1
		visited[start] = 1;
		
		//res.add(start);
		
		while(!queue.isEmpty()) {
			
			List<Integer> popped = queue.poll();
			
			List<Integer> adjacentVertices = G.get(popped.get(0));
			
			if(adjacentVertices == null) {
				continue;
			}
			
			for(int i = 0; i <= adjacentVertices.size()-1; i++) {
				if(visited[adjacentVertices.get(i)] == 0) {
					visited[adjacentVertices.get(i)] = 1;
					queue.add(Arrays.asList(adjacentVertices.get(i), popped.get(0)));
					
					//res.add(adjacentVertices.get(i));
				} else {
					if(adjacentVertices.get(i) != popped.get(1)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
