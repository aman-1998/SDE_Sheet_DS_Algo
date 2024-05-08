package algorithms.part2;

public class Frequency_Of_An_Element_In_Sorted_Array {
	
	public static void main(String[] args) {
		
		//int[] arr = {1, 3, 5, 9, 9, 9, 10, 13, 15};
		//int target = 9;
		
		int[] arr = {1, 3, 5, 9, 9, 9, 10, 13, 15};
		int target = 8;
		
		int frequency = count(arr, target);
		
		System.out.println("Frequency of " + target + " is " + frequency);
	}
	
	public static int count(int arr[], int target) {
        
        int[] range = searchRange(arr, target);

        if(range[0] == -1) {
            return 0;
        }
        
        return range[1] - range[0] + 1;
    }
	
	public static int[] searchRange(int[] arr, int target) {
        
        int n = arr.length;
        int firstPosition = lowerBound(arr, target);

        if(firstPosition == n || arr[firstPosition] != target) {
            return new int[] {-1, -1};
        }

        int lastPosition = upperBound(arr, target) - 1;

        return new int[] {firstPosition, lastPosition};
    }

    public static int lowerBound(int[] arr, int target) {

        int n = arr.length;
        int left = 0;
        int right = n-1;
        int index = n;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                if(mid < index) {
                    index = mid;
                } 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

    public static int upperBound(int[] arr, int target) {

        int n = arr.length;
        int left = 0;
        int right = n-1;
        int index = n;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] > target) {
                if(mid < index) {
                    index = mid;
                } 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }
}
