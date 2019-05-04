/*
	961. N-Repeated Element in Size 2N Array
	In a array A of size 2N, there are N+1 unique elements,
	and exactly one of these elements is repeated N times.
	Return the element repeated N times.
	Example 1:
		Input: [1,2,3,3]
		Output: 3
	Example 2:
		Input: [2,1,2,5,3,2]
		Output: 2
	Example 3:
		Input: [5,1,5,2,5,3,5,4]
		Output: 5
	Note:
		4 <= A.length <= 10000
		0 <= A[i] < 10000
		A.length is even
*/

public class NRepeatedElementInSize2NArray {
	public int repeatedNTimes(int[] A) {
		if (A[0] == A[1] || A[0] == A[2] || A[0] == A[3]) {
			return A[0];
		}
		if (A[1] == A[2] || A[1] == A[3]) {
			return A[1];
		}
		if (A[2] == A[3]) {
			return A[2];
		}

		for (int i = 5; i < A.length; i++) {
			if (A[i] == A[i - 1]) {
				return A[i];
			}
		}

		return -1;
	}

	public int repeatedNTimes2(int[] A) {
		for (int i = 2; i < A.length; i++) {
			if (A[i] == A[i - 1] || A[i] == A[i - 2]) {
				return A[i];
			}
		}

		return A[A.length - 1];
	}
}