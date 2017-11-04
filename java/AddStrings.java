/*
	problem 415
	Given two non-negative integers num1 and num2 represented as string,
	return the sum of num1 and num2.
	Note:
		The length of both num1 and num2 is < 5100.
		Both num1 and num2 contains only digits 0-9.
		Both num1 and num2 does not contain any leading zero.
		You must not use any built-in BigInteger library or
		convert the inputs to integer directly.
*/

public class AddStrings {
	public static void main(String[] args) {
		System.out.println(addStrings(args[0], args[1]));
	}

	public static String addStrings(String num1, String num2) {
		int longIndex, shortIndex, carry = 0;
		char[] longerChar, shorterChar;
		if (num1.length() > num2.length()) {
			longerChar = num1.toCharArray();
			shorterChar = num2.toCharArray();
		} else {
			longerChar = num2.toCharArray();
			shorterChar = num1.toCharArray();
		}

		longIndex = longerChar.length - 1;
		shortIndex = shorterChar.length - 1;

		while (shortIndex >= 0) {
			longerChar[longIndex] += shorterChar[shortIndex] - '0' + carry;
			if (longerChar[longIndex] > '9') {
				longerChar[longIndex] -= 10;
				carry = 1;
			} else {
				carry = 0;
			}

			longIndex--;
			shortIndex--;
		}

		while (carry >= 1 && longIndex >= 0) {
			longerChar[longIndex] += carry;
			if (longerChar[longIndex] > '9') {
				longerChar[longIndex] -= 10;
				carry = 1;
			} else {
				carry = 0;
			}

			longIndex--;
		}

		return carry >= 1 ? 1 + new String(longerChar) : new String(longerChar);

	}
}