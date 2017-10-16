/*
	problem 90
	Given a collection of integers that might contain duplicates,
	nums, return all possible subsets.
	Note: The solution set must not contain duplicate subsets.
	For example,
	If nums = [1,2,2], a solution is:
	[
		[2],
		[1],
		[1,2,2],
		[2,2],
		[1,2],
		[]
	]
*/

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class SubsetsII {
	public static void main(String[] args) {
		int len = args[0].length();
		int[] nums = new int[len];

		for (int i = 0; i < len; i++) {
			nums[i] = args[0].charAt(i) - '0';
		}

		for (List<Integer> list : subsetsWithDup(nums)) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> resultList = new LinkedList<>();
		List<Integer> result = new LinkedList<>();
		subsetsWithDupHelper2(resultList, result, nums, 0);
		return resultList;
	}

	public static void subsetsWithDupHelper2(List<List<Integer>> resultList, List<Integer> result, int[] nums, int index) {
		resultList.add(new LinkedList<>(result));

		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1]) continue;
			result.add(nums[i]);
			subsetsWithDupHelper2(resultList, result, nums, i + 1);
			result.remove(result.size() - 1);
		}
	}

	public static void subsetsWithDupHelper(List<List<Integer>> resultList, List<Integer> result, int[] nums, int index) {
		if (index >= nums.length) {
			resultList.add(result);
			return;
		}


		if (index == 0 || nums[index] != nums[index - 1] ||
		        result.size() == 0 || result.get(result.size() - 1) != nums[index - 1]) {
			List<Integer> copy = new LinkedList<>(result);
			subsetsWithDupHelper(resultList, copy, nums, index + 1);
		}

		result.add(nums[index]);
		subsetsWithDupHelper(resultList, result, nums, index + 1);
	}
}