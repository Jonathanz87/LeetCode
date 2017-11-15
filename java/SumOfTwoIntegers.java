/*
	problem 371
	Calculate the sum of two integers a and b,
	but you are not allowed to use the operator + and -.
	Example:
		Given a = 1 and b = 2, return 3.
*/

public class SumOfTwoIntegers {
	public static void main(String[] args) {
		System.out.println(getSum(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	public static int getSum(int a, int b) {
		int carry = 0, result = 0;
		for (int i = 0; i < 32; i++) {
			int aBit = (a >> i) & 1;
			int bBit = (b >> i) & 1;
			result |= (aBit ^ bBit ^ carry) << i;
			carry = (aBit & bBit) | (aBit & carry) | (bBit & carry);
		}

		return result;
	}
}