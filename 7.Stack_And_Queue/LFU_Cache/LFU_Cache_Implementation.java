package algorithms.part4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LFU_Cache_Implementation {
	
	public static void main(String[] args) {
		
		LFUCache lfuCache = new LFUCache(2);
		
		lfuCache.put(1, 1);
		
		lfuCache.display();
		
		lfuCache.put(2, 2);
		
		lfuCache.display();
		
		System.out.println(lfuCache.get(1));
		
		lfuCache.display();
		
		lfuCache.put(3, 3);
		
		lfuCache.display();
		
		System.out.println(lfuCache.get(2));
		
		lfuCache.display();
		
		System.out.println(lfuCache.get(3));
		
		lfuCache.display();
		
		lfuCache.put(4, 4);
		
		lfuCache.display();
		
		System.out.println(lfuCache.get(1));
		
		lfuCache.display();
		
		System.out.println(lfuCache.get(3));
		
		lfuCache.display();
		
		System.out.println(lfuCache.get(4));
		
		lfuCache.display();
		
		System.out.println(lfuCache.get(4));
		
		lfuCache.display();
		
		lfuCache.put(5, 5);
		
		lfuCache.display();
	}
}

class CacheNode {
	
	public int key;
	
	public int value;
	
	public int count;
	
	public CacheNode before;
	
	public CacheNode after;
}

class LRUCache1 {
	
	public CacheNode head = null;
	
	public CacheNode last = null;
	
	public int noOfLements = 0;
	
}

class LFUCache {
	
	// freq, LRUCache
	Map<Integer, LRUCache1> freqMap = new HashMap<>();
	
	// key, NodeAddress
	Map<Integer, CacheNode> lfuNodeMap = new HashMap<>();
	
	int minFreq = 0;
	
	int capacity = 0;
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
		
		if(capacity == 0) {
    		return -1;
    	}
		
		CacheNode cacheNode = lfuNodeMap.get(key);
    	
    	if(cacheNode != null) {
    		
    		LRUCache1 lruCache = freqMap.get(cacheNode.count);
			
			if(lruCache.noOfLements == 1) {
       	 	    freqMap.remove(cacheNode.count);
       	 	    if(minFreq == cacheNode.count) {
	 	    		minFreq++; 
	 	    	}
       	 	    
			} else if(lruCache.head == cacheNode) {
				lruCache.head = cacheNode.after;
				lruCache.head.before = null;
				
			} else if(lruCache.last == cacheNode) {
				lruCache.last = cacheNode.before;
				lruCache.last.after = null;
				
			} else {
				cacheNode.before.after = cacheNode.after;
				cacheNode.after.before = cacheNode.before;
			}
			
			lruCache.noOfLements--;
			cacheNode.count++;
   	 	    LRUCache1 nextLruCache = freqMap.get(cacheNode.count);
   	 	    if(nextLruCache == null) {
   	 	    	nextLruCache = new LRUCache1();
				cacheNode.before = null;
				cacheNode.after = null;
				nextLruCache.head = cacheNode;
				nextLruCache.last = cacheNode;
				nextLruCache.noOfLements = 1;
				freqMap.put(cacheNode.count, nextLruCache);
   	 	    } else {
	    		cacheNode.after = nextLruCache.head;
	    		nextLruCache.head.before = cacheNode;
	    		nextLruCache.head = cacheNode;
	    		nextLruCache.noOfLements++;
   	 	    }
   	 	    
   	 	    return cacheNode.value;
    	}
		
		return -1;
	}
	
	public void put(int key, int value) {
		
		if(capacity == 0) {
			return;
		}
		
		CacheNode cacheNode = lfuNodeMap.get(key);
		
		if(cacheNode == null) {
			
			if(lfuNodeMap.size() == capacity){
				
				LRUCache1 lruCache = freqMap.get(minFreq);
				
           	 	if(lruCache.noOfLements == 1) {
           	 	    lfuNodeMap.remove(lruCache.last.key);
           	 	    freqMap.remove(lruCache.last.count);
					
				} else {
					lfuNodeMap.remove(lruCache.last.key);
					lruCache.last = lruCache.last.before;
					lruCache.last.after = null;
           	 	    lruCache.noOfLements--;
				} 
			}
			
			minFreq = 1;
			LRUCache1 lruCache = freqMap.get(minFreq);
			if(lruCache == null) {
				lruCache = new LRUCache1();
				cacheNode = new CacheNode();
				cacheNode.key = key;
				cacheNode.value = value;
				cacheNode.before = null;
				cacheNode.after = null;
				cacheNode.count = minFreq;
				lruCache.head = cacheNode;
				lruCache.last = cacheNode;
				lruCache.noOfLements = 1;
				lfuNodeMap.put(key, cacheNode);
				freqMap.put(minFreq, lruCache);
			} else {
				cacheNode = new CacheNode();
	    		cacheNode.key = key;
	    		cacheNode.value = value;
	    		cacheNode.count = minFreq;
	    		cacheNode.after = lruCache.head;
	    		lruCache.head.before = cacheNode;
	    		lruCache.head = cacheNode;
	    		lruCache.noOfLements++;
	    		
	    		lfuNodeMap.put(key, cacheNode);
			}
			
		} else {
			
			LRUCache1 lruCache = freqMap.get(cacheNode.count);
			
			if(lruCache.noOfLements == 1) {
       	 	    freqMap.remove(cacheNode.count);
       	 	    if(minFreq == cacheNode.count) {
	 	    		minFreq++; 
	 	    	}
       	 	    
			} else if(lruCache.head == cacheNode) {
				lruCache.head = cacheNode.after;
				lruCache.head.before = null;
				
			} else if(lruCache.last == cacheNode) {
				lruCache.last = cacheNode.before;
				lruCache.last.after = null;
				
			} else {
				cacheNode.before.after = cacheNode.after;
				cacheNode.after.before = cacheNode.before;
			}
			
			lruCache.noOfLements--;
			cacheNode.value = value;
			cacheNode.count++;
   	 	    LRUCache1 nextLruCache = freqMap.get(cacheNode.count);
   	 	    if(nextLruCache == null) {
   	 	    	nextLruCache = new LRUCache1();
				cacheNode.before = null;
				cacheNode.after = null;
				nextLruCache.head = cacheNode;
				nextLruCache.last = cacheNode;
				nextLruCache.noOfLements = 1;
				freqMap.put(cacheNode.count, nextLruCache);
   	 	    } else {
	    		cacheNode.after = nextLruCache.head;
	    		nextLruCache.head.before = cacheNode;
	    		nextLruCache.head = cacheNode;
	    		nextLruCache.noOfLements++;
   	 	    }
		}
	}
	
    public void display() {
		
    	System.out.println("------------------------------------------------------------------------------");
    	
		Iterator<Map.Entry<Integer, LRUCache1>> ite = freqMap.entrySet().iterator();
		while(ite.hasNext()) {
			Map.Entry<Integer, LRUCache1> entry = ite.next();
			System.out.print(entry.getKey() + " (no. of elements = "+ entry.getValue().noOfLements + ") -> ");
			CacheNode t = entry.getValue().head;
			while(t != null) {
				System.out.print("(" + t.key + ", " + t.value + " : freq = " + t.count + ")");
				if(t != entry.getValue().last) {
					System.out.print(" | ");
				}
				t = t.after;
			}
			System.out.println();
		}
		
		System.out.println("------------------------------------------------------------------------------");
    }
}
