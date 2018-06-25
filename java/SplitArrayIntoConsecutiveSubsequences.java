/*
	problem 659
	You are given an integer array sorted in ascending order (may contain duplicates), 
	you need to split them into several subsequences, 
	where each subsequences consist of at least 3 consecutive integers. 
	Return whether you can make such a split.
	Example 1:
		Input: [1,2,3,3,4,5]
		Output: True
		Explanation:
		You can split them into two consecutive subsequences : 
		1, 2, 3
		3, 4, 5
	Example 2:
		Input: [1,2,3,3,4,4,5,5]
		Output: True
		Explanation:
		You can split them into two consecutive subsequences : 
		1, 2, 3, 4, 5
		3, 4, 5
	Example 3:
		Input: [1,2,3,4,4,5]
		Output: False
	Note: The length of the input is in range of [1, 10000]
*/

public class SplitArrayIntoConsecutiveSubsequences {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(isPossible(nums));
	}
	public static boolean isPossible(int[] nums) {
		if (nums.length == 0) return true;
		if (nums.length < 3) return false;
		int numCount = 0;
		int second = 0;
		int third = 0;
		int completed = 0;
		int last = nums[0];

		for (int n : nums) {
			if (n != last) {
				numCount -= second + third;
				if (numCount < 0) return false;
				if (numCount > completed) {
					numCount -= completed;
				} else {
					completed = numCount;
					numCount = 0;
				}

				completed += third;
				third = second;
				second = numCount;
				numCount = 0;

				if (n != last + 1) {
					if (second != 0 || third != 0 ) {
						return false;
					}
					completed = 0;
				}

				last = n;
			}
			numCount++;
		}

		numCount -= second + third;
		if (numCount < 0) return false;
		if (numCount > completed) {
			numCount -= completed;
		} else {
			numCount = 0;
			completed = numCount;
		}

		third = second;
		second = numCount;

		return second == 0 && third == 0;
	}
}