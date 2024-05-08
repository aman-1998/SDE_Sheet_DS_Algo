package algorithms.part2;

public class Search_In_Rotated_Sorted_Array_1 {
	
	public static void main(String[] args) {
		
		int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
		int target = 1;
		
		int index = search(arr, target);
		
		System.out.println(index);
	}
	
	/*
	 * T = O(log n)
	 * S = O(1)
	 */
	public static int search(int[] arr, int target) {
		
		int n = arr.length;
		int left = 0;
		int right = n-1;
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(arr[mid] == target) {
				return mid;
			} else {
				if(arr[left] > arr[mid]) { // Sorted from mid to right
					if(arr[mid] <= target && target <= arr[right]) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				} else { // Sorted from left to mid
					if(arr[left] <= target && target <= arr[mid]) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				}
			}
		}
		
		return -1;
	}
}
