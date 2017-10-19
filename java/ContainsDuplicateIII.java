/*
	problem 220
	Given an array of integers,
	find out whether there are two distinct indices i and j in the array
	such that the absolute difference between nums[i] and nums[j] is at most t
	and the absolute difference between i and j is at most k.
*/

import java.util.Map;
import java.util.HashMap;

public class ContainsDuplicateIII {
	public static void main(String[] args) {
		int[] nums = { -3, 3};
		System.out.println(containsNearbyAlmostDuplicate2(nums, 2, 4));
	}

	//n^2 timeout
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1, len = i + k; j < nums.length && j <= len; j++) {
				if (Math.abs((long)nums[i] - (long)nums[j]) <= t) {
					return true;
				}
			}
		}
		return false;
	}

	//bucket n
	public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (t < 0) return false;
		Map<Long, Long> numMap = new HashMap<>();
		long w = t + 1;
		int rightIndex = 0, leftIndex = 0;
		while (rightIndex < nums.length && rightIndex <= k) {
			long key = getKey(nums[rightIndex], w);
			if (numMap.containsKey(key)) {
				return true;
			} else if (numMap.containsKey(key - 1) && Math.abs(numMap.get(key - 1) - nums[rightIndex]) <= t) {
				return true;
			} else if (numMap.containsKey(key + 1) && Math.abs(numMap.get(key + 1) - nums[rightIndex]) <= t) {
				return true;
			}
			numMap.put(key, (long)nums[rightIndex]);
			rightIndex++;
		}

		while (rightIndex < nums.length) {
			numMap.remove(getKey(nums[leftIndex++], w));

			long key = getKey(nums[rightIndex], w);
			if (numMap.containsKey(key)) {
				return true;
			} else if (numMap.containsKey(key - 1) && Math.abs(numMap.get(key - 1) - nums[rightIndex]) <= t) {
				return true;
			} else if (numMap.containsKey(key + 1) && Math.abs(numMap.get(key + 1) - nums[rightIndex]) <= t) {
				return true;
			}
			numMap.put(key, (long)nums[rightIndex]);
			rightIndex++;
		}

		return false;

	}

	private static long getKey(int num, long w) {
		return num < 0 ? (num / w) - 1 : num / w;
	}
}