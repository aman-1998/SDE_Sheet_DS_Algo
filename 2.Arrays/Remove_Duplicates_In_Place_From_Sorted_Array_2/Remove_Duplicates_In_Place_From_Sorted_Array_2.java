package algorithms;

public class Remove_Duplicates_In_Place_From_Sorted_Array_2 {
	
	public static void main(String[] args) {
		
		int[] arr = {0,0,1,1,1,1,2,3,3};
		
		int k = removeDuplicates(arr);
		
		System.out.println(k);
	}
	
	public static int removeDuplicates(int[] arr) {
        
        int n = arr.length;
        int i = 0;
        for(int j = 0; j < n; j++) {
            if(i<2 || arr[j] != arr[i-2]) {
                arr[i] = arr[j];
                i++;
            }
        }

        return i;
    }
}
