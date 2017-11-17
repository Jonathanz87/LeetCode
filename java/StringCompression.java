/*
	problem 443
	Given an array of characters, compress it in-place.
	The length after compression must always be smaller than or equal to the original array.
	Every element of the array should be a character (not int) of length 1.
	After you are done modifying the input array in-place,
	return the new length of the array.
	Follow up:
		Could you solve it using only O(1) extra space?
	Example 1:
		Input:
		["a","a","b","b","c","c","c"]
		Output:
		Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
		Explanation:
		"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
	Example 2:
		Input:
		["a"]
		Output:
		Return 1, and the first 1 characters of the input array should be: ["a"]
		Explanation:
		Nothing is replaced.
	Example 3:
		Input:
		["a","b","b","b","b","b","b","b","b","b","b","b","b"]
		Output:
		Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
		Explanation:
		Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
		Notice each digit has it's own entry in the array.
	Note:
	All characters have an ASCII value in [35, 126].
	1 <= len(chars) <= 1000.
*/

public class StringCompression {
	public static void main(String[] args) {
		char[] charArr = args[0].toCharArray();
		int length = compress(charArr);

		for (int i = 0; i < length; i++) {
			System.out.print(charArr[i] + " ");
		}
		System.out.println();
	}
	public static int compress(char[] chars) {
		if (chars.length <= 0) return 0;

		int charCount = 1, result = 0, currentIndex = 1;

		for (int i = 1; i < chars.length; i++) {
			if (chars[i - 1] == chars[i]) {
				charCount++;
			} else {
				if (charCount > 1) {
					String count = Integer.toString(charCount);
					for (char c : count.toCharArray()) {
						chars[currentIndex++] = c;
					}
					result += count.length() + 1;
				} else {
					result += charCount;
				}
				charCount = 1;
				chars[currentIndex++] = chars[i];
			}
		}

		if (charCount > 1) {
			String count = Integer.toString(charCount);
			for (char c : count.toCharArray()) {
				chars[currentIndex++] = c;
			}
			result += count.length() + 1;
		} else {
			result += charCount;
		}

		return result;
	}
}