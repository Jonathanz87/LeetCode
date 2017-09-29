/*
	problem 209
	Given an array of n positive integers and a positive integer s,
	find the minimal length of a contiguous subarray of which the sum ≥ s.
	If there isn't one, return 0 instead.
	For example, given the array [2,3,1,2,4,3] and s = 7,
	the subarray [4,3] has the minimal length under the problem constraint.
*/

public class MinimumSizeSubarraySum {
	public static void main(String[] args) {
		int[] nums = new int[args.length - 1];
		for(int i = 0; i < nums.length; i++){
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(minSubArrayLen(Integer.parseInt(args[args.length - 1]), nums));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		int sum = 0, size = nums.length + 1, leftIndex = 0;
		for (int i = 0, len = nums.length; i < len; i++) {
			sum += nums[i];
			if (sum >= s) {
				while (sum - nums[leftIndex] >= s) {
					sum -= nums[leftIndex++];
				}
				int temp = i - leftIndex + 1;
				if (temp < size) {
					size = temp;
				}
			}
		}
		return size > nums.length ? 0 : size;
	}
}