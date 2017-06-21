/*
	problem 121
	Say you have an array for which the ith element is the price of a given stock on day i.
	If you were only permitted to complete at most one transaction 
	(ie, buy one and sell one share of the stock), 
	design an algorithm to find the maximum profit.
	Example 1:
	Input: [7, 1, 5, 3, 6, 4]
	Output: 5
	max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
	Example 2:
	Input: [7, 6, 4, 3, 1]
	Output: 0
	In this case, no transaction is done, i.e. max profit = 0.
*/

public class BestTimeToBuyAndSellStock{
	public static void main(String[] args){
		int[] prices = new int[args.length];
		for(int i = 0, len = prices.length; i < len; i++){
			prices[i] = Integer.parseInt(args[i]);
		}
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		if(prices.length == 0){
			return 0;
		}
		final int LEN = prices.length - 1;
		int maxProfit = 0, min = prices[0];
		for(int i = 0; i < LEN; i++){
			if(prices[i] > prices[i + 1]){
				maxProfit = Math.max(maxProfit, prices[i] - min);
				min = Math.min(prices[i + 1], min);
			}
		}
		maxProfit = Math.max(maxProfit, prices[LEN] - min);
		return maxProfit > 0 ? maxProfit : 0;
	}
	public int maxProfit2(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}		
		int max = 0;
		int sofarMin = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > sofarMin) {
				max = Math.max(max, prices[i] - sofarMin);
			} else{
				sofarMin = prices[i];  
		 	}
		}	     
		return max;
    }
}