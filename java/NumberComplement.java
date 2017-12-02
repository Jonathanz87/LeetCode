/*
	problem 476
	Given a positive integer,
	output its complement number.
	The complement strategy is to flip the bits of its binary representation.
	Note:
	The given integer is guaranteed to fit within the range of a 32-bit signed integer.
	You could assume no leading zero bit in the integer’s binary representation.
	Example 1:
		Input: 5
		Output: 2
		Explanation: The binary representation of 5 is 101 (no leading zero bits),
		and its complement is 010.
		So you need to output 2.
	Example 2:
		Input: 1
		Output: 0
		Explanation: The binary representation of 1 is 1 (no leading zero bits),
		and its complement is 0.
		So you need to o
*/

/*
	solution
	5	101
	get highest bit (Math.log10(5) / Math.log10(2)) = 2		1(01 ---|
	left shift 1 << (2 + 1) 							 = 10 00	|
	1000 - 1 = 0111										   01 11	|
														^   1 01 ---|
															0 10	2
*/
public class NumberComplement {
	public static void main(String[] args) {
		System.out.println(findComplement(Integer.parseInt(args[0])));
	}
	public static int findComplement(int num) {
		return num ^ ((1 << ((int)(Math.log10(num) / Math.log10(2)) + 1)) - 1);
	}
}