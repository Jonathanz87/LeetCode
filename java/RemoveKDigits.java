/*
	problem 402
	Given a non-negative integer num represented as a string,
	remove k digits from the number so that the new number is the smallest possible.
	Note:
		The length of num is less than 10002 and will be ≥ k.
		The given num does not contain any leading zero.
	Example 1:
		Input: num = "1432219", k = 3
		Output: "1219"
		Explanation: Remove the three digits 4, 3, and 2 to
		form the new number 1219 which is the smallest.
	Example 2:
		Input: num = "10200", k = 1
		Output: "200"
		Explanation: Remove the leading 1 and the number is 200.
		Note that the output must not contain leading zeroes.
	Example 3:
		Input: num = "10", k = 2
		Output: "0"
		Explanation: Remove all the digits from the number
		and it is left with nothing which is 0.
*/

public class RemoveKDigits {
	public static void main(String[] args) {
		System.out.println(removeKdigits(args[0], Integer.parseInt(args[1])));
	}
	public static String removeKdigits(String num, int k) {
		if (num.length() <= k) return "0";

		final int NUM_LEN = num.length();
		final int STACK_LEN = NUM_LEN - k;
		int stackIndex = -1;
		char[] numChar = num.toCharArray();
		char[] digitsStack = new char[STACK_LEN];

		digitsStack[++stackIndex] = numChar[0];

		for (int i = 1; i < NUM_LEN; i++) {
			int minStackIndex = Math.max(0, i - k);
			while (stackIndex >= minStackIndex && digitsStack[stackIndex] > numChar[i]) {
				stackIndex--;
			}

			if (stackIndex + 1 < STACK_LEN) {
				digitsStack[++stackIndex] = numChar[i];
			}
		}

		StringBuilder builder = new StringBuilder();
		builder.append(digitsStack);

		while (builder.length() > 0 && builder.charAt(0) == '0') {
			builder.deleteCharAt(0);
		}

		return builder.length() <= 0 ? "0" : builder.toString();
	}
}