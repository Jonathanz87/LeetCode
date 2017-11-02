/*
	problem 367
	Given a positive integer num,
	write a function which returns True if num is a perfect square else False.
	Note: Do not use any built-in library function such as sqrt.
	Example 1:
		Input: 16
		Returns: True
	Example 2:
		Input: 14
		Returns: False
*/

public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num <= 0) return false;
		if (num == 1) return true;
		long small = 1, large = num / 2;

		while (small <= large) {
			long mid = (small + large) >> 1;
			long square = mid * mid;
			if (square > num) large = mid - 1;
			else if (square < num) small = mid + 1;
			else return true;
		}
		return false;
	}

	public boolean isPerfectSquare2(int num) {
		if (num <= 0) return false;
		if (num == 1) return true;
		int small = 1, large = num / 2;

		while (small <= large) {
			int mid = (small + large) >> 1;
			if (mid > num / mid) large = mid - 1;
			else if (mid < (double)num / mid) small = mid + 1;
			else return true;
		}
		return false;
	}
}