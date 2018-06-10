/*
	problem 844
	Given two strings S and T,
	return if they are equal when both are typed into empty text editors.
	# means a backspace character.
	Example 1:
		Input: S = "ab#c", T = "ad#c"
		Output: true
		Explanation: Both S and T become "ac".
	Example 2:
		Input: S = "ab##", T = "c#d#"
		Output: true
		Explanation: Both S and T become "".
	Example 3:
		Input: S = "a##c", T = "#a#c"
		Output: true
		Explanation: Both S and T become "c".
	Example 4:
		Input: S = "a#c", T = "b"
		Output: false
		Explanation: S becomes "c" while T becomes "b".
	Note:
		1 <= S.length <= 200
		1 <= T.length <= 200
		S and T only contain lowercase letters and '#' characters.
	Follow up:
		Can you solve it in O(N) time and O(1) space?
*/

public class BackspaceStringCompare {
	public static void main(String[] args) {
		System.out.println(backspaceCompare(args[0], args[1]));
	}

	public static boolean backspaceCompare(String S, String T) {
		int sIndex = S.length(), tIndex = T.length();
		while ((sIndex = findLast(S, sIndex)) >= 0 & (tIndex = findLast(T, tIndex)) >= 0) {
			if (S.charAt(sIndex) != T.charAt(tIndex)) {
				return false;
			}
		}

		return sIndex == -1 && tIndex == -1;
	}

	private static int findLast(String s, int index) {
		index--;
		int backCt = 0;
		while (index >= 0) {
			if (s.charAt(index) == '#') {
				backCt++;
			} else {
				if (backCt > 0) {
					backCt--;
				} else {
					break;
				}
			}
			index--;
		}

		return index;
	}
}