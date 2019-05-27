/*
    1020. Number of Enclaves
    Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
    A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
    Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
    Example 1:
        Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
        Output: 3
        Explanation: 
        There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.
    Example 2:
        Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
        Output: 0
        Explanation: 
        All 1s are either on the boundary or can reach the boundary.
    Note:
        1 <= A.length <= 500
        1 <= A[i].length <= 500
        0 <= A[i][j] <= 1
        All rows have the same size.
*/

public class NumberOfEnclaves {
    public static int numEnclaves(int[][] A) {
        int count = 0;
        for (int x = 0; x < A.length; x++) {
            dfs(A, x, 0);
            dfs(A, x, A[0].length - 1);
        }

        for (int y = 1, len = A[0].length - 1; y < len; y++) {
            dfs(A, 0, y);
            dfs(A, A.length - 1, y);
        }

        for (int x = 1, xLen = A.length - 1; x < xLen; x++) {
            for (int y = 1, yLen = A[0].length - 1; y < yLen; y++) {
                if (A[x][y] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(int[][] A, int x, int y) {
        if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] == 0) {
            return;
        }

        A[x][y] = 0;
        dfs(A, x + 1, y);
        dfs(A, x - 1, y);
        dfs(A, x, y + 1);
        dfs(A, x, y - 1);
    }
}