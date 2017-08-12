/*
	problem 217
	Given an array of integers, find if the array contains any duplicates. 
	Your function should return true if any value appears at least twice in the array, 
	and it should return false if every element is distinct.
*/

import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate{
	public static void main(String[] args) {
		int[] nums = new int[args[0].length()];
		for(int i = 0; i < nums.length; i++){
			nums[i] = args[0].charAt(i) - '0';
		}

		System.out.println(containsDuplicate2(nums));
	}

	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> numSet = new HashSet<>(); 
		for(int n : nums){
			if(numSet.contains(n))
				return true;
			numSet.add(n);
		}
		return false;
	}

	public static boolean containsDuplicate2(int[] nums) {
		final int SIZE = nums.length;
		if(SIZE <= 1){
			return false;
		}
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i : nums){
			max = Math.max(i, max);
			min = Math.min(i, min);
		}
		boolean[] map = new boolean[max - min + 1];
		for(int i : nums){
			if(map[i - min]){
				return true;
			}
			map[i - min] = true;
		}

		return false;
	}
}