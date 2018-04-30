/*
	problem 583
	Given two words word1 and word2,
	find the minimum number of steps required to make word1 and word2 the same,
	where in each step you can delete one character in either string.
	Example 1:
		Input: "sea", "eat"
		Output: 2
		Explanation: You need one step to make "sea" to "ea"
		and another step to make "eat" to "ea".
	Note:
		The length of given words won't exceed 500.
		Characters in given words can only be lower-case letters.
*/

public class DeleteOperationForTwoStrings {
	public static void main(String[] args) {
		System.out.println(minDistance(args[0], args[1]));
	}
	public static int minDistance(String word1, String word2) {
		int w1Size = word1.length();
		int w2Size = word2.length();
		int[] pre = new int[w2Size + 1];
		int[] cur = new int[w2Size + 1];

		for (char c : word1.toCharArray()) {
			for (int j = 0; j < w2Size; j++) {
				if (c == word2.charAt(j)) {
					cur[j + 1] = Math.max(pre[j] + 1, cur[j]);
				} else {
					cur[j + 1] = Math.max(pre[j + 1], cur[j]);
				}
			}
			int[] temp = pre;
			pre = cur;
			cur = temp;
		}

		return (w1Size + w2Size) - pre[w2Size] * 2;
	}
}