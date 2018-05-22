/*
	problem 718
	Given two integer arrays A and B,
	return the maximum length of an subarray that appears in both arrays.
	Example 1:
		Input:
		A: [1,2,3,2,1]
		B: [3,2,1,4,7]
		Output: 3
		Explanation:
		The repeated subarray with maximum length is [3, 2, 1].
	Note:
		1 <= len(A), len(B) <= 1000
		0 <= A[i], B[i] < 100
*/

public class MaximumLengthOfRepeatedSubarray {
	public int findLength(int[] A, int[] B) {
		int maxCount = 0;
		int[] countTable = new int[B.length + 1];

		for (int a : A) {
			for (int j = B.length; j > 0; j--) {
				if (a == B[j - 1]) {
					countTable[j] = countTable[j - 1] + 1;
					maxCount = Math.max(countTable[j], maxCount);
				} else {
					countTable[j] = 0;
				}
			}
		}

		return maxCount;
	}
}