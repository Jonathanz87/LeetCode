/*
	problem 673
	Given an unsorted array of integers,
	find the number of longest increasing subsequence.
	Example 1:
		Input: [1,3,5,4,7]
		Output: 2
		Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
	Example 2:
		Input: [2,2,2,2,2]
		Output: 5
		Explanation: The length of longest continuous increasing subsequence is 1,
		and there are 5 subsequences' length is 1, so output 5.
	Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
*/

/*
	solution DP
	nums = 								{	1	3	2	6	7	4	5	4}
	increasing length = 				{	1	2	2	3	4	3	4	3}
	increasing subsequences count = 	{	1	1	1	2	2	2	2	2}
	final count 											*		*		= 2 + 2 = 4
	final count = the sum of increasing count of each longest increasing length
*/

public class NumberOfLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
		if (nums == null)
			return 0;
		int[] length = new int[nums.length];
		int[] count = new int[nums.length];
		int longest = 0;
		int largestCount = 0;

		for (int i = 0; i < nums.length; i++) {
			int len = 0;
			int ct = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					if (length[j] > len) {
						len = length[j];
						ct = count[j];
					} else if (length[j] == len) {
						ct += count[j];
					}
				}
			}
			length[i] = len + 1;
			count[i] = ct;
			if (length[i] > longest) {
				longest = length[i];
				largestCount = ct;
			} else if (length[i] == longest) {
				largestCount += ct;
			}
		}

		return largestCount;
	}
}