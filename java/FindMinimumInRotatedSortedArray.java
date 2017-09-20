/*
	problem 153
	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	Find the minimum element.
	You may assume no duplicate exists in the array.
*/

public class FindMinimumInRotatedSortedArray {
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
		int firstValue = nums[fIndex];

		if (nums[fIndex] < nums[bIndex]) {
			return nums[fIndex];
		}

		while (fIndex < bIndex) {
			int mIndex = (fIndex + bIndex) / 2;

			if (nums[mIndex] < firstValue) {
				bIndex = mIndex;
			} else {
				fIndex = mIndex + 1;
			}
		}
		return nums[fIndex];
	}
}