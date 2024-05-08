package algorithms.part2;

public class Lower_Bound {
	
	public static void main(String[] args) {
		
		int[] arr = {3, 5, 7, 10, 12, 16, 20, 24, 27, 30, 34, 38, 40, 41, 45, 55, 59};
		int n = arr.length;
		//int target = 38;
		int target = 22;
		
		int index = lowerBound(arr, target);
		
		System.out.println(index);
	}
	
	/*
	 * Finding smallest 'index' such that arr[index] >= target
	 * 
	 * T = O(log n)
	 * S = O(1)
	 */
	public static int lowerBound(int[] arr, int target) {
		
		int n = arr.length;
		int left = 0;
		int right = n-1;
		
		int index = n;
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(arr[mid] >= target) {
				if(mid < index) {
					index = mid;
				}
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		
		return index;
	}
}
