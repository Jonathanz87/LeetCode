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
	public List<int[]> pacificAtlantic(int[][] matrix) {
		if (matrix == null || matrix.size <= 0 || matrix[0].size <= 0) return new LinkedList<>();

		int m = matrix.length, n = matrix[0].length;
		int[] xQueue = new int[m * n];
		int[] yQueue = new int[m * n];
		int queueSize = -1;
		int queueIndex = -1;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];

		for (int j = 0; j < n; j++) {
			queueSize++;
			xQueue[queueSize] = 0;
			yQueue[queueSize] = j;
			pacific[0][j] = true;
		}

		for(int i = 1; i < m; i++){
			queueSize++;
			xQueue[queueSize] = i;
			yQueue[queueSize] = 0;
			pacific[i][0] = true;
		}

		while(queueIndex <= queueSize){
			queueIndex++;
			int x = xQueue[queueIndex];
			int y = yQueue[queueIndex];
			if(flowable(matrix, matrix[x][y], x + 1, y)){
				queueSize++;
				xQueue[queueSize] = x + 1;
				yQueue[queueSize] = y;
			}


		}

		private boolean flowable(int[][] matrix, int height, int x, int y){
			if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length){
				return false;
			}
			return height <= matrix[x][y];
		}

		private void update(int q)
	}
}