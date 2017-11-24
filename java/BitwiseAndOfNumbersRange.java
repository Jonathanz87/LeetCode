/*
	problem 201
	Given a range [m, n] where 0 <= m <= n <= 2147483647,
	return the bitwise AND of all numbers in this range, inclusive.
	For example,
		given the range [5, 7], you should return 4.
*/

/*
	solution
	5	-	1|01
	6	-	1|10
	7	-	1|11
	digits after | need to be 0s
	digits before | need to be kept as it
*/

public class BitwiseAndOfNumbersRange {
	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
	public static int rangeBitwiseAnd(int m, int n) {
		int mask = Integer.MAX_VALUE;
		while ((m & mask) != (n & mask)) {
			mask <<= 1;
		}
		return m & mask;
	}

	public static int rangeBitwiseAnd2(int m, int n) {
		int bit = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			bit++;
		}
		return m << bit;
	}
}