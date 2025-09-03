package algorithms;

public class Count_Max_Consecutive_Ones_In_Array {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1};
		
		int count = findMaxConsecutiveOnes(arr);
		
		System.out.println(count);
	}
	
	public static int findMaxConsecutiveOnes(int[] arr) {
        
        int maxConsecutiveOnes = 0;
        int count = 0;
        for(int i = 0; i <= arr.length-1; i++) {
            if(arr[i] == 1) {
                count++;
                if(count > maxConsecutiveOnes) {
                    maxConsecutiveOnes = count;
                }
            } else {
                count = 0;
            }
        }

        return maxConsecutiveOnes;
    }
}
