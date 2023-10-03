package algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

class Triplet implements Comparable<Triplet> {
	public int v1;
	public int v2;
	public int wt;
	
	public Triplet(int v1, int v2, int wt) {
		this.v1 = v1;
		this.v2 = v2;
		this.wt = wt;
	}
	
	public int compareTo(Triplet that) {
		if(this.wt > that.wt) {
			return 1;
		} else {
			return -1;
		}
	}
	
}

public class Prims_Algo_Minimal_Spanning_Tree {
	
	static int[][] edges;
	
	public static void main(String[] args) {
		int n = 5;
		int[][] G = {{0,1,0,8,4},
					 {1,0,3,0,7},
					 {0,3,0,5,2},
					 {8,0,5,0,4},
					 {6,7,2,4,0}};
		
		int minimalCost = minimalSpanningTree(G, 5, 0);
		System.out.println("Cost = " + minimalCost);
		
		for(int i = 0; i <=n-1; i++) {
			System.out.println(edges[i][0] + " to " + edges[i][1]);
		}
	}
	
	public static int minimalSpanningTree(int[][] G, int n, int start) {
		
		PriorityQueue<Triplet> minHeap = new PriorityQueue<>();
		//PriorityQueue<Triplet> minHeap = new PriorityQueue<>((triplet1, triplet2) -> triplet1.wt < triplet2.wt ? -1 : 1);
		edges = new int[n][2];
		int countEdge = 0;
		int[] visited = new int[n];
		Arrays.fill(visited, 0); // Initialize each index with 0
		
		minHeap.add(new Triplet(start, start, 0));
		int cost = 0;
		
		while(!minHeap.isEmpty()) {
			
			Triplet current = minHeap.poll();
			
			if(visited[current.v2] == 0) {
				cost = cost + current.wt;
				edges[countEdge][0] = current.v1;
				edges[countEdge][1] = current.v2;
				countEdge++;
				
				visited[current.v2] = 1;
				
				for(int i = 0; i <= n-1; i++) {
					if(G[current.v2][i] != 0) {
						if(visited[i] == 0) {
							minHeap.add(new Triplet(current.v2, i, G[current.v2][i]));
						}
					}
				}
			}
			
		}
		return cost;
	}
}
