/*
	problem 198
	You are a professional robber planning to rob houses along a street.
	Each house has a certain amount of money stashed,
	the only constraint stopping you from robbing each of them is that
	adjacent houses have security system connected and
	it will automatically contact the police
	if two adjacent houses were broken into on the same night.
	Given a list of non-negative integers representing the amount of money of each house,
	determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class HouseRobber {
    public static void main(String[] args) {

    }

    public static int robDP(int[] nums) {
        if(nums.length <= 0) return 0;
        if(nums.length <= 1) return nums[0];

        if(nums.length >= 3) {
            nums[2] += nums[0];
        }

        for(int i = 3; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }

        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }

    public static int rob(int[] nums) {
        int[] sumArr = new int[nums.length];
        for (int i = 0; i < sumArr.length; i++) {
            sumArr[i] = -1;
        }
        return Math.max(rob(nums, sumArr, 0), rob(nums, sumArr, 1));
    }

    public static int rob(int[] nums, int[] sumArr, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (sumArr[index] == -1) {
            sumArr[index] = nums[index] +
                            Math.max(rob(nums, sumArr, index + 2), rob(nums, sumArr, index + 3));
        }
        return sumArr[index];
    }
}