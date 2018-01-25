/*
	problem 397
	Given a positive integer n and you can do operations as follow:
	If n is even, replace n with n/2.
	If n is odd, you can replace n with either n + 1 or n - 1.
	What is the minimum number of replacements needed for n to become 1?
	Example 1:
		Input: 8
		Output: 3
		Explanation: 8 -> 4 -> 2 -> 1
	Example 2:
		Input: 7
		Output: 4
		Explanation: 7 -> 8 -> 4 -> 2 -> 1
		or 7 -> 6 -> 3 -> 2 -> 1

*/
public class IntegerReplacement {
	public static void main(String[] args) {
		System.out.println(integerReplacement(Integer.parseInt(args[0])));
	}
	public static int integerReplacement(long n) {
		if (n <= 0) return 0;
		if (n == 2) {
			return 1;
		}
		int count = 0;
		while (n % 2 == 0) {
			n /= 2;
			count++;
		}
		if (n == 1) {
			return count;
		}
		return Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1 + count;
	}
	public static int integerReplacement(int n) {
		return integerReplacement((long)n);
	}

	public int integerReplacement2(int n) {
		if (n == Integer.MAX_VALUE) return 32;
		int op = 0;
		while (n > 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				if ((n + 1) % 4 == 0 && n != 3) {
					n++;
				} else {
					n--;
				}
			}
			op++;
		}
		return op;
	}