package algorithms.part4;

import java.util.HashMap;
import java.util.Map;
/*
 * Video : https://www.youtube.com/watch?v=z9bJUPxzFOw
 */
public class LRU_Cache_Implementation {
	
	public static void main(String[] args) {
		
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.toString());
		
		lruCache.put(3, 3);
		System.out.println(lruCache.toString());
		
		System.out.println(lruCache.get(2));
		
		lruCache.put(4, 4);
		
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));
		
		lruCache.toString();
	}
}

class LRUCacheNode {
	
	public int key;
	
	public int value;
	
	public LRUCacheNode before;
	
	public LRUCacheNode after;
}

class LRUCache {
	
	public LRUCacheNode head = null;
	
	public LRUCacheNode last = null;
	
	public Map<Integer, LRUCacheNode> nodeMap = new HashMap<>();
	
	int capacity = 0;
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
    	if(capacity == 0) {
    		return -1;
    	}
    	
    	LRUCacheNode lruCacheNode = nodeMap.get(key);
    	
    	if(lruCacheNode != null) {
    		if(head != lruCacheNode) {
				if(last == lruCacheNode) {
					last = lruCacheNode.before;
					last.after = null;
				} else {
					lruCacheNode.before.after = lruCacheNode.after;
					lruCacheNode.after.before = lruCacheNode.before;
				}
				lruCacheNode.after = head;
				head.before = lruCacheNode;
				lruCacheNode.before = null;
				head = lruCacheNode;
			}
    		
    		return lruCacheNode.value;
    	}
    	
    	return -1;
    }
    
    public void put(int key, int value) {
    	
    	if(capacity == 0) {
    		return;
    	}
    	
		LRUCacheNode lruCacheNode = nodeMap.get(key);

		if(lruCacheNode == null) {
	
			if(nodeMap.size() == capacity){
           	 	if(nodeMap.size() == 1) {
					head = null;
					last = null;
					nodeMap.clear();
				} else {
					nodeMap.remove(last.key);
					last = last.before;
           	 		last.after = null;
				} 
			}
			
			if(head == null && last == null) {
	    		lruCacheNode = new LRUCacheNode();
	    		lruCacheNode.key = key;
	    		lruCacheNode.value = value;
	    		lruCacheNode.before = null;
	    		lruCacheNode.after = null;
	    		head = lruCacheNode;
	    		last = lruCacheNode;
	    		nodeMap.put(key, lruCacheNode);
	    	} else {
	    		lruCacheNode = new LRUCacheNode();
	    		lruCacheNode.key = key;
	    		lruCacheNode.value = value;
	    		lruCacheNode.after = head;
	    		head.before = lruCacheNode;
	    		head = lruCacheNode;
	    		nodeMap.put(key, lruCacheNode);
	    	}
			
		} else {
			lruCacheNode.value = value;
			if(head != lruCacheNode) {
				if(last == lruCacheNode) {
					last = lruCacheNode.before;
					last.after = null;
				} else {
					lruCacheNode.before.after = lruCacheNode.after;
					lruCacheNode.after.before = lruCacheNode.before;
				}
				lruCacheNode.after = head;
				head.before = lruCacheNode;
				lruCacheNode.before = null;
				head = lruCacheNode;
			}
    	}
    }
    
    @Override
    public String toString() {
    	
    	StringBuilder sb = new StringBuilder();
    	if(head != null) {
    		LRUCacheNode t = head;
    		while(t != null) {
    			sb.append(t.key + ", " + t.value);
    			if(t != last) {
    				sb.append(" | ");
    			}
    			t = t.after;
    		}
    	}
    	
    	return sb.toString();
    }
    
}
