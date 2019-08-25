/*
	121. Best Time to Buy and Sell Stock
	Say you have an array for which the ith element is the price of a given stock on day i.
	If you were only permitted to complete at most one transaction 
	(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
	Note that you cannot sell a stock before you buy one.
	Example 1:
		Input: [7,1,5,3,6,4]
		Output: 5
		Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
					Not 7-1 = 6, as selling price needs to be larger than buying price.
	Example 2:
		Input: [7,6,4,3,1]
		Output: 0
		Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

package main

import ( "fmt" ) 

func main() {
	fmt.Println(maxProfit([]int{2,7,11,15}))
}

func maxProfit(prices []int) int {
	if prices == nil || len(prices) <= 1{
		return 0
	}

	maxProfit := 0
	smallest := prices[0]

	for i, len := 1, len(prices); i < len; i++ {
		if prices[i] < smallest {
			smallest = prices[i]
		} else {
			maxProfit = max(maxProfit, prices[i] - smallest)
		}
	}

	return maxProfit
}

func max(n1, n2 int) int {
	if n1 > n2 {
		return n1
	}else{
		return n2
	}
}