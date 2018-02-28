/*
	problem 474

*/

import java.util.Arrays;
import java.util.stream.Stream;

public class OnesAndZeroes {
	public static void main(String[] args) {
		String[] strs = Arrays.copyOfRange(args, 0, args.length - 2);
		System.out.println(Integer.parseInt(args[args.length - 2]));
		System.out.println(findMaxForm(strs, Integer.parseInt(args[args.length - 2]), Integer.parseInt(args[args.length - 1])));
	}

	public static int findMaxForm(String[] strs, int m, int n) {
		int[][] digitCount = new int[2][strs.length];
		for (int i = 0, len = strs.length; i < len; i++) {
			for (char c : strs[i].toCharArray()) {
				if (c == '0') {
					digitCount[0][i]++;
				} else {
					digitCount[1][i]++;
				}
			}
		}

		return findMaxForm(digitCount, m, n, 0, 0);
	}

	public static int findMaxForm(int[][] digitCount, int m, int n, int i, int count) {
		if (n < 0 || m < 0) {
			return count - 1;
		}
		if (i >= digitCount[0].length || (n == 0 && m == 0)) {
			return count;
		}

		int len1 = findMaxForm(digitCount, m, n, i + 1, count);

		m -= digitCount[0][i];
		n -= digitCount[1][i];

		int len2 = findMaxForm(digitCount, m, n, i + 1, count + 1);
		return Math.max(len2, len1);
	}
}