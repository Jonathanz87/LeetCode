/*
	problem 576
	There is an m by n grid with a ball. 
	Given the start coordinate (i,j) of the ball, 
	you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). 
	However, you can at most move N times. 
	Find out the number of paths to move the ball out of grid boundary. 
	The answer may be very large, return it after mod 109 + 7.
	Example 1:
		Input:m = 2, n = 2, N = 2, i = 0, j = 0
		Output: 6
	Example 2:
		Input:m = 1, n = 3, N = 3, i = 0, j = 1
		Output: 12
		Explanation:
	Note:
		Once you move the ball out of boundary, you cannot move it back.
		The length and height of the grid is in range [1,50].
		N is in range [0,50].
*/

public class OutOfBoundaryPaths {
	public int findPaths(int m, int n, int N, int i, int j) {
		return dsf(m, n, N, i, j, new int[m][n][N]);
	}

	private static int dsf(int m, int n, int N, int i, int j, int[][][] count) {
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return 1;
		}
		if (N <= 0) {
			return 0;
		}
		N = N - 1;
		int ct = 0;
		if (count[i][j][N] != 0) {
			ct = count[i][j][N] - 1;
		} else {
			ct = (ct + dsf(m, n, N, i + 1, j, count)) % 1000000007;
			ct = (ct + dsf(m, n, N, i - 1, j, count)) % 1000000007;
			ct = (ct + dsf(m, n, N, i, j + 1, count)) % 1000000007;
			ct = (ct + dsf(m, n, N, i, j - 1, count)) % 1000000007;
			count[i][j][N] = ct + 1;
		}
		return ct;
	}
}