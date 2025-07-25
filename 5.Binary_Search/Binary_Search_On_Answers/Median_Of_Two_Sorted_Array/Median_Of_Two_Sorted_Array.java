package algorithms.part2;

public class Median_Of_Two_Sorted_Array {
	
	public static void main(String[] args) {
		
		int[] arr1 = {1, 3, 4, 7, 10, 12};
		
		int[] arr2 = {2, 3, 6, 15};
		
		double median = findMedianSortedArrays(arr1, arr2);
		
		System.out.println("Median = " + median);
	}
	
	/*
	 * T = O(log(min(m,n))) or T = O(min(log m, log n))
	 * S = O(1)
	 */
	private static double findMedianSortedArrays(int[] arr1, int[] arr2) {
		
		int n1 = arr1.length;
		int n2 = arr2.length;
		int n = n1 + n2;
		if(n1 > n2) {
			return findMedianSortedArrays(arr2, arr1);
		}
		int leftArrSize = (n1 + n2 + 1)/2;
		int l = 0;
		int r = n1;
		
		while(l <= r) {
			int mid1 = (l+r)/2;
			int mid2 = leftArrSize - mid1;
			int l1,l2,r1,r2;
			if(mid1 - 1 < 0) {
				l1 = Integer.MIN_VALUE;
			} else {
				l1 = arr1[mid1 - 1];
			}
			
			if(mid2 - 1 < 0) {
				l2 = Integer.MIN_VALUE;
			} else {
				l2 = arr2[mid2 - 1];
			}
			
			if(mid1 >= n1) {
				r1 = Integer.MAX_VALUE;
			} else {
				r1 = arr1[mid1];
			}
			
			if(mid2 >= n2) {
				r2 = Integer.MAX_VALUE;
			} else {
				r2 = arr2[mid2];
			}
			
			if(l1 <= r2 && l2 <= r1) {
				if(n % 2 == 0) {
					return ((double)Math.max(l1, l2) + (double)Math.min(r1, r2)) / 2.0;
				} else {
					return (double)Math.max(l1, l2);
				}
			} else if(l2 > r1) {
				l = mid1 + 1;
			} else if(l1 > r2) {
				r = mid1 - 1;
			}
		}
		
		return 0;
	}
}
