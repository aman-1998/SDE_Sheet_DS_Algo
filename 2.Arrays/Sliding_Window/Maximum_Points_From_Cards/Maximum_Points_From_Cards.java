package algorithms;

public class Maximum_Points_From_Cards {
	
	public static void main(String[] args) {
		
		//int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
		//int k = 3;
		
		int[] cardPoints = {6, 2, 3, 4, 7, 2, 1, 7, 1};
		int k = 4;
		
		int maxscore = maxScore(cardPoints, k);
		
		System.out.println(maxscore);
	}
	
	public static int maxScore(int[] arr, int k) {
		
		int n = arr.length;
		
		int leftSum = 0;
		int rightSum = 0;
		
		for(int i = 0; i <= k-1; i++) {
			leftSum = leftSum + arr[i];
		}
		
		int maxScore = leftSum;
		
		int rightIndex = n-1;
		for(int i = k-1; i >=0; i--) {
			leftSum = leftSum - arr[i];
			rightSum = rightSum + arr[rightIndex];
			rightIndex--;
			
			if(leftSum + rightSum > maxScore) {
				maxScore = leftSum + rightSum;
			}
		}
		
		return maxScore;
	}
}
