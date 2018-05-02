/*
	problem 763
	A string S of lowercase letters is given. 
	We want to partition this string into as many parts as possible so that each letter appears in at most one part, 
	nd return a list of integers representing the size of these parts.
	Example 1:
		Input: S = "ababcbacadefegdehijhklij"
		Output: [9,7,8]
		Explanation:
		The partition is "ababcbaca", "defegde", "hijhklij".
		This is a partition so that each letter appears in at most one part.
		A partition like "ababcbacadefegde", "hijhklij" is incorrect, 
		because it splits S into less parts.
	Note:
		S will have length in range [1, 500].
		S will consist of lowercase letters ('a' to 'z') only.
*/

import java.util.List;
import java.util.LinkedList;

public class PartitionLabels {
	public static void main(String[] args) {
		System.out.println(partitionLabels(args[0]));
	}
	public static List<Integer> partitionLabels(String S) {
		List<Integer> result = new LinkedList<>();
		int[] startPosition = new int[26];
		int[] endPosition = new int[26];
		int startIndex = 0;
		int startCt = 0;

		for (int i = 0, len = S.length(); i < len; i++) {
			int mapIndex = S.charAt(i) - 'a';
			if (startPosition[mapIndex] == 0) {
				startPosition[mapIndex] = i + 1;
			}
			endPosition[mapIndex] = i + 1;
		}

		for (int i = 0, len = S.length(); i < len; i++) {
			int mapIndex = S.charAt(i) - 'a';
			if (startPosition[mapIndex] == i + 1) {
				startCt++;
			}
			if (endPosition[mapIndex] == i + 1) {
				startCt--;
			}

			if (startCt == 0) {
				result.add(i - startIndex + 1);
				startIndex = i + 1;
			}

		}

		return result;
	}
}
