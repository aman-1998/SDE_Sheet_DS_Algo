package practice.dsa.sheet.part8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accounts_Merge {
	
	public static void main(String[] args) {
		
//		List<List<String>> accounts = new ArrayList<>();
//		accounts.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"));
//		accounts.add(Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"));
//		accounts.add(Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"));
//		accounts.add(Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"));
//		accounts.add(Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"));
		
		
		List<List<String>> accounts = new ArrayList<>();
		accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
		accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
		accounts.add(Arrays.asList("Mary","mary@mail.com"));
		accounts.add(Arrays.asList("John","johnnybravo@mail.com"));
		
		List<List<String>> res = accountsMerge(accounts);
		
		System.out.println(res);
		
	}
	
	/*
	 * T = O(total no. of mailIds)
	 * S = O(total no. of mailIds)
	 * 
	 */
	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        
		int n = accounts.size();
		
		DisjointSet ds = new DisjointSet(n);
		
		Map<String, Integer> mailMap = new HashMap<>();
		
		for(int i = 0; i <= n-1; i++) {
			for(int j = 1; j <= accounts.get(i).size()-1; j++) {
				if(mailMap.containsKey(accounts.get(i).get(j))) {
					ds.unionBySize(i, mailMap.get(accounts.get(i).get(j)));
				} else {
					mailMap.put(accounts.get(i).get(j), i);
				}
			}
		}
		
		Map<Integer, List<String>> mergedMap = new HashMap<>();
		
		for(Map.Entry<String, Integer> entry : mailMap.entrySet()) {
			
			int val = entry.getValue();
			
			int ultimateParent = ds.findSet(val);
			
			List<String> mergedMails = mergedMap.get(ultimateParent);
			
			if(mergedMails == null) {
				mergedMails = new ArrayList<>();
				mergedMails.add(entry.getKey());
				mergedMap.put(ultimateParent, mergedMails);
			} else {
				mergedMails.add(entry.getKey());
			}
		}
		
		List<List<String>> res = new ArrayList<>();
		
		for(int i = 0; i <= n-1; i++) {
			List<String> mergedMails = mergedMap.get(i);
			if(mergedMails != null) {
				List<String> temp = new ArrayList<>();
				temp.add(accounts.get(i).get(0));
				Collections.sort(mergedMails);
				temp.addAll(mergedMails);
				res.add(temp);
			}
		}
		
		return res;
    }
}
