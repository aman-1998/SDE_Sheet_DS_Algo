import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
/*
 * Video Link : https://www.youtube.com/watch?v=pNichitDD2E
 */

public class Design_Twitter_2nd {
    
    public static void main(String[] args) {
		
		Twitter twitter = new Twitter();
		
		/*
		twitter.postTweet(1, 5);
		twitter.postTweet(1, 3);
		twitter.postTweet(1, 101);
		twitter.postTweet(1, 13);
		twitter.postTweet(1, 10);
		twitter.postTweet(1, 2);
		twitter.postTweet(1, 94);
		twitter.postTweet(1, 505);
		twitter.postTweet(1, 333);
		twitter.postTweet(1, 22);
		twitter.postTweet(1, 11);
		System.out.println(twitter.getNewsFeed(1));
		*/
		
		twitter.postTweet(2, 5);
		twitter.postTweet(1, 3);
		twitter.postTweet(1, 101);
		twitter.postTweet(2, 13);
		twitter.postTweet(2, 10);
		twitter.postTweet(1, 2);
		twitter.postTweet(2, 94);
		twitter.postTweet(2, 505);
		twitter.postTweet(1, 333);
		twitter.postTweet(1, 22);
		System.out.println(twitter.getNewsFeed(2));
		twitter.follow(2,1);
		System.out.println(twitter.getNewsFeed(2));
		
	}
}

class Twitter {
	
	private Map<Integer, List<Tweet>> tweetMap = null;
	private Map<Integer, Set<Integer>> followeeMap = null;
	private int time = 0;
	
	public Twitter() {
		tweetMap = new HashMap<>();
		followeeMap = new HashMap<>();
	}
	
	public void postTweet(int userId, int tweetId) {
		List<Tweet> tweetList = tweetMap.get(userId);
		if(tweetList == null) {
			tweetList = new LinkedList<>();
			tweetList.add(new Tweet(tweetId, time++));
			tweetMap.put(userId, tweetList);
		} else {
			tweetList.add(new Tweet(tweetId, time++));
		}
	}
	
	public List<Integer> getNewsFeed(int userId) {
		List<List<Tweet>> mat = new LinkedList<>();
		List<Tweet> ownTweetList = tweetMap.get(userId);
		if(ownTweetList != null) {
			mat.add(ownTweetList);
		}
		Set<Integer> followeeSet = followeeMap.get(userId);
		if(followeeSet != null) {
			for(Integer followeeId : followeeSet) {
				List<Tweet> followeeTweetList = tweetMap.get(followeeId);
				if(followeeTweetList != null) {
					mat.add(followeeTweetList);
				}
			}
		}
		
		List<Integer> newsFeed = mergeKSortedLists(mat);
		
		if(newsFeed.size() >= 10) {
			return newsFeed.subList(0, 10);
		}
		
		return newsFeed;
	}
	
	public List<Integer> mergeKSortedLists(List<List<Tweet>> mat) {
		
		int m = mat.size();
		PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(Comparator.comparing((List<Integer> list) -> mat.get((int)list.get(0)).get((int)list.get(1)).time));
		
		for(int i = 0; i <= m-1; i++) {
			maxHeap.add(Arrays.asList(i, 0));
		}
		
		List<Integer> newsFeed = new LinkedList<>();
		
		while(!maxHeap.isEmpty()) {
			List<Integer> deleted = maxHeap.poll();
			newsFeed.add(mat.get(deleted.get(0)).get(deleted.get(1)).tweetId);
			
			if(deleted.get(1) < mat.get((int)deleted.get(0)).size() - 1) {
				maxHeap.add(Arrays.asList(deleted.get(0), deleted.get(1)+1));
			}
		}
		
		return newsFeed;
	}
	
	public void follow(int followerId, int followeeId) {
		Set<Integer> followeeSet = followeeMap.get(followerId);
		if(followeeSet == null) {
			followeeSet = new HashSet<>();
			followeeSet.add(followeeId);
			followeeMap.put(followerId, followeeSet);
		} else {
			followeeSet.add(followeeId);
		}
	}
	
	public void unfollow(int followerId, int followeeId) {
		Set<Integer> followeeSet = followeeMap.get(followerId);
		if(followeeSet != null) {
			followeeSet.remove(followeeId);
		}
	}
}

class Tweet {
	
	public int tweetId;
	public int time;
	
	public Tweet(int tweetId, int time) {
		this.tweetId = tweetId;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Tweet [tweetId=" + tweetId + ", time=" + time + "]";
	}
}


