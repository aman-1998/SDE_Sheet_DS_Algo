package algorithms;

public class Remove_Duplicates_In_Place_From_Sorted_Array {
	
	public static void main(String[] args) {
		
	}
	
	public static int removeDuplicatesInPlace(int[] arr) {
		
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
}
