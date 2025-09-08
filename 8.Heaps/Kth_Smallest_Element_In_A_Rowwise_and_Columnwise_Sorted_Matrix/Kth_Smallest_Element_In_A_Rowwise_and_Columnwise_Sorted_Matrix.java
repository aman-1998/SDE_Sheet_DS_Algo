package practice.dsa.sheet.part5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth_Smallest_Element_In_A_Rowwise_and_Columnwise_Sorted_Matrix {
	
	public static void main(String[] args) {
		
		int[][] mat = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
		int k = 8;
		
		int kthSmallest = kthSmallest_1st_Approach(mat, k);
		
		System.out.println(kthSmallest);
	}
	
	/*
	 * Using maxHeap : This approach is worst approach. This works only when m and n value is very small and also k is small
	 * 
	 * This approach works even if matrix is not sorted at all
	 * 
	 * T = O(k*log k) + O((m*n - k)*2*log k) 
	 * => T = O((2*m*n - k)*log k) 
	 * => T = O(m*n*log k)
	 * 
	 * S = O(k)
	 */
	public static int kthSmallest_1st_Approach(int[][] mat, int k) {
		
		int m = mat.length;
		int n = mat[0].length;
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				maxHeap.add(mat[i][j]);
				if(maxHeap.size() > k) {
					maxHeap.poll();
				}
			}
		}
		
		return maxHeap.peek();
	}
	
	/*
	 * Using MinHeap : This approach is better from smaller value of k
	 * In the question if it is given that k value is very small compared to m then use this approach.
	 * 
	 * This approach works only when matrix is row wise and column wise sorted
	 * 
	 * T = O((2k+m)*log m)
	 * if k value is very large then (given in question) => T = O(k*log m)
	 * S = O(m)
	 */
	public static int kthSmallest_2nd_Approach(int[][] mat, int k) {
		
		int m = mat.length;
		int n = mat[0].length;
		
		PriorityQueue<IndexRowInfo> minHeap = new PriorityQueue<>(Comparator.comparing(info -> mat[info.row][info.index]));
		
		for(int i = 0; i <= m-1; i++) { // T = O(m*log m)
			minHeap.add(new IndexRowInfo(i, 0));
		}
		
		int output = -1;
		int count = 0;
		while(!minHeap.isEmpty()) { // T = O(k*2*log m)
			IndexRowInfo info = minHeap.poll();
			count++;
			if(count == k) {
				output = mat[info.row][info.index];
				break;
			}
			
			if(info.index < n-1) {
				minHeap.add(new IndexRowInfo(info.row, info.index+1));
			}
		}
		
		return output;
	}
	
	/*
	 * Using binary search : This approach is better for larger value of k
	 * In the question if it is given that k value is very large compared to m and n then use this approach.
	 * 
	 * Note: Even if the mat is only row wise sorted still this approach works. Just we have to select max and min carefully.
	 * 
	 * T = O(log max-min) * O(m*log n)
	 * S = O(1)
	 */
	public static int kthSmallest_3rd_Approach(int[][] mat, int k) {
		
		int m = mat.length;
		int n = mat[0].length;
		
		int min = mat[0][0];
		int max = mat[m-1][n-1];
		
		int l = min;
		int r = max;
		
		int ans = Integer.MAX_VALUE;
		
		while(l <= r) {
			int mid = (l+r)/2;
			int count = countLessOrEqual(mat, mid);
			if(count >= k) {
				if(mid < ans) {
					ans = mid;
				}
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return ans;
	}
	
	/*
	 * T = O(m*log n)
	 */
	private static int countLessOrEqual(int[][] mat, int mid) {
		int m = mat.length;
		int sum = 0;
		for(int i = 0; i <= m-1; i++) {
			sum = sum + upperBound(mat[i], mid);
		}
		return sum;
	}
	
	/*
	 * T = O(log n)
	 */
	private static int upperBound(int[] arr, int target) {
		
		int n = arr.length;
		int l = 0;
		int r = n-1;
		int ans = n;
		
		while(l <= r) {
			int mid = (l+r)/2;
			if(arr[mid] > target) {
				if(mid < ans) {
					ans = mid;
				}
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return ans;
	}
}

class IndexRowInfo {
	
	public int row;
	public int index;
	
	public IndexRowInfo(int row, int index) {
		this.row = row;
		this.index = index;
	}
}
