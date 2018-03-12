/*
	problem 494
	You are given a list of non-negative integers, 
	a1, a2, ..., an, and a target, S. 
	Now you have 2 symbols + and -. 
	For each integer, you should choose one from + and - as its new symbol.
	Find out how many ways to assign symbols to make sum of integers equal to target S.
	Example 1:
		Input: nums is [1, 1, 1, 1, 1], S is 3. 
		Output: 5
		Explanation: 
		-1+1+1+1+1 = 3
		+1-1+1+1+1 = 3
		+1+1-1+1+1 = 3
		+1+1+1-1+1 = 3
		+1+1+1+1-1 = 3
		There are 5 ways to assign symbols to make the sum of nums be target 3.
	Note:
		The length of the given array is positive and will not exceed 20.
		The sum of elements in the given array will not exceed 1000.
		Your output answer is guaranteed to be fitted in a 32-bit integer.
*/

public class TargetSum {
	public static void main(String[] args) {
		int[] nums = new int[args.length - 1];
		for (int i = 0; i < nums.length ; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(findTargetSumWays(nums, Integer.parseInt(args[args.length - 1])));
	}

	public static int findTargetSumWays(int[] nums, int S) {
		return dfs(nums, 0, 0, S);
	}

	private static int dfs(int[] nums, int i, int sum, int S) {
		if (i >= nums.length) {
			return sum == S ? 1 : 0;
		}

		return dfs(nums, i + 1, sum + nums[i], S) + dfs(nums, i + 1, sum - nums[i], S);
	}

	// public static int findTargetSumWaysDP(int[] nums, int S) {
	// 	int sum = 0;

	// 	for (int n : nums) {
	// 		sum += n;
	// 	}

	// 	int[] dp = new int[sum + 1];

	// 	for(int n : nums){
	// 		for(int i = sum; i )
	// 	}
	// }
}