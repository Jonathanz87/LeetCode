/*
	problem 459
	Given a non-empty string check if it can be constructed by taking a substring of it
	and appending multiple copies of the substring together.
	You may assume the given string consists of lowercase English letters only and
	its length will not exceed 10000.
	Example 1:
		Input: "abab"
		Output: True
		Explanation: It's the substring "ab" twice.
	Example 2:
		Input: "aba"
		Output: False
	Example 3:
		Input: "abcabcabcabc"
		Output: True
		Explanation: It's the substring "abc" four times.
		(And the substring "abcabc" twice.)
*/

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern(args[0]));
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        char[] strArray = s.toCharArray();

        for(int i = 1, stopLen = len / 2 + 1; i < stopLen; i++) {
            if(len % i == 0) {
                int j = 0, k = i;
                boolean isSubstringPattern = true;
                while(k < len) {
                    if(strArray[j] != strArray[k]) {
                        isSubstringPattern = false;
                        break;
                    }
                    j++;
                    k++;
                }
                if(isSubstringPattern) {
                    return true;
                }
            }
        }

        return false;
    }
}