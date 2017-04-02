/*
	Given two binary strings,
	return their sum (also a binary string).
	For example,
		a = "11"
		b = "1"
		Return "100".
*/

public class AddBinary{
	public static void main(String[] args){
		System.out.println(addBinary(args[0], args[1]));
	}

	public static String addBinary(String a, String b){
		if(a.length() == 0) return b;
		if(b.length() == 0) return a;

		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;
		char carry = '0';
		StringBuilder result = new StringBuilder(""); 

		while(aIndex >= 0 && bIndex >= 0){
			int ones = a.charAt(aIndex--) + b.charAt(bIndex--) + carry - '0' - '0' - '0';

			result.insert(0,(char)(ones % 2 + '0'));
			carry = ones > 1 ? '1' : '0';
		}

		while(aIndex >= 0){
			int ones = a.charAt(aIndex--) + carry - '0' - '0';

			result.insert(0,(char)(ones % 2 + '0'));
			carry = ones > 1 ? '1' : '0';
		}

		while(bIndex >= 0){
			int ones = b.charAt(bIndex--) + carry - '0' - '0';

			result.insert(0,(char)(ones % 2 + '0'));
			carry = ones > 1 ? '1' : '0';
		}
		if(carry == '1'){
			result.insert(0,'1');
		}

		return result.toString();
	}
}