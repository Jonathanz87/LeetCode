/*
	problem 402
	Given a non-negative integer num represented as a string, 
	remove k digits from the number so that the new number is the smallest possible.
	Note:
		The length of num is less than 10002 and will be ≥ k.
		The given num does not contain any leading zero.
	Example 1:
		Input: num = "1432219", k = 3
		Output: "1219"
		Explanation: Remove the three digits 4, 3, and 2 to 
		form the new number 1219 which is the smallest.
	Example 2:
		Input: num = "10200", k = 1
		Output: "200"
		Explanation: Remove the leading 1 and the number is 200. 
		Note that the output must not contain leading zeroes.
	Example 3:
		Input: num = "10", k = 2
		Output: "0"
		Explanation: Remove all the digits from the number 
		and it is left with nothing which is 0.
*/

/*
	bug "9999999999991"
	8
*/

public class RemoveKDigits {
	public static String removeKdigits(String num, int k) {
		if (num.length() <= k) return "0";

		final int NUM_LEN = num.length();
		final int STACK_LEN = NUM_LEN - k;
		int numIndex = 1;
		int stackIndex = -1;
		char[] numChar = num.toCharArray();
		char[] digitsStack = new char[STACK_LEN];

		digitsStack[++stackIndex] = numChar[0];

		while (k > 0 && numIndex < NUM_LEN) {
			while (k > 0 && stackIndex >= 0 && digitsStack[stackIndex] > numChar[numIndex]) {
				stackIndex--;
				k--;
			}
			if (stackIndex < STACK_LEN - 1) {
				digitsStack[++stackIndex] = numChar[numIndex];
			}
			numIndex++;
		}

		while (numIndex < NUM_LEN) {
			digitsStack[++stackIndex] = numChar[numIndex++];
		}

		int noneZeroIndex = 0;
		while(noneZeroIndex < STACK_LEN && digitsStack[noneZeroIndex] == '0'){
			noneZeroIndex++;
		}

		return noneZeroIndex >= STACK_LEN ? "0" : new String(digitsStack).substring(noneZeroIndex);
	}
}