/*
	problem 520
	Given a word, you need to judge whether the usage of capitals in it is right or not.
	We define the usage of capitals in a word to be right when one of the following cases holds:
	All letters in this word are capitals, like "USA".
	All letters in this word are not capitals, like "leetcode".
	Only the first letter in this word is capital if it has more than one letter, like "Google".
	Otherwise, we define that this word doesn't use capitals in a right way.
	Example 1:
		Input: "USA"
		Output: True
	Example 2:
		Input: "FlaG"
		Output: False
*/

public class DetectCapital {
	public static void main(String[] args) {
		System.out.println(detectCapitalUse(args[0]));
	}

	public static boolean detectCapitalUse(String word) {
		int len = word.length();
		if (len < 2) return true;
		boolean isCapital = isCapital(word.charAt(len - 1));

		for (int i = len - 2; i > 0; i--) {
			if (isCapital(word.charAt(i)) != isCapital) {
				return false;
			}
		}

		if (isCapital) {
			return isCapital(word.charAt(0));
		}
		return true;
	}

	public static boolean isCapital(char c) {
		return c >= 'A' && c <= 'Z';
	}
}