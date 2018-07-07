/*
	problem 861
	We have a two dimensional matrix A where each value is 0 or 1.
	A move consists of choosing any row or column, and toggling each value in that row or column:
	changing all 0s to 1s, and all 1s to 0s.
	After making any number of moves, every row of this matrix is interpreted as a binary number,
	and the score of the matrix is the sum of these numbers.
	Return the highest possible score.
	Example 1:
		Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
		Output: 39
		Explanation:
		Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
		0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
	Note:
		1 <= A.length <= 20
		1 <= A[0].length <= 20
		A[i][j] is 0 or 1.
*/

public class ScoreAfterFlippingMatrix {
	public static int matrixScore(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0) return 0;

		int sum = 0;
		for (int r = 0, len = A.length; r < len; r++) {
			if (A[r][0] == 0) {
				flipRow(A, r);
			}
		}

		for (int c = 1, len = A[0].length; c < len; c++) {
			if (flippable(A, c)) {
				flipColumn(A, c);
			}
		}

		for (int r = 0, len = A.length; r < len; r++) {
			sum += rowToInt(A[r]);
		}

		return sum;
	}

	public static int rowToInt(int[] A) {
		int num = 0;
		for (int i = 0; i < A.length; i++) {
			num = (num << 1) + A[i];
		}
		return num;
	}

	public static void flipRow(int[][] A, int rowIndex) {
		for (int c = 0, len = A[rowIndex].length; c < len; c++) {
			A[rowIndex][c] = (~A[rowIndex][c]) & 1;
		}
	}

	public static void flipColumn(int[][] A, int columnIndex) {
		for (int r = 0, len = A.length; r < len; r++) {
			A[r][columnIndex] = (~A[r][columnIndex]) & 1;
		}
	}

	public static boolean flippable(int[][] A, int columnIndex) {
		int count = 0;
		for (int r = 0, len = A.length; r < len; r++) {
			count += A[r][columnIndex];
		}

		return A.length - count > count;
	}
}