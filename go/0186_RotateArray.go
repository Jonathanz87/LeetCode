/*
	189. Rotate Array
	Given an array, rotate the array to the right by k steps, where k is non-negative.
	Example 1:
		Input: [1,2,3,4,5,6,7] and k = 3
		Output: [5,6,7,1,2,3,4]
		Explanation:
		rotate 1 steps to the right: [7,1,2,3,4,5,6]
		rotate 2 steps to the right: [6,7,1,2,3,4,5]
		rotate 3 steps to the right: [5,6,7,1,2,3,4]
	Example 2:
		Input: [-1,-100,3,99] and k = 2
		Output: [3,99,-1,-100]
		Explanation: 
		rotate 1 steps to the right: [99,-1,-100,3]
		rotate 2 steps to the right: [3,99,-1,-100]
	Note:
		Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
		Could you do it in-place with O(1) extra space?
*/

package main

func rotate(nums []int, k int)  {
	size := len(nums)

	k = k % size
	if k != 0 {
		visited := make([]bool, size)
		for i := 0; i < size; i++ {
			if visited[i] {
				continue
			}

			for n, nextIndex := nums[i], (i + k) % size; !visited[nextIndex]; nextIndex = (nextIndex + k) % size {
				n = n ^ nums[nextIndex]
				nums[nextIndex] = n ^ nums[nextIndex]
				n = n ^ nums[nextIndex]
				visited[nextIndex] = true
			}
		}
	}
}

func rotate2(nums []int, k int)  {
	size := len(nums)
	k = k % size

	if k != 0 {
		reverse(nums, 0, size - 1)
		reverse(nums, 0, k - 1)
		reverse(nums, k , size - 1)
	}
}

func reverse(nums []int, left, right int) {
	for left < right {
		nums[left] = nums[left] ^ nums[right]
		nums[right] = nums[left] ^ nums[right]
		nums[left] = nums[left] ^ nums[right]
		left++
		right--
	}
}