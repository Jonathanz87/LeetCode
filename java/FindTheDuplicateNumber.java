/*
	problem 287
	Given an array nums containing n + 1 integers
	where each integer is between 1 and n (inclusive),
	prove that at least one duplicate number must exist.
	Assume that there is only one duplicate number,
	find the duplicate one.
	Note:
		You must not modify the array (assume the array is read only).
		You must use only constant, O(1) extra space.
		Your runtime complexity should be less than O(n2).
		There is only one duplicate number in the array,
		but it could be repeated more than once.
*/

public class FindTheDuplicateNumber {
	public static void main(String[] args) {
		int[] nums = new int[args.length];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(findDuplicate(nums));
	}

	public static int findDuplicate(int[] nums) {
		int smallest = 1, biggest = nums.length - 1;
		while (smallest < biggest) {
			int mid = ((smallest + biggest) >> 1) + 1;
			int count = 0;
			for (int n : nums) {
				if (n < mid) {
					count++;
				}
			}

			if (count < mid) {
				smallest = mid;
			} else {
				biggest = mid - 1;
			}
		}

		return smallest;
	}
}