/*
	problem 137
	Given a non-empty array of integers, every element appears three times except for one,
	which appears exactly once. Find that single one.
	Note:
		Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	Example 1:
		Input: [2,2,3,2]
		Output: 3
	Example 2:
		Input: [0,1,0,1,0,1,99]
		Output: 99
*/

public class SingleNumberII {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(singleNumber(nums));
	}
	public static int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int ct = 0;
			for (int n : nums) {
				ct += (n >>> i & 1);
			}

			result |= (ct % 3) << i;
		}

		return result;
	}
}