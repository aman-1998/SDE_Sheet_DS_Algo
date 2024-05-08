package algorithms.part2;

public class Binary_Search_FromIndex_ToIndex {
	
	public static void main(String[] args) {
		
		int[] arr = {3, 5, 7, 10, 12, 16, 20, 24, 27, 30, 34, 38, 40, 41, 45, 55, 59};
		int n = arr.length;
		int target = 38;
		//int target = 35;
		
		int index = binarySeach(arr, 0, n-1, target);
		
		System.out.println(target + " found at " + index);
	}
	
	/*
	 * T = O(log n)
	 * S = O(1)
	 */
	public static int binarySeach(int[] arr, int fromIndex, int toIndex, int target) {
		
		int left = fromIndex;
		int right = toIndex;
		
		while(left <= right) {
			
			int mid = (left + right)/2;
			
			if(arr[mid] < target) {
				left = mid + 1;
			} else if(arr[mid] > target) {
				right = mid - 1 ;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
}
