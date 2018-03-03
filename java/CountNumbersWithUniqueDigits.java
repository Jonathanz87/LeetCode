/*
	problem 357
	Given a non-negative integer n, 
	count all numbers with unique digits, x, 
	where 0 ≤ x < 10n.
	Example:
		Given n = 2, return 91. 
		(The answer should be the total numbers in the range of 0 ≤ x < 100, 
		excluding [11,22,33,44,55,66,77,88,99])
*/	

public class CountNumbersWithUniqueDigits{
	public static void main(String[] args){
		System.out.println(countNumbersWithUniqueDigits(Integer.parseInt(args[0])));
	}
	public static int countNumbersWithUniqueDigits(int n) {
		if(n <= 0) return 1;

		int result = 10;
		int base = 9;
		for(int i = 1; i < n && i < 10; i++){
			base *= 10 - i;
			result += base;
		}
		return result;
	}
}
