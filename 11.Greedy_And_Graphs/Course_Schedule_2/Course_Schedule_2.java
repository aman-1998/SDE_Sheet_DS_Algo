package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_2 {
	
	public static void main(String[] args) {
		
		int[][] prerequisites = {{3, 1}, {1, 7}, {1, 4}, 
				 {5, 6}, {0, 2}, {4, 7}, {0, 7}, 
				 {6, 2}, {7, 2}, {2, 5}, {5, 8}};

		int numCourses = 9;
		
		int[] courseOrder = findOrder(numCourses, prerequisites);
		
		Arrays.stream(courseOrder).forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * If directed graph, if cycle found then course can't be completed
	 * If cycle is not present then find topologically sorted order.
	 * 
	 * T = O(V + E) = O(numCourses + prerequisites)
	 * S = O(V)
	 */
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        
		List<List<Integer>> adjacencyList = new ArrayList<>();
		
		for(int i = 0; i <= numCourses-1; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		
		for(int i = 0; i <= prerequisites.length-1; i++) {
			List<Integer> list = adjacencyList.get(prerequisites[i][0]);
			list.add(prerequisites[i][1]);
		}
		
		// If cycle found then course can't be completed
		//boolean isCycleFound = detectCycle_Using_DFS(numCourses, adjacencyList);
		return detectCycle_using_Topological_sorting(numCourses, adjacencyList);
    }
	
	private static int[] detectCycle_using_Topological_sorting(int n, List<List<Integer>> adjacencyList) {
		
		int[] indegree = new int[n];
		
		for(int i = 0; i <= n-1; i++) {
			List<Integer> adjacentVertices = adjacencyList.get(i);
			for(int vertex : adjacentVertices) {
				indegree[vertex]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i <= n-1; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		int[] topoSort = new int[n];
		int index = -1;
		
		while(!queue.isEmpty()) {
			int popped = queue.poll();
			indegree[popped] = -1;
			
			index++;
			topoSort[index] = popped;
			
			List<Integer> adjacentVertices = adjacencyList.get(popped);
			
			for(int i = 0; i <= adjacentVertices.size()-1; i++) {
				indegree[adjacentVertices.get(i)]--;
				if(indegree[adjacentVertices.get(i)] == 0) {
					queue.add(adjacentVertices.get(i));
				}
			}
		}
		
		if(index+1 != n) {
			topoSort = new int[0]; //  empty array
		}
		
		return topoSort;
	} 
}
