/*
	problem 771
	You're given strings J representing the types of stones that are jewels, 
	and S representing the stones you have.  
	Each character in S is a type of stone you have.  
	You want to know how many of the stones you have are also jewels.
	The letters in J are guaranteed distinct, and all characters in J and S are letters. 
	Letters are case sensitive, so "a" is considered a different type of stone from "A".
	Example 1:
		Input: J = "aA", S = "aAAbbbb"
		Output: 3
	Example 2:
		Input: J = "z", S = "ZZ"
		Output: 0
	Note:
		S and J will consist of letters and have length at most 50.
		The characters in J are distinct.
*/

public class JewelsAndStones {
	public static void main(String[] args) {
		System.out.println(numJewelsInStones(args[0], args[1]));
	}

	public static int numJewelsInStones(String J, String S) {
		int ct = 0;
		boolean[] jewelMap = new boolean[52];
		for (char c : J.toCharArray()) {
			jewelMap[letterToIndex(c)] = true;
		}

		for (char c : S.toCharArray()) {
			if (jewelMap[letterToIndex(c)]) {
				ct++;
			}
		}
		return ct;
	}

	private static int letterToIndex(char c) {
		if (Character.isUpperCase(c)) {
			return c - 'A' + 26;
		} else {
			return c - 'a';
		}
	}
}