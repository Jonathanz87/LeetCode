/*
	problem 712
	Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
	Example 1:
		Input: s1 = "sea", s2 = "eat"
		Output: 231
		Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
		Deleting "t" from "eat" adds 116 to the sum.
		At the end, both strings are equal,
		and 115 + 116 = 231 is the minimum sum possible to achieve this.
	Example 2:
		Input: s1 = "delete", s2 = "leet"
		Output: 403
		Explanation: Deleting "dee" from "delete" to turn the string into "let",
		adds 100[d]+101[e]+101[e] to the sum.
		Deleting "e" from "leet" adds 101[e] to the sum.
		At the end, both strings are equal to "let",
		and the answer is 100+101+101+101 = 403.
		If instead we turned both strings into "lee" or "eet",
		we would get answers of 433 or 417, which are higher.
	Note:
		0 < s1.length, s2.length <= 1000.
		All elements of each string will have an ASCII value in [97, 122].
*/

/*
	solution:
	DP find the largest common sub seq, then use the total sum - the sum of common sub seq * 2
*/

public class MinimumASCIIDeleteSumForTwoStrings {
	public static void main(String[] args) {
		System.out.println(minimumDeleteSum(args[0], args[1]));
	}
	public static int minimumDeleteSum(String s1, String s2) {
		int total = 0;
		for (char c : s1.toCharArray()) {
			total += c;
		}

		for (char c : s2.toCharArray()) {
			total += c;
		}

		int[] pre = new int[s1.length() + 1];
		int[] cur = new int[s1.length() + 1];

		for (int i = 0; i < s2.length(); i++) {
			for (int j = 0, len = s1.length(); j < len; j++) {
				if (s1.charAt(j) == s2.charAt(i)) {
					cur[j + 1] = Math.max(cur[j], pre[j] + s2.charAt(i));
				} else {
					cur[j + 1] = Math.max(cur[j], pre[j + 1]);
				}
			}
			int[] temp = pre;
			pre = cur;
			cur = temp;
		}


		return total - pre[pre.length - 1] * 2;
	}
}
