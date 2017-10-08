/*
	problem 115
	Given a string S and a string T,
	count the number of distinct subsequences of S which equals T.
	A subsequence of a string is a new string
	which is formed from the original string by deleting some (can be none) of the characters
	without disturbing the relative positions of the remaining characters.
	(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
	Here is an example:
		S = "rabbbit", T = "rabbit"
		Return 3.
*/

/*
	solution DP
	example s = "abdabefbc" t = "ab"
		  . a b d a b e f b c
		. 1	1 1 1 1 1 1 1 1 1		help value
		a 0	1 1 1 2 2 2 2 2 2	there will be 2 subsequences of 'a' in 'abdabefbc'	t[i + 1][j + 1] = t[i][j] + t[i][j - 1]
		b 0 0 1 1 1 3 3 3 5	5	for any match b, the number of subsequence equals its previous number and the number of subsequence of 'a' before current index
*/

public class DistinctSubsequences {
	public static void main(String[] args) {
		System.out.println(numDistinct(args[0], args[1]));
	}

	public static int numDistinctDP(String s, String t) {
		int[][] pathTable = new int[t.length() + 1][s.length() + 1];

		for (int i = 0, len = pathTable[0].length; i < len; i++) {
			pathTable[0][i] = 1;
		}

		for (int i = 0, tLen = t.length(); i < tLen; i++) {
			for (int j = 0, sLen = s.length(); j < sLen; j++) {
				if (s.charAt(j) == t.charAt(i)) {
					pathTable[i + 1][j + 1] = pathTable[i + 1][j] + pathTable[i][j];
				} else {
					pathTable[i + 1][j + 1] = pathTable[i + 1][j];
				}
			}
		}
		return pathTable[t.length()][s.length()];
	}

	public static int numDistinct(String s, String t) {
		if (t.length() > s.length()) return 0;
		return numDistinctDFS(s.toCharArray(), t.toCharArray(), 0, 0, new int[s.length()][t.length()]);
	}

	public static int numDistinctDFS(char[] s, char[] t, int sIndex, int tIndex, int[][] cache) {
		if (tIndex >= t.length) {
			return 1;
		}
		if (cache[sIndex][tIndex] != 0) {
			return cache[sIndex][tIndex] - 1;
		}

		int count = 0;
		char tChar = t[tIndex];
		for (int i = sIndex, len = s.length - t.length + tIndex; i <= len; i++) {
			if (s[i] == tChar) {
				count += numDistinctDFS(s, t, i + 1, tIndex + 1, cache);
			}
		}

		cache[sIndex][tIndex] = count + 1;
		return count;
	}

	public int numDistinct2(String s, String t) {
		return dfs(s.toCharArray(), 0, t.toCharArray(), 0, new int[s.length()][t.length()]);
	}

	private int dfs(char[] sarr, int si, char[] tarr, int ti, int[][] cache) {
		if (ti >= tarr.length) return 1;
		if (tarr.length - ti > sarr.length - si) {
			return 0;
		}
		if (cache[si][ti] != 0) {
			return cache[si][ti] - 1;
		} else {
			char tc = tarr[ti];
			int cnt = 0;
			for (int i = si; i < sarr.length; i++) {
				if (sarr[i] != tc) {
					continue;
				}
				int restCnt = dfs(sarr, i + 1, tarr, ti + 1, cache);
				if (restCnt == 0) break;
				cnt += restCnt;
			}
			cache[si][ti] = cnt + 1;
			return cnt;
		}
	}
}