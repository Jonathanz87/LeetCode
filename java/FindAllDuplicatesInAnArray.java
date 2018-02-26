/*
	problem 442
	Given an array of integers,
	1 ≤ a[i] ≤ n (n = size of array),
	some elements appear twice and others appear once.
	Find all the elements that appear twice in this array.
	Could you do it without extra space and in O(n) runtime?
	Example:
		Input:
		[4,3,2,7,8,2,3,1]
		Output:
		[2,3]
*/

import java.util.List;
import java.util.LinkedList;

public class FindAllDuplicatesInAnArray {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		findDuplicatesMarkUp(nums).forEach(System.out::println);

	}

	//swap and sort
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			while (nums[i] != 0 && nums[i] != j) {
				int k = nums[i] - 1;
				if (nums[i] == nums[k]) {
					result.add(nums[i]);
					nums[i] = 0;
					break;
				}

				nums[i] = nums[i] ^ nums[k];
				nums[k] = nums[i] ^ nums[k];
				nums[i] = nums[i] ^ nums[k];
			}
		}
		return result;
	}

	//mark as -value
	public static List<Integer> findDuplicatesMarkUp(int[] nums) {
		List<Integer> result = new LinkedList<>();
		for (int n : nums) {
			int i = Math.abs(n) - 1;
			if (nums[i] > 0) {
				nums[i] = -nums[i];
			} else {
				result.add(Math.abs(n));
			}
		}
		return result;
	}
}