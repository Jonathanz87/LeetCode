/*
	problem 704
	Given a sorted (in ascending order) integer array nums of n elements and a target value,
	write a function to search target in nums.
	If target exists, then return its index, otherwise return -1.
	Example 1:
		Input: nums = [-1,0,3,5,9,12], target = 9
		Output: 4
		Explanation: 9 exists in nums and its index is 4
	Example 2:
		Input: nums = [-1,0,3,5,9,12], target = 2
		Output: -1
		Explanation: 2 does not exist in nums so return -1
 	Note:
		You may assume that all elements in nums are unique.
		n will be in the range [1, 10000].
		The value of each element in nums will be in the range [-9999, 9999].
*/
public class BinarySearch {
	public static void main(String[] args) {
		int[] nums = new int[args.length - 1];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(search(nums, Integer.parseInt(args[args.length - 1])));
	}
	public static int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		while (left < right) {
			int mid = (left + right) >> 1;

			if (nums[mid] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return nums[left] == target ? left : -1;
	}
}