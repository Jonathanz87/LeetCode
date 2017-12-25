/*
	problem 581
	Given an integer array, you need to find one continuous subarray
	that if you only sort this subarray in ascending order,
	then the whole array will be sorted in ascending order, too.
	You need to find the shortest such subarray and output its length.
	Example 1:
		Input: [2, 6, 4, 8, 10, 9, 15]
		Output: 5
		Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order
		to make the whole array sorted in ascending order.
	Note:
		Then length of the input array is in range [1, 10,000].
		The input array may contain duplicates,
		so ascending order here means <=.
*/

public class ShortestUnsortedContinuousSubarray {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(findUnsortedSubarray(nums));
	}

	public static int findUnsortedSubarray(int[] nums) {
		int biggest = nums[0];
		int smallest = nums[nums.length - 1];
		int sortEndIndex = 0;
		int sortStartIndex = nums.length - 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < biggest) {
				sortEndIndex = i;
			} else {
				biggest = nums[i];
			}
		}

		for (int i = sortStartIndex; i >= 0; i--) {
			if (nums[i] > smallest) {
				sortStartIndex = i;
			} else {
				smallest = nums[i];
			}
		}
		int result = Math.max(0, sortEndIndex - sortStartIndex + 1);

		return result == 1 ? 0 : result;
	}
}