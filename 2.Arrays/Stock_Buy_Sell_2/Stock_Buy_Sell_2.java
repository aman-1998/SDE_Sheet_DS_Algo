package algorithms;

public class Stock_Buy_Sell_2 {
	
	public static void main(String[] args) {
		
		int[] arr = {5, 2, 7, 3, 6, 1, 2, 4};
		
		int maximumProfit = maxProfit(arr);
		
		System.out.println("Maximum profit: " + maximumProfit);
	}
	
	public static int maxProfit(int[] arr) {
		
		int n = arr.length;
        int profit = 0;
        for(int i = 1; i <= n-1; i++) {
            if(arr[i] > arr[i-1]) {
                profit = profit + (arr[i] - arr[i-1]);
            }
        }

        return profit;
	}
}
