/*
	problem 540
	Single Element in a Sorted Array
	DescriptionHintsSubmissionsDiscussSolution
	Given a sorted array consisting of only integers
	where every element appears twice except for one element which appears once.
	Find this single element that appears only once.
	Example 1:
		Input: [1,1,2,3,3,4,4,8,8]
		Output: 2
	Example 2:
		Input: [3,3,7,7,10,11,11]
		Output: 10
	Note: Your solution should run in O(log n) time and O(1) space.
*/

public class SingleElementInASortedArray {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		System.out.println(singleNonDuplicate(nums));
	}

	public static int singleNonDuplicate(int[] nums) {
		int fIndex = 0, bIndex = nums.length - 1;

		while (fIndex < bIndex) {
			int mIndex = (fIndex + bIndex) >> 1;
			if (mIndex % 2 == 1) {
				mIndex--;
			}
			if (nums[mIndex] == nums[mIndex + 1]) {
				fIndex = mIndex + 2;
			} else {
				bIndex = mIndex;
			}
		}

		return nums[fIndex];
	}
}
