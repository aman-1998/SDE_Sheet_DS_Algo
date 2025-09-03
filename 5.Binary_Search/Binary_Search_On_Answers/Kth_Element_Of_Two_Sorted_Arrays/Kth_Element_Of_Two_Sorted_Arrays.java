package algorithms.part2;

public class Kth_Element_Of_Two_Sorted_Arrays {
	
public static void main(String[] args) {
		
		int[] arr1 = {1, 3, 4, 7, 10, 12};
		
		int[] arr2 = {2, 3, 6, 15};
		
		int k = 4;
		
		int ans = kthElementInTwoSortedArrays(arr1, arr2, k);
		
		System.out.println("kth element of two sorted array = " + ans);
	}
	
	/*
	 * T = O(log(min(m,n))) or T = O(min(log m, log n))
	 * S = O(1)
	 */
	private static int kthElementInTwoSortedArrays(int[] arr1, int[] arr2, int k) {
		
		// code here
        int n1 = arr1.length;
		int n2 = arr2.length;
		int n = n1 + n2;
		
		if(n < k) {
			return -1;
		}
		
		if(n1 > n2) {
			return kthElementInTwoSortedArrays(arr2, arr1, k);
		}
		int leftArrSize = k;
		int l = Math.max(0, k-n2);
		int r = Math.min(k, n1);
		
		/*
		if(n2 >= k) {
			l = 0;
		} else {
			l = k - n2;
		}
		
		if(n1 >= k) {
			r = k;
		} else {
			r = n1;
		}*/
		
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
				return Math.max(l1, l2);
			} else if(l2 > r1) {
				l = mid1 + 1;
			} else if(l1 > r2) {
				r = mid1 - 1;
			}
		}
		
		return -1;
	}
}
