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

public class FindMinimumInRotatedSortedArrayII{
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

		int smallest = nums[0];

		if (smallest < nums[nums.length - 1]) {
			return smallest;
		}

		for(int i = 1; i < nums.length; i++){
			if(nums[i] < smallest){
				return nums[i];
			}
		}

		return smallest;
	}
}