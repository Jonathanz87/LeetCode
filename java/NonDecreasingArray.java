/*
	problem 665
	Given an array with n integers,
	your task is to check if it could become non-decreasing by modifying at most 1 element.
	We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
	Example 1:
		Input: [4,2,3]
		Output: True
		Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
	Example 2:
		Input: [4,2,1]
		Output: False
		Explanation: You can't get a non-decreasing array by modify at most one element.
*/

public class NonDecreasingArray {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(checkPossibility(nums));
	}

	public static boolean checkPossibility(int[] nums) {
		boolean modified = false;

		for (int i = 1; i < nums.length; i++) {
			if (!(nums[i - 1] <= nums[i])) {
				if (modified) {
					return false;
				}
				modified = true;
				if ( !(i - 2 < 0 || nums[i - 2] <= nums[i] ||
				        i + 1 >= nums.length || nums[i - 1] <= nums[i + 1]) ) {
					return false;
				}
			}
		}
		return true;
	}
}
