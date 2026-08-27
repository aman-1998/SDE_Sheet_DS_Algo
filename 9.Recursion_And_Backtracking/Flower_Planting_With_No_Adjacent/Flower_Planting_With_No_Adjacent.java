package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Flower_Planting_With_No_Adjacent {
	
	public static void main(String[] args) {
		
		int n = 4;
		
		int[][] paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
		
		int[] res = gardenNoAdj(n, paths);
		
		Arrays.stream(res).forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * It is similar to M-Coloring problem where m = 4
	 * 
	 * Total combinations = m^V and then for each vertex we examine its adjacent vertices' color.
	 * Max adjacent vertices can be v-1 i.e., O(V)
	 * T = O(V * m^V + E)  [Here, m = 4]
	 *   = O(V * 4^V + E )
	 * 
	 * S = (adjacency list) + (color array) + (system stack)
	 *   = O(V + 2E) + O(v) + O(v)   [v = no. of vertices , E = no. of edges]
	 *     
	 */
	public static int[] gardenNoAdj(int v, int[][] edges) {
        int m = 4;

        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i <= v; i++) {
        	adjacencyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i <= edges.length-1; i++) { // O(E)
        	adjacencyList.get(edges[i][0]).add(edges[i][1]);
        	adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] color = new int[v+1]; // initialized with 0 (uncolored)
        
        boolean check = solve(adjacencyList, v, m, color, 1); // O(V * m^V)

        int[] res = new int[v];
        for(int i = 0; i <= v; i++) {
            if(i != 0) {
                res[i-1] = color[i];
            }
        }
        
        return res;
    }

    private static boolean solve(List<List<Integer>> adjacencyList, 
							  int v, int m, int[] color,
							  int vertex) {
		
		if(vertex == v+1) {
			return true;
		}
		
		for(int c = 1; c <= m; c++) {
			List<Integer> adjacentVertices = adjacencyList.get(vertex);
			boolean isColorable = true;
			for(Integer node : adjacentVertices) {
				if(color[vertex] == 0 && color[node] == c) {
					isColorable = false;
					break;
				}
			}
			
			if(isColorable) {
				color[vertex] = c;
				boolean check = solve(adjacencyList, v, m, color, vertex+1);
				if(check) {
					return true;
				}
				color[vertex] = 0; // uncolor it
			}
		}
		
		return false;
	} 
}
