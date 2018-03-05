/*
	problem 413
	A sequence of number is called arithmetic if it consists of at least three elements
	and if the difference between any two consecutive elements is the same.
	For example, these are arithmetic sequence:
	1, 3, 5, 7, 9
	7, 7, 7, 7
	3, -1, -5, -9
	The following sequence is not arithmetic.
	1, 1, 2, 5, 7
	A zero-indexed array A consisting of N numbers is given.
	A slice of that array is any pair of integers (P, Q)
	such that 0 <= P < Q < N.
	A slice (P, Q) of array A is called arithmetic if the sequence:
	A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular,
	this means that P + 1 < Q.
	The function should return the number of arithmetic slices in the array A.
	Example:
		A = [1, 2, 3, 4]
		return: 3, for 3 arithmetic slices in
		A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
*/

public class ArithmeticSlices {
	public static void main(String[] args) {
		int[] a = new int[args.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(args[i]);
		}

		System.out.println(numberOfArithmeticSlices2(a));
	}
	public static int numberOfArithmeticSlices(int[] A) {
		long diff = Long.MAX_VALUE;
		int ct = 0;
		int result = 0;

		for (int i = 1; i < A.length; i++) {
			if (diff == ((long)A[i] - (long)A[i - 1])) {
				ct++;
			} else {
				if (ct >= 3) {
					int n = ct - 2;
					result += (n + 1) * n / 2;
				}
				diff = ((long)A[i] - (long)A[i - 1]);
				ct = 2;
			}
		}

		if (ct >= 3) {
			int n = ct - 2;
			result += (n + 1) * n / 2;
		}

		return result;
	}

	public static int numberOfArithmeticSlices2(int[] A) {
		if (A == null || A.length < 3) return 0;

		int result = 0;
		int current = 0;

		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				result += ++current;
			} else {
				current = 0;
			}
		}

		return result;
	}
}