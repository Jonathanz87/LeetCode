/*
	problem 216
	Find all possible combinations of k numbers that add up to a number n,
	given that only numbers from 1 to 9 can be used and
	each combination should be a unique set of numbers.
	Example 1:
		Input: k = 3, n = 7
		Output:
		[[1,2,4]]
	Example 2:
		Input: k = 3, n = 9
		Output:
		[[1,2,6], [1,3,5], [2,3,4]]
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class CombinationSumIII {
	public static void main(String[] args) {
		List<List<Integer>> list = combinationSum3(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

		for (List<Integer> numbers : list) {
			System.out.println(numbers);
		}

	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		if (k < 0 || k > 9) return new LinkedList<>();
		List<List<Integer>> result = new LinkedList<>();
		int[] combination = new int[k];

		combination(result, combination, 0, k, 1, n);
		return result;
	}

	public static void combination(List<List<Integer>> result, int[] combination, int i, int k, int start, int n) {
		if (i >= k) {
			if (n == 0) {
				result.add(toList(combination));
			}
			return;
		}

		while (start <= 9) {
			combination[i] = start;
			combination(result, combination, i + 1, k, start + 1, n - start);
			start++;
		}
	}

	private static List<Integer> toList(int[] combination) {
		List<Integer> list = new LinkedList<>();
		for (int n : combination) {
			list.add(n);
		}
		return list;
	}

}