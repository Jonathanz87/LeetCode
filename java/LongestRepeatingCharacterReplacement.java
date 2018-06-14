/*
	problem 424
	Given a string that consists of only uppercase English letters,
	you can replace any letter in the string with another letter at most k times.
	Find the length of a longest substring containing all repeating letters
	you can get after performing the above operations.
	Note:
		Both the string's length and k will not exceed 104.
	Example 1:
		Input:
		s = "ABAB", k = 2
		Output:
		4
		Explanation:
		Replace the two 'A's with two 'B's or vice versa.
	Example 2:
		Input:
		s = "AABABBA", k = 1
		Output:
		4
		Explanation:
		Replace the one 'A' in the middle with 'B' and form "AABBBBA".
		The substring "BBBB" has the longest repeating letters, which is 4.
*/

public class LongestRepeatingCharacterReplacement {
	public static void main(String[] args) {
		System.out.println(characterReplacement2(args[0], Integer.parseInt(args[1])));
	}
	public static int characterReplacement(String s, int k) {
		if (s.length() <= 0) return 0;
		char[] chars = s.toCharArray();
		int maxCount = 1;
		for (int i = 0, len = chars.length - 1; i < len && (len - i + 1 + k) > maxCount; i++) {
			char c = chars[i];
			int replaceCt = k;
			int ct = 1;
			for (int j = i + 1; j <= len; j++) {
				if (chars[j] != c) {
					if (replaceCt <= 0)
						break;
					replaceCt--;
				}
				ct++;
			}
			maxCount = Math.max(maxCount, ct + replaceCt);

		}
		return Math.min(maxCount, s.length());
	}

	public static int characterReplacement2(String s, int k) {
		int[] letterCount = new int[26];
		int max = 0, start = 0, result = 0;

		for (int end = 0, len = s.length(); end < len; end++) {
			max = Math.max(++letterCount[s.charAt(end) - 'A'], max);

			while (end - start + 1 > k + max) {
				letterCount[s.charAt(start++) - 'A']--;
			}

			result = Math.max(end - start + 1, result);
		}

		return result;
	}

}