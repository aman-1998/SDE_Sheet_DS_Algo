package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Eventual_Safe_States {
	
	public static void main(String[] args) {
		
		int[][] graph = {{2, 3}, {0}, {5}, {1}, {5}, {}, {}, {1}, {7}};
		
		List<Integer> safenodes = eventualSafeNodes_using_Topological_Sorting(graph);
		
		System.out.println(safenodes);
	}
	
	/*
	 * Using the same concept to Detect cycle in directed graph using DFS
	 * 
	 * T = O(V) + O(V+E)
	 * S = O(2V)
	 */
	public static List<Integer> eventualSafeNodes_using_dfs(int[][] adjacencyList) {
        
		int n = adjacencyList.length;
		
		int[] nodeVisited = new int[n];
		int[] pathVisited = new int[n];
		List<Integer> safeNodes = new ArrayList<>();
		
		for(int i = 0; i <= n-1; i++) {
			if(nodeVisited[i] == 0) {
				DFS(adjacencyList, nodeVisited, pathVisited, i, safeNodes);
			}
		}
		
		Collections.sort(safeNodes);
		
		return safeNodes;
    }
	
	private static boolean DFS(int[][] adjacencyList, int[] nodeVisited, int[] pathVisited, int start, List<Integer> safeNodes) {
		
		nodeVisited[start] = 1;
		pathVisited[start] = 1;
		
		int[] adjacentVertices = adjacencyList[start];
		
		for(int i = 0; i <= adjacentVertices.length-1; i++) {
			if(nodeVisited[adjacentVertices[i]] == 0) {
				boolean check = DFS(adjacencyList, nodeVisited, pathVisited, adjacentVertices[i], safeNodes);
				if(check) {
					return true;
				}
			} else {
				if(nodeVisited[adjacentVertices[i]] == 1 && pathVisited[adjacentVertices[i]] == 1) {
					return true;
				}
			}
		}
		
		safeNodes.add(start);
		pathVisited[start] = 0;
		return false;
	}
	
	/*
	 * Using the same concept to Detect cycle in directed graph using Topological sorting or BFS
	 * 
	 * T = O(V) + O(V+E)
	 * S = O(V)
	 */
	public static List<Integer> eventualSafeNodes_using_Topological_Sorting(int[][] adjacencyList) {
		
		int n = adjacencyList.length;
		
		List<Integer> safeNodes = new ArrayList<>();
		
		List<List<Integer>> revAdjList = new ArrayList<>();
		
		int[] indegree = new int[n];
		
		for(int i = 0; i <= n-1; i++) {
			revAdjList.add(new ArrayList<>());
		}
		
		for(int i = 0; i <= n-1; i++) {
			int[] adjacentVertices = adjacencyList[i];
			for(int j : adjacentVertices) {
				List<Integer> list = revAdjList.get(j);
				list.add(i);
				indegree[i]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i <= n-1; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int popped = queue.poll();
			indegree[popped] = -1;
			
			safeNodes.add(popped);
			
			List<Integer> adjacentVertices = revAdjList.get(popped);
			
			for(int i = 0; i <= adjacentVertices.size()-1; i++) {
				indegree[adjacentVertices.get(i)]--;
				if(indegree[adjacentVertices.get(i)] == 0) {
					queue.add(adjacentVertices.get(i));
				}
			}
		}
		
		Collections.sort(safeNodes);
		
		return safeNodes;
	}
	
	
}
