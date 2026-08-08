package practice.dsa.sheet.part9;

public class City_With_Smallest_Number_Of_Neighbors {
	
	public static void main(String[] args) {
		
		 int n = 4;
		 int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
		 int distanceThreshold = 4;
		 
		 int res = findTheCity(distanceThreshold, edges, distanceThreshold);
		 
		 System.out.println(res);
	}
	
	/*
	 * Using Floyd Warshall Algorithm this can be solved
	 * 
	 * T = O(V^2) + O(E) + O(V^3) + O(V^2)
	 *   = O(E) + O(V^3)
	 *   = O(V^3 + E)    [E = V^2 for dense graphs]
	 *   = O(V^3)
	 *   
	 * S = O(V^2)
	 * 
	 */
	public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
		int[][] adjacencyMatrix = new int[n][n];
		
		for(int i = 0; i <= n-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				adjacencyMatrix[i][j] = Integer.MAX_VALUE;
				if(i == j) {
					adjacencyMatrix[i][j] = 0;
				}
			}
		}
		
		for(int[] edge : edges) {
			adjacencyMatrix[edge[0]][edge[1]] = edge[2];
			adjacencyMatrix[edge[1]][edge[0]] = edge[2];
		}
		
		for(int via = 0; via <= n-1; via++) { // Finding all pair shortest path
			for(int i = 0; i <= n-1; i++) {
				for(int j = 0; j <= n-1; j++) {
					
					if(adjacencyMatrix[i][via] == Integer.MAX_VALUE
						|| adjacencyMatrix[via][j] == Integer.MAX_VALUE	) {
						
						continue;
					}
					
					int cost = adjacencyMatrix[i][via] + adjacencyMatrix[via][j];
					
					if(cost < adjacencyMatrix[i][j]) {
						
						adjacencyMatrix[i][j] = cost;
						if(i == j && cost < 0) { // negative weight cycle
							return -1;
						}
					}
				}
			}
		}
		
		int res = 0;
		int minNeighbour = Integer.MAX_VALUE;
		
		for(int i = 0; i <= n-1; i++) {
			int count = 0;
			for(int j = 0; j <= n-1; j++) {
				if(adjacencyMatrix[i][j] <= distanceThreshold) {
					count++;
				}
			}
			
			if(count <= minNeighbour) {
				minNeighbour = count;
				res = i;
			}
		}
		
		return res;
    }
}
