/*
	problem 238
	Given an array of n integers where n > 1, nums,
	return an array output such that output[i]
	is equal to the product of all the elements of nums except nums[i].

	Solve it without division and in O(n).
	For example, given [1,2,3,4], return [24,12,8,6].
	Follow up:
	Could you solve it with constant space complexity?
	(Note: The output array does not count as extra space
	for the purpose of space complexity analysis.)
*/

public class ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		int[] result = productExceptSelf2(nums);
		for (int num : result) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static int[] productExceptSelf2(int[] nums) {
		int[] result = new int[nums.length];

		result[0] = 1;
		for (int i = 1; i < result.length; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}

		for (int i = result.length - 2, rightProd = nums[result.length - 1]; i >= 0; i--) {
			result[i] *= rightProd;
			rightProd *= nums[i];
		}

		return result;
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		productExceptSelf(nums, result, 1, 0);
		return result;
	}

	public static int productExceptSelf(int[] nums, int[] result, int leftProd, int index) {
		if (index >= nums.length - 1) {
			result[index] = leftProd;
			return nums[index];
		}

		int rightProd = productExceptSelf(nums, result, leftProd * nums[index], index + 1);
		result[index] = leftProd * rightProd;
		return rightProd * nums[index];
	}
}