/*
	problem 523
	Given a list of non-negative numbers and a target integer k,
	write a function to check if the array has a continuous subarray of size at least 2
	that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
	Example 1:
		Input: [23, 2, 4, 6, 7],  k=6
		Output: True
		Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
	Example 2:
		Input: [23, 2, 6, 4, 7],  k=6
		Output: True
		Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
	Note:
		The length of the array won't exceed 10,000.
		You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
*/

import java.util.Set;
import java.util.HashSet;

public class ContinuousSubarraySum {
	public static void main(String[] args) {
		int[] nums = new int[args.length - 1];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		System.out.println(checkSubarraySum(nums, Integer.parseInt(args[args.length - 1])));
	}

	public static boolean checkSubarraySum(int[] nums, int k) {
		if (nums.length <= 1) return false;
		if (k == 0) {
			for(int i = 1; i < nums.length; i++){
				if(nums[i - 1] == 0 && nums[i] == 0){
					return true;
				}
			}
			return false;
		}
		int remainder = nums[0] % k;
		Set<Integer> remainderSet = new HashSet<Integer>();
		remainderSet.add(remainder);
		remainderSet.add(0);

		for (int i = 1; i < nums.length; i++) {
			remainder = (remainder + nums[i]) % k;
			if (remainderSet.contains(remainder)) {
				return true;
			}
			remainderSet.add(remainder);
		}

		return false;
	}
}
