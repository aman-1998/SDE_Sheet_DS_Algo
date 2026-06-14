package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.dsa.sheet.part7.utility.Node;

public class Topologically_Sort_In_DAG_Using_Adj_List {
	
	public static void main(String[] args) {
		
//		int[][] G = {{0, 0, 0, 0, 0, 0, 0},
//				     {0, 0, 0, 0, 0, 0, 0},
//				     {0, 0, 0, 0, 1, 0, 1},
//				     {0, 0, 1, 0, 0, 0, 0},
//				     {0, 1, 0, 0, 0, 0, 0},
//				     {0, 0, 1, 0, 0, 0, 0},
//				     {0, 1, 0, 0, 1, 0, 0}};
		
		List<Node> G = new ArrayList<>();
		
		G.add(null);
		
		G.add(null);
		
		Node node = new Node(4);
		node.next = new Node(6);
		G.add(node);
		
		node = new Node(2);
		G.add(node);
		
		node = new Node(1);
		G.add(node);
		
		node = new Node(2);
		G.add(node);
		
		node = new Node(4);
		node.next = new Node(1);
		G.add(node);
		
		List<Integer> res = topologicalSorting(G);
		
		System.out.println(res);
	}
	
	/*
	 * T = O(v + e)
	 * S = O(v + v) = O(v)
	 */
	public static List<Integer> topologicalSorting(List<Node> G) {
		 
		int n = G.size();
		int[] indegree = new int[n];
		Arrays.fill(indegree, 0);
		
		Queue<Integer> queue = new LinkedList<>();
		
		List<Integer> res = new ArrayList<>();
		
		for(int i = 1; i <= n-1; i++) {
			Node t = G.get(i);
			while(t != null) {
				indegree[t.data]++;
				t = t.next;
			}
		}
		
		for(int i = 1; i <= n-1; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int popped = queue.poll();
			indegree[popped] = -1;
			res.add(popped);
			
			Node t = G.get(popped);
			
			while(t != null) {
				indegree[t.data]--;
				if(indegree[t.data] == 0) {
					queue.add(t.data);
				}
				
				t = t.next;
			}
		}
		
		return res;
	}
}
