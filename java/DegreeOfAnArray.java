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

import java.util.Map;
import java.util.HashMap;

public class DegreeOfAnArray {
	public static void main(String[] args){
		int[] nums = new int[args.length];

		for(int i = 0; i < nums.length; i++){
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(findShortestSubArray(nums));
	}
	public static int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> indexMap = new HashMap<>();
		int minSize = Integer.MAX_VALUE;
		int maxDdegree = 0;

		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if (!indexMap.containsKey(n)) {
				indexMap.put(n, i);
				nums[i] = 0;
			}
			int index = indexMap.get(n);
			nums[index]++;
			if (nums[index] > maxDdegree) {
				minSize = i - index + 1;
				maxDdegree = nums[index];
			} else if (nums[index] == maxDdegree) {
				minSize = Math.min(minSize, i - index + 1);
			}
		}

		return minSize;
	}
}