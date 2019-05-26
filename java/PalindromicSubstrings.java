/*
    647. Palindromic Substrings
    Given a string, your task is to count how many palindromic substrings in this string.
    The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
    Example 1:
        Input: "abc"
        Output: 3
        Explanation: Three palindromic strings: "a", "b", "c".
    Example 2:
        Input: "aaa"
        Output: 6
        Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
    Note:
        The input string length won't exceed 1000.
*/

public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int count = 0;

        for (int i = 0, len = chars.length - 1; i < len; i++) {
            count += palindromicCount(chars, i, i) + palindromicCount(chars, i, i + 1);
        }
        return count + 1;
    }

    public static int palindromicCount(char[] chars, int left, int right) {
        if (left < 0 || right >= chars.length) {
            return 0;
        }

        return chars[left] == chars[right] ? palindromicCount(chars, left - 1, right + 1) + 1 : 0;

    }
}