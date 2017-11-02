/*
	problem 349
	Given two arrays, write a function to compute their intersection.
	Example:
		Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	Note:
	Each element in the result must be unique.
	The result can be in any order.
*/

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> numSet = new HashSet<>();
		Set<Integer> resultSet = new HashSet<>();
		int[] result = null;

		for (int n : nums1) {
			numSet.add(n);
		}

		for (int n : nums2) {
			if (numSet.contains(n)) {
				resultSet.add(n);
			}
		}

		result = new int[resultSet.size()];
		int i = 0;
		for (int n : resultSet) {
			result[i++] = n;
		}

		return result;
	}
}