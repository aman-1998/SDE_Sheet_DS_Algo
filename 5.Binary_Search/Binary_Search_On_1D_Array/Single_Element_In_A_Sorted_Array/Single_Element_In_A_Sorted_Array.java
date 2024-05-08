package algorithms.part2;

public class Single_Element_In_A_Sorted_Array {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
		
		int single = singleElement(arr);
		
		System.out.println(single);
	}
	
	/*
	 * T = O(log n)
	 * S = O(1)
	 */
	public static int singleElement(int[] arr) {
		
		int n = arr.length;
		
		if(n==1) {
			return arr[0];
		}
		if(arr[0] != arr[1]) {
			return arr[0];
		}
		if(arr[n-1] != arr[n-2]) {
			return arr[n-1];
		}
		
		int left = 1;
		int right = n-2;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) {
				return arr[mid];
			} else {
				// That means we are at left of the required element. So, trim down left half
				if((mid % 2 == 0 && arr[mid] == arr[mid+1])
						|| (mid % 2 != 0 && arr[mid] == arr[mid-1])) {
					left = mid + 1;
				} else {  // That means we are at right of the required element. So, trim down right half
					right = mid - 1;
				}
			}
		}
		
		return -1;
	}
}
