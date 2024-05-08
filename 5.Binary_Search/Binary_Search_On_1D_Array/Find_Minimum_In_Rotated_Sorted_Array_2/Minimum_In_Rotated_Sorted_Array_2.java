package algorithms.part2;

public class Minimum_In_Rotated_Sorted_Array_2 {
	
	public static void main(String[] args) {
		
		//int[] arr = {4, 5, 6, 7, 8, 1, 2, 3};
		//int[] arr = {4, 5, 6, 7, 1, 2, 3};
		//int[] arr = {3, 1, 2, 3, 3, 3, 3};
		int[] arr = {4, 5, 6, 7, 3, 3, 3};
		
		int min = findMinInRotatedSortedArray(arr);
		
		System.out.println(min);
	}
	
	/*
	 * Average case: T = O(log n)
	 * Worst Case: T = O(n)
	 * S = O(1)
	 */
	public static int findMinInRotatedSortedArray(int[] arr) { 
        
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = n-1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(arr[left] == arr[mid] && arr[mid] == arr[right]) { // Can't decide which side is sorted
            	if(arr[mid] < min) {
            		min = arr[mid];
            	}
            	left++;
            	right--;
            } else if(arr[left] > arr[mid]) { // Sorted from mid to right
                if(arr[mid] < min) {
                    min = arr[mid];
                }
                right = mid - 1;
            } else { // Sorted from left to mid
                if(arr[left] < min) {
                    min = arr[left];
                }
                left = mid + 1;
            }
        }

        return min;
    }
	
	/*
	 * If we have both sides sorted (i.e., when left to right is sorted), at that time we can find minimum(arr[left], min) and then break 
	 * as no more binary search is required.
	 * 
	 * This is a very minor optimization which is not very important
	 * 
	 * Average case: T = O(log n)
	 * Worst Case: T = O(n)
	 * S = O(1)
	 */
	public static int findMinInRotatedSortedArray_Optimized(int[] arr) {
        
		int n = arr.length;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = n-1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(arr[left] == arr[mid] && arr[mid] == arr[right]) { // Can't decide which side is sorted
            	if(arr[mid] < min) {
            		min = arr[mid];
            	}
            	left++;
            	right--;
            } else if(arr[left] < arr[right]) { // Sorted from left to right
            	if(arr[left] < min) {
                    min = arr[left];
                }
            	break;
            } else if(arr[left] > arr[mid]) { // Sorted from mid to right
                if(arr[mid] < min) {
                    min = arr[mid];
                }
                right = mid - 1;
            } else { // Sorted from left to mid
                if(arr[left] < min) {
                    min = arr[left];
                }
                left = mid + 1;
            }
        }

        return min;
    }
}
