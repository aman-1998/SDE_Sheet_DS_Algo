package practice.dsa.sheet.part8;

public class No_Of_Operations_To_Make_Network_Connected {
	
	public static void main(String[] args) {
		//int n = 6;
		//int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
		
		int n = 6;
		int[][] connections = {{0,1},{0,2},{0,3},{1,2}};
		
		int noOfOperations = makeConnected(n, connections);
		
		System.out.println(noOfOperations);
	}
	
	/*
	 * T = O(noOfEdges + n) = O(n-1 + n) = O(2n) = O(n)
	 * S = O(n)
	 */
	public static int makeConnected(int n, int[][] connections) {
        
		DisjointSet ds = new DisjointSet(n);
		
		int noOfEdges = connections.length;
		
		if(noOfEdges < n-1) { // in a MST there are n-1 edges
			return -1;
		}
		
		for(int i = 0; i <= noOfEdges-1; i++) {
			ds.unionBySize(connections[i][0], connections[i][1]);
		}
		
		int count = 0;
		for(int i = 0; i <= n-1; i++) {
			if(ds.findSet(i) == i) {
				count++;
			}
		}
		
		return count-1;
    }
}
