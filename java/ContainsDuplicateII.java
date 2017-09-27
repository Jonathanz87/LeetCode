/*
	problem 219
	Given an array of integers and an integer k,
	find out whether there are two distinct indexes i and j in the array such that
	nums[i] = nums[j] and the absolute difference between i and j is at most k.
*/

import java.util.Set;
import java.util.HashSet;
public class ContainsDuplicateII {

	public static void main(String[] args){
		System.out.println(containsNearbyDuplicate(new int[]{99,99}, 2));
	}
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length == 0) return false;
		Set<Integer> numSet = new HashSet<>();
		int i = 0;

		while (i < nums.length && i <= k) {
			if (!numSet.add(nums[i])) {
				return true;
			}
			i++;
		}

		while (i < nums.length) {
			numSet.remove(nums[i - k - 1]);
			if (!numSet.add(nums[i])) {
				return true;
			}
			i++;
		}

		return false;
	}
}