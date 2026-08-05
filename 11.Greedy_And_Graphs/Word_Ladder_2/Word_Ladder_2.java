package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_2 {

	public static void main(String[] args) {
		
//		String beginWord = "hit";
//		String endWord = "cog";
//		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		
		String beginWord = "red";
		String endWord = "tax";
		List<String> wordList = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
		
		List<List<String>> shortestSequences = findLadders(beginWord, endWord, wordList);
		
		shortestSequences.forEach(list -> System.out.println(list));
	}
	
	/*
	 * N = number of words in wordList
	 * L = length of each word
	 * 
	 * T = O(N * L^2) + O(N^2 * L)
	 * S = O(N*N * L)
	 */
	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
		Set<String> wordSet = new HashSet<>(wordList);
		wordSet.add(beginWord);
		
		Queue<Entry> queue = new LinkedList<>();
		queue.add(new Entry(Arrays.asList(beginWord), new ArrayList<>()));
		
		List<List<String>> res = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			
			Entry triplet = queue.poll();
			List<String> toBeDeleted = triplet.toBeDeleted;
			List<String> sequence = triplet.sequence;
			
			for(String word : toBeDeleted) {
				
				if(word.equals(endWord)) {
					
					if(!res.isEmpty() && sequence.size()+1 > res.get(0).size()) {
						continue;
					}
					
					List<String> tempSeq = new ArrayList<>(sequence);
					tempSeq.add(word);
					res.add(tempSeq);
					continue;
				}
				
				wordSet.remove(word);
				
				char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
						'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
						'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
						'y', 'z'};
	
				for(int i = 0; i <= word.length()-1; i++) {
					
					StringBuilder wordSb = new StringBuilder(word);
					List<String> toBeDeletedTemp = new ArrayList<>();
					
					for(char ch : alphabets) {
						wordSb.replace(i, i+1, ""+ch);
						if(wordSet.contains(wordSb.toString())) {
							toBeDeletedTemp.add(wordSb.toString());
						}
					}
					
					if(!toBeDeletedTemp.isEmpty()) {
						List<String> tempSeq = new ArrayList<>(sequence);
						tempSeq.add(word);
						queue.add(new Entry(toBeDeletedTemp, tempSeq));
					}
				}
			}
			
		}
		
		return res;
    } 
}

class Entry {
	
	public List<String> toBeDeleted;
	public List<String> sequence;
	
	public Entry(List<String> toBeDeleted, List<String> sequence) {
		this.toBeDeleted = toBeDeleted;
		this.sequence = sequence;
	}
	
	public String toString() {
		return "("+toBeDeleted+", "+sequence+")";
	}
}
