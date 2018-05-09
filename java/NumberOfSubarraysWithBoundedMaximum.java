/*
	problem 795
	We are given an array A of positive integers, 
	and two positive integers L and R (L <= R).
	Return the number of (contiguous, non-empty) subarrays such that 
	the value of the maximum array element in that subarray is at least L and at most R.
	Example :
		Input: 
		A = [2, 1, 4, 3]
		L = 2
		R = 3
		Output: 3
		Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
	Note:
		L, R  and A[i] will be an integer in the range [0, 10^9].
		The length of A will be in the range of [1, 50000].
*/

public class NumberOfSubarraysWithBoundedMaximum {
	public int numSubarrayBoundedMax(int[] A, int L, int R) {
		int result = 0;
		int lessEqualThanRCt = 0;
		int lessThanLCt = 0;

		for (int n : A) {
			if (n > R) {
				lessEqualThanRCt = 0;
				lessThanLCt = 0;
			} else {
				if (n < L) {
					result -= ++lessThanLCt;
				} else {
					lessThanLCt = 0;
				}
				result += ++lessEqualThanRCt;
			}
		}

		return result;
	}
}
