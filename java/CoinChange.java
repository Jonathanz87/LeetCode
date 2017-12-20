/*
	problem 322
	You are given coins of different denominations and a total amount of money amount.
	Write a function to compute the fewest number of coins that you need to make up that amount.
	If that amount of money cannot be made up by any combination of the coins, return -1.
	Example 1:
		coins = [1, 2, 5], amount = 11
		return 3 (11 = 5 + 5 + 1)
	Example 2:
		coins = [2], amount = 3
		return -1.
	Note:
		You may assume that you have an infinite number of each kind of coin.
*/

import.util.Arrays;

public class CoinChange {
	//O(n^n)
	public static int coinChangeDsf(int[] coins, int amount) {
		Arrays.sort(coins);
		return dsf(amount, coins.length - 1, coins, 0);
	}

	public static int dsf(int amount, int coinIndex, int[] coins, int count) {
		if (amount == 0) {
			return count;
		}
		if (coinIndex < 0) {
			return -1;
		}

		int value = coins[coinIndex];
		int minCount = Integer.MAX_VALUE;
		int temp = dsf(amount, coinIndex - 1, coins, count);

		if (temp != -1) {
			minCount = Math.min(minCount, temp);
		}
		while (amount >= value) {
			amount -= value;
			int c = dsf(amount, coinIndex - 1, coins, ++count);
			if (c != -1) {
				minCount = Math.min(minCount, c);
			}
		}

		return minCount == Integer.MAX_VALUE ? -1 : minCount;
	}

	//DP time:O(n^2) space O(n)
	public static int coinChangeDp(int[] coins, int amount) {
		if (amount == 0) return 0;
		int[] minCoins = new int[amount + 1];
		minCoins[0] = 0;

		for (int i = 1; i <= amount; i++) {
			int min = -1;
			for (int c : coins) {
				if (c <= i && minCoins[i - c] != -1) {
					if (min < 0) {
						min = minCoins[i - c] + 1;
					} else {
						min = Math.min(minCoins[i - c] + 1, min);
					}
				}
			}
			minCoins[i] = min;
		}
		return minCoins[amount];
	}
}