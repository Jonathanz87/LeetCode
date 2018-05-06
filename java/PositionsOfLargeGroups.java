/*
	problem 830
	In a string S of lowercase letters, these letters form consecutive groups of the same character.
	For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
	Call a group large if it has 3 or more characters.
	We would like the starting and ending positions of every large group.
	The final answer should be in lexicographic order.
	Example 1:
		Input: "abbxxxxzzy"
		Output: [[3,6]]
		Explanation: "xxxx" is the single large group with starting 3 and ending positions 6.
	Example 2:
		Input: "abc"
		Output: []
		Explanation: We have "a","b" and "c" but no large group.
	Example 3:
		Input: "abcdddeeeeaabbbcd"
		Output: [[3,5],[6,9],[12,14]]
 	Note:  1 <= S.length <= 1000
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class PositionsOfLargeGroups {
	public static void main(String[] args) {
		System.out.println(largeGroupPositions2(args[0]));
	}

	public static List<List<Integer>> largeGroupPositions2(String S) {
		final int LARGE_SIZE = 3;
		List<List<Integer>> result = new LinkedList<>();
		int s = 0;

		for (int i = 1, len = S.length(); i < len; i++) {
			if (S.charAt(i) != S.charAt(i - 1)) {
				if (i - s >= LARGE_SIZE) {
					result.add(Arrays.asList(new Integer[] {s, i - 1}));
				}
				s = i;
			}
		}

		if (S.length() - s >= LARGE_SIZE) {
			result.add(Arrays.asList(new Integer[] {s, S.length() - 1}));
		}

		return result;
	}
	public static List<List<Integer>> largeGroupPositions(String S) {
		final int LARGE_SIZE = 3;
		List<List<Integer>> result = new LinkedList<>();
		List<Integer> indexes = new LinkedList<>();
		char c = S.charAt(0);
		int ct = 1;
		indexes.add(0);

		for (int i = 1, len = S.length(); i < len; i++) {
			if (S.charAt(i) != c) {
				if (ct >= LARGE_SIZE) {
					indexes.add(i - 1);
					result.add(indexes);
					indexes = new LinkedList<>();
					indexes.add(i);
				} else {
					indexes.set(0, i);
				}
				c = S.charAt(i);
				ct = 0;
			}
			ct++;
		}

		if (ct >= LARGE_SIZE) {
			indexes.add(S.length() - 1);
			result.add(indexes);
		}

		return result;
	}
}