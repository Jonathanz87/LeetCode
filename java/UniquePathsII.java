/*
	problem 63
	Follow up for "Unique Paths":
	Now consider if some obstacles are added to the grids.
	How many unique paths would there be?
	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	For example,
	There is one obstacle in the middle of a 3x3 grid as illustrated below.
		[
			[0,0,0],
			[0,1,0],
			[0,0,0]
		]
	The total number of unique paths is 2.
*/

public class UniquePathsII{
	public static void main(String[] args){
		int[][] obstacleGrid = {{0,0},
								{1,0}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	} 
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int xIndex = obstacleGrid.length - 1;
		int yIndex = obstacleGrid[0].length - 1;
		if(obstacleGrid[xIndex][yIndex] == 1 || obstacleGrid[0][0] == 1)
			return 0;
		obstacleGrid[xIndex][yIndex] = 1;

		for(int i = xIndex - 1; i >= 0; i--){
			if(obstacleGrid[i][yIndex] == 1){
				obstacleGrid[i][yIndex] = 0;
			}else{
				obstacleGrid[i][yIndex] = obstacleGrid[i + 1][yIndex];
			}
		}

		for(int i = yIndex - 1; i >= 0; i--){
			if(obstacleGrid[xIndex][i] == 1){
				obstacleGrid[xIndex][i] = 0;
			}else{
				obstacleGrid[xIndex][i] = obstacleGrid[xIndex][i + 1];
			}
		}

		for(int i = xIndex - 1; i >= 0; i--){
			for(int j = yIndex - 1; j >= 0; j--){
				if(obstacleGrid[i][j] == 1){
					obstacleGrid[i][j] = 0;
				}else{
					obstacleGrid[i][j] = obstacleGrid[i + 1][j] + obstacleGrid[i][j + 1];
				}
			}
		}

		return obstacleGrid[0][0];
	}
}