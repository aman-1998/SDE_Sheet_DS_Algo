import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class K_Max_Sum_Combinations {
	
	public static void main(String[] args) {
		
		int[] arr1 = {3, 4, 5};
		int[] arr2 = {2, 6, 3};
		int k = 2;
		
		/*
		(5,6) (5,3) (5,2)
		(4,6) (4,3) (4,2)
		(3,6) (3,3) (3,2)
		*/
		
		int[] output = kMaxSumCombination_2nd(arr1, arr2, k);
		
		Arrays.stream(output).boxed().forEach(sum -> System.out.println(sum));
	}
	
	/*
	 * It is similar to the problem "K_Pairs_With_Smallest_Sums". We just have to find largest k pairs
	 * 
	 * min = min(m, k)
	 * 
	 * T = O(m*log m) + O(n*log n) + O(min*log min) + O(k*log min)
	 * 
	 * if m == n
	 * => T = O(2*n*log n) + O(k*log min)
	 * 
	 * S = O(min)
	 */
	public static int[] kMaxSumCombination(int [] arr1, int [] arr2, int k){
		
		int m = arr1.length;
		int n = arr2.length;
		
		Arrays.sort(arr1); // T = O(m*log m)
		Arrays.sort(arr2); // T = O(n*log n)
		
		PriorityQueue<IndexNode> maxHeap = new PriorityQueue<>(Comparator.comparing((IndexNode node) -> arr1[node.arr1Index] + arr2[node.arr2Index]).reversed());
		
		int min = Integer.MAX_VALUE;
		if(k < m) {
			min = k;
		} else {
			min = m;
		}
		
		for(int i = n-1; i >= n-1-min; i--) { // T = O(min*log min) 
			maxHeap.add(new IndexNode(i, n-1));
		}
		// heapSize = min(m, k) = min
		 
		int[] output = new int[k];
		int i = 0;
		while(!maxHeap.isEmpty()) { // T = O(k*2*log min) 
			IndexNode deleted = maxHeap.poll();
			output[i] = arr1[deleted.arr1Index] + arr2[deleted.arr2Index];
			i++;
			if(i == k) {
				break;
			}
			
			if(deleted.arr2Index > 0) {
				IndexNode toBeAdded = new IndexNode(deleted.arr1Index, deleted.arr2Index - 1);
				maxHeap.add(toBeAdded);
			}
		}
		
		return output;
	}

	// Better than above solution
	public static int[] kMaxSumCombination_2nd(int[] arr1, int[] arr2, int k) {
	
		int m = arr1.length;
		int n = arr2.length;

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(Comparator.comparing((List<Integer> list) -> arr1[list.get(0)] + arr2[list.get(1)]).reversed());
		
		int min = Integer.MAX_VALUE;
		if(k < m) {
			min = k;
		} else {
			min = m;
		}
		
		for(int i = m-1; i >= m-min; i--) {
			maxHeap.add(Arrays.asList(i, n-1));
		}
		
		int[] output = new int[k];
		int i = 0;
		
		while(!maxHeap.isEmpty()) {
			List<Integer> deleted = maxHeap.poll();
			output[i] = arr1[deleted.get(0)] + arr2[deleted.get(1)];
			i++;
			if(i == k) {
				break;
			}
			
			if(deleted.get(1) > 0) {
				maxHeap.add(Arrays.asList(deleted.get(0), deleted.get(1)-1));
			}
		}
		
		return output;
	}
}

class IndexNode {
	
	public int arr1Index;
	
	public int arr2Index;
	
	public IndexNode(int arr1Index, int arr2Index) {
		this.arr1Index = arr1Index;
		this.arr2Index = arr2Index;
	}

	@Override
	public String toString() {
		return "(" + arr1Index + ", " + arr2Index + ")";
	}
}
