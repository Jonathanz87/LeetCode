/*
	problem 695
	Given a non-empty 2D array grid of 0's and 1's,
	an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
	You may assume all four edges of the grid are surrounded by water.
	Find the maximum area of an island in the given 2D array.
	(If there is no island, the maximum area is 0.)
	Example 1:
		[[0,0,1,0,0,0,0,1,0,0,0,0,0],
		 [0,0,0,0,0,0,0,1,1,1,0,0,0],
		 [0,1,1,0,1,0,0,0,0,0,0,0,0],
		 [0,1,0,0,1,1,0,0,1,0,1,0,0],
		 [0,1,0,0,1,1,0,0,1,1,1,0,0],
		 [0,0,0,0,0,0,0,0,0,0,1,0,0],
		 [0,0,0,0,0,0,0,1,1,1,0,0,0],
		 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
		Given the above grid, return 6.
		Note the answer is not 11,
		because the island must be connected 4-directionally.
	Example 2:
		[[0,0,0,0,0,0,0,0]]
		Given the above grid, return 0.
	Note: The length of each dimension in the given grid does not exceed 50.
*/

public class MaxAreaOfIsland {
	public static int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0, iLen = grid.length, jLen = grid[0].length; i < iLen; i++) {
			for (int j = 0; j < jLen; j++) {
				max = Math.max(max, dp(grid, i, j));
			}
		}

		return max;

	}

	private static int dp(int[][] grid, int x, int y) {
		if (x < grid.length && y < grid[0].length && grid[x][y] == 1) {
			grid[x][y] = 0;
			int count = dp(grid, x + 1, y) + dp(grid, x, y + 1) + 1;
			return count;
		}
		return 0;
	}
}