/*
	problem 474
	In the computer world, 
	use restricted resource you have to generate maximum benefit is 
	what we always want to pursue.
	For now, suppose you are a dominator of m 0s and n 1s respectively. 
	On the other hand, there is an array with strings consisting of only 0s and 1s.
	Now your task is to find the maximum number of strings that 
	you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
	Note:
		The given numbers of 0s and 1s will both not exceed 100
		The size of given string array won't exceed 600.
	Example 1:
		Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
		Output: 4
		Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, 
		which are “10,”0001”,”1”,”0”
	Example 2:
		Input: Array = {"10", "0", "1"}, m = 1, n = 1
		Output: 2
		Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
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

	public static int findMaxForm2(String[] strs, int m, int n) {
		int[][] max = new int[m + 1][n + 1];

		for(String s : strs){
			int zero = 0;
			int one = 0;
			//get current 0s and 1s
			for(char c : s.toCharArray()){
				if(c == '0'){
					zero++;
				}else{
					one++;
				}
			}

			for(int i = m; i >= zero; i--){
				for(int j = n; j >= one; j--){
					max[i][j] = Math.max(max[i][j], max[i - zero][j - one] + 1);
				}
			}
		}

		return max[m][n];
	}
}
