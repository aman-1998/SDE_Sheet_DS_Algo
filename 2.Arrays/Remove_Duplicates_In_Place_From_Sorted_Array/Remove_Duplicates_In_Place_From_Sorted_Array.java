
public class Remove_Duplicates_In_Place_From_Sorted_Array {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
		
		int newLength = removeDuplicatesInPlace_2nd_approach(arr);
		
		System.out.println("New Length: " + newLength);
		
		for(int i = 0; i < newLength; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	/*
	 * T = O(n) 
	 * S = O(1)
	 */
	private static int removeDuplicatesInPlace(int[] arr) {
		
		int i = 0;
		int j = 1;
		
		int n = arr.length;
		
		while(j < n) {
			if(arr[i] == arr[j]) {
				j++;
			} else {
				i++;
				arr[i] = arr[j];
				j++;
			}
		}
		
		return i+1;
	}
	
	/*
	 * Generic approach: Better
	 * T = O(n) 
	 * S = O(1)
	 */
	private static int removeDuplicatesInPlace_2nd_approach(int[] arr) {
		
		int n = arr.length;
		int i = 1;
		for(int j = i; j <= n-1; j++) {
			if(arr[i-1] != arr[j]) {
				arr[i] = arr[j];
				i++;
			}
		}
		
		return i;
	}
}
