/*
	problem 463
	You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
	Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
	and there is exactly one island (i.e., one or more connected land cells).
	The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
	One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
	Determine the perimeter of the island.
	Example:
		[
			[0,1,0,0],
			[1,1,1,0],
			[0,1,0,0],
			[1,1,0,0]
		]
		Answer: 16
*/

public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        if(grid == null) return 0;
        final int I_LENGTH = grid.length;
        if(I_LENGTH <= 0) return 0;
        final int J_LENGTH = grid[0].length;
        if(J_LENGTH <= 0) return 0;

        int perimeter = 0;

        for(int i = 0; i < I_LENGTH; i++) {
            for(int j = 0; j < J_LENGTH; j++) {
                if(grid[i][j] == 1) {

                    perimeter += perimeterCount(grid, i, j);
                }
            }
        }

        return perimeter;
    }

    private static int perimeterCount(int[][] grid, int i, int j) {
        int count = 0;
        if(i <= 0 || grid[i - 1][j] == 0) {
            count++;
        }
        if(i >= grid.length - 1 || grid[i + 1][j] == 0 ) {
            count++;
        }
        if(j <= 0 || grid[i][j - 1] == 0) {
            count++;
        }
        if(j >= grid[i].length - 1 || grid[i][j + 1] == 0) {
            count++;
        }
        return count;
    }

    /*
		solution
		the count of sides (number of 1 * 4) - the count of adjacent sides (adjacent * 2)
    */
    public int islandPerimeter2(int[][] grid) {
        int duplicate = 0;
        int island = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    island++;
                    if(i + 1 < grid.length && grid[i + 1][j] == 1)
                        duplicate++;
                    if(j + 1 < grid[0].length && grid[i][j + 1] == 1)
                        duplicate++;
                }
            }
        }
        return island * 4 - duplicate * 2;
    }
}