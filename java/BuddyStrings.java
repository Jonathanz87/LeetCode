/*
	problem 859
	Given two strings A and B of lowercase letters,
	return true if and only if we can swap two letters in A so that the result equals B.
	Example 1:
		Input: A = "ab", B = "ba"
		Output: true
	Example 2:
		Input: A = "ab", B = "ab"
		Output: false
	Example 3:
		Input: A = "aa", B = "aa"
		Output: true
	Example 4:
		Input: A = "aaaaaaabc", B = "aaaaaaacb"
		Output: true
	Example 5:
		Input: A = "", B = "aa"
		Output: false
	Note:
		0 <= A.length <= 20000
		0 <= B.length <= 20000
		A and B consist only of lowercase letters.
*/

public class BuddyStrings {
	public static void main(String[] args) {
		System.out.println(buddyStrings(args[0], args[1]));
	}

	public static boolean buddyStrings(String A, String B) {
		if (A == null || B == null || A.length() != B.length() || A.length() < 2) return false;

		int[] letterCounterA = new int[26];
		int[] letterCounterB = new int[26];
		char[] charsA = A.toCharArray();
		char[] charsB = B.toCharArray();
		int diffCt = 0;
		boolean hasDuplication = false;

		for (int i = 0; i < charsA.length; i++) {
			if (charsA[i] != charsB[i]) {
				diffCt++;
			}
			letterCounterA[charsA[i] - 'a']++;
			letterCounterB[charsB[i] - 'a']++;
		}

		for (int i = 0; i < charsA.length; i++) {
			if (letterCounterA[i] != letterCounterB[i]) {
				return false;
			}
			if (letterCounterA[i] >= 2) {
				hasDuplication = true;
			}
		}

		return diffCt == 2 || (diffCt == 0 && hasDuplication);
	}

}