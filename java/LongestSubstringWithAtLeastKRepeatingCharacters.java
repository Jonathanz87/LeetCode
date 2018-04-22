/*
	problem 395
	Find the length of the longest substring T of a given string (consists of lowercase letters only)
	such that every character in T appears no less than k times.
	Example 1:
		Input: s = "aaabb", k = 3
		Output: 3
		The longest substring is "aaa", as 'a' is repeated 3 times.
	Example 2:
		Input: s = "ababbc", k = 2
		Output: 5
		The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/

public class LongestSubstringWithAtLeastKRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(longestSubstring(args[0], Integer.parseInt(args[1])));
	}

	public static int longestSubstring(String s, int k) {
		if (k <= 1) {
			return s.length();
		}
		return longestSubstring(s, k, 0, s.length() - 1);

	}

	private static int longestSubstring(String s, int k, int leftIndex, int rightIndex) {
		if (rightIndex - leftIndex + 1 < k) {
			return 0;
		}

		int[] letterCt = new int[26];
		int maxSize = 0;
		int beginIndex = leftIndex;

		for (int i = leftIndex; i <= rightIndex; i++) {
			letterCt[s.charAt(i) - 'a']++;
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (letterCt[s.charAt(i) - 'a'] < k) {
				maxSize = Math.max(longestSubstring(s, k, beginIndex, i - 1), maxSize);
				beginIndex = i + 1;
			}
		}

		return (beginIndex == leftIndex)
		       ? (rightIndex - leftIndex + 1)
		       : Math.max(longestSubstring(s, k, beginIndex, rightIndex), maxSize);
	}
}