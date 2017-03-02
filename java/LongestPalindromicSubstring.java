/*	Given a string s, find the longest palindromic substring in s.
	You may assume that the maximum length of s is 1000.

	Example:
	Input: "babad"
	Output: "bab"
	Note: "aba" is also a valid answer.

	Example:
	Input: "cbbd"
	Output: "bb"
*/

public class LongestPalindromicSubstring{
	static public void main(String[] args){
		System.out.println(longestPalindrome(args[0]));
	}

	static public String longestPalindrome(String s){
		if(s.length() <= 0){
			return "";
		}
		char[] c = s.toCharArray();
		int longest = 0;
		int fIndex = -1, bIndex = -1;

		for(int i = 0, strLen = c.length; i < strLen; i++){
			int possibleLen = i < strLen - i ? i : strLen - i;
			int ct = 0;
			int j = 0;
			boolean flag = possibleLen * 2 > longest;
			while(flag && j < possibleLen){
				if(c[i + j] == c[i - 1 - j]){
					ct += 2;
				}else{
					break;
				}
				j++;
			}
			if(ct > longest){
				longest = ct;
				fIndex = i - j;
				bIndex =  i + j - 1;
			}

			possibleLen = i < strLen - i - 1 ? i : strLen - i - 1;
			flag = possibleLen * 2 + 1 > longest;
			ct = 1;
			j = 0;
			while(flag && j < possibleLen){
				if(c[i + j + 1] == c[i - j - 1]){
					ct += 2;
				}else{
					break;
				}
				j++;
			}
			if(ct > longest){
				longest = ct;
				fIndex = i - j;
				bIndex =  i + j;
			}
		}
		return s.substring(fIndex, bIndex + 1);
	}
}