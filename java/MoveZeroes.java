/*
	problem 283
	Given an array nums, write a function to move all 0's to the end of it
	while maintaining the relative order of the non-zero elements.
	For example, given nums = [0, 1, 0, 3, 12], after calling your function,
	nums should be [1, 3, 12, 0, 0].
	Note:
		You must do this in-place without making a copy of the array.
		Minimize the total number of operations.
*/

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int swapIndex = 0, index = 0, len = nums.length;

		while (index < len && nums[index] != 0) {
			index++;
		}

		swapIndex = index++;

		while (index < len) {
			if (nums[index] != 0) {
				nums[swapIndex] = nums[index];
				swapIndex++;
			}
			index++;
		}

		while (swapIndex < len) {
			nums[swapIndex++] = 0;
		}
	}
}