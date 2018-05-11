/*
	problem 678
	Given a string containing only three types of characters: '(', ')' and '*', 
	write a function to check whether this string is valid. 
	We define the validity of a string by these rules:
	Any left parenthesis '(' must have a corresponding right parenthesis ')'.
	Any right parenthesis ')' must have a corresponding left parenthesis '('.
	Left parenthesis '(' must go before the corresponding right parenthesis ')'.
	'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
	An empty string is also valid.
	Example 1:
		Input: "()"
		Output: True
	Example 2:
		Input: "(*)"
		Output: True
	Example 3:
		Input: "(*))"
		Output: True
	Note:
		The string size will be in the range [1, 100].
*/

public class ValidParenthesisString {
	public static void main(String[] args) {
		System.out.println(checkValidString(args[0]));
	}
	public static boolean checkValidString(String s) {
		int lowLeft = 0;
		int highLeft = 0;

		for (char c : s.toCharArray()) {
			if (c == '(') {
				lowLeft++;
				highLeft++;
			} else if (c == ')') {
				lowLeft = Math.max(0, lowLeft - 1);
				highLeft--;
			} else {
				lowLeft = Math.max(0, lowLeft - 1);
				highLeft++;
			}
			if (highLeft < 0) {
				return false;
			}

			System.out.println(c + " - " + lowLeft + " : " + highLeft);
		}

		return lowLeft <= 0 && highLeft >= 0;
	}
}
