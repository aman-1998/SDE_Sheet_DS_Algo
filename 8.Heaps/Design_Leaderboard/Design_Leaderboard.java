package practice.dsa.sheet.part5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Design_Leaderboard {
	
	public static void main(String[] args) {
		
		Leaderboard leaderboard = new Leaderboard();
		leaderboard.addScore(1, 47);
		leaderboard.addScore(2, 100);
		leaderboard.addScore(3, 84);
		leaderboard.addScore(1, 72);
		leaderboard.addScore(1, 81);
		leaderboard.addScore(1, 97);
		
		int sumOfTopK = leaderboard.top_1st_approach(2);
		System.out.println(sumOfTopK);
		
		sumOfTopK = leaderboard.top_2nd_approach(2);
		System.out.println(sumOfTopK);
	}
}


class Leaderboard {
	
	Map<Integer, Integer> playerScoreMap = new HashMap<>();
	
	public void addScore(int playerId, int score) {
		Integer scoreSoFar = playerScoreMap.get(playerId);
		if(scoreSoFar == null) {
			playerScoreMap.put(playerId, score);
		} else {
			playerScoreMap.put(playerId, scoreSoFar + score);
		}
	}
	
	/*
	 * T = O(k + n*log k) = O(n*log k)
	 * 
	 * Better for smaller values of k i.e., k << n
	 */
	public int top_1st_approach(int k) {
		
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparing(entry -> entry.getValue()));
		
		for(Map.Entry<Integer, Integer> entry : playerScoreMap.entrySet()) { // T = O(n*log k)
			minHeap.add(entry);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		int sum = 0;
		for(Map.Entry<Integer, Integer> entry : minHeap) { // T = O(k)
			sum = sum + entry.getValue();
		}
		
		return sum;
	}
	
	/*
	 * T = O(n + k*log n) = O(k*log n)
	 * 
	 * Better for larger values of k i.e., k and n are close
	 */
	public int top_2nd_approach(int k) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		maxHeap.addAll(playerScoreMap.values()); // T = O(n)
		
		int min = Integer.MAX_VALUE;
		if(k < maxHeap.size()) {
			min = k;
		} else {
			min = maxHeap.size();
		}
		
		int sum = 0;
		for(int i = 0; i <= min - 1 ; i++) { // T = O(min*log n) ; min = min(n , k)
			sum = sum + maxHeap.poll();
		}
		
		return sum;
	}
	
	/*
	 * T = O(1)
	 */
	public void reset(int playerId) {
		if(playerScoreMap.containsKey(playerId)) {
			playerScoreMap.remove(playerId);
		}
	}
}
