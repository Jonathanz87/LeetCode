/*
	problem 869
	Starting with a positive integer N, 
	we reorder the digits in any order (including the original order) such that the leading digit is not zero.
	Return true if and only if we can do this in a way such that the resulting number is a power of 2.
	Example 1:
		Input: 1
		Output: true
	Example 2:
		Input: 10
		Output: false
	Example 3:
		Input: 16
		Output: true
	Example 4:
		Input: 24
		Output: false
	Example 5:
		Input: 46
		Output: true
*/

import java.util.Set;
import java.util.HashSet;

public class ReorderedPowerOf2 {
	public static void main(String[] args){
		System.out.println(reorderedPowerOf2(Integer.parseInt(args[0])));
	}
	private static Set<String> powerOf2 = new HashSet<String>(){{
		this.add("1");
		this.add("2");
		this.add("4");
		this.add("8");
		this.add("61");
		this.add("32");
		this.add("64");
		this.add("821");
		this.add("652");
		this.add("521");
		this.add("4210");
		this.add("8420");
		this.add("9640");
		this.add("9821");
		this.add("86431");
		this.add("87632");
		this.add("66553");
		this.add("732110");
		this.add("644221");
		this.add("885422");
		this.add("8765410");
		this.add("9752210");
		this.add("9444310");
		this.add("8888630");
		this.add("77766211");
		this.add("55443332");
		this.add("88766410");
		this.add("877432211");
		this.add("866554432");
		this.add("987653210");
		this.add("8774432110");
		this.add("8876444321");
		this.add("9997664422");
		this.add("9998855432");
	}};
	public static boolean reorderedPowerOf2(int N) {
		int[] digits = new int[10];
		StringBuilder builder = new StringBuilder();

		while(N > 0){
			digits[N % 10]++;
			N /= 10;
		}

		for(int i = 9; i >= 0; i--){
			while(digits[i]-- > 0){
				builder.append(i);
			}
		}

		return powerOf2.contains(builder.toString());
	}
}
