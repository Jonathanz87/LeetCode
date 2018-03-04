/*
	problem 409
	Given a string which consists of lowercase or uppercase letters,
	find the length of the longest palindromes that can be built with those letters.
	This is case sensitive, for example "Aa" is not considered a palindrome here.
	Note:
		Assume the length of given string will not exceed 1,010.
	Example:
		Input:
		"abccccdd"
		Output: 7
		Explanation:
		One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

public class LongestPalindrome {
	public static void main(String[] args) {
		System.out.println(longestPalindrome(args[0]));
	}
	public static int longestPalindrome(String s) {
		if(s == null) return 0;
		boolean[] charMap = new boolean['z' + 1];
		int length = 0;
		for (char c : s.toCharArray()) {
			if (charMap[c]) {
				length += 2;
			}
			charMap[c] = !charMap[c];
		}

		return s.length() > length ? length + 1 : length;
	}
}
