/*
	problem 658
	Given a sorted array, two integers k and x, 
	find the k closest elements to x in the array. 
	The result should also be sorted in ascending order. 
	If there is a tie, the smaller elements are always preferred.
	Example 1:
		Input: [1,2,3,4,5], k=4, x=3
		Output: [1,2,3,4]
	Example 2:
		Input: [1,2,3,4,5], k=4, x=-1
		Output: [1,2,3,4]
	Note:
		The value k is positive and will always be smaller than the length of the sorted array.
		Length of the given array is positive and will not exceed 104
		Absolute value of elements in the array and x will not exceed 104
*/

import java.util.List;
import java.util.LinkedList;

public class FindKClosestElements {
	public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
		List<Integer> result = new LinkedList<>();
		int l = 0, h = arr.length - k;

		while (l < h) {
			int m = (l + h) >> 1;
			if (x - arr[m] <= arr[m + k] - x) {
				h = m;
			} else {
				l = m + 1;
			}
		}

		for(int i = 0; i < k; i++){
			result.add(arr[l + i]);
		}

		return result;
	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new LinkedList<>();

		int l = 0, r = arr.length - 1;

		// find >= k
		while (l < r) {
			int m = (l + r) >> 1;
			if (arr[m] >= x) {
				r = m;
			} else {
				l = m + 1;
			}
		}

		l--;

		while (result.size() < k && l >= 0 && r <= arr.length - 1) {
			if (arr[r] - x < x - arr[l]) {
				result.add(arr[r++]);
			} else {
				result.add(0, arr[l--]);
			}
		}

		while (result.size() < k && l >= 0) {
			result.add(0, arr[l--]);
		}

		while (result.size() < k && r <= arr.length - 1) {
			result.add(arr[r++]);
		}

		return result;
	}
}