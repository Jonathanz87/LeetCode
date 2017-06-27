/*
	problem 242
	Given two strings s and t, write a function to determine if t is an anagram of s.
	For example,
	s = "anagram", t = "nagaram", return true.
	s = "rat", t = "car", return false.
	Note:
	You may assume the string contains only lowercase alphabets.
*/
public class ValidAnagram{
	public static void main(String[] args){
		System.out.println(isAnagram(args[0], args[1]));
	}

	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
		
		int[] letterCount = new int[26];

		for(int i = 0, len = s.length(); i < len; i++){
			letterCount[s.charAt(i) - 'a']++;
			letterCount[t.charAt(i) - 'a']--;
		}

		for(int n : letterCount){
			if(n != 0) return false;
		}

		return true;
	}
}