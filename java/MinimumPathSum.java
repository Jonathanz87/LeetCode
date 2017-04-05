/*
	problem 64
	Given a m x n grid filled with non-negative numbers,
	find a path from top left to bottom right
	which minimizes the sum of all numbers along its path.
	Note: You can only move either down or right at any point in time.
*/

public class MinimumPathSum{
	public static void main(String[] args){
		int[][] grid = {{1,2,1,1,1},
						{2,1,1,1,1},
						{2,1,1,1,1}};
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		if(grid.length <= 0 || grid[0].length <= 0) return 0;
		int m = grid.length, n = grid[0].length;

		for(int i = 1; i < m; i++){
			grid[i][0] += grid[i - 1][0];
		}

		for(int i = 1; i < n; i++){
			grid[0][i] += grid[0][i - 1];
		}

		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}

		return grid[m - 1][n - 1];
	}
}