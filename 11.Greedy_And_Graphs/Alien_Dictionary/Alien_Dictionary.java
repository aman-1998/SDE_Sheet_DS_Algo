package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Alien_Dictionary {
	
	public static void main(String[] args) {
		
		int k = 5;
		String[] dict =  {"baa", "abcd", "abca", "cab", "cad"};
		
		String order = findOrder(dict, k);
		
		System.out.println(order);
	}
	
	/*
	 * T = O(n * max_length_of_strings) + O(k + E)
     *   = O(n × max_length) + O(k + n)    [since E ≤ n]
     *   = O(n × max_length + k)           [since n ≤ n × max_length when max_length ≥ 1]
	 * 
	 * S = O(k+n)
	 */
	public static String findOrder(String [] dict, int k) {
		
		int n = dict.length;
		
		List<List<Integer>> adjacencyList = new ArrayList<>();
		
		for(int i = 0; i <= k-1; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		
		for(int i = 0; i <= n-2; i++) {
			String str1 = dict[i];
			String str2 = dict[i+1];
			
			int min = str1.length() < str2.length() 
					  ? str1.length() 
					  : str2.length();
			
			for(int j = 0; j <= min-1; j++) {
				if(str1.charAt(j) != str2.charAt(j)) {
					List<Integer> list = adjacencyList.get(str1.charAt(j) - 'a');
					list.add(str2.charAt(j) - 'a');
					break;
				}
			}
		}
		
		return topological_sorting(adjacencyList); // The graph will never have cycle
    }

	private static String topological_sorting(List<List<Integer>> adjacencyList) {
		
		int n = adjacencyList.size();
		
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
		
		StringBuilder topoSortSb = new StringBuilder();
		
		while(!queue.isEmpty()) {
			int popped = queue.poll();
			indegree[popped] = -1;
			
			topoSortSb.append((char)(popped + 'a'));
			
			List<Integer> adjacentVertices = adjacencyList.get(popped);
			
			for(int i = 0; i <= adjacentVertices.size()-1; i++) {
				indegree[adjacentVertices.get(i)]--;
				if(indegree[adjacentVertices.get(i)] == 0) {
					queue.add(adjacentVertices.get(i));
				}
			}
		}
		
		return topoSortSb.toString();
	}
}
