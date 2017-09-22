/*
	problem 202
	Write an algorithm to determine if a number is "happy".
	A happy number is a number defined by the following process:
	Starting with any positive integer,
	replace the number by the sum of the squares of its digits,
	and repeat the process until the number equals 1 (where it will stay),
	or it loops endlessly in a cycle which does not include 1.
	Those numbers for which this process ends in 1 are happy numbers.
	Example: 19 is a happy number
		1^2 + 9^2 = 82
		8^2 + 2^2 = 68
		6^2 + 8^2 = 100
		1^2 + 0^2 + 0^2 = 1
*/

import java.util.Set;
import java.util.HashSet;

public class HappyNumber {
	public static void main(String[] args) {
		System.out.println(isHappy(Integer.parseInt(args[0])));
	}

	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (n != 1) {
			n = calculate(n);
			if (!set.add(n)) {
				return false;
			}
		}

		return true;
	}

	//slow move 1 fast move 2 each time, linked Node loop problem
	public static boolean isHappy2(int n) {
		int slow = n, fast = n;
		do {
			slow = calculate(slow);
			fast = calculate(calculate(fast));
		} while (slow != fast);
		return fast == 1;
	}

	private static int calculate(int n) {
		int result = 0;
		while (n > 0) {
			int digit = n % 10;
			n /= 10;
			result += Math.pow(digit, 2);
		}
		return result;
	}
}