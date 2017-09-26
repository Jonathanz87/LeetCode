/*
	problem 198
	You are a professional robber planning to rob houses along a street.
	Each house has a certain amount of money stashed,
	the only constraint stopping you from robbing each of them is that
	adjacent houses have security system connected and
	it will automatically contact the police
	if two adjacent houses were broken into on the same night.
	Given a list of non-negative integers representing the amount of money of each house,
	determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class HouseRobber {
	public static void main(String[] args) {

	}

	public static int rob(int[] nums) {
		int[] sumArr = new int[nums.length];
		for (int i = 0; i < sumArr.length; i++) {
			sumArr[i] = -1;
		}
		return Math.max(rob(nums, sumArr, 0), rob(nums, sumArr, 1));
	}

	public static int rob(int[] nums, int[] sumArr, int index) {
		if (index >= nums.length) {
			return 0;
		}
		if (sumArr[index] == -1) {
			sumArr[index] = nums[index] +
			                Math.max(rob(nums, sumArr, index + 2), rob(nums, sumArr, index + 3));
		}
		return sumArr[index];
	}
}