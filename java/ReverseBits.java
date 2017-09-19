/*
	problem 190
	Reverse bits of a given 32 bits unsigned integer.
	For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
	return 964176192 (represented in binary as 00111001011110000010100101000000).
	Follow up:
	If this function is called many times, how would you optimize it?
*/

public class ReverseBits {
	public static void main(String[] args) {
		System.out.println(reverseBits(Integer.parseInt(args[0])));
		System.out.println(reverseBits2(Integer.parseInt(args[0])));
	}

	public static int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = result << 1 | (n & 1);
			n = n >> 1;
		}

		return result;
	}

	public static int reverseBits2(int n) {
		int result = 0;

		for(int i = 0; i < 16; i++){
			int lb = n >> i & 1;
			int hb = n >> (31 - i) & 1;

			result |= lb << (31 - i);
			result |= hb << i;
		}

		return result;
	}
}