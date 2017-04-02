/*
	problem 62
	A robot is located at the top-left corner of a m x n grid
	The robot can only move either down or right at any point in time. 
	The robot is trying to reach the bottom-right corner of the grid
	How many possible unique paths are there?
*/
public class UniquePaths{
	public static void main(String[] args){
		System.out.println(uniquePaths(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	public static int uniquePaths(int m, int n) {
		if(m <= 1 || n <= 1) return 1;
		int[][] grid = new int[m][n];

		for(int i = 0, index = m - 1; i < n; grid[index][i++] = 1);
		for(int i = 0, index = n - 1; i < m; grid[i++][index] = 1);

		for(int i = m - 2; i >= 0; i--){
			for(int j = n - 2; j >= 0; j--){
				grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
			}
		}

		return grid[0][0];
	}
}