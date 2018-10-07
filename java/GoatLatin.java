/*
	problem 824
	A sentence S is given, composed of words separated by spaces.
	Each word consists of lowercase and uppercase letters only.
	We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
	The rules of Goat Latin are as follows:
	If a word begins with a vowel (a, e, i, o, or u),
	append "ma" to the end of the word.
	For example, the word 'apple' becomes 'applema'.
 	If a word begins with a consonant (i.e. not a vowel),
 	remove the first letter and append it to the end, then add "ma".
	For example, the word "goat" becomes "oatgma".
 	Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
	For example, the first word gets "a" added to the end,
	the second word gets "aa" added to the end and so on.
	Return the final sentence representing the conversion from S to Goat Latin.
	Example 1:
		Input: "I speak Goat Latin"
		Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
	Example 2:
		Input: "The quick brown fox jumped over the lazy dog"
		Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 	Notes:
		S contains only uppercase, lowercase and spaces.
		Exactly one space between each word.
		1 <= S.length <= 150.
*/

public class GoatLatin {
	public static void main(String[] args) {
		System.out.println(toGoatLatin(args[0]));
	}
	
	public static String toGoatLatin(String S) {
		String[] strs = S.split(" ");
		StringBuilder sentence = new StringBuilder();

		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			StringBuilder builder = new StringBuilder(s);
			if (!startWitVowel(s)) {
				char c = builder.charAt(0);
				builder.deleteCharAt(0).append(c);
			}
			sentence.append(builder.append("ma").append(getAs(i + 1))).append(" ");
		}

		return (sentence.length() > 0 ? sentence.deleteCharAt(sentence.length() - 1) : sentence).toString();
	}

	private static boolean startWitVowel(String str) {
		char c = str.charAt(0);
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	private static char[] getAs(int n) {
		char[] chars = new char[n];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = 'a';
		}
		return chars;
	}
}