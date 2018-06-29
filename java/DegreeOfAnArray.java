/*
	problem 697
	Given a non-empty array of non-negative integers nums,
	the degree of this array is defined as the maximum frequency of any one of its elements.
	Your task is to find the smallest possible length of a (contiguous) subarray of nums,
	that has the same degree as nums.
	Example 1:
		Input: [1, 2, 2, 3, 1]
		Output: 2
		Explanation:
		The input array has a degree of 2 because both elements 1 and 2 appear twice.
		Of the subarrays that have the same degree:
		[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
		The shortest length is 2. So return 2.
	Example 2:
		Input: [1,2,2,3,1,4,2]
		Output: 6
	Note:
		nums.length will be between 1 and 50,000.
		nums[i] will be an integer between 0 and 49,999.
*/

public class DegreeOfAnArray {
	public int findShortestSubArray(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		//Base case: if length of nums is 0 or 1, return the length
		if (nums == null || nums.length == 0 || nums.length == 1)
			return nums.length;

		//General case: if 2 or more elements are present

		//list to store numbers with max degree
		List<Integer> numbers = new ArrayList<Integer>();
		//array to store frequency of each number
		int[] freq = new int[50000];

		int degree = 0;

		//for loop to find out degree of nums[]
		for (int i = 0; i < nums.length; i++) {
			int val = ++ freq[nums[i]];

			if (val > degree) {
				numbers.clear();
				numbers.add(nums[i]);
				degree = val;
			} else if (val == degree) {
				numbers.add(nums[i]);
			}
		}

		//variable to store final answer
		int minLength = Integer.MAX_VALUE;

		//loop through all numbers which have same frequency as degree of nums
		for (int i = 0; i < numbers.size(); i++) {

			int currentNumber = numbers.get(i);
			int start = -1;
			int end = -1;
			int currentLength = 0;

			//find the start and end indices of the number in the array
			for (int j = 0; j < nums.length; j++) {
				if (currentNumber == nums[j]) {
					if (start == -1)
						start = j;

					--freq[nums[j]];

					if (freq[nums[j]] == 0) {
						end = j;
						break;
					}

				}
			}

			currentLength = end - start + 1;

			//if length is same as degree of nums[] break
			if (currentLength == degree) {
				minLength = currentLength;
				break;
			}

			//update minLength if currentLength is shorter
			if (currentLength < minLength)
				minLength = currentLength;


		}

		return minLength;
	}
}