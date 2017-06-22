/*
	problem 122
	Say you have an array for which the ith element is the price of a given stock on day i.
	Design an algorithm to find the maximum profit. 
	You may complete as many transactions as you like 
	(ie, buy one and sell one share of the stock multiple times). 
	However, you may not engage in multiple transactions at the same time 
	(ie, you must sell the stock before you buy again).
*/

public class BestTimeToBuyAndSellStockII{
	public static void main(String[] args){
		int[] prices = new int[args.length];
		for(int i = 0, len = prices.length; i < len; i++){
			prices[i] = Integer.parseInt(args[i]);
		}
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int len;
		if(prices == null || (len = prices.length) < 2){
			return 0;
		}
		int totalProfit = 0, profit = 0;

		for(int i = 1, min = prices[0]; i < len; i++){
			int temp = prices[i] - min;
			if(temp > profit){
				profit = temp;
			}else{
				totalProfit += profit;
				profit = 0;
				min = prices[i];
			}
		}

		return totalProfit + profit;
	}

	public static int maxProfit2(int[] prices) {
		if(prices == null){
			return 0;
		}
		int totalProfit = 0;
		for(int i = 1, len = prices.length; i < len; i++){
			totalProfit += Math.max(prices[i] - prices[i - 1], 0);
		}

		return totalProfit;
	}
}