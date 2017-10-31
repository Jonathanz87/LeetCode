/*
	problem 387
	Given a string, find the first non-repeating character in it and return it's index.
	If it doesn't exist, return -1.
	Examples:
		s = "leetcode"
		return 0.
		s = "loveleetcode",
		return 2.
*/

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] characterMap = new int[256];
        for(char c : s.toCharArray()) {
            characterMap[(int)c]++;
        }

        for(int i = 0, len = s.length(); i < len; i++) {
            if(characterMap[(int)s.charAt(i)] == 1 ) {
            	return i;
            }
        }

        return -1;
    }
}