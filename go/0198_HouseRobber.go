/*
	198. House Robber
	You are a professional robber planning to rob houses along a street.
	Each house has a certain amount of money stashed,
	the only constraint stopping you from robbing each of them is that
	adjacent houses have security system connected and
	it will automatically contact the police if two adjacent houses were broken into on the same night.
	Given a list of non-negative integers representing the amount of money of each house,
	determine the maximum amount of money you can rob tonight without alerting the police.
	Example 1:
		Input: [1,2,3,1]
		Output: 4
		Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
		Total amount you can rob = 1 + 3 = 4.
	Example 2:
		Input: [2,7,9,3,1]
		Output: 12
		Explanation: Rob house 1 (money = 2),
		rob house 3 (money = 9) and rob house 5 (money = 1).
		Total amount you can rob = 2 + 9 + 1 = 12.
*/

package main

func rob(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	} else if len(nums) == 1 {
		return nums[0]
	} else if len(nums) == 2 {
		if nums[0] > nums[1] {
			return nums[0]
		} else {
			return nums[1]
		}
	} else if len(nums) == 3 {
		if nums[0]+nums[2] > nums[1] {
			return nums[0] + nums[2]
		} else {
			return nums[1]
		}
	}

	nums[2] += nums[0]

	for i, len := 3, len(nums); i < len; i++ {
		if nums[i-2] > nums[i-3] {
			nums[i] += nums[i-2]
		} else {
			nums[i] += nums[i-3]
		}
	}

	if nums[len(nums)-1] > nums[len(nums)-2] {
		return nums[len(nums)-1]
	} else {
		return nums[len(nums)-2]
	}
}
