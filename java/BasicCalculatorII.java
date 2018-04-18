/*
	problem 227
	Implement a basic calculator to evaluate a simple expression string.
	The expression string contains only non-negative integers,
	+, -, *, / operators and empty spaces .
	The integer division should truncate toward zero.
	You may assume that the given expression is always valid.
	Some examples:
		"3+2*2" = 7
		" 3/2 " = 1
		" 3+5 / 2 " = 5
*/

public class BasicCalculatorII {
	public static void main(String[] args) {
		System.out.println(calculate(args[0]));
	}
	public static int calculate(String s) {
		int[] stack = new int[s.length() / 2 + 1];
		int pt = 0;
		char preSign = '+';

		for (char c : s.toCharArray()) {
			if (c >= '0' && c <= '9') {
				stack[pt] = stack[pt] * 10 + c - '0';
			} else if (c == ' ') {

			} else 	{
				if (preSign == '-') {
					stack[pt] = -stack[pt];
					pt++;
				} else if (preSign == '*') {
					stack[pt - 1] *= stack[pt];
					stack[pt] = 0;
				} else if (preSign == '/') {
					stack[pt - 1] /= stack[pt];
					stack[pt] = 0;
				} else {
					pt++;
				}
				preSign = c;
			}
		}

		if (preSign == '-') {
			stack[pt] = -stack[pt];
			pt++;
		} else if (preSign == '*') {
			stack[pt - 1] *= stack[pt];
		} else if (preSign == '/') {
			stack[pt - 1] /= stack[pt];
		} else {
			pt++;
		}

		for (int i = 1; i < pt; i++) {
			stack[0] += stack[i];
		}
		return stack[0];
	}
}