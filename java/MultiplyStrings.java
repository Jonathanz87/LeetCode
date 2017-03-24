/*
	problem 43
	Given two non-negative integers num1 and num2 represented as strings,
	return the product of num1 and num2.

	Note:
		The length of both num1 and num2 is < 110.
		Both num1 and num2 contains only digits 0-9.
		Both num1 and num2 does not contain any leading zero.
		You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

public class MultiplyStrings{
	static public void main(String[] args){
		System.out.println(multiply(args[0], args[1]));
	}

	static public String multiply(String num1, String num2) {
		if(num1.length() <= 0 || num1.length() <= 0 || 
			num1.charAt(0) == '0' || num2.charAt(0) == '0'){
			return "0";
		}

		int num1MaxIndex = num1.length() - 1, num2MaxIndex = num2.length() - 1;
		int carry = 0;
		StringBuilder result = new StringBuilder("");

		for(int i = num1MaxIndex + num2MaxIndex; i >= 0; i--){
			for(int x = Math.min(num1MaxIndex, i), y = i - x; x >= 0 && y <= num2MaxIndex; x--, y++){
				carry += (num1.charAt(x) - '0') * (num2.charAt(y) - '0');
			}

			result.insert(0, carry % 10);
			carry /= 10;
		}

		if(carry != 0)
			result.insert(0, carry);

		return new String(result);
	}
}