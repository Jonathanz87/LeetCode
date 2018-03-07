/*
	problem 416
	Given a non-empty array containing only positive integers,
	find if the array can be partitioned into two subsets such
	that the sum of elements in both subsets is equal.
	Note:
	Each of the array element will not exceed 100.
	The array size will not exceed 200.
	Example 1:
		Input: [1, 5, 11, 5]
		Output: true
		Explanation: The array can be partitioned as [1, 5, 5] and [11].
	Example 2:
		Input: [1, 2, 3, 5]
		Output: false
		Explanation: The array cannot be partitioned into equal sum subsets.
*/

import java.util.stream.IntStream;

public class PartitionEqualSubsetSum {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		System.out.println(canPartition(nums));
	}

	//DP
	public static boolean canPartition(int[] nums) {
		int sum = IntStream.of(nums).sum();
		if (sum % 2 != 0) {
			return false;
		}

		sum /= 2;

		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for (int num : nums) {
			for (int s = sum; s >= num; s--) {
				dp[s] = dp[s] || dp[s - num];
			}
		}

		return dp[sum];
	}
}