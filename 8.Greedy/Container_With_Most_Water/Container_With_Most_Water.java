package algorithms;

public class Container_With_Most_Water {
	
	public static void main(String[] args) {
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		
		int maxArea = maxArea(height);
		
		System.out.println(maxArea);
	}
	
	/*
	 * Brute Force
	 * 
	 * T = O(n^2)
	 * S = O(1)
	 */
	public static int maxArea_BF(int[] arr) {
		
		int n = arr.length;
		int maxArea = 0;
		int tempMaxArea = 0;
		for(int i = 0; i <= n-1; i++) {
			for(int j = i+1; j <= n-1; j++) {
				int minHieght = Math.min(arr[i], arr[j]);
				int distance = j-i;
				tempMaxArea = minHieght * distance;
				if(tempMaxArea > maxArea) {
					maxArea = tempMaxArea;
				}
			}
		}
		
		return maxArea;
	}
	
	/*
	 * Optimal solution: Using two pointers
	 * 
	 * T = O(n)
	 * S = O(1)
	 */
	public static int maxArea(int[] arr) {
		
		int n = arr.length;
		int i = 0;
		int j = n-1;
		int maxArea = 0;
		int tempMaxArea = 0;
		while(i < j) {
			
			int minHeight = Math.min(arr[i], arr[j]);
			int distance = j - i;
			tempMaxArea = minHeight * distance;
			if(tempMaxArea > maxArea) {
				maxArea = tempMaxArea;
			}
			if(arr[i] <= arr[j]) {
				i++;
			} else {
				j--;
			}
		}
		
		return maxArea;
		
	}
}
