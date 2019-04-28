/*
	problem 788
	X is a good number if after rotating each digit individually by 180 degrees,
	we get a valid number that is different from X.
	Each digit must be rotated - we cannot choose to leave it alone.
	A number is valid if each digit remains a digit after rotation.
	0, 1, and 8 rotate to themselves;
	2 and 5 rotate to each other;
	6 and 9 rotate to each other,
	and the rest of the numbers do not rotate to any other number and become invalid.
	Now given a positive number N, how many numbers X from 1 to N are good?
	N  will be in range [1, 10000].
*/

public class RotatedDigits {
	public int rotatedDigits(int N) {
		if (N < 2) {
			return 0;
		}
		if (N < 5) {
			return 1;
		}
		if (N < 6) {
			return 2;
		}
		if (N < 9) {
			return 3;
		}
		if (N < 12) {
			return 4;
		}

		int ct = 4;
		boolean[] validNumbers = new boolean[N + 1];
		boolean[] goodNumbers = new boolean[N + 1];

		validNumbers[0] = true;
		validNumbers[1] = true;
		validNumbers[2] = true;
		validNumbers[5] = true;
		validNumbers[6] = true;
		validNumbers[8] = true;
		validNumbers[9] = true;
		validNumbers[10] = true;
		validNumbers[11] = true;
		goodNumbers[2] = true;
		goodNumbers[5] = true;
		goodNumbers[6] = true;
		goodNumbers[9] = true;

		for (int n = 12; n <= N; n++) {
			int left = n / 10;
			int right = n % 10;

			if (validNumbers[left] && validNumbers[right]) {
				validNumbers[n] = true;
				if (goodNumbers[left] || goodNumbers[right]) {
					goodNumbers[n] = true;
					ct++;
				}
			}
		}
		return ct;
	}
}