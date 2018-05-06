/*
	problem 821
	Given a string S and a character C, 
	return an array of integers representing the shortest distance from the character C in the string.
	Example 1:
		Input: S = "loveleetcode", C = 'e'
		Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
	Note:
		S string length is in [1, 10000].
		C is a single character, and guaranteed to be in string S.
		All letters in S and C are lowercase.
*/

public class ShortestDistanceToACharacter {
	public static void main(String[] args){
		for(int n : shortestToChar(args[0], args[1].charAt(0))){
			System.out.print(n + " ");
		}
		System.out.println();
	}
	public static int[] shortestToChar(String S, char C) {
		int[] result = new int[S.length()];

		for (int i = 0, targetIndex = -S.length(); i < result.length; i++) {
			if (S.charAt(i) == C) {
				result[i] = 0;
				targetIndex = i;
			} else {
				result[i] = i - targetIndex;
			}
		}

		for (int i = S.length() - 1, targetIndex = S.length() * 2; i >= 0; i--) {
			if (S.charAt(i) == C) {
				targetIndex = i;
			} else {
				result[i] = Math.min(targetIndex - i, result[i]);
			}
		}

		return result;
	}
}