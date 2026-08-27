package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given an undirected graph consisting of V vertices and E edges 
 * represented by a list edges[][], along with an integer m. Your task is 
 * to determine whether it is possible to color the graph using at most m 
 * different colors such that no two adjacent vertices share the same color. 
 * Return true if the graph can be colored with at most m colors, otherwise 
 * return false.
 *
 * Note: The graph is indexed with 0-based indexing.
 *
 * Examples:
 * Input: V = 4, edges[][] = [[0, 1], [1, 3], [2, 3], [3, 0], [0, 2]], m = 3
 * Output: true
 * 
 * Explanation: It is possible to color the given graph using 3 colors, for 
 * example, one of the possible ways vertices can be colored as follows:
 * 
 * Vertex 0: Color 1
 * Vertex 1: Color 2
 * Vertex 2: Color 2
 * Vertex 3: Color 3
 * 
 */
public class M_Coloring_Problem {
	
	public static void main(String[] args) {
		
		int v = 4; // no. of vertices
		int[][] edges = {{0, 1}, {1, 3}, {2, 3}, {3, 0}, {0, 2}};
		int m = 3; // no. of colors
		
		System.out.println(graphColoring(v, edges, m));
	}
	
	/*
	 * Total combinations = m^V and then for each vertex we examine its adjacent vertices' color.
	 * Max adjacent vertices can be v-1 i.e., O(V)
	 * T = O(V * m^V + E) 
	 * 
	 * S = (adjacency list) + (color array) + (system stack)
	 *   = O(V + 2E) + O(v) + O(v)   [v = no. of vertices , E = no. of edges]
	 *     
	 */
	private static boolean graphColoring(int v, int[][] edges, int m) {
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i <= v-1; i++) {
        	adjacencyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i <= edges.length-1; i++) { // O(E)
        	adjacencyList.get(edges[i][0]).add(edges[i][1]);
        	adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] color = new int[v]; // initialized with 0 (uncolored)
        
        boolean check = solve(adjacencyList, v, m, color, 0); // O(V * m^V)
        
        return check;
    }

	private static boolean solve(List<List<Integer>> adjacencyList, 
							  int v, int m, int[] color,
							  int vertex) {
		
		if(vertex == v) {
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
