/*
	problem 417
	Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
	the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
	Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
	Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
	Note:
		The order of returned grid coordinates does not matter.
		Both m and n are less than 150.
	Example:
		Given the following 5x5 matrix:

		Pacific ~   ~   ~   ~   ~
		     ~  1   2   2   3  (5) *
		     ~  3   2   3  (4) (4) *
		     ~  2   4  (5)  3   1  *
		     ~ (6) (7)  1   4   5  *
		     ~ (5)  1   1   2   4  *
		        *   *   *   *   * Atlantic
		Return:
		[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
		(positions with parentheses in above matrix).
*/

import java.util.List;
import java.util.LinkedList;

public class PacificAtlanticWaterFlow {
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1, 2, 2, 3, 5},
			{3, 2, 3, 4, 4},
			{2, 4, 5, 3, 1},
			{6, 7, 1, 4, 5},
			{5, 1, 1, 2, 4}
		};

		List<int[]> list = pacificAtlanticDsf(matrix);
		for (int[] i : list) {
			System.out.println(i[0] + " - " + i[1]);
		}
	}

	public static List<int[]> pacificAtlanticDsf(int[][] matrix) {
		List<int[]> result = new LinkedList<>();
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) return result;
		int m = matrix.length, n = matrix[0].length;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];

		for (int j = 0; j < n; j++) {
			dsf(matrix, pacific, 0, j, matrix[0][j]);
		}

		for (int i = 1; i < m; i++) {
			dsf(matrix, pacific, i, 0, matrix[i][0]);
		}

		for (int j = 0, i = m - 1; j < n; j++) {
			dsf(matrix, atlantic, i, j, matrix[i][j]);
		}

		for (int i = m - 2, j = n - 1; i >= 0; i--) {
			dsf(matrix, atlantic, i, j, matrix[i][j]);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					result.add(new int[] {i, j});
				}
			}
		}

		return result;
	}

	private static void dsf(int[][] matrix, boolean[][] visited, int x, int y, int preValue) {
		if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length ||
		        matrix[x][y] < preValue || visited[x][y]) {
			return;
		}
		visited[x][y] = true;
		dsf(matrix, visited, x + 1, y, matrix[x][y]);
		dsf(matrix, visited, x - 1, y, matrix[x][y]);
		dsf(matrix, visited, x, y + 1, matrix[x][y]);
		dsf(matrix, visited, x, y - 1, matrix[x][y]);
	}

	public static List<int[]> pacificAtlanticBsf(int[][] matrix) {
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) return new LinkedList<>();

		int m = matrix.length, n = matrix[0].length;
		int[] xQueue = new int[m * n];
		int[] yQueue = new int[m * n];
		int queueSize = -1;
		int queueIndex = -1;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];
		List<int[]> result = new LinkedList<>();

		for (int j = 0; j < n; j++) {
			update(xQueue, yQueue, ++queueSize, pacific, 0, j);
		}

		for (int i = 1; i < m; i++) {
			update(xQueue, yQueue, ++queueSize, pacific, i, 0);
		}

		while (queueIndex < queueSize) {
			queueIndex++;
			int x = xQueue[queueIndex];
			int y = yQueue[queueIndex];
			if (flowable(matrix, matrix[x][y], x + 1, y) && !pacific[x + 1][y]) {
				update(xQueue, yQueue, ++queueSize, pacific, x + 1, y);
			}

			if (flowable(matrix, matrix[x][y], x - 1, y) && !pacific[x - 1][y]) {
				update(xQueue, yQueue, ++queueSize, pacific, x - 1, y);
			}

			if (flowable(matrix, matrix[x][y], x, y + 1) && !pacific[x][y + 1]) {
				update(xQueue, yQueue, ++queueSize, pacific, x, y + 1);
			}

			if (flowable(matrix, matrix[x][y], x, y - 1) && !pacific[x][y - 1]) {
				update(xQueue, yQueue, ++queueSize, pacific, x, y - 1);
			}

		}

		queueSize = -1;
		queueIndex = -1;
		for (int j = 0, i = m - 1; j < n; j++) {
			update(xQueue, yQueue, ++queueSize, atlantic, i, j);
		}

		for (int i = m - 2, j = n - 1; i >= 0; i--) {
			update(xQueue, yQueue, ++queueSize, atlantic, i, j);
		}

		while (queueIndex < queueSize) {
			queueIndex++;
			int x = xQueue[queueIndex];
			int y = yQueue[queueIndex];
			if (pacific[x][y]) {
				result.add(new int[] {x, y});
			}

			if (flowable(matrix, matrix[x][y], x + 1, y) && !atlantic[x + 1][y]) {
				update(xQueue, yQueue, ++queueSize, atlantic, x + 1, y);
			}

			if (flowable(matrix, matrix[x][y], x - 1, y) && !atlantic[x - 1][y]) {
				update(xQueue, yQueue, ++queueSize, atlantic, x - 1, y);
			}

			if (flowable(matrix, matrix[x][y], x, y + 1) && !atlantic[x][y + 1]) {
				update(xQueue, yQueue, ++queueSize, atlantic, x, y + 1);
			}

			if (flowable(matrix, matrix[x][y], x, y - 1) && !atlantic[x][y - 1]) {
				update(xQueue, yQueue, ++queueSize, atlantic, x, y - 1);
			}
		}

		return result;
	}


	private static boolean flowable(int[][] matrix, int height, int x, int y) {
		if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
			return false;
		}
		return height <= matrix[x][y];
	}

	private static void update(int[] xQueue, int[] yQueue, int index, boolean[][] visited, int x, int y) {
		xQueue[index] = x;
		yQueue[index] = y;

		visited[x][y] = true;
	}
}