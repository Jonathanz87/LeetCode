/*
	problem 709
	Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
*/
public class ToLowerCase {
	public static void main(String[] args) {
		System.out.println(toLowerCase(args[0]));
	}
	public static String toLowerCase(String str) {
		int shift = 'A' - 'a';
		char[] charArr = str.toCharArray();

		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] >= 'A' && charArr[i] <= 'Z') {
				charArr[i] = (char)(charArr[i] - shift);
			}
		}

		return new String(charArr);
	}
}