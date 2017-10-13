/*
	problem 131
	Given a string s, partition s such that
	every substring of the partition is a palindrome.
	Return all possible palindrome partitioning of s.
	For example,
		given s = "aab", Return
		[
			["aa","b"],
			["a","a","b"]
		]
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class PalindromePartitioning {
	public static void main(String[] args) {
		List<List<String>> result = partition(args[0]);

		for(List<String> strings : result){
			for(String string : strings){
				System.out.print(string + " ");
			}
			System.out.println();
		}
	}

	public static List<List<String>> partition(String s) {
		List<String> result = new LinkedList<>();
		List<List<String>> resultList = new LinkedList<>();
		//0 unknown, 1 true, 2 false
		byte[][] isPalindrome = new byte[s.length()][s.length()];

		partition(s, resultList, result, isPalindrome, 0);
		return resultList;
	}

	public static void partition(String s, List<List<String>> resultList, List<String> result, byte[][] isPalindrome, int startIndex) {
		if (startIndex >= s.length()) {
			List<String> temp = new LinkedList<>(result);
			resultList.add(temp);
			return;
		}

		for (int i = startIndex, len = s.length(); i < len; i++) {
			if (isPalindrome(s, isPalindrome, startIndex, i)) {
				result.add(s.substring(startIndex, i + 1));
				partition(s, resultList, result, isPalindrome, i + 1);
				result.remove(result.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String s, byte[][] isPalindrome, int leftIndex, int rightIndex) {
		if(isPalindrome[leftIndex][rightIndex] == 1) return true;
		if(isPalindrome[leftIndex][rightIndex] == 2) return false;
		int i = leftIndex, j = rightIndex;
		while (leftIndex < rightIndex) {
			if (s.charAt(leftIndex++) != s.charAt(rightIndex--)) {
				isPalindrome[i][j] = 2;
				return false;
			}
		}
		isPalindrome[i][j] = 1;
		return true;
	}
}