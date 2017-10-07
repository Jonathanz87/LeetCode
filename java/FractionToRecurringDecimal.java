/*
	problem 166
	Given two integers representing the numerator and denominator of a fraction,
	return the fraction in string format.
	If the fractional part is repeating,
	enclose the repeating part in parentheses.
	For example,
		Given numerator = 1, denominator = 2, return "0.5".
		Given numerator = 2, denominator = 1, return "2".
		Given numerator = 2, denominator = 3, return "0.(6)".
*/

import java.util.Map;
import java.util.HashMap;

public class FractionToRecurringDecimal {
	public static void main(String[] args){
		System.out.println(fractionToDecimal(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		StringBuilder builder = new StringBuilder();
		builder.append(numerator >= 0 && denominator >= 0 || numerator <= 0 && denominator <= 0? "" : "-");

		long numeratorLong = Math.abs((long)numerator);
		long denominatorLong = Math.abs((long)denominator);
		builder.append(numeratorLong / denominatorLong);
		long reminder = numeratorLong % denominatorLong;
		if (reminder == 0) {
			return builder.toString();
		}

		Map<Long, Integer> indexTracker = new HashMap<>();
		builder.append('.');
		int index = builder.length();

		while (reminder != 0) {
			reminder *= 10;
			if (indexTracker.containsKey(reminder)) {
				builder.insert(indexTracker.get(reminder), "(");
				builder.append(")");
				return builder.toString();
			}
			indexTracker.put(reminder, index++);
			builder.append(reminder / denominatorLong);
			reminder = reminder % denominatorLong;
		}
		return builder.toString();
	}
}