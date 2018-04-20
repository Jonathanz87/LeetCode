/*
	problem 467
	Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
	so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
	Now we have another string p.
	Your job is to find out how many unique non-empty substrings of p are present in s. In particular,
	your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
	Note: p consists of only lowercase English letters and the size of p might be over 10000.
	Example 1:
		Input: "a"
		Output: 1
		Explanation: Only the substring "a" of string "a" is in the string s.
	Example 2:
		Input: "cac"
		Output: 2
		Explanation: There are two substrings "a", "c" of string "cac" in the string s.
	Example 3:
		Input: "zab"
		Output: 6
		Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
*/

		/*
			qwertyuiopasdfghjklzxcvbnm
		*/

public class UniqueSubstringsInWraparoundString {
	public static void main(String[] args){
		System.out.println(findSubstringInWraproundString(args[0]));
	}
	public static int findSubstringInWraproundString(String p) {
		if (p.length() == 0) return 0;
		int[] letterCounter = new int[26];
		int ct = 1;
		int startIndex = p.charAt(0) - 'a';
		int largestCt = 0;
		int letterIndex = 0;

		int letterSize = 26;
		int result = 0;

		for (int i = 1, len = p.length(); i < len; i++) {
			if (p.charAt(i) == (p.charAt(i - 1) + 1) || (p.charAt(i) == 'a' && p.charAt(i - 1) == 'z')) {
				ct++;
			} else {
				letterCounter[startIndex] = Math.max(letterCounter[startIndex], ct);

				if(letterCounter[startIndex] > largestCt){
					largestCt = letterCounter[startIndex];
					letterIndex = startIndex;
				}

				startIndex = p.charAt(i) - 'a';
				ct = 1;
			}
		}
		letterCounter[startIndex] = Math.max(letterCounter[startIndex], ct);
		if(letterCounter[startIndex] > largestCt){
			largestCt = letterCounter[startIndex];
			letterIndex = startIndex;
		}

		int currentCt = 0;
		while(letterSize-- >= 0 && letterIndex < 26){
			currentCt = Math.max(currentCt, letterCounter[letterIndex++]);
			result += currentCt--;
		}

		letterIndex = 0;

		while(letterSize-- >= 0){
			currentCt = Math.max(currentCt, letterCounter[letterIndex++]);
			result += currentCt--;
		}

		return result;
	}
}