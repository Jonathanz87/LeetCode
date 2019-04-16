/*
	problem 953
	In an alien language, surprisingly they also use english lowercase letters,
	but possibly in a different order.
	The order of the alphabet is some permutation of lowercase letters.
	Given a sequence of words written in the alien language,
	and the order of the alphabet, return true if and only if
	the given words are sorted lexicographicaly in this alien language.
	Example 1:
		Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
		Output: true
		Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

	Example 2:
		Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
		Output: false
		Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

	Example 3:
		Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
		Output: false
		Explanation: The first three characters "app" match, and the second string is shorter (in size.)
		According to lexicographical rules "apple" > "app", because 'l' > '∅',
		where '∅' is defined as the blank character which is less than any other character (More info).

	Note:
		1 <= words.length <= 100
		1 <= words[i].length <= 20
		order.length == 26
		All characters in words[i] and order are english lowercase letters.
*/

public class VerifyingAnAlienDictionary {
	public boolean isAlienSorted(String[] words, String order) {
		int[] letterMap = new int[26];
		for (int i = 0; i < 26; i++) {
			letterMap[order.charAt(i) - 'a'] = i;
		}

		for (int i = 1, len = words.length; i < len; i++) {
			if (!lessThan(words[i - 1], words[i], letterMap)) {
				return false;
			}
		}
		return true;
	}

	private static boolean lessThan(String str1, String str2, int[] letterMap) {
		int i1 = 0;
		int i2 = 0;
		int len1 = str1.length();
		int len2 = str2.length();

		while (i1 < len1 && i2 < len2) {
			char c1 = str1.charAt(i1);
			char c2 = str2.charAt(i2);

			if (c1 != c2) {
				return letterMap[c1 - 'a'] < letterMap[c2 - 'a'];
			}
			i1++;
			i2++;
		}

		return len1 < len2;
	}
}