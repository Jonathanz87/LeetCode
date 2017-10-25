/*
	problem 53
	Find the contiguous subarray within an array (containing at least one number)
	which has the largest sum.
	For example,
		given the array [-2,1,-3,4,-1,2,1,-5,4],
		the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            if (sum <= 0) {
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(sum, max);
        }

        return max;
    }
}