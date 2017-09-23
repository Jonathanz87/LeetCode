/*
	problem 205
	Given two strings s and t, determine if they are isomorphic.
	Two strings are isomorphic if the characters in s can be replaced to get t.
	All occurrences of a character must be replaced with another character
	while preserving the order of characters.
	No two characters may map to the same character but a character may map to itself.
	For example,
	Given "egg", "add", return true.
	Given "foo", "bar", return false.
	Given "paper", "title", return true.
	Note:
	You may assume both s and t have the same length.
*/

public class IsomorphicStrings {
	public static void main(String[] args) {
		System.out.println(isIsomorphic(args[0], args[1]));
	}

	public static boolean isIsomorphic(String s, String t) {
		char[] charMap = new char[256];
		boolean[] isMapped = new boolean[256];

		for (int i = 0, len = s.length(); i < len; i++) {
			if (charMap[s.charAt(i)] == '\u0000') {
				if (isMapped[t.charAt(i)]) {
					return false;
				}
				charMap[s.charAt(i)] = t.charAt(i);
				isMapped[t.charAt(i)] = true;
			} else if (charMap[s.charAt(i)] != t.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
