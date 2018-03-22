/*
	problem 560
	Given an array of integers and an integer k,
	you need to find the total number of continuous subarrays whose sum equals to k.
	Example 1:
		Input:nums = [1,1,1], k = 2
		Output: 2
	Note:
		The length of the array is in range [1, 20,000].
		The range of numbers in the array is [-1000, 1000]
		and the range of the integer k is [-1e7, 1e7].
*/

import java.util.HashMap;

public class SubarraySumEqualsK {
	public static void main(String[] args) {
		int[] nums = new int[args.length - 1];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		for(int n : nums){
			System.out.println(n);
		}

		System.out.println(subarraySum(nums, Integer.parseInt(args[args.length - 1])));
	}

	public static int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> sumCount = new HashMap<>();
		int sum = 0;
		int ct = 0;
		sumCount.put(sum, 1);
		for (int n : nums) {
			sum += n;
			int diff = sum - k;
			ct += sumCount.getOrDefault(diff, 0);
			int tct = sumCount.getOrDefault(sum, 0);
			sumCount.put(sum, ++tct);
		}
		return ct;
	}
}
