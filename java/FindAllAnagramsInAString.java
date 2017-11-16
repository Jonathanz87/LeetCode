/*
	problem 438
	Given a string s and a non-empty string p,
	find all the start indices of p's anagrams in s.
	Strings consists of lowercase English letters only
	and the length of both strings s and p will not be larger than 20,100.
	The order of output does not matter.
	Example 1:
		Input:
		s: "cbaebabacd" p: "abc"
		Output:
		[0, 6]
		Explanation:
		The substring with start index = 0 is "cba", which is an anagram of "abc".
		The substring with start index = 6 is "bac", which is an anagram of "abc".
	Example 2:
		Input:
		s: "abab" p: "ab"
		Output:
		[0, 1, 2]
		Explanation:
		The substring with start index = 0 is "ab", which is an anagram of "ab".
		The substring with start index = 1 is "ba", which is an anagram of "ab".
		The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

import java.util.List;
import java.util.LinkedList;

public class FindAllAnagramsInAString {
	public static void main(String[] args) {
		List<Integer> result = findAnagrams(args[0], args[1]);
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static List<Integer> findAnagrams(String s, String p) {
		if (p.length() > s.length()) return new LinkedList<>();
		int[] letterCount = new int[26];
		int nonZeroCount = 0;
		List<Integer> resultList = new LinkedList<>();

		for (char c : p.toCharArray()) {
			int i = c - 'a';
			if (letterCount[i] == 0) {
				nonZeroCount++;
			}
			letterCount[i]++;
		}

		int fastIndex = 0;
		while (fastIndex < p.length()) {
			int i = s.charAt(fastIndex) - 'a';
			letterCount[i]--;
			if (letterCount[i] == 0) {
				nonZeroCount--;
			} else if (letterCount[i] == -1) {
				nonZeroCount++;
			}
			fastIndex++;
		}
		if (nonZeroCount == 0) {
			resultList.add(0);
		}

		for (int i = 0, len = s.length(); fastIndex < len; i++, fastIndex++) {
			int add = s.charAt(i) - 'a';
			int sub = s.charAt(fastIndex) - 'a';

			letterCount[add]++;
			if (letterCount[add] == 0) {
				nonZeroCount--;
			} else if (letterCount[add] == 1) {
				nonZeroCount++;
			}

			letterCount[sub]--;
			if (letterCount[sub] == -1) {
				nonZeroCount++;
			} else if(letterCount[sub] == 0){
				nonZeroCount--;
			}

			if (nonZeroCount == 0) {
				resultList.add(i + 1);
			}
		}

		return resultList;

	}

}