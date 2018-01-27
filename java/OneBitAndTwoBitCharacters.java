/*
	problem 717
	We have two special characters.
	The first character can be represented by one bit 0.
	The second character can be represented by two bits (10 or 11).
	Now given a string represented by several bits.
	Return whether the last character must be a one-bit character or not.
	The given string will always end with a zero.
	Example 1:
		Input: bits = [1, 0, 0]
		Output: True
		Explanation:
		The only way to decode it is two-bit character and one-bit character.
		So the last character is one-bit character.
	Example 2:
		Input: bits = [1, 1, 1, 0]
		Output: False
		Explanation:
		The only way to decode it is two-bit character and two-bit character.
		So the last character is NOT one-bit character.
	Note:
		1 <= len(bits) <= 1000.
		bits[i] is always 0 or 1.
*/

/*
	solution DP
	if privious == 0 current = 0
		current is the end of char
	if privious == 0 current = 1
		current is not the end of char

	if privious == 1 current = 0
		if privious is the end of char, then current is the end of char
	if privious == 1 current = 1
		if privious is the end of char, then current is not the end of char
*/


public class OneBitAndTwoBitCharacters {
	public static void main(String[] args) {
		int[] bits = new int[args[0].length()];
		char[] bitsChar = args[0].toCharArray();
		for (int i = 0; i < bits.length; i++) {
			bits[i] = bitsChar[i] - '0';
		}
		System.out.println(isOneBitCharacter(bits));
	}

	public static boolean isOneBitCharacter(int[] bits) {
		boolean[] isEndOfCharacter = new boolean[bits.length];
		isEndOfCharacter[0] = bits[0] == 0;

		for (int i = 1, len = bits.length; i < len; i++) {
			if (bits[i - 1] == 0) {
				isEndOfCharacter[i] = bits[i] == 0;
			} else {
				isEndOfCharacter[i] = bits[i] == 0 ? isEndOfCharacter[i - 1] : !isEndOfCharacter[i - 1];
			}
		}
		return isEndOfCharacter[isEndOfCharacter.length - 1];
	}
}