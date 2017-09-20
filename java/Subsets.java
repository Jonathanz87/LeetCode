/*
	problem 78
	Given a set of distinct integers,
	nums, return all possible subsets.
	Note: The solution set must not contain duplicate subsets.
	For example,
	If nums = [1,2,3], a solution is:
		[
			[3],
			[1],
			[2],
			[1,2,3],
			[1,3],
			[2,3],
			[1,2],
			[]
		]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Subsets {
	public static void main(String[] args) {
		int len = args[0].length();
		int[] nums = new int[len];

		for (int i = 0; i < len; i++) {
			nums[i] = args[0].charAt(i) - '0';
		}

		for (List<Integer> list : subsets2(nums)) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new LinkedList<Integer>();
		subsetsHelper(result, list, nums, 0);

		return result;
	}

	private static void subsetsHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int i) {
		if (i < nums.length) {
			List<Integer> copy = new LinkedList<Integer>();
			for (Integer n : list)
				copy.add(n);
			copy.add(nums[i]);

			subsetsHelper(result, list, nums, i + 1);
			subsetsHelper(result, copy, nums, i + 1);
		} else {
			result.add(list);
		}
	}

	public static List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		int size = nums.length;
		int max = 1 << size;

		for (int i = 0; i < max; i++) {
			List<Integer> numList = new ArrayList<>();
			for (int j = 0; j < size; j++) {
				if (((i >> j) & 1) == 1) {
					numList.add(nums[j]);
				}
			}
			result.add(numList);
		}
		return result;
	}
}