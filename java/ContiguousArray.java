/*
	problem 525
	Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
	Example 1:
		Input: [0,1]
		Output: 2
		Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
	Example 2:
		Input: [0,1,0]
		Output: 2
		Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*/

/*
	solution
	use a map to record the previous sum
	 0  0  1  1
	-1 -2 -1  0
	and also track the sum from index 0 to current index
	if any previous sum matches the sum, then the length will be use to compare to the max length
	if the current sum == previous sum, 
	that means if use the current substring - the previous substring, 
	the total sum of the new substring will be 0

	use array with a size of (nums.length * 2 + 1) will reduce the running time.
	since the number array only contains 0s and 1s,
	so the range of the sum is [-nums.length, nums.length];
*/

import java.util.Map;
import java.util.HashMap;

public class ContiguousArray {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(findMaxLength(nums));
	}
	public static int findMaxLength(int[] nums) {
		int maxLength = 0, sum = 0;
		Map<Integer, Integer> sumIndex = new HashMap<>();

		sumIndex.put(sum, -1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i] == 1 ? 1 : -1;
			if (!sumIndex.containsKey(sum)) {
				sumIndex.put(sum, i);
			} else {
				maxLength = Math.max(i - sumIndex.get(sum), maxLength);
			}
		}

		return maxLength;
	}
}
