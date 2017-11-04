/*
	problem 241
	Given a string of numbers and operators,
	return all possible results from computing all the different possible ways
	to group numbers and operators.
	The valid operators are +, - and *.
	Example 1
		Input: "2-1-1".
		((2-1)-1) = 0
		(2-(1-1)) = 2
		Output: [0, 2]
	Example 2
		Input: "2*3-4*5"public List<Integer> diffWaysToCompute(String input) {

    }
		(2*(3-(4*5))) = -34
		((2*3)-(4*5)) = -14
		((2*(3-4))*5) = -10
		(2*((3-4)*5)) = -10
		(((2*3)-4)*5) = 10
		Output: [-34, -14, -10, -10, 10]
*/

import java.util.List;
import java.util.LinkedList;
public class DifferentWaysToAddParentheses {
	public static void main(String[] args) {
		diffWaysToCompute(args[0]);
	}

	public static List<Integer> diffWaysToCompute(String input) {
		String[] intArray = input.split("\\+|-|\\*");
		char[] operatorArray = new char[intArray.length - 1];
		for (int operatorIndex = 0, i = 0; operatorIndex < operatorArray.length; i++) {
			switch (input.charAt(i)) {
			case '+':
				operatorArray[operatorIndex++] = '+';
				break;
			case '-':
				operatorArray[operatorIndex++] = '-';
				break;
			case '*':
				operatorArray[operatorIndex++] = '*';
				break;
			}
		}



		return null;
	}

	public static List<Integer> diffWaysToCompute(String[] intArray, char[] operatorArray, int startIndex, int endIndex, List<Integer>[] results) {

		return null;
	}
}