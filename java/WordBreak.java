/*
	problem 139
	Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
	determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	You may assume the dictionary does not contain duplicate words.
	For example, given
		s = "leetcode",
		dict = ["leet", "code"].
	Return true because "leetcode" can be segmented as "leet code".
*/

/*
	DP solution
	create a boolean array with size of s.length() + 1
	each index represent the substring before its index is words or not
	loop each index of the string, at some index, 
	if the substring before the index is words, 
	and the substring after the index is a word
	the substring at the index is a words
*/

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordSet = new HashSet<>(wordDict);
		return wordBreakDP(s, wordSet);
	}

	public boolean wordBreakDP(String s, Set<String> wordDict) {
		boolean[] isWords = new boolean[s.length() + 1];
		isWords[0] = true;

		for (int right = 1, len = s.length(); right <= len; right++) {
			for (int left = 0; left < right; left++) {
				if(isWords[left] && wordDict.contains(s.substring(left, right))){
					isWords[right] = true;
					break;
				}
			}
		}

		return isWord[s.length()];
	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s.length() <= 0) {
			return true;
		}

		for (int i = 1, len = s.length(); i <= len; i++) {
			if (wordDict.contains(s.substring(0, i))
			        && wordBreak(s.substring(i), wordDict)) {
				return true;
			}
		}

		return false;
	}

}