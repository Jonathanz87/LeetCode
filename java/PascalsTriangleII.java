/*
	problem 119
	Given an index k, return the kth row of the Pascal's triangle.
	For example, given k = 3,
	Return [1,3,3,1].
*/

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangleII {
	public static void main(String[] args) {
		System.out.println(getRow2(Integer.parseInt(args[0])));
	}

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++) {
			result.add(1);
			for (int j = i - 1; j > 0; j--) {
				result.set(j, result.get(j) + result.get(j - 1));
			}
		}
		return result;
	}

	public static List<Integer> getRow2(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		int[] intArray = new int[rowIndex + 1];
		for (int i = 0; i <= rowIndex; i++) {
			intArray[i] = 1;
			for (int j = i - 1; j > 0; j--) {
				intArray[j] = intArray[j] + intArray[j - 1];
			}
		}

		for (int n : intArray) {
			result.add(n);
		}
		return result;
	}
}