/*
	problem 79
	Given a 2D board and a word,
	find if the word exists in the grid.
	The word can be constructed from letters of sequentially adjacent cell,
	where "adjacent" cells are those horizontally or vertically neighboring.
	The same letter cell may not be used more than once.
	For example,
	Given board =
		[
			['A','B','C','E'],
			['S','F','C','S'],
			['A','D','E','E']
		]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
*/

public class WordSearch {
	public static void main(String[] args) {
		// char[][] board = {
		// 	{'A', 'B', 'C', 'E'},
		// 	{'S', 'F', 'C', 'S'},
		// 	{'A', 'D', 'E', 'E'}
		// };

		char[][] board = {
			{'B'},
			{'A'},
			{'B'}
		};

		System.out.println(exist(board, args[0]));
	}

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		if (board.length == 1 && board[0].length == 1 && word.length() == 1) {
			return board[0][0] == word.charAt(0);
		}
		for (int i = 0, iLen = board.length; i < iLen; i++) {
			for (int j = 0, jLen = board[i].length; j < jLen; j++) {
				if (dfs(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean dfs(char[][]board, String word, int index, int i, int j) {
		if (index >= word.length()) {
			return true;
		}

		if (board[i][j] != word.charAt(index)) {
			return false;
		}

		board[i][j] = '.';

		//up
		if (i - 1 >= 0 && dfs(board, word, index + 1, i - 1, j)) {
			return true;
		}

		//down
		if (i + 1 < board.length && dfs(board, word, index + 1, i + 1, j)) {
			return true;
		}

		//left
		if (j - 1 >= 0 && dfs(board, word, index + 1, i, j - 1)) {
			return true;
		}

		//right
		if (j + 1 < board[0].length && dfs(board, word, index + 1, i, j + 1)) {
			return true;
		}

		board[i][j] = word.charAt(index);
		return false;
	}
}