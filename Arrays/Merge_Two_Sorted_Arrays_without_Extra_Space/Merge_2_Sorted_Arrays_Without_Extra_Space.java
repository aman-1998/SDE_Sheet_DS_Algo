package algorithms;

import java.util.Arrays;

public class Merge_2_Sorted_Arrays_Without_Extra_Space {
	public static void main(String[] args) {
		int[] left = {0, 4, 7, 10, 15};
		int[] right = {2, 5, 8, 9, 11, 13};
		
		//int[] left = {2};
		//int[] right = {1};
		
		mergeTwoSortedArrays(left, right);
	}
	
	/*
	 * T = O(min(m, n)) + O(mlog m) + O(nlog n)
	 * S = O(1)
	 */
	public static void mergeTwoSortedArrays(int[] left, int[] right) {
		
		int m = left.length;
		int n = right.length;
		
		int i = m-1;
		int j = 0;
		
		// O(min(m,n))
		while(i >= 0 && j < n) {
			if(left[i] > right[j]) {
				// swap(left[i], right[j])
				int temp = left[i];
				left[i] = right[j];
				right[j] = temp;
			}
			i--;
			j++;
		}
		
		Arrays.sort(left); // O(mlog m)
		Arrays.sort(right); // O(nlog n)
		
		for(int k = 0; k < m+n; k++) {
			if(k < m) {
				System.out.print(left[k] + " ");
			} else {
				System.out.print(right[k - m] + " ");
			}
		}
	}
}


// LeetCode version of the same question
/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1~,2~,2,3~,5,6] with the underlined(tidle) elements coming from nums1.
							
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109

 */
class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] left = nums1;
        int[] right = nums2;
        
		int i = m-1;
		int j = 0;
				
		// O(min(m,n))
		while(i >= 0 && j < n) {
			if(left[i] > right[j]) {
				// swap(left[i], right[j])
				int temp = left[i];
				left[i] = right[j];
				right[j] = temp;
			}
			i--;
			j++;
		}
		
		Arrays.sort(left, 0, m); // Sort from 0 to m because after m there may b zeroes
		Arrays.sort(right);
		
		for(int k = m; k < m+n; k++) {
			left[k] = right[k - m];
		}
    }
}
