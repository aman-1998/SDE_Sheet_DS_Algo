package practice.dsa.sheet.part8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import practice.dsa.sheet.part8.utility.WeightedNode;

public class Prims_Algo_To_Find_MST {
	
	private static int[][] edges;
	
	public static void main(String[] args) {
		int n = 5;
		int[][] G = {{0,1,0,8,4},
					 {1,0,3,0,7},
					 {0,3,0,5,2},
					 {8,0,5,0,4},
					 {6,7,2,4,0}};
		
		int minimalCost = MSTUsingMatrix(G, 0);
		System.out.println("Cost = " + minimalCost);
		
		for(int i = 0; i <=n-1; i++) {
			System.out.println(edges[i][0] + " to " + edges[i][1]);
		}
		
		System.out.println("\n==============================================");
		
		List<WeightedNode> Graph = new ArrayList<>();
		
		WeightedNode weightedNode = new WeightedNode(1, 1);
		weightedNode.next = new WeightedNode(3, 8);
		weightedNode.next.next = new WeightedNode(4, 4);
		Graph.add(weightedNode); // 0
		
		weightedNode = new WeightedNode(0, 1);
		weightedNode.next = new WeightedNode(2, 3);
		weightedNode.next.next = new WeightedNode(4, 7);
		Graph.add(weightedNode); // 1
		
		weightedNode = new WeightedNode(1, 3);
		weightedNode.next = new WeightedNode(3, 5);
		weightedNode.next.next = new WeightedNode(4, 2);
		Graph.add(weightedNode); // 2
		
		weightedNode = new WeightedNode(0, 8);
		weightedNode.next = new WeightedNode(2, 5);
		weightedNode.next.next = new WeightedNode(4, 4);
		Graph.add(weightedNode); //3
		
		weightedNode = new WeightedNode(0, 4);
		weightedNode.next = new WeightedNode(1, 7);
		weightedNode.next.next = new WeightedNode(2, 2);
		weightedNode.next.next = new WeightedNode(3, 4);
		Graph.add(weightedNode); //4
		
		minimalCost = MSTUsingAdjacencyList(Graph, 0);
		System.out.println("Cost = " + minimalCost);
		
		for(int i = 0; i <=n-1; i++) {
			System.out.println(edges[i][0] + " to " + edges[i][1]);
		}
	}
	
	/*
	 * Time Complexity : O(n² + E log E)
	 * Space Complexity: O(E + n)
	 *
	 * Dense Graph (E = n²)
	 * --------------------
	 * T = O(n² + n² log(n²))
	 *   = O(n² log n)
	 *
	 * S = O(n²)
	 *
	 * Sparse Graph (E = n)
	 * --------------------
	 * T = O(n² + n log n)
	 *   = O(n²)
	 *
	 * S = O(n)
	 */
	public static int MSTUsingMatrix(int[][] G, int start) {
		
		int n = G.length;
		
		PriorityQueue<EdgeWithWeight> minHeap = new PriorityQueue<>(Comparator.comparing((EdgeWithWeight e) -> e.wt));
		
		edges = new int[n][2];
		int countEdge = 0;
		int[] visited = new int[n];
		Arrays.fill(visited, 0); // Initialize each index with 0
		
		minHeap.add(new EdgeWithWeight(start, start, 0));
		int cost = 0;
		
		while(!minHeap.isEmpty()) {
			
			EdgeWithWeight current = minHeap.poll();
			
			if(visited[current.v2] == 0) {
				cost = cost + current.wt;
				edges[countEdge][0] = current.v1;
				edges[countEdge][1] = current.v2;
				countEdge++;
				
				visited[current.v2] = 1;
				
				for(int i = 0; i <= n-1; i++) {
					if(G[current.v2][i] != 0) {
						if(visited[i] == 0) {
							minHeap.add(new EdgeWithWeight(current.v2, i, G[current.v2][i]));
						}
					}
				}
			}
		}
		
		return cost;
	}
	
	/*
	 * Time Complexity : O(E log E)
	 * Space Complexity: O(E + n)
	 *
	 * Dense Graph (E = n²)
	 * --------------------
	 * T = O(E log(n²))
	 *   = O(E log n)
	 *   = O(E log v)
	 *
	 * S = O(E)
	 *
	 * Sparse Graph (E = n)
	 * --------------------
	 * T = O(n log n)
	 *   = O(v log v)
	 *
	 * S = O(v)
	 */
	public static int MSTUsingAdjacencyList(List<WeightedNode> G, int start) {
		
		int n = G.size();
		
		PriorityQueue<EdgeWithWeight> minHeap = new PriorityQueue<>(Comparator.comparing((EdgeWithWeight e) -> e.wt));
		
		edges = new int[n][2];
		int countEdge = 0;
		int[] visited = new int[n];
		Arrays.fill(visited, 0); // Initialize each index with 0
		
		minHeap.add(new EdgeWithWeight(start, start, 0));
		int cost = 0;
		
		while(!minHeap.isEmpty()) {
			
			EdgeWithWeight current = minHeap.poll();
			
			if(visited[current.v2] == 0) {
				cost = cost + current.wt;
				edges[countEdge][0] = current.v1;
				edges[countEdge][1] = current.v2;
				countEdge++;
				
				visited[current.v2] = 1;
				
				WeightedNode t = G.get(current.v2);
				while(t != null) {
					if(visited[t.vertex] == 0) {
						minHeap.add(new EdgeWithWeight(current.v2, t.vertex, t.weight));
					}
					t = t.next;
				}
			}
		}
		
		return cost;
	}
}

class EdgeWithWeight {
	public int v1;
	public int v2;
	public int wt;
	
	public EdgeWithWeight(int v1, int v2, int wt) {
		this.v1 = v1;
		this.v2 = v2;
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "EdgeWithWeight[v1=" + v1 + ", v2=" + v2 + ", wt=" + wt + "]";
	}
}
