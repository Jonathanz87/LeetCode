/*
  problem 661
	Given an array consists of non-negative integers, 
	your task is to count the number of triplets chosen 
	from the array that can make triangles if we take them as side lengths of a triangle.
	Example 1:
		Input: [2,2,3,4]
		Output: 3
		Explanation:
		Valid combinations are: 
		2,3,4 (using the first 2)
		2,3,4 (using the second 2)
		2,2,3
	Note:
		The length of the given array won't exceed 1000.
		The integers in the given array are in the range of [0, 1000].
*/
import java.util.Arrays;

public class ValidTriangleNumber {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(triangleNumber(nums));
	}

	//n^2logn
	public static int triangleNumber(int[] nums) {
		int ct = 0;
		Arrays.sort(nums);
		for (int i = 0, iLen = nums.length - 2; i < iLen; i++) {
			for (int j = i + 1, jLen = nums.length - 1; j < jLen; j++) {
				int k = findSmallerIndex(nums, j + 1, nums.length - 1, nums[i] + nums[j]);
				ct += k - j;
			}
		}
		return ct;
	}

	private static int findSmallerIndex(int[] nums, int startIndex, int endIndex, int target) {
		if (nums[startIndex] >= target) {
			return startIndex - 1;
		}

		while (startIndex < endIndex) {
			int mid = (startIndex + endIndex + 1) >> 1;
			if (nums[mid] >= target) {
				endIndex = mid - 1;
			} else {
				startIndex = mid;
			}
		}

		return startIndex;
	}

}
