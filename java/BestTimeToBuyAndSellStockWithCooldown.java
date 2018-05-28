/*
	problem 309
	Say you have an array for which the ith element is the price of a given stock on day i.
	Design an algorithm to find the maximum profit.
	You may complete as many transactions as you like
	(ie, buy one and sell one share of the stock multiple times) with the following restrictions:
	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
	Example:
		Input: [1,2,3,0,2]
		Output: 3
		Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/

public class BestTimeToBuyAndSellStockWithCooldown {
	// public int maxProfit2(int[] prices) {
	// 	int[] dp = new int[prices.length];
	// 	if (prices.length > 0) dp[0] = 0;
	// 	if (prices.length > 1) dp[1] = Math.max(0, prices[1] - prices[0]);
	// 	if (prices.length > 2) dp[2] = Math.max(0, Math.max(prices[2] - prices[1], prices[2] - prices[0]));
	// 	if (prices.length > 3) dp[3] = Math.max(0, Math.max(prices[3] - prices[2], prices[3] - prices[1]));

	// 	for (int i = 4; i < prices.length; i++) {
			  
	// 	}
	// }


	public int maxProfit2(int[] prices) {
		return maxProfit(prices, false, 0, 0, 0);
	}
	private int maxProfit(int[] prices, boolean hasStock, int price, int currentProfit, int index) {
		if (index >= prices.length) {
			return currentProfit;
		}
		int maxProfit = 0;

		if (hasStock) {
			if (price < prices[index]) {
				maxProfit = maxProfit(prices, false, price, currentProfit + prices[index] - price, index + 2);
			}
		} else {
			maxProfit = maxProfit(prices, true, prices[index], currentProfit, index + 1);
		}

		return Math.max(maxProfit, maxProfit(prices, hasStock, price, currentProfit, index + 1));
	}
}