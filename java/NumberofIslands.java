/*
	problem 200
	Given a 2d grid map of '1's (land) and '0's (water),
	count the number of islands.
	An island is surrounded by water and
	is formed by connecting adjacent lands horizontally or vertically.
	You may assume all four edges of the grid are all surrounded by water.

		Example 1:
			11110
			11010
			11000
			00000
		Answer: 1

		Example 2:
			11000
			11000
			00100
			00011
		Answer: 3
*/

public class NumberofIslands{
	static public void main(String[] args){
		char[][] grid = {	{'1','1','0','0','0'},
							{'1','1','0','0','0'},
							{'0','0','1','0','0'},
							{'0','0','0','1','1'}};
		System.out.println(numIslands(grid));

		char[][] grid2 = {	{'1','1','1','1','0'},
							{'1','1','0','1','0'},
							{'1','1','0','0','0'},
							{'0','0','1','0','1'}};
		System.out.println(numIslands(grid2));

	}

	static public int numIslands(char[][] grid){
		int islandCt = 0;
		for(int x = 0, xLen = grid.length; x < xLen; x++){
			for(int y = 0, yLen = grid[x].length; y < yLen; y++){
				if(grid[x][y] == '1'){
					islandCt++;
					dfs(grid, x, y);
				}
			}
		}
		return islandCt;
	}

	static private void dfs(char[][] grid, int x, int y){
		if(x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == '0')
			return;

		grid[x][y] = '0';
		dfs(grid, x - 1, y);
		dfs(grid, x + 1, y);
		dfs(grid, x, y - 1);
		dfs(grid, x, y + 1);
	}
}