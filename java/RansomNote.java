/*
	problem 383
	Given an arbitrary ransom note string and another string
	containing letters from all the magazines,
	write a function that will return true
	if the ransom note can be constructed from the magazines;
	otherwise, it will return false.
	Each letter in the magazine string can only be used once in your ransom note.
	Note:
		You may assume that both strings contain only lowercase letters.
		canConstruct("a", "b") -> false
		canConstruct("aa", "ab") -> false
		canConstruct("aa", "aab") -> true
*/


public class RansomNote {
	public static void main(String[] args) {
		System.out.println(canConstruct(args[0], args[1]));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		int[] charCounter = new int[256];

		for (char c : magazine.toCharArray()) {
			charCounter[c]++;
		}

		for (char c : ransomNote.toCharArray()) {
			if (charCounter[c] <= 0) {
				return false;
			}
			charCounter[c]--;
		}

		return true;
	}
}