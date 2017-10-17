/*
	problem 59
	Given an integer n,
	generate a square matrix filled with elements from 1 to n2 in spiral order.
	For example, Given n = 3,
	You should return the following matrix:
	[
		[ 1, 2, 3 ],
		[ 8, 9, 4 ],
		[ 7, 6, 5 ]
	]
*/
public class SpiralMatrixII {
	public static void main(String[] args) {
		int[][] matrix = generateMatrix(Integer.parseInt(args[0]));

		for (int[] nums : matrix) {
			for (int n : nums) {
				System.out.print(n + "\t");
			}
			System.out.println();
		}
	}

	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if (n <= 0) return matrix;

		int yLowerBoundary = 0, yUpperBoundary = matrix.length - 1,
		    xLowerBoundary = 0, xUpperBoundary = matrix[0].length - 1;
		int num = 1;

		while (yLowerBoundary <= yUpperBoundary && xLowerBoundary <= xUpperBoundary) {
			for (int x = xLowerBoundary; x <= xUpperBoundary; x++) {
				matrix[yLowerBoundary][x] = num++;
			}
			yLowerBoundary++;

			for (int y = yLowerBoundary; y <= yUpperBoundary; y++) {
				matrix[y][xUpperBoundary] = num++;
			}
			xUpperBoundary--;

			if (yLowerBoundary <= yUpperBoundary && xLowerBoundary <= xUpperBoundary) {
				for (int x = xUpperBoundary; x >= xLowerBoundary; x--) {
					matrix[yUpperBoundary][x] = num++;
				}
				yUpperBoundary--;

				for (int y = yUpperBoundary; y >= yLowerBoundary; y--) {
					matrix[y][xLowerBoundary] = num++;
				}
				xLowerBoundary++;
			}
		}

		return matrix;
	}
}