/*
	problem 150
	Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	Valid operators are +, -, *, /.
	Each operand may be an integer or another expression.
	Some examples:
	  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		System.out.println(evalRPN(args));
	}

	public static int evalRPN(String[] tokens) {
		if (tokens.length <= 0) return 0;
		int[] stack = new int[tokens.length];
		int tokensIndex = 0, stackIndex = -1;

		while (tokensIndex < tokens.length) {
			if (isSign(tokens[tokensIndex])) {
				int reuslt =
				    calculate(stack[stackIndex--], stack[stackIndex--], tokens[tokensIndex]);
				stack[++stackIndex] = reuslt;
			} else {
				stack[++stackIndex] = Integer.parseInt(tokens[tokensIndex]);
			}
			tokensIndex++;
		}

		return stack[0];
	}

	public static boolean isSign(String token) {
		return "+".equals(token) ||
		       "-".equals(token) ||
		       "*".equals(token) ||
		       "/".equals(token);
	}

	public static int calculate(int n1, int n2, String sign) {
		switch (sign) {
		case "+" : return n2 + n1;
		case "-" : return n2 - n1;
		case "*" : return n2 * n1;
		case "/" : return n2 / n1;
		}
		return 0;
	}
}