/*
	problem 264
	Write a program to find the n-th ugly number.
	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
	For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
	Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
*/

/*
	solution
	ugly numbers	: 	1	2	3	4	5	6	8...

	2 factor 		:	2	2	6	8	10	12	16
	3 factor 		:	3	6	9	12	15	18	24
	5 factor 		:	5	10	15	20	25	30	35

	add all the n factors in order, is the ugly numbers sequence
*/

public class UglyNumberII {
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(Integer.parseInt(args[0])));
	}


	public static int nthUglyNumber(int n) {
		int[] uglyArray = new int[n];
		int twoFactor = 2, threeFactor = 3, fiveFactor = 5;
		int twoIndex = 1, threeIndex = 1, fiveIndex = 1;

		uglyArray[0] = 1;

		for (int i = 1; i < n; i++) {
			int min = Math.min(Math.min(twoFactor, threeFactor), fiveFactor);
			uglyArray[i] = min;

			if (twoFactor == min) {
				twoFactor = 2 * uglyArray[twoIndex++];
			}
			if (threeFactor == min) {
				threeFactor = 3 * uglyArray[threeIndex++];
			}
			if (fiveFactor == min) {
				fiveFactor = 5 * uglyArray[fiveIndex++];
			}
		}

		return uglyArray[n - 1];
	}

}