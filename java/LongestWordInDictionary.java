/*
	problem 720
	Given a list of strings words representing an English Dictionary,
	find the longest word in words that can be built one character at a time by other words in words.
	If there is more than one possible answer,
	return the longest word with the smallest lexicographical order.
	If there is no answer, return the empty string.
	Example 1:
		Input: words = ["w","wo","wor","worl", "world"]
		Output: "world"
		Explanation:
		The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
	Example 2:
		Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
		Output: "apple"
		Explanation:
		Both "apply" and "apple" can be built from other words in the dictionary.
		However, "apple" is lexicographically smaller than "apply".
	Note:
		All the strings in the input will only contain lowercase letters.
		The length of words will be in the range [1, 1000].
		The length of words[i] will be in the range [1, 30].
*/

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class LongestWordInDictionary {
	public static void main(String[] args) {
		System.out.println(longestWord(args));
	}

	public static String longestWord(String[] words) {
		Set<String> wordSet = new HashSet<>();
		Arrays.sort(words);
		int longest = 0;
		String result = null;

		wordSet.add("");
		for (String word : words) {
			if (wordSet.contains(word.substring(0, word.length() - 1))) {
				wordSet.add(word);
				if (word.length() > longest) {
					longest = word.length();
					result = word;
				}
			}
		}
		return result;
	}
}
