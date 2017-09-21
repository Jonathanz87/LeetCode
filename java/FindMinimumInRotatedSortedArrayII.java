/*
	problem 154
	Follow up for "Find Minimum in Rotated Sorted Array":
	What if duplicates are allowed?
	Would this affect the run-time complexity? How and why?

	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	Find the minimum element.
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

public class FindMinimumInRotatedSortedArrayII {
	public static void main(String[] args) {
		int[] arr = new int[args[0].length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = args[0].charAt(i) - '0';
		}

		System.out.println(findMin(arr));
	}

	public static int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int fIndex = 0, bIndex = nums.length - 1;
		while (fIndex < bIndex && nums[fIndex] == nums[bIndex]) {
			bIndex--;
		}
		int pivot = nums[bIndex];

		while (fIndex < bIndex) {
			int mIndex = (fIndex + bIndex) / 2;
			if (nums[mIndex] > pivot) {
				fIndex = mIndex + 1;
			} else {
				bIndex = mIndex;
			}
		}

		return nums[fIndex];
	}
}