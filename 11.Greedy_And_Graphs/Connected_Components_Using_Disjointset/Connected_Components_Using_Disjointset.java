package practice.dsa.sheet.part8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Connected_Components_Using_Disjointset {
	
	public static void main(String[] args) {
		
		List<List<Integer>> G = new ArrayList<>();
		
		G.add(null);
		
		G.add(Arrays.asList(2,4));
		
		G.add(Arrays.asList(1));
		
		G.add(Arrays.asList(5));
		
		G.add(Arrays.asList(1));
		
		G.add(Arrays.asList(3));
		
		G.add(null);
		
		int count = noOfConnectedComponents(G);
		
		System.out.println(count);
	}
	
	/*
	 * T = O(V + 2*E)
	 * S = O(V)
	 */
	public static int noOfConnectedComponents(List<List<Integer>> G) {
		
		int n = G.size();
		
		DisjointSet ds = new DisjointSet(n);
		
		for(int i = 1; i <= n-1; i++) {
			List<Integer> list = G.get(i);
			if(list != null) {
				for(int j = 0; j <= list.size()-1; j++) {
					if(ds.findSet(i) != ds.findSet(list.get(j))) {
						ds.unionBySize(i, list.get(j));
					}
				}
			}
		}
		
		int count = 0;
		for(int i = 1; i <= n-1; i++) {
			if(ds.findSet(i) == i) {
				count++;
			}
		}
		
		return count;
	}

}
