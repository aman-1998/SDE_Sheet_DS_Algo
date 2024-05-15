package algorithms.part2;

public class Find_Peak_Element {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 10, 13, 7, 6, 5, 4, 2, 1, 0};
		
		int peakIndex = findPeakElement_index(arr);
		
		System.out.println(peakIndex);
	}
	
	/*
	 * T = O(log n)
	 * S = O(1)
	 */
	public static int findPeakElement_index(int[] arr) {

        int n = arr.length;
		
		if(n == 1) {
			return 0;
		}
		if(arr[0] > arr[1]) {
			return 0;
		}
		if(arr[n-1] > arr[n-2]) {
			return n-1;
		}
		
		int left = 1;
		int right = n-2;
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
				return mid;
			} else {
				if(arr[mid] > arr[mid-1]) {
					left = mid + 1;
				} else if(arr[mid] < arr[mid-1]) {
					right = mid - 1;
				} else {
					left = mid + 1; // or right = mid - 1;
				}
			}
		}
		
		return -1;
    }
}
