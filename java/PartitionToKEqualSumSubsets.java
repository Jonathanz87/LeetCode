/*
	problem 698
	Given an array of integers nums and a positive integer k,
	find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
	Example 1:
		Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
		Output: True
		Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
	Note:
		1 <= k <= len(nums) <= 16.
		0 < nums[i] < 10000.
*/

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
	public static void main(String[] args) {
		int[] nums = new int[args.length - 1];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		System.out.println(canPartitionKSubsets(nums, Integer.parseInt(args[args.length - 1])));
	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		int target = 0;
		int[] sums = null;
		for (int n : nums) {
			sum += n;
		}

		if (sum % k != 0) {
			return false;
		}
		target = sum / k;

		sums = new int[k];

		Arrays.sort(nums);

		return bsf(nums, nums.length - 1, sums, target);

	}

	private static boolean bsf(int[] nums, int index, int[] sums, int target) {
		if (index < 0) {
			return true;
		}

		int n = nums[index];

		for (int i = 0; i < sums.length; i++) {
			sums[i] += n;
			if (sums[i] <= target) {
				if (bsf(nums, index - 1, sums, target)) return true;
			}

			sums[i] -= n;

			if(sums[i] == 0) break; //if the group is 0 then the following groups must be all 0s
		}

		return false;
	}
}