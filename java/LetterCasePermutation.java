/*
	problem 784
	Given a string S,
	we can transform every letter individually to be lowercase or uppercase to create another string.
	Return a list of all possible strings we could create.
	Examples:
		Input: S = "a1b2"
		Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
		Input: S = "3z4"
		Output: ["3z4", "3Z4"]
		Input: S = "12345"
		Output: ["12345"]
	Note:
		S will be a string with length at most 12.
		S will consist only of letters or digits.
*/
import java.util.List;
import java.util.LinkedList;

public class LetterCasePermutation {
	public static void main(String[] args) {
		for(String s : letterCasePermutation(args[0])){
			System.out.println(s);
		}
	}

	public static List<String> letterCasePermutation(String S) {
		List<String> result = new LinkedList<>();
		letterCasePermutation(S.toCharArray(), 0, result);
		return result;
	}

	private static void letterCasePermutation(char[] s, int index, List<String> result) {
		if (index >= s.length) {
			result.add(new String(s));
			return;
		}

		if (s[index] >= '0' && s[index] <= '9') {
			letterCasePermutation(s, index + 1, result);
		} else {
			s[index] = Character.toLowerCase(s[index]);
			letterCasePermutation(s, index + 1, result);
			s[index] = Character.toUpperCase(s[index]);
			letterCasePermutation(s, index + 1, result);
		}
	}
}