/*
	problem 567
	Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
	In other words, one of the first string's permutations is the substring of the second string.
	Example 1:
		Input:s1 = "ab" s2 = "eidbaooo"
		Output:True
		Explanation: s2 contains one permutation of s1 ("ba").
	Example 2:
		Input:s1= "ab" s2 = "eidboaoo"
		Output: False
	Note:
		The input strings only contain lower case letters.
		The length of both given strings is in range [1, 10,000].
*/

public class PermutationInString {
	public static void main(String[] args) {
		System.out.println(checkInclusion(args[0], args[1]));
	}
	public static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) return false;

		int[] letterCount = new int[26];
		int pCount = 0, nCount = 0, s1Size = s1.length();
		char[] s2Char = s2.toCharArray();

		for (char c : s1.toCharArray()) {
			if (letterCount[c - 'a']++ == 0) {
				pCount++;
			}
		}

		for (int i = 0, size = s1.length(); i < size; i++) {
			int ct = --letterCount[s2Char[i] - 'a'];
			if (ct == 0) {
				pCount--;
			} else if (ct == -1) {
				nCount++;
			}
		}

		if (pCount == 0 && nCount == 0) {
			return true;
		}

		for (int i = s1.length(), size = s2.length(); i < size; i++ ) {
			int ct1 = --letterCount[s2Char[i] - 'a'];
			if (ct1 == 0) {
				pCount--;
			} else if (ct1 == -1) {
				nCount++;
			}

			int ct2 = ++letterCount[s2Char[i - s1Size] - 'a'];
			if (ct2 == 0) {
				nCount--;
			} else if (ct2 == 1) {
				pCount++;
			}
			if (pCount == 0 && nCount == 0) {
				return true;
			}
		}

		return false;
	}
}