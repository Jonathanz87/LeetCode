/*
	problem 856
	Given a balanced parentheses string S, compute the score of the string based on the following rule:
	() has score 1
	AB has score A + B, where A and B are balanced parentheses strings.
	(A) has score 2 * A, where A is a balanced parentheses string.
	Example 1:
		Input: "()"
		Output: 1
	Example 2:
		Input: "(())"
		Output: 2
	Example 3:
		Input: "()()"
		Output: 2
	Example 4:
		Input: "(()(()))"
		Output: 6

	Note:
		S is a balanced parentheses string, containing only ( and ).
		2 <= S.length <= 50
*/

public class ScoreOfParentheses {
	public static void main(String[] args) {
		System.out.println(scoreOfParentheses(args[0]));
	}

	public static int scoreOfParentheses(String S) {
		if (S == null || S.length() <= 0) return 0;
		int[] score = new int[S.length() / 2];
		int index = -1;

		for (char c : S.toCharArray()) {
			if (c == '(') {
				score[++index] = 0;
			} else {
				if (score[index] == 0) {
					score[index] = 1;
				} else {
					while (score[index - 1] != 0) {
						score[index - 1] += score[index];
						index--;
					}
					score[index - 1] = score[index] * 2;
					index--;
				}
			}
		}

		while (index > 0) {
			score[index - 1] += score[index];
			index--;
		}

		return score[0];
	}
}