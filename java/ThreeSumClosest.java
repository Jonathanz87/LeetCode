/*
	problem 16
	Given an array S of n integers,
	find three integers in S such that
	the sum is closest to a given number, target.
	Return the sum of the three integers.
	You may assume that each input would have exactly one solution.
	For example,
		given array S = {-1 2 1 -4}, and target = 1.
		The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

import java.util.Arrays;
public class ThreeSumClosest {
	public static void main(String[] args) {
		int[] nums = new int[args.length - 1];

		for (int i = 0; i < args.length - 1; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		System.out.println(threeSumClosest(nums, Integer.parseInt(args[args.length - 1])));

	}
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;
		int minSum = 0;

		for (int i = 0, len = nums.length - 2; i < len; i++) {
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int temp = Math.abs(sum - target);
				if (temp < minDiff) {
					minDiff = temp;
					minSum = sum;
				}
				if (sum > target) {
					k--;
				} else if (sum < target) {
					j++;
				} else {
					return minSum;
				}
			}
		}
		return minSum;
	}
}