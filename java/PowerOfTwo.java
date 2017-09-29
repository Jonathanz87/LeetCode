/*
	problem 231
	Given an integer, write a function to determine if it is a power of two.
*/
public class PowerOfTwo {
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(Integer.parseInt(args[0])));
	}

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0) return false;
		for (int i = 0; i < 32; i++, n >>= 1) {
			if ((n & 1) == 1) break;
		}

		return n == 1 ? true : false;
	}
}