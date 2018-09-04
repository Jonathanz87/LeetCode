/*
	problem 884
	We are given two sentences A and B.
	(A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
	A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
	Return a list of all uncommon words.
	You may return the list in any order.
	Example 1:
		Input: A = "this apple is sweet", B = "this apple is sour"
		Output: ["sweet","sour"]
	Example 2:
		Input: A = "apple apple", B = "banana"
		Output: ["banana"]
	Note:
		0 <= A.length <= 200
		0 <= B.length <= 200
		A and B both contain only spaces and lowercase letters.
*/

import java.util.Set;
import java.util.TreeSet;

public class UncommonWordsFromTwoSentences {
	public static void main(String[] args) {
		for (String s : uncommonFromSentences(args[0], args[1])) {
			System.out.println(s);
		}
	}

	public static String[] uncommonFromSentences(String A, String B) {
		Set<String> allWords = new TreeSet<>();
		Set<String> repeatedWords = new TreeSet<>();

		for (String s : A.split("\\s")) {
			if (allWords.contains(s)) {
				repeatedWords.add(s);
			} else {
				allWords.add(s);
			}
		}

		for (String s : B.split("\\s")) {
			if (allWords.contains(s)) {
				repeatedWords.add(s);
			} else {
				allWords.add(s);
			}
		}

		for (String s : repeatedWords) {
			allWords.remove(s);
		}


		return allWords.toArray(new String[allWords.size()]);
	}
}