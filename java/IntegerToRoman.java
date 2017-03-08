/*	
	problem 12
	Given an integer, convert it to a roman numeral.
	Input is guaranteed to be within the range from 1 to 3999.
*/

public class IntegerToRoman{
	static public void main(String[] args){
		System.out.println(intToRoman(Integer.parseInt(args[0])));
	}

	static private String[] value = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	static private int[] key = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

	static public String intToRoman(int num) {
		StringBuilder buf = new StringBuilder();
		for(int i = 0, len = key.length; i < len; i++){
			for(int j = 0, n = num / key[i]; j < n; j++){
				buf.append(value[i]);
			}
			num = num % key[i];
		}
		return buf.toString();
	}

	//solution 2
	static private String M[] = {"", "M", "MM", "MMM"};
	static private String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	static private String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	static private String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	static public String intToRoman_solution2(int num) {
		return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}
}