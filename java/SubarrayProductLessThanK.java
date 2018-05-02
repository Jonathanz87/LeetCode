/*
	problem 713
	Your are given an array of positive integers nums.
	Count and print the number of (contiguous) subarrays
	where the product of all the elements in the subarray is less than k.
	Example 1:
		Input: nums = [10, 5, 2, 6], k = 100
		Output: 8
		Explanation: The 8 subarrays that have product less than 100 are:
		[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
		Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
	Note:
		0 < nums.length <= 50000.
		0 < nums[i] < 1000.
		0 <= k < 10^6.
*/

public class SubarrayProductLessThanK {
	public static void main(String[] args) {
		System.out.println(numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
	}
	public static int numSubarrayProductLessThanKSlow(int[] nums, int k) {
		if (k <= 1) return 0;
		int preEnd = -1;
		int curStart = 0;
		int prod = 1;
		int ct = 0;

		for (int i = 0; i < nums.length; i++) {
			if ((prod *= nums[i]) >= k) {
				int size = i - curStart;
				int overlap = Math.max(preEnd - curStart + 1, 0);
				ct += size * (size + 1) / 2 - overlap * (overlap + 1) / 2;
				preEnd = i - 1;
				while ((prod /= nums[curStart++]) >= k);
			}
		}

		int size = nums.length - curStart;
		int overlap = Math.max(preEnd - curStart + 1, 0);
		ct += size * (size + 1) / 2 - overlap * (overlap + 1) / 2;
		return ct;
	}
}