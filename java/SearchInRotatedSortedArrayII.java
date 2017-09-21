/*
	problem 81
	Follow up for "Search in Rotated Sorted Array":
	What if duplicates are allowed?
	Would this affect the run-time complexity? How and why?
	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	Write a function to determine if a given target is in the array.
	The array may contain duplicates.
*/

/*
	solution
	the difference between this problem with problem 31 is that
	it is possible to have duplicate value for the pivot
		ex [1 1 1 1 1 1 1] [0 1 1 1]
			higher range 	lower range
	therefore, it is impossible to judge the current is in higher range or lower range
	to solve this problem, the pivot index need to be moved backward to the position where
	the pivot value smaller than any of values in higher range, 
	in example the back index should be moved to position of 0
	in worst case, the time complexity is O(n) ex(1 1 1 1 1 1 1 1 1 1 1 1 ...)
*/

public class SearchInRotatedSortedArrayII {
	static public void main(String[] args) {
		int length = args.length - 1;
		int[] nums = new int[length];
		for (int i = 0; i < length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(search(nums, Integer.parseInt(args[length])));
	}
	public static boolean search(int[] nums, int target) {
		if (nums.length == 0) {
			return false;
		}
		int fIndex = 0, bIndex = nums.length - 1;
		while (fIndex < bIndex && nums[fIndex] == nums[bIndex]) {
			bIndex--;
		}

		int pivot = nums[bIndex];
		boolean inHigherRange = target > pivot;

		while (fIndex < bIndex) {
			int mIndex = (fIndex + bIndex) / 2;

			if (nums[mIndex] > pivot == inHigherRange) {
				if (target > nums[mIndex]) {
					fIndex = mIndex + 1;
				} else {
					bIndex = mIndex;
				}
			} else if (inHigherRange) {
				bIndex = mIndex - 1;
			} else {
				fIndex = mIndex + 1;
			}

		}
		return nums[fIndex] == target;
	}
}