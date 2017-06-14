/*
	problem 54
	Given a matrix of m x n elements (m rows, n columns),
	return all elements of the matrix in spiral order.
	For example,
	Given the following matrix:
		[
			[ 1, 2, 3 ],
			[ 4, 5, 6 ],
			[ 7, 8, 9 ]
		]
	You should return [1,2,3,6,9,8,7,4,5].
*/
import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix{

	public static void main(String[] args){
		// int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		// int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		// int[][] matrix = {{1}};
		//int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		int[][] matrix = {};

		spiralOrder(matrix).forEach(System.out::println);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		final int ROW_INDEX = 0, COLUMN_INDEX = 1, BOUNDARY_INDEX = 2;
		List<Integer> spiralList = new ArrayList<>();
		if (matrix == null || matrix.length == 0){
			return spiralList;
		}
		int[][] dataTable = {{0, 1, 0, -1},
				{1, 0, -1, 0},
				{matrix[0].length - 1, matrix.length - 1, 0, 0}};

		int index = 0;
		int[] coordinate = {0, 0};

		while (dataTable[BOUNDARY_INDEX][0] >= dataTable[BOUNDARY_INDEX][2] &&
				dataTable[BOUNDARY_INDEX][1] >= dataTable[BOUNDARY_INDEX][3]) {
			spiralList.add(matrix[coordinate[ROW_INDEX]][coordinate[COLUMN_INDEX]]);

			if (index == 0 &&
					coordinate[COLUMN_INDEX] >= dataTable[BOUNDARY_INDEX][index]) {
				dataTable[BOUNDARY_INDEX][3]++;
				index++;
			} else if (index == 1 &&
					coordinate[ROW_INDEX] >= dataTable[BOUNDARY_INDEX][index]) {
				dataTable[BOUNDARY_INDEX][0]--;
				index++;
			} else if (index == 2 &&
					coordinate[COLUMN_INDEX] <= dataTable[BOUNDARY_INDEX][index]) {
				dataTable[BOUNDARY_INDEX][1]--;
				index++;
			} else if (index == 3 &&
					coordinate[ROW_INDEX] <= dataTable[BOUNDARY_INDEX][index]) {
				dataTable[BOUNDARY_INDEX][2]++;
				index = 0;
			}

			coordinate[ROW_INDEX] += dataTable[ROW_INDEX][index];
			coordinate[COLUMN_INDEX] += dataTable[COLUMN_INDEX][index];
		}
		return spiralList;
	}
}