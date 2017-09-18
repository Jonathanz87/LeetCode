/*
	problem 151
	Given an input string,
	reverse the string word by word.
	For example,
	Given s = "the sky is blue",
	return "blue is sky the".
*/

public class ReverseWordsInAString {
	public static void main(String[] args){
		System.out.println(reverseWords(args[0]));
	}

	public static String reverseWords(String s) {
		String[] strList = s.split("\\s+");
		StringBuilder builder = new StringBuilder();
		for (int i = strList.length - 1; i >= 0; i--) {
			builder.append(strList[i] + " ");
		}

		return new String(builder).trim();
	}
}