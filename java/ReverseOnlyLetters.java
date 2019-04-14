/*
	problem 917
	Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
	and all letters reverse their positions.

	Example 1:
	Input: "ab-cd"
	Output: "dc-ba"

	Example 2:
	Input: "a-bC-dEf-ghIj"
	Output: "j-Ih-gfE-dCba"

	Example 3:
	Input: "Test1ng-Leet=code-Q!"
	Output: "Qedo1ct-eeLg=ntse-T!"

	Note:
	S.length <= 100
	33 <= S[i].ASCIIcode <= 122
	S doesn't contain \ or "
*/

public class ReverseOnlyLetters {
	public String reverseOnlyLetters(String S) {
		char[] charArray = S.toCharArray();
		int l = 0, r = charArray.length - 1;

		while (l < r) {
			while (l < r && !isLetter(charArray[l])) {
				l++;
			}

			while (l < r && !isLetter(charArray[r])) {
				r--;
			}

			if (l >= r) {
				break;
			}

			char temp = charArray[l];
			charArray[l] = charArray[r];
			charArray[r] = temp;
			l++;
			r--;
		}

		return new String(charArray);
	}

	private static boolean isLetter(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}
}