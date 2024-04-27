package algorithms;

public class Find_Pivot_Index {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 7, 3, 6, 5, 6};
		
		/*
		 * Brute Force : For every elements we will check can it be a pivot element or not by 
		 * iterating over the array using i.
		 * 
		 * T = O(n^2)
		 * S = O(1)
		 * 
		 * But optimal solution will take T = O(n) and S = O(1)
		 * 
		 */
		int pivot = pivotIndex(arr);
		
		System.out.println("Pivot index : " + pivot);
	}
	
	/*
	 * T = O(2n) = O(n)
	 * S = O(1)
	 */
	public static int pivotIndex(int[] arr) {
		
		int n = arr.length;
        int totalSum = 0;
        for(int i = 0; i <= n-1; i++) {
            totalSum = totalSum + arr[i];
        }

        int sumLeft = 0;
        for(int i = 0; i <= n-1; i++) {
            int sumRight = totalSum - sumLeft - arr[i];
            if(sumLeft == sumRight) {
                return i;
            }
            sumLeft = sumLeft + arr[i]; 
        }

        return -1;
	}
}
