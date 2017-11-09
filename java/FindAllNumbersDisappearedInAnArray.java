/*
	problem 448
	Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
	some elements appear twice and others appear once.
	Find all the elements of [1, n] inclusive that do not appear in this array.
	Could you do it without extra space and in O(n) runtime?
	You may assume the returned list does not count as extra space.
	Example:
		Input:
		[4,3,2,7,8,2,3,1]
		Output:
		[5,6]
*/

/*
	solution 
	use each number as index,
	set the index number to nums[nums[i] - 1] = -nums[nums[i] - 1] can be another solution
*/

import java.util.List;
import java.util.LinkedList;

public class FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			int j = nums[i];
			while (nums[j - 1] != j) {
				int temp = nums[j - 1];
				nums[j - 1] = j;
				j = temp;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				result.add(i + 1);
			}
		}

		return result;
	}
}