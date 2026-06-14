package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topologically_Sort_In_DAG_Using_Matrix {
	
	public static void main(String[] args) {
		
		int[][] G = {{0, 0, 0, 0, 0, 0, 0},
				     {0, 0, 0, 0, 0, 0, 0},
				     {0, 0, 0, 0, 1, 0, 1},
				     {0, 0, 1, 0, 0, 0, 0},
				     {0, 1, 0, 0, 0, 0, 0},
				     {0, 0, 1, 0, 0, 0, 0},
				     {0, 1, 0, 0, 1, 0, 0}};
		
		List<Integer> res = topologicalSorting(G);
		
		System.out.println(res);
	}
	
	/*
	 * T = O(v^2)
	 * S = O(v + v) = O(v)
	 */
	public static List<Integer> topologicalSorting(int[][] G) {
		 
		int n = G.length;
		int[] indegree = new int[n];
		Arrays.fill(indegree, 0);
		
		Queue<Integer> queue = new LinkedList<>();
		
		List<Integer> res = new ArrayList<>();
		
		for(int i = 1; i <= n-1; i++) {
			for(int j = 1; j <= n-1; j++) {
				if(G[j][i] == 1) {
					indegree[i]++;
				}
			}
			
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int popped = queue.poll();
			indegree[popped] = -1;
			res.add(popped);
			
			for(int i = 1; i <= n-1; i++) {
				if(G[popped][i] == 1 && indegree[i] > 0) {
					indegree[i]--;
					if(indegree[i] == 0) {
						queue.add(i);
					}
				}
			}
		}
		
		return res;
	}
}
