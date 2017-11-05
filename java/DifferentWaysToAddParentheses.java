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

/*
	solution DP
	example 2 + 3 - 4 * 5
	resultTable:
			2									3							4			5
	2 	+	2
	3	-	5(2+3)								3
	4	*	(2,2)*(3,4),(2,3)*(4,4)				-4-1(3-4)					4
	5		(2,2)*(3,5),(2,3)*(4,5),(2,4)*(5,5)	(3,3)*(4,5),(3,4)*(5,5)		20(4*5)					5
*/

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
public class DifferentWaysToAddParentheses {
	public static void main(String[] args) {
		for(int num : diffWaysToCompute(args[0])){
			System.out.println(num);
		}
	}

	public static List<Integer> diffWaysToCompute(String input) {
		String[] intArray = input.split("\\+|-|\\*");
		char[] operatorArray = new char[intArray.length - 1];
		int[][][] resultTable = new int[intArray.length][intArray.length][];

		//get operators for each number in resultTable[i][][] at index i
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

		//fill table for (0,0), (1,1), (2,2)...
		for (int i = 0; i < intArray.length; i++) {
			resultTable[i][i] = new int[1];
			resultTable[i][i][0] = Integer.parseInt(intArray[i]);
		}

		//calculation
		int startIndex = 0, endIndex = resultTable.length - 1;
		//first cell of each row in table
		for (int index = startIndex + 1; index <= endIndex; index++) {
			//move right down (1,0) to (2,1)...
			for (int x = index, y = 0; x <= endIndex; x++, y++) {
				int size = 0;
				//get size for each cell table[x][y]
				for (int i = y, j = y + 1; i < x && j <= x; i++, j++) {
					size += resultTable[i][y].length * resultTable[x][j].length;
				}
				resultTable[x][y] = new int[size];

				//fill up value list for each cell table[x][y] 
				for (int i = y, j = y + 1, p = 0; i < x && j <= x; i++, j++) {
					for (int num1 : resultTable[i][y]) {
						for (int num2 : resultTable[x][j]) {
							switch (operatorArray[i]) {
							case '+':
								resultTable[x][y][p] = num1 + num2;
								break;
							case '-':
								resultTable[x][y][p] = num1 - num2;
								break;
							case '*':
								resultTable[x][y][p] = num1 * num2;
								break;
							}

							p++;
						}
					}
				}
			}
		}

		List<Integer> result = new LinkedList<>();

		for(int num : resultTable[endIndex][0]){
			result.add(num);
		}

		return result;
	}
}