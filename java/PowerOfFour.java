/*
	problem 342
	Given an integer (signed 32 bits), 
	write a function to check whether it is a power of 4.
	Example:
	Given num = 16, return true. 
	Given num = 5, return false.
	Follow up: Could you solve it without loops/recursion?
*/

public class PowerOfFour{
	public static void main(String[] args){
		System.out.println(isPowerOfFour(Integer.parseInt(args[0])));
	}
	public static boolean isPowerOfFour(int num) {
		if(num <= 0){
			return false;
		}
		while((num & 3) == 0){
			num = num >> 2;
		}
		return num == 1;
	}

	public static boolean isPowerOfFour2(int num){
		//		10000	num
		//	&	 1111	num - 1
		//			0	0

		//		1010101010101010101010101010101	 0x55555555
		//	&								100			num
		//									100			num
		return num > 0 && (num & (num - 1)) == 0 && num & 0x55555555 != 0;
	}

	public static boolean isPowerOfTwo(int num){
		return num > 0 && (num & (num - 1)) == 0;
	}
}