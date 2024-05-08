package algorithms.part2;

public class Search_In_Rotated_Sorted_Array_2 {
	
	public static void main(String[] args) {
		
		//int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
		//int target = 1;
		
		int[] arr = {3, 1, 2, 3, 3, 3, 3};
		int target = 2;
		
		boolean check = search(arr, target);
		
		System.out.println(check);
	}
	
	/*
	 * Average case: T = O(log n)
	 * Worst Case: T = O(n)
	 * S = O(1)
	 */
	public static boolean search(int[] arr, int target) {
		
		int n = arr.length;
		int left = 0;
		int right = n-1;
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(arr[mid] == target) {
				return true;
			} else {
				if(arr[left] == arr[mid] && arr[mid] == arr[right]) { // Can't decide which side is sorted
					left++;
					right--;
				} else if(arr[left] > arr[mid]) { // Sorted from mid to right
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
		
		return false;
	}
}
