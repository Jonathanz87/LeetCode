/*
	problem 394
	Given an encoded string,
	return it's decoded string.
	The encoding rule is: k[encoded_string],
	where the encoded_string inside the square brackets is being repeated exactly k times.
	Note that k is guaranteed to be a positive integer.
	You may assume that the input string is always valid;
	No extra white spaces, square brackets are well-formed, etc.
	Furthermore, you may assume that the original data does not contain any digits
	and that digits are only for those repeat numbers, k.
	For example, there won't be input like 3a or 2[4].
	Examples:
		s = "3[a]2[bc]", return "aaabcbc".
		s = "3[a2[c]]", return "accaccacc".
		s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

public class DecodeString {
	public static void main(String[] args) {
		System.out.println(decodeString(args[0]));
	}

	public static String decodeString(String s) {
		if (s == null) return null;
		int size = s.length();
		int[] repeatStack = new int[size / 3];
		StringBuilder[] builderStack = new StringBuilder[size / 3];
		int index = -1;
		int repeat = 0;
		StringBuilder result = new StringBuilder();
		StringBuilder builder = result;

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				repeat = repeat * 10 + c - '0';
			} else if (c == '[') {
				index++;
				repeatStack[index] = repeat;
				repeat = 0;
				builder = new StringBuilder();
				builderStack[index] = builder;
			} else if (c == ']') {
				StringBuilder temp = new StringBuilder();
				String tempStr = builderStack[index].toString();
				while (repeatStack[index] > 0) {
					temp.append(tempStr);
					repeatStack[index]--;
				}
				builder = --index >= 0 ? builderStack[index] : result;
				builder.append(temp);
			} else {
				builder.append(c);
			}
		}
		return result.toString();
	}
}