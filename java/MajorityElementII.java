/*
	problem 229
	Given an integer array of size n,
	find all elements that appear more than ⌊ n/3 ⌋ times.
	The algorithm should run in linear time and in O(1) space.
*/

import java.util.List;
import java.util.LinkedList;

public class MajorityElementII {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		List<Integer> numList = majorityElement(nums);
		for (int n : numList) {
			System.out.print(n + " ");
		}

		System.out.println();
	}

	/*
		moore majority vote, find all numbers that appears > n/m
		where m is the count of result
	*/

	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new LinkedList<>();
		if (nums.length <= 0) return result;

		int n1 = nums[0], n2 = nums[0], count1 = 0, count2 = 0;

		for (int num : nums) {
			if (num == n1) {
				count1++;
			} else if (num == n2) {
				count2++;
			} else if (count1 == 0) {
				n1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				n2 = num;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;

		for (int num : nums) {
			if (num == n1) {
				count1++;
			} else if (num == n2) {
				count2++;
			}
		}

		if (count1 > nums.length / 3) {
			result.add(n1);
		}
		if (count2 > nums.length / 3) {
			result.add(n2);
		}

		return result;
	}
}