/*
	problem 318
	Given a string array words, find the maximum value of length(word[i]) * length(word[j])
	where the two words do not share common letters.
	You may assume that each word will contain only lower case letters.
	If no such two words exist, return 0.
	Example 1:
		Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
		Return 16
		The two words can be "abcw", "xtfn".
	Example 2:
		Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
		Return 4
		The two words can be "ab", "cd".
	Example 3:
		Given ["a", "aa", "aaa", "aaaa"]
		Return 0
		No such pair of words.
*/

public class MaximumProductOfWordLengths {
	public static int maxProductn2(String[] words) {
		int maxProduct = 0;
		for (int i = 0, iLen = words.length - 1, jLen = words.length; i < iLen; i++) {
			for (int j = i + 1; j < jLen; j++) {
				int product = words[i].length() * words[j].length();
				if (product > maxProduct && !haveCommomLetters(words[i], words[j])) {
					maxProduct = product;
				}
			}
		}
		return maxProduct;
	}

	private static boolean haveCommomLetters(String s1, String s2) {
		for (char c : s1.toCharArray()) {
			if (s2.contains(Character.toString(c))) {
				return true;
			}
		}
		return false;
	}

	// still in time complexity of n^2, but use bitmap to compare strings
	// a lot faster
	public int maxProductBitmap(String[] words) {
		int len = words.length;
		int[] element = new int[len];

		//set up bitmap
		for (int i = 0; i < len; i++) {
			char[] ch = words[i].toCharArray();
			for (int j = 0; j < ch.length; j++) {
				element[i] |= 1 << (ch[j] - 'a');
			}
		}

		int ans = 0;

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if ((element[i] & element[j]) == 0) {
					ans = Math.max(ans, words[i].length() * words[j].length());
				}
			}
		}
		return ans;
	}

}