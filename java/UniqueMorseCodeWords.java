/*
	problem 804
	International Morse Code defines a standard encoding
	where each letter is mapped to a series of dots and dashes,
	as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
	For convenience, the full table for the 26 letters of the English alphabet is given below:
	[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
	Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
	For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-").
	We'll call such a concatenation, the transformation of a word.
	Return the number of different transformations among all words we have.
	Example:
		Input: words = ["gin", "zen", "gig", "msg"]
		Output: 2
		Explanation:
		The transformation of each word is:
		"gin" -> "--...-."
		"zen" -> "--...-."
		"gig" -> "--...--."
		"msg" -> "--...--."
		There are 2 different transformations, "--...-." and "--...--.".
	Note:
		The length of words will be at most 100.
		Each words[i] will have length in range [1, 12].
		words[i] will only consist of lowercase letters.
*/

import java.util.Set;
import java.util.HashSet;

public class UniqueMorseCodeWords {
	private static final byte[][] MORSE_MAP = {
		{2, 1},		// a {0, 1}
		{4, 8},		// b {1, 0, 0, 0}
		{4, 10},	// c {1, 0, 1, 0}
		{3, 4},		// d {1, 0, 0}
		{1, 0},		// e {0}
		{4, 2},		// f {0, 0, 1, 0}
		{3, 6}, 	// g {1, 1, 0}
		{4, 0}, 	// h {0, 0, 0, 0}
		{2, 0}, 	// i {0, 0}
		{4, 7}, 	// j {0, 1, 1, 1}
		{3, 5}, 	// k {1, 0, 1}
		{4, 4}, 	// l {0, 1, 0, 0}
		{2, 3}, 	// m {1, 1}
		{2, 2}, 	// n {1, 0}
		{3, 7}, 	// o {1, 1, 1}
		{4, 6}, 	// p {0, 1, 1, 0}
		{4, 13}, 	// q {1, 1, 0, 1}
		{3, 2}, 	// r {0, 1, 0}
		{3, 0}, 	// s {0, 0, 0}
		{1, 1}, 	// t {1}
		{3, 1}, 	// u {0, 0, 1}
		{4, 1}, 	// v {0, 0, 0, 1}
		{3, 3}, 	// w {0, 1, 1}
		{4, 9}, 	// x {1, 0, 0, 1}
		{4, 11}, 	// y {1, 0, 1, 1}
		{4, 12}		// z {1, 1, 0, 0}
	};

	public static void main(String[] args) {
		System.out.println(uniqueMorseRepresentations(args));
	}

	public static int uniqueMorseRepresentations(String[] words) {
		Set<Long> morseSet = new HashSet<>();
		for (String word : words) {
			long key = 0;
			for (char c : word.toCharArray()) {
				int i = c - 'a';
				key = (key << MORSE_MAP[i][0]) | MORSE_MAP[i][1];
			}
			morseSet.add(key);
		}
		return morseSet.size();
	}
}