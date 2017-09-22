/*
	problem 191
	Write a function that takes an unsigned integer and 
	returns the number of ’1' bits it has (also known as the Hamming weight).
	For example, the 32-bit integer ’11' has binary representation 
	00000000000000000000000000001011, so the function should return 3.
*/

public class NumberOf1Bits {
	public static void main(String[] args) {
		System.out.println(hammingWeight2(Integer.parseInt(args[0])));
	}

	public static int hammingWeight(int n) {
		int filter = 1, count = 0;
		while (filter != 0) {
			if ((n & filter) != 0) {
				count++;
			}
			filter = filter << 1;
		}
		return count;
	}

	public static int hammingWeight2(int n) {
		int count = 0;
		while (n != 0) {
			count += (n & 1);
			n >>>= 1;
		}
		return count;
	}
}