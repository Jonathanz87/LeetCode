/*
    problem 524
    Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
    Example 1:
        Input:
        s = "abpcplea", d = ["ale","apple","monkey","plea"]
        Output: 
        "apple"
    Example 2:
        Input:
        s = "abpcplea", d = ["a","b","c"]
        Output: 
        "a"
    Note:
        All the strings in the input will only contain lower-case letters.
        The size of the dictionary won't exceed 1,000.
        The length of all the strings in the input won't exceed 1,000.
*/

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String word : d) {
            if (word.length() < result.length()) {
                continue;
            }
            if (isSubsequence(s, word)) {
                if (word.length() > result.length() || word.compareTo(result) < 0) {
                    result = word;
                }
            }

        }
        return result;
    }

    private boolean isSubsequence(String s, String w) {
        int wIndex = 0;
        char[] sChar = s.toCharArray();
        char[] wChar = w.toCharArray();

        for (int i = 0, sLen = sChar.length, wLen = wChar.length; i < sLen && wIndex < wLen; i++) {
            if ((int)sChar[i] == (int)wChar[wIndex]) {
                wIndex++;
            }
        }

        return wIndex == w.length();
    }

    private boolean isSubsequenceIndexOf(String t, String s) {
        for (int i = 0, pos = 0; i < s.length(); i++, pos++) {
            pos = t.indexOf(s.charAt(i), pos);
            if (pos == -1) return false;
        }
        return true;
    }
}

