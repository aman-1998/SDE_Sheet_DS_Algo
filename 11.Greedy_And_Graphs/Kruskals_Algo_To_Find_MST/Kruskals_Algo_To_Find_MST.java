package practice.dsa.sheet.part8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import practice.dsa.sheet.part8.utility.EdgeWithWeight;
import practice.dsa.sheet.part8.utility.WeightedNode;

public class Kruskals_Algo_To_Find_MST {
	
	private static int[][] edges;
		
	public static void main(String[] args) {
		
		int n = 5;
		
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
		
		int minimalCost = MSTUsingAdjacencyList(Graph, 0);
		System.out.println("Cost = " + minimalCost);
		
		for(int i = 0; i <= n-2; i++) {
			System.out.println(edges[i][0] + " to " + edges[i][1]);
		}
	}
	
	/*
	 * Kruskal's Algorithm
	 * --------------------
	 * 
	 * 1. Sort the edges in increasing order
	 * 2. Select the edges but skip if selection of an edge results in cycle
	 * 
	 * T = O(E*log E)
	 * S = O(v)
	 * 
	 * Dense Graph (E = V²)
	 * --------------------
	 * T = O(E log(V²))
	 *   = O(E log v)
	 * 
	 * 
	 * Sparse Graph (E = V)
	 * --------------------
	 * T = O(v log v)
	 * 
	 * Kruskal's Algo is slightly better than Prim's Algo because the time 
	 * is same but space required is less.
	 */
	public static int MSTUsingAdjacencyList(List<WeightedNode> G, int start) {
		
		int n = G.size(); // no. of vertices
		
		List<EdgeWithWeight> edgeWithWeightArr = new ArrayList<>();
		
		for(int i = 0; i <= n-1; i++) { // O(2E)
			WeightedNode t = G.get(i);
			while(t != null) {
				edgeWithWeightArr.add(new EdgeWithWeight(i, t.vertex, t.weight));
				t = t.next;
			}
		}
		
		// O(E*log E)
		Collections.sort(edgeWithWeightArr, Comparator.comparing((EdgeWithWeight e) -> e.wt));
		
		DisjointSet ds = new DisjointSet(n);
		
		int cost = 0;
		edges = new int[n-1][2]; // MST has n-1 edges; n = no. of vertices
		int countEdge = 0;
		
		for(int i = 0; i <= edgeWithWeightArr.size()-1; i++) { // O(E)
			int u = edgeWithWeightArr.get(i).v1;
			int v = edgeWithWeightArr.get(i).v2;
			int wt = edgeWithWeightArr.get(i).wt;
			
			if(ds.findSet(u) != ds.findSet(v)) {
				cost = cost + wt;
				edges[countEdge][0] = u;
				edges[countEdge][1] = v;
				countEdge++;
				
				ds.unionBySize(u, v);
			}
		}
		
		return cost;
	}
}
