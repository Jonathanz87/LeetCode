/*
	problem 300
	Given an unsorted array of integers,
	find the length of longest increasing subsequence.
	For example,
	Given [10, 9, 2, 5, 3, 7, 101, 18],
	The longest increasing subsequence is [2, 3, 7, 101],
	therefore the length is 4.
	Note that there may be more than one LIS combination,
	it is only necessary for you to return the length.
	Your algorithm should run in O(n^2) complexity.

	Follow up: Could you improve it to O(n log n) time complexity?
*/

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] nums = new int[args.length];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(lengthOfLISDP(nums));
	}

	/*
		O(n^2)
	*/
	public static int lengthOfLISDP(int[] nums) {
		if (nums == null || nums.length <= 0) return 0;
		int[] longestLIS = new int[nums.length];
		int longestCount = 1;
		int minNum = Integer.MAX_VALUE;
		longestLIS[nums.length - 1] = 1;

		for (int len = nums.length, i = len - 2; i >= 0; i--) {
			if (nums[i] >= minNum) {
				continue;
			}
			int max = 0;
			for (int j = i + 1; j < len; j++) {
				if (nums[j] > nums[i]) {
					max = Math.max(max, longestLIS[j]);
				}
			}
			longestLIS[i] = ++max;
			if (max >= longestCount) {
				longestCount = max;
				minNum = Math.max(nums[i], minNum);
			}
		}

		return longestCount;
	}

	public static int lengthOfLISDP2(int[] nums) {
		if (nums == null || nums.length <= 0) return 0;
		int[] longestLIS = new int[nums.length];
		int longestCount = 1;
		int minNum = Integer.MAX_VALUE;
		//	longestLIS[nums.length - 1] = 1;


		int i = nums.length - 2;

		while (i >= 0 && i < )

			for (int len = nums.length, i = len - 2; i >= 0; i--) {
				if (lonestCount == 1 || nums[i] < minNum) {
					longestCount++;
					minNum = Math.max(nums[i], minNum);

				}

				// int max = 0;
				// for (int j = i + 1; j < len; j++) {
				// 	if (nums[j] > nums[i]) {
				// 		max = Math.max(max, longestLIS[j]);
				// 	}
				// }
				// longestLIS[i] = ++max;
				//longestCount++;
				// if(max >= longestCount){

				//minNum = Math.max(nums[i], minNum);
				// }
			}

		return longestCount;
	}
}