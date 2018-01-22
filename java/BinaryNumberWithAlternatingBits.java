/*
	problem 693
	Given a positive integer,
	check whether it has alternating bits: namely,
	if two adjacent bits will always have different values.
	Example 1:
		Input: 5
		Output: True
		Explanation:
		The binary representation of 5 is: 101
	Example 2:
		Input: 7
		Output: False
		Explanation:
		The binary representation of 7 is: 111.
	Example 3:
		Input: 11
		Output: False
		Explanation:
		The binary representation of 11 is: 1011.
	Example 4:
		Input: 10
		Output: True
		Explanation:
		The binary representation of 10 is: 1010.
*/

public class BinaryNumberWithAlternatingBits {
	public static void main(String[] args) {
		System.out.println(hasAlternatingBits(Integer.parseInt(args[0])));
	}

	public static boolean hasAlternatingBits(int n) {
		while (n > 0) {
			int bit = n & 1;
			n >>>= 1;
			if ((bit ^ n & 1) != 1) {
				return false;
			}
		}

		return true;
	}

	/*
		solution
		for any AlternatingBits number n 
		(n ^ n / 2) = [0]+[1]+  (0000....1111)
			000000101010101010
		^	000000010101010101
			000000111111111111

		for any number x start with 0s end with 1s
		x & (x + 1) = 0
			000000111111111111
		&	000001000000000000
			000000000000000000
	*/
	public static boolean hasAlternatingBits2(int n) {
		int x = (n >>> 1) ^ n;
		return (x & (x + 1)) == 0;
	}
}