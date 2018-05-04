/*
	problem 791
	S and T are strings composed of lowercase letters. 
	In S, no letter occurs more than once.
	S was sorted in some custom order previously. 
	We want to permute the characters of T so that they match the order that S was sorted. 
	More specifically, if x occurs before y in S, then x should occur before y in the returned string.
	Return any permutation of T (as a string) that satisfies this property.
	Example :
		Input: 
		S = "cba"
		T = "abcd"
		Output: "cbad"
		Explanation: 
		"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
		Since "d" does not appear in S, it can be at any position in T. 
		"dcba", "cdba", "cbda" are also valid outputs.
	Note:
		S has length at most 26, and no character is repeated in S.
		T has length at most 200.
		S and T consist of lowercase letters only.
*/


public class CustomSortString {
	public static void main(String[] args) {
		System.out.println(customSortString(args[0], args[1]));
	}

	public static String customSortString(String S, String T) {
		char[] result = new char[T.length()];
		int[] orderTable = new int[26];
		int[] positionTable = new int[S.length()];
		int preSum = 0;
		int unsortedIndex = T.length();

		for (int i = 0, len = S.length(); i < len; i++) {
			orderTable[S.charAt(i) - 'a'] = i + 1;
		}

		for (char c : T.toCharArray()) {
			int positionIndex = orderTable[c - 'a'] - 1;
			if (positionIndex >= 0) {
				positionTable[positionIndex]++;
			}
		}

		for (char c : S.toCharArray()) {
			int positionIndex = orderTable[c - 'a'] - 1;
			preSum += positionTable[positionIndex];
			positionTable[positionIndex] = preSum;
		}


		for (char c : T.toCharArray()) {
			int positionIndex = orderTable[c - 'a'] - 1;
			if (positionIndex < 0) {
				result[--unsortedIndex] = c;
			} else {
				result[--positionTable[positionIndex]] = c;
			}
		}

		return new String(result);

	}
}
