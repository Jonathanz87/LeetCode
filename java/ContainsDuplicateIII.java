/*
	problem 220
	Given an array of integers,
	find out whether there are two distinct indices i and j in the array
	such that the absolute difference between nums[i] and nums[j] is at most t
	and the absolute difference between i and j is at most k.
*/

public class ContainsDuplicateIII {
	//n^2 timeout
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1, len = i + k; j < nums.length && j <= len; j++) {
				if (Math.abs((long)nums[i] - (long)nums[j]) <= t) {
					return true;
				}
			}
		}
		return false;
	}
}