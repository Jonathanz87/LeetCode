/*
	problem 313
	Write a program to find the nth super ugly number.
	Super ugly numbers are positive numbers whose
	all prime factors are in the given prime list primes of size k.
	For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
	is the sequence of the first 12 super ugly numbers
	given primes = [2, 7, 13, 19] of size 4.
	Note:
	(1) 1 is a super ugly number for any given primes.
	(2) The given numbers in primes are in ascending order.
	(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
	(4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
*/

public class SuperUglyNumber {
	public static void main(String[] args) {
		System.out.println(nthSuperUglyNumber(2, new int[] {2, 7, 13, 19}));
	}

	public static int nthSuperUglyNumber(int n, int[] primes) {
		int[] uglyNums = new int[n];
		int[] primesTimesFactor = new int[primes.length];
		int[] indexes = new int[primes.length];
		int uglyIndex = 1;
		uglyNums[0] = 1;

		for (int i = 0; i < primes.length; i++) {
			primesTimesFactor[i] = primes[i];
		}

		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = 1;
		}

		while (uglyIndex < n - 1) {
			int smallestIndex = findSmallestIndex(primesTimesFactor);
			int smallest = primesTimesFactor[smallestIndex];
			if (smallest != uglyNums[uglyIndex]) {
				uglyNums[++uglyIndex] = smallest;
			}
			primesTimesFactor[smallestIndex] = primes[smallestIndex] * uglyNums[++indexes[smallestIndex]];
		}

		return uglyNums[n - 1];
	}

	private static int findSmallestIndex(int[] primes) {
		int smallestIndex = 0;
		for (int i = 1; i < primes.length; i++) {
			if (primes[i] < primes[smallestIndex]) {
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}
}