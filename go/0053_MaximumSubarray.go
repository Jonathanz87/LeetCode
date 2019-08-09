	/*
		53. Maximum Subarray
		Given an integer array nums, find the contiguous subarray (containing at least one number) 
		which has the largest sum and return its sum.
		Example:
			Input: [-2,1,-3,4,-1,2,1,-5,4],
			Output: 6
			Explanation: [4,-1,2,1] has the largest sum = 6.
		Follow up:
			If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
	*/

	package main

	import( "fmt"; "math")

	func main(){
		fmt.Println(maxSubArray( []int{10,-9,10,-9} ))
	}

	func maxSubArray(nums []int) int {
		if nums == nil || len(nums) <= 0 {
			return 0
		}

		max := int(math.MinInt32)
		var current int = 0

		for _, n := range nums {
			current += n
			max = maxValue(max, current)
			current = maxValue(current, 0)
		}

		return max;
	}

	func maxValue(x, y int) int{
		if x > y {
			return x
		}else {
			return y
		}
	}
