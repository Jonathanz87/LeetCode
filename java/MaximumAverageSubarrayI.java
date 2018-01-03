/*
	problem 643
	Given an array consisting of n integers,
	find the contiguous subarray of given length k
	that has the maximum average value.
	And you need to output the maximum average value.
	Example 1:
		Input: [1,12,-5,-6,50,3], k = 4
		Output: 12.75
		Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
	Note:
		1 <= k <= n <= 30,000.
		Elements of the given array will be in the range [-10,000, 10,000].
*/

public class MaximumAverageSubarrayI {
	public double findMaxAverage(int[] nums, int k) {
		int max = 0;
		int current = 0;
		int i = 0;
		while (i < k) {
			max += nums[i++];
		}
		current = max;

		while (i < nums.length) {
			current -= nums[i - k];
			current += nums[i];
			i++;
			max = Math.max(max, current);
		}

		return (double)max / k;
	}
}