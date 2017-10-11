/*
	problem 221
	Given a 2D binary matrix filled with 0's and 1's,
	find the largest square containing only 1's and return its area.
	For example, given the following matrix:
		1 0 1 0 0
		1 0 1 1 1
		1 1 1 1 1
		1 0 0 1 0
	Return 4.
*/

/*
	solution
	a square have edge of 2
		1 1
		1 2
	its left up and left-up must have 1s

	a square have edge of 3
		1 1 1	1 0 1	1 1		1 2		2 2
		1 2 2	1 1 2	2 2		1 2		2 3
		1 2 3	1 2 2
	has three layers

	to do a left to right, up to down scanning,
	the right down corner is the last scanned position in the square
	therefore the min of (left, up and left-up) + 1 is the edge size of the current square
*/

public class MaximalSquare {
	public static void main(String[] args) {
		char[][] matrix = {
			{'1', '1', '1', '0', '0'},
			{'1', '1', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '0', '1', '0'}
		};
		System.out.println(maximalSquare(matrix));
	}

	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] board = new int[matrix.length][matrix[0].length];

		int max = 0, xLength = matrix.length, yLength = matrix[0].length;

		for (int x = 0; x < xLength; x++) {
			board[x][0] = matrix[x][0] - '0';
			max = Math.max(max, board[x][0]);
		}
		for (int y = 0; y < yLength; y++) {
			board[0][y] = matrix[0][y] - '0';
			max = Math.max(max, board[0][y]);
		}

		for (int x = 1; x < xLength; x++) {
			for (int y = 1; y < yLength; y++) {
				if (matrix[x][y] == '1') {
					board[x][y] = Math.min(board[x - 1][y - 1],
					                       Math.min(board[x - 1][y], board[x][y - 1])) + 1;
					max = Math.max(board[x][y], max);
				}
			}
		}
		return max * max;
	}

	public static int maximalSquare2(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] board = new int[matrix.length + 1][matrix[0].length + 1];
		int max = 0, xLength = board.length, yLength = board[0].length;

		for (int x = 1; x < xLength; x++) {
			for (int y = 1; y < yLength; y++) {
				if (matrix[x - 1][y - 1] == '1') {
					board[x][y] = Math.min(board[x - 1][y - 1],
					                       Math.min(board[x - 1][y], board[x][y - 1])) + 1;
					max = Math.max(board[x][y], max);
				}
			}
		}
		return max * max;
	}
}