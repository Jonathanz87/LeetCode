/*
	problem 289
	According to the Wikipedia's article: "The Game of Life, also known simply as Life,
	is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
	Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
	Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
	using the following four rules (taken from the above Wikipedia article):
		Any live cell with fewer than two live neighbors dies, as if caused by under-population.
		Any live cell with two or three live neighbors lives on to the next generation.
		Any live cell with more than three live neighbors dies, as if by over-population..
		Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
	Write a function to compute the next state (after one update) of the board given its current state.
	Follow up:
		Could you solve it in-place?
		Remember that the board needs to be updated at the same time:
		You cannot update some cells first and then use their updated values to update other cells.
		In this question, we represent the board using a 2D array.
		In principle, the board is infinite,
		which would cause problems when the active area encroaches the border of the array.
		How would you address these problems?
*/
public class GameOfLife {
	public static void main(String[] args) {
		int[][] board = {	{0, 1, 1, 0, 1, 0, 1}, 
							{0, 1, 1, 0, 1, 0, 1}, 
							{0, 1, 1, 0, 1, 0, 1}, 
							{0, 1, 1, 0, 1, 0, 1}};
		gameOfLife(board);
	}

	public static void gameOfLife(int[][] board) {
		if (board == null || board.length <= 0 || board[0].length <= 0) {
			return;
		}
		int[] preRow = new int[board[0].length];
		int[] leftCol = new int[2];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int neighbors = getNeighbors(board, preRow, leftCol, i, j);
				if (board[i][j] == 1) {
					if (neighbors != 2 && neighbors != 3) {
						board[i][j] = 0;
					}
				} else if (neighbors == 3) {
					board[i][j] = 1;
				}
			}
		}
	}

	private static int getNeighbors(int[][] board, int[] preRow, int[] leftCol, int i, int j) {
		int ct = 0;
		if (checkValid(board, i, j - 1) && leftCol[1] == 1) {
			ct++;
		}

		if (checkValid(board, i - 1, j - 1) && leftCol[0] == 1) {
			ct++;
		}

		if (checkValid(board, i - 1, j) && preRow[j] == 1) {
			ct++;
		}

		if (checkValid(board, i - 1, j + 1) && preRow[j + 1] == 1) {
			ct++;
		}

		if (checkValid(board, i, j + 1) && board[i][j + 1] == 1) {
			ct++;
		}

		if (checkValid(board, i + 1, j + 1) && board[i + 1][j + 1] == 1) {
			ct++;
		}

		if (checkValid(board, i + 1, j) && board[i + 1][j] == 1) {
			ct++;
		}

		if (checkValid(board, i + 1, j - 1) &&  board[i + 1][j - 1] == 1) {
			ct++;
		}
		leftCol[0] = preRow[j];
		leftCol[1] = board[i][j];
		preRow[j] = board[i][j];
		return ct;
	}

	private static boolean checkValid(int[][] board, int i, int j) {
		return !(i < 0 || j < 0 || i >= board.length || j >= board[0].length);
	}
}
