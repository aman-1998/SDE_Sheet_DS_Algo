package practice.dsa.sheet.part5;

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
public class Design_Twitter {
	
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
	
	private Map<Integer, Set<Integer>> followerMap = null;
	private Map<Integer, LinkedList<Tweet>> tweetMap = null;
	private int time = 0;

    public Twitter() {
    	followerMap = new HashMap<>();
    	tweetMap = new HashMap<>();
    }
    
    /*
     * T = O(1)
     */
    public void postTweet(int userId, int tweetId) {
        LinkedList<Tweet> tweetList = tweetMap.get(userId);
        if(tweetList == null) {
        	tweetList = new LinkedList<>();
        	tweetList.add(new Tweet(tweetId, time++));
        	tweetMap.put(userId, tweetList);
        } else {
        	tweetList.addFirst(new Tweet(tweetId, time++));
        }
    }
    
    
    public List<Integer> getNewsFeed(int userId) {
    	
    	Set<Integer> followeeSet = followerMap.get(userId);
    	LinkedList<LinkedList<Tweet>> mat = new LinkedList<>();
    	LinkedList<Tweet> ownTweetList = tweetMap.get(userId);
    	if(ownTweetList != null) {
    		mat.add(ownTweetList);
    	}
    	
    	if(followeeSet != null) {
    		for(Integer followee : followeeSet) {
    			LinkedList<Tweet> tweetList = tweetMap.get(followee);
    			if(tweetList != null) {
    				mat.add(tweetList);
    			}
    		}
    	}
    	
    	LinkedList<Integer> tweetsOnFeed = mergekSortedLists(mat);
    	
    	if(tweetsOnFeed.size() >= 10) {
    		return tweetsOnFeed.subList(0, 10);
    	}
    	
    	return tweetsOnFeed;
    }
    
    /*
	 * T = O(k*n*log k) ; k = no. of rows, n = no. of columns
	 * S = O(k)
	 */
    private LinkedList<Integer> mergekSortedLists(LinkedList<LinkedList<Tweet>> mat) {
		
    	int k = mat.size();
		
		PriorityQueue<TNode> maxHeap = new PriorityQueue<>(Comparator.comparing((TNode node) -> node.tweet.time).reversed());
		
		for(int i = 0; i <= k-1; i++) { // T = O(k*log k)
			TNode node = new TNode(mat.get(i).get(0), 0, mat.get(i));
			maxHeap.add(node);
		}
		
		LinkedList<Integer> output = new LinkedList<>();
		while(!maxHeap.isEmpty()) { // T = O((k*n-k)*2*log k) + O(k*log k)
			TNode deleted = maxHeap.poll();
			output.add(deleted.tweet.tweetId);
			if(deleted.index < deleted.arr.size() - 1) {
				TNode toBeAdded = new TNode(deleted.arr.get(deleted.index + 1) , deleted.index + 1, deleted.arr);
				maxHeap.add(toBeAdded);
			}
		}
		
		return output;
	}

	/*
     * T = O(1)
     */
    public void follow(int followerId, int followeeId) {
    	Set<Integer> followeeSet = followerMap.get(followerId);
    	if(followeeSet == null) {
    		followeeSet = new HashSet<>();
    		followeeSet.add(followeeId);
    		followerMap.put(followerId, followeeSet);
    	} else {
    		followeeSet.add(followeeId);
    	}
    }
    
    /*
     * T = O(1)
     */
    public void unfollow(int followerId, int followeeId) {
    	Set<Integer> followeeSet = followerMap.get(followerId);
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

class TNode {
	
	public Tweet tweet;
	public int index;
	public LinkedList<Tweet> arr;
	
	public TNode(Tweet tweet, int index, LinkedList<Tweet> arr) {
		this.tweet = tweet;
		this.index = index;
		this.arr = arr;
	}

	@Override
	public String toString() {
		return "TNode [tweet=" + tweet + ", index=" + index + ", arr=" + arr + "]";
	}
}

