/*
	problem 40
	Given a collection of candidate numbers (C) and a target number (T),
	find all unique combinations in C where the candidate numbers sums to T.
	Each number in C may only be used once in the combination.
	Note:
	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.
	For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
	A solution set is:
		[
			[1, 7],
			[1, 2, 5],
			[2, 6],
			[1, 1, 6]
		]
*/

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class CombinationSumII {
	public static void main(String[] args) {
		int[] candidates = new int[args.length - 1];
		for (int i = 0; i < candidates.length; i++) {
			candidates[i] = Integer.parseInt(args[i]);
		}

		int target = Integer.parseInt(args[args.length - 1]);
		List<List<Integer>> result = combinationSum2(candidates, target);

		for (List<Integer> numbers : result) {
			for (Integer i : numbers) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> resultList = new LinkedList<>();
		List<Integer> combination = new LinkedList<>();
		combinationSum2(candidates, target, 0, resultList, combination);
		return resultList;
	}

	public static void combinationSum2(int candidates[], int target, int startIndex, List<List<Integer>> resultList, List<Integer> combination) {
		if (target <= 0 || startIndex >= candidates.length) {
			if (candidates.length > 0 && target == 0) {
				resultList.add(new LinkedList<>(combination));
			}
			return;
		}

		for (int i = startIndex, len = candidates.length; i < len; i++) {
			if (i > startIndex && candidates[i] == candidates[i - 1]) continue;
			combination.add(candidates[i]);
			combinationSum2(candidates, target - candidates[i], i + 1, resultList, combination);
			combination.remove(combination.size() - 1);
		}
	}
}