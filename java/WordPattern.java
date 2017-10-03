/*
	problem 290
	Given a pattern and a string str, find if str follows the same pattern.
	Here follow means a full match,
	such that there is a bijection between a letter in pattern and a non-empty word in str.
	Examples:
		pattern = "abba", str = "dog cat cat dog" should return true.
		pattern = "abba", str = "dog cat cat fish" should return false.
		pattern = "aaaa", str = "dog cat cat dog" should return false.
		pattern = "abba", str = "dog dog dog dog" should return false.
	Notes:
	You may assume pattern contains only lowercase letters,
	and str contains lowercase letters separated by a single space.
*/

import java.util.Map;
import java.util.HashMap;

public class WordPattern {
	public static void main(String[] args) {
		System.out.println(wordPattern(args[0], args[1]));
	}

	public static boolean wordPattern(String pattern, String str) {
		final int LENGTH = pattern.length();
		final String[] strArray = str.split(" ");
		if (LENGTH != strArray.length) return false;

		final boolean[] LETTER_MAP = new boolean[26];
		final Map<String, Character> WORD_MAP = new HashMap<>();

		for (int i = 0; i < LENGTH; i++) {
			if (WORD_MAP.containsKey(strArray[i])) {
				if (WORD_MAP.get(strArray[i]) != pattern.charAt(i)) {
					return false;
				}
			} else {
				if (LETTER_MAP[pattern.charAt(i) - 'a']) {
					return false;
				}
				WORD_MAP.put(strArray[i], pattern.charAt(i));
				LETTER_MAP[pattern.charAt(i) - 'a'] = true;
			}
		}

		return true;
	}
}

