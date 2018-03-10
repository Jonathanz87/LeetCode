/*
	problem 89
	The gray code is a binary numeral system
	where two successive values differ in only one bit.
	Given a non-negative integer n representing the total number of bits in the code,
	print the sequence of gray code. A gray code sequence must begin with 0.
	For example, given n = 2, return [0,1,3,2].
	Its gray code sequence is:
		00 - 0
		01 - 1
		11 - 3
		10 - 2
	Note:
	For a given n, a gray code sequence is not uniquely defined.
	For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
	For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/

import java.util.List;
import java.util.ArrayList;

public class GrayCode {
	public static void main(String[] args) {
		grayCode2(Integer.parseInt(args[0]))
		.forEach(i -> System.out.print(Integer.toBinaryString(i) + ", "));
	}

	public static List<Integer> grayCode2(int n) {
		List<Integer> result = new ArrayList<>();
		result.add(0);
		for (int s = 0; s < n; s++) {
			int mask = 1 << s;
			int i = result.size() - 1;
			while (i >= 0) {
				result.add(result.get(i--) | mask);
			}
		}
		return result;
	}

	public static List<Integer> grayCode(int n) {
		List<Integer> codes = new ArrayList<Integer>();
		grayCodeHelper(codes, 0, 0, n);
		return codes;
	}

	public static void grayCodeHelper(List<Integer> codes, int num, int d, int n) {
		if (d < n) {
			int temp = num;
			int bit = 0;
			while (temp > 0) {
				bit ^= temp;
				temp = temp >> 1;
			}
			bit = bit & 0x1;

			grayCodeHelper(codes, ((num << 1) | bit), d + 1, n);
			grayCodeHelper(codes, ((num << 1) | (~bit & 0x1)), d + 1, n);
		} else {
			codes.add(num);
		}
	}
}