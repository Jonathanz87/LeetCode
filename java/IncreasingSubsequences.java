/*
	problem 491
	Given an integer array,
	your task is to find all the different possible increasing subsequences of the given array,
	and the length of an increasing subsequence should be at least 2 .
	Example:
		Input: [4, 6, 7, 7]
		Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
	Note:
		The length of the given array will not exceed 15.
		The range of integer in the given array is [-100,100].
		The given array may contain duplicates,
		and two equal integers should also be considered as a special case of increasing sequence.
*/

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class IncreasingSubsequences {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		findSubsequencesBsf(nums).forEach(System.out::println);

	}

	public static List<List<Integer>> findSubsequencesSet(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		dsf(nums, 0, result, new LinkedList<Integer>(), Integer.MIN_VALUE);
		return new ArrayList<>(result);
	}

	private static void dsf(int[] nums, int index, Set<List<Integer>> result, LinkedList<Integer> list, int last) {
		if (index >= nums.length) {
			if (list.size() >= 2) {
				result.add(new ArrayList<>(list));
			}
			return;
		}

		dsf(nums, index + 1, result, list, last);


		if (nums[index] >= last) {
			list.add(nums[index]);
			dsf(nums, index + 1, result, list, nums[index]);
			list.removeLast();
		}
	}

	public static List<List<Integer>> findSubsequencesBsf(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		bsf(nums, 0, result, new LinkedList<>(), Integer.MIN_VALUE);
		return result;
	}

	private static void bsf(int[] nums, int index, List<List<Integer>> result, LinkedList<Integer> list, int last) {
		if (list.size() >= 2) {
			result.add(new ArrayList<>(list));
		}

		if (index >= nums.length) {
			return;
		}

		Set<Integer> set = new HashSet<>();

		for (int i = index; i < nums.length; i++) {
			if (nums[i] >= last && !set.contains(nums[i])) {
				set.add(nums[i]);
				list.add(nums[i]);
				bsf(nums, i + 1, result, list, nums[i]);
				list.removeLast();
			}
		}
	}
}