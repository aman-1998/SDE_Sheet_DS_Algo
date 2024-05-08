package algorithms.part2;

public class Find_Out_How_Many_Times_Has_An_Array_Been_Rotated {
	
	public static void main(String[] args) {
		
		int[] arr = {3, 4, 5, 1, 2};
		
		int k = findKRotation(arr);
		
		System.out.println("Number of rotations = " + k);
	}
	
	/*
	 * T = O(log n)
	 * S = O(1)
	 */
	public static int findKRotation(int []arr){

        return findIndexOfMin(arr);
    }

    public static int findIndexOfMin(int []arr){
        
        int  n = arr.length;
        int left = 0;
        int right = n-1;
        int min = Integer.MAX_VALUE;
        int index = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[left] <= arr[right]) { // Left to right is sorted
                if(arr[left] < min) {
                    min = arr[left];
                    index = left;
                }
                break;
            } else if(arr[left] > arr[mid]) { // mid to right is sorted
                if(arr[mid] < min) {
                    min = arr[mid];
                    index = mid;
                }
                right = mid - 1;
            } else { // left to mid is sorted
                if(arr[left] < min) {
                    min = arr[left];
                    index = left;
                }
                left = mid + 1;
            }
        }

        return index;
    }
}
