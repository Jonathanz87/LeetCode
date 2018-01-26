/*
	problem 423
	Given a non-empty string containing an out-of-order English
	representation of digits 0-9,
	output the digits in ascending order.
	Note:
		Input contains only lowercase English letters.
		Input is guaranteed to be valid and can be transformed to its original digits.
		That means invalid inputs such as "abc" or "zerone" are not permitted.
		Input length is less than 50,000.
	Example 1:
		Input: "owoztneoer"
		Output: "012"
	Example 2:
		Input: "fviefuro"
		Output: "45"
*/
/*
	solution
	0 zero
	1 one
	2 two
	3 three
	4 four
	5 five
	6 six
	7 seven
	8 eight
	9 nine

	z 0 only
	w 2 only
	u 4 only
	x 6 only
	g 8 only

	f 5 only after 4
	s 7 only after 6
	i 9 only after 6 8 5

	o 1 only after 2 4
	t 3 only after all
*/

public class ReconstructOriginalDigitsFromEnglish {
	public static void main(String[] args){
		System.out.println(originalDigits(args[0]));
	}

	private static final char[][] DIGITS_DIC = {
		{'0', 'z', 'e', 'r', 'o'},
		{'2', 'w', 't', 'o'},
		{'4', 'u', 'f', 'o', 'r'},
		{'6', 'x', 's', 'i'},
		{'8', 'g', 'e', 'i', 'h', 't'},
		{'5', 'f', 'i', 'v', 'e'},
		{'7', 's', 'e', 'v', 'e', 'n'},
		{'9', 'i', 'n', 'n', 'e'},
		{'1', 'o', 'n', 'e'},
		{'3', 't', 'h', 'r', 'e', 'e'}
	};
	public static String originalDigits(String s) {
		int[] numberCount = new int[10];
		char[] letterCount = new char[26];

		for (char c : s.toCharArray()) {
			letterCount[c - 'a']++;
		}

		for (char[] digit : DIGITS_DIC) {
			int ct = letterCount[digit[1] - 'a'];
			if (ct > 0) {
				letterCount[digit[1] - 'a'] = 0;
				numberCount[digit[0] - '0'] = ct;
				for (int i = 2, len = digit.length; i < len; i++) {
					letterCount[digit[i] - 'a'] -= ct;
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0, len = numberCount.length; i < len; i++) {
			for (int c = numberCount[i]; c > 0; c--) {
				builder.append(i);
			}
		}

		return builder.toString();
	}
}































