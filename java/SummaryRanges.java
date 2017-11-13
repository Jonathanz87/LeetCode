/*
	problem 228
	Given a sorted integer array without duplicates,
	return the summary of its ranges.
	Example 1:
		Input: [0,1,2,4,5,7]
		Output: ["0->2","4->5","7"]
	Example 2:
		Input: [0,2,3,4,6,8,9]
		Output: ["0","2->4","6","8->9"]
*/

import java.util.List;
import java.util.LinkedList;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> resultList = new LinkedList<>();
		if (nums.length <= 0) {
			return resultList;
		}

		int start = nums[0];
		int next = start + 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != next) {
				if (start == nums[i - 1]) {
					resultList.add(Integer.toString(start));
				} else {
					resultList.add(Integer.toString(start) + "->" + Integer.toString(nums[i - 1]));
				}
				start = nums[i];
				next = start + 1;
			} else {
				next++;
			}
		}

		if (start == nums[nums.length - 1]) {
			resultList.add(Integer.toString(start));
		} else {
			resultList.add(Integer.toString(start) + "->" + Integer.toString(nums[nums.length - 1]));
		}

		return resultList;
	}
}