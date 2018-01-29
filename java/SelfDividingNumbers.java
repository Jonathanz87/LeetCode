/*
	problem 728
	A self-dividing number is a number that is divisible by every digit it contains.
	For example,
	128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
	Also, a self-dividing number is not allowed to contain the digit zero.
	Given a lower and upper number bound,
	output a list of every possible self dividing number,
	including the bounds if possible.
	Example 1:
		Input: left = 1, right = 22
		Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
	Note:
		The boundaries of each input argument are 1 <= left <= right <= 10000.
*/

import java.util.List;
import java.util.LinkedList;

public class SelfDividingNumbers {
	public static void main(String[] args) {
		List<Integer> numberList = selfDividingNumbers(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

		for (int n : numberList) {
			System.out.print(n + " ");
		}

		System.out.println();
	}


	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> numberList = new LinkedList<>();
		while (left <= right) {
			if (isSelfDividingNumber(left)) {
				numberList.add(left);
			}
			left++;
		}

		return numberList;
	}

	private static boolean isSelfDividingNumber(int n) {
		if (n <= 0) return false;
		int number = n;
		while (n > 0) {
			int r = n % 10;
			if (r == 0 || number % r != 0) {
				return false;
			}
			n /= 10;
		}
		return true;
	}
}