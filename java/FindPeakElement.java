/*
	problem 162
	A peak element is an element that is greater than its neighbors.
	Given an input array where num[i] ≠ num[i+1],
	find a peak element and return its index.
	The array may contain multiple peaks,
	in that case return the index to any one of the peaks is fine.
	You may imagine that num[-1] = num[n] = -∞.
	For example, in array [1, 2, 3, 1],
	3 is a peak element and your function should return the index number 2.
*/


public class FindPeakElement {
	public static void main(String[] args) {
		int[] array = new int[args[0].length()];

		for (int i = 0; i < array.length; i++) {
			array[i] = args[0].charAt(i) - '0';
		}

		System.out.println(findPeakElement(array));
	}

	public static int findPeakElement(int[] nums) {
		int fIndex = 0, bIndex = nums.length - 1, targetIndex = (fIndex + bIndex) / 2;
		int max = nums.length - 1;

		while (fIndex < bIndex) {
			if (targetIndex > 0 && nums[targetIndex - 1] > nums[targetIndex]) {
				bIndex = targetIndex - 1;
			} else if (targetIndex < max && nums[targetIndex + 1] > nums[targetIndex]) {
				fIndex = targetIndex + 1;
			} else {
				break;
			}
			targetIndex = (fIndex + bIndex) / 2;
		}

		return targetIndex;
	}

}