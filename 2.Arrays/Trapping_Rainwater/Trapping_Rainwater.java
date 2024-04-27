package algorithms;

public class Trapping_Rainwater {
	
	public static void main(String[] args) {
		int[] arr = {0, 2, 3, 0, 1, 2, 4, 3, 0, 2, 3, 1, 1, 2};
		int trappedWater = trappedRainWater(arr);
		System.out.println(arr);
	}
	
	public static int trappedRainWater(int[] arr) {
		
		int n = arr.length;
		int[] left = new int[n];
		int[] right = new int[n];
		
		int maxSofar = Integer.MIN_VALUE;
		for(int i = 0; i <= n-1; i++) {
			if(arr[i] > maxSofar) {
				maxSofar = arr[i];
			}
			left[i] = maxSofar;
		}
		
		maxSofar = Integer.MIN_VALUE;
		for(int i = n-1; i >= 0; i--) {
			if(arr[i] > maxSofar) {
				maxSofar = arr[i];
			}
			right[i] = maxSofar;
		}
		
		int sum = 0;
		for(int i = 0; i <= n-1; i++) {
			sum = sum + (Math.min(left[i], right[i]) - arr[i]);
		}
		
		return sum;
	}
}
