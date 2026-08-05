package practice.dsa.sheet.part7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_1 {

	public static void main(String[] args) {
		
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		
		int shortestLengthOfLadder = ladderLength(beginWord, endWord, wordList);
		
		System.out.println(shortestLengthOfLadder);
	}
	
	/*
	 * N = number of words in wordList
	 * L = length of each word
	 * 
	 * T = O(N * L^2)
	 * S = O(N)
	 */
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
		Set<String> wordSet = new HashSet<>(wordList);
		wordSet.add(beginWord);
		
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(beginWord, 1));
		
		while(!queue.isEmpty()) {
			
			Pair pair = queue.poll();
			String word = pair.word;
			int length = pair.length;
			
			if(word.equals(endWord)) {
				return length;
			}
			
			if(!wordSet.remove(word)) { // Because already deleted earlier
				continue;
			}
			
			char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
								'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
								'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
								'y', 'z'};
			
			for(int i = 0; i <= word.length()-1; i++) {
				
				StringBuilder wordSb = new StringBuilder(word);
				
				for(char ch : alphabets) {
					wordSb.replace(i, i+1, ""+ch);
					if(wordSet.contains(wordSb.toString())) {
						queue.add(new Pair(wordSb.toString(), length+1));
					}
				}
			}
		}
		
		return 0;
    } 
}

class Pair {
	
	public String word;
	public int length;
	
	public Pair(String word, int length) {
		this.word = word;
		this.length = length;
	}
	
	public String toString() {
		return "("+word+", "+length+")";
	}
}
