/*
	problem 646
	You are given n pairs of numbers.
	In every pair, the first number is always smaller than the second number.
	Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c.
	Chain of pairs can be formed in this fashion.
	Given a set of pairs, find the length longest chain which can be formed.
	You needn't use up all the given pairs. You can select pairs in any order.
	Example 1:
		Input: [[1,2], [2,3], [3,4]]
		Output: 2
		Explanation: The longest chain is [1,2] -> [3,4]
	Note:
		The number of given pairs will be in the range [1, 1000].
*/
public class MaximumLengthOfPairChain {
	public static int findLongestChain(int[][] pairs) {
		if (pairs == null || pairs.length <= 0) return 0;

		int ct = 1;
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int[] curPair = pairs[0];

		for (int i = 1; i < pairs.length; i++) {
			if (pairs[i][0] > curPair[1]) {
				curPair = pairs[i];
				ct++;
			} else if (pairs[i][1] < curPair[1]) {
				curPair = pairs[i];
			}
		}

		return ct;
	}
}