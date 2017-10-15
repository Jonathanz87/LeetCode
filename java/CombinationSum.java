/*
	problem 39
	Given a set of candidate numbers (C) (without duplicates) and a target number (T),
	find all unique combinations in C where the candidate numbers sums to T.
	The same repeated number may be chosen from C unlimited number of times.
	Note:
	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.
	For example, given candidate set [2, 3, 6, 7] and target 7,
	A solution set is:
		[
			[7],
			[2, 2, 3]
		]
*/

import java.util.List;
import java.util.LinkedList;

public class CombinationSum {
	public static void main(String[] args) {
	
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> resultList = new LinkedList<>();
		List<Integer> result = new LinkedList<>();
		combinationSum(resultList, result, candidates, 0, target);
		return resultList;
	}

	public static void combinationSum(List<List<Integer>> resultList, List<Integer> result, int[] candidates, int startIndex, int target) {
		if (target <= 0) {
			if (candidates.length > 0 && target == 0) {
				resultList.add(new LinkedList<Integer>(result));
			}
			return;
		}

		for (int i = startIndex, len = candidates.length; i < len; i++) {
			result.add(candidates[i]);
			combinationSum(resultList, result, candidates, i, target - candidates[i]);
			result.remove(result.size() - 1);
		}
	}
}