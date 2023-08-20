package algorithms;

public class Count_Inversion_Pairs_In_Array {
	
	public static int countInversionPair = 0;
	
	public static void main(String[] args) {
		int[] arr = {9, 3, 7, 1, 1, 5, 8};
		System.out.println(countInversionPairs(arr));
	}
	
	public static int countInversionPairs(int[] arr) {
		
		int n = arr.length; // size of array
		
		arr = mergeSort(arr, 0, n-1);
		return countInversionPair;
	}
	
	public static int[] mergeSort(int[] arr, int p, int r) {
		int q = (p+r)/2;
		if(p < r) {
			arr = mergeSort(arr, p, q);
			arr = mergeSort(arr, q+1, r);
			arr = merge(arr, p, q, r);
		}
		return arr;
	}
	
	public static int[] merge(int[] arr, int p, int q, int r) {
		
		int[] mergedArray = new int[r-p+1];
		int i = p;
		int j = q+1;
		
		for(int k = 0; k < r-p+1; k++) {
			
			if(i == q+1 && j <= r) {
				mergedArray[k] = arr[j];
				j++;
				continue;
			} else if(j == r+1 && i <= q) {
				mergedArray[k] = arr[i];
				i++;
				continue;
			} else if(i <= q && j <= r) {
				if(arr[i] <= arr[j]) {
					mergedArray[k] = arr[i];
					i++;
				} else {
					countInversionPair = countInversionPair + (q - i + 1);
					mergedArray[k] = arr[j];
					j++;
				}
			} else {
				break;
			}
		}
		
		for(int k = 0; k < r-p+1; k++) {
			arr[k+p] = mergedArray[k];
		}
		
		return arr;
	}
}
