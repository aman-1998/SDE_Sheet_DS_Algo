package algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra_Algorithm {
	static int[] dis;
	public static void main(String[] args) {
		//int n = 5;
		int[][] G = {{0,10,5,0,0},
					 {0,0,2,1,0},
					 {0,3,0,9,2},
					 {0,0,0,0,4},
					 {7,0,0,6,0}};
		
		
		int  n = G.length;
		singleSourceShortestPath(G, n, 0);
		for(int i : dis) {
			System.out.print(i + " ");
		}
		
	}
	
	public static void singleSourceShortestPath(int[][] G, int n, int source) {
		
		int[] computed = new int[n]; // To keep track of the vertices whose shortest distance is already computed
		dis = new int[n]; // To store shortest distance for each vertex
		
		Arrays.fill(computed, 0);
		
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((pair1, pair2) -> pair1.d < pair2.d ? -1 : 1);
		
		for(int i=0; i <= n-1; i++) {
			if(i == source) {
				dis[i] = 0;
			} else {
				dis[i] = Integer.MAX_VALUE;
			}
			minHeap.add(new Pair(i, dis[i]));
		}
		
		while(!minHeap.isEmpty()) {
			Pair curr = minHeap.remove();
			
			if(computed[curr.v] == 0) {
				
				for(int i=0; i<=n-1; i++) {
					if(G[curr.v][i] != 0) {
						if(computed[i] == 0) {
							if(curr.d + G[curr.v][i] < dis[i]) { // relaxing curr.v -----> i
								dis[i] = curr.d + G[curr.v][i];
								minHeap.add(new Pair(i, dis[i]));
							}
						}
					}
				}
				
				computed[curr.v] = 1; // Once a pair is out from minHeap then it's vertex is marked computed
			}
		}
		
	}
}

class Pair {
	int v;
	int d;
	
	public Pair(int v, int d) {
		this.v = v;
		this.d = d;
	}
}
