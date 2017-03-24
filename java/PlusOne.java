/*
	problem 66
	Given a non-negative integer represented as a non-empty array ofdigits,
	plus one to the integer.
	You may assume the integer do not
	contain any leading zero,
	except the number 0 itself.
	The digits are stored such that the most significant digit is at the head of the list. 
*/

public class PlusOne{

	static public void main(String[] args){
		int[] digits = new int[args.length];

		for(int i = 0, len = args.length; i < len; i++){
			digits[i] = Integer.parseInt(args[i]);
		}

		digits = plusOne(digits);

		for(int i : digits){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	static public int[] plusOne(int[] digits) {
		int carry = 1;
		for(int i = digits.length - 1; i >= 0 && carry > 0; i--){
			carry += digits[i];
			digits[i] = carry % 10;
			carry /= 10;
		}

		if(carry == 0) return digits;

		int[] result = new int[digits.length + 1];
		result[0] = 1;
		for(int i = result.length - 1; i > 0; i--){
			result[i] = digits[i - 1];
		}

		return result;
	}
}