# problem 53
# Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
# Example:
# Input: [-2,1,-3,4,-1,2,1,-5,4],
# Output: 6
# Explanation: [4,-1,2,1] has the largest sum = 6.
# Follow up:
# If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return None
        max = nums[0]
        sum = nums[0]
        for i in range(1, len(nums)):
            if sum < 0:
                sum = 0

            sum += nums[i]

            if sum > max:
                max = sum

        return max

obj = Solution()

print(obj.maxSubArray([3,-5,3]))
