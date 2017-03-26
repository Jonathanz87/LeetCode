/*
	problem 36
	Determine if a Sudoku is valid,
	according to: Sudoku Puzzles - The Rules.
	The Sudoku board could be partially filled,
	where empty cells are filled with the character '.'.
*/

public class ValidSudoku{
	static public void main(String[] args){
		char[][] board = {	{'5','3','.','.','7','.','.','.','.'},
							{'6','.','.','1','9','5','.','.','.'},
							{'.','9','8','.','.','.','.','6','.'},
							{'8','.','.','.','6','.','.','.','3'},
							{'4','.','.','8','.','3','.','.','1'},
							{'7','.','.','.','2','.','.','.','6'},
							{'.','6','.','.','.','.','2','8','.'},
							{'.','.','.','4','1','9','.','.','5'},
							{'.','.','.','.','8','.','.','7','9'}};

		String[] str = {"..4...63.",
						".........",
						"5......9.",
						"...56....",
						"4.3.....1",
						"...7.....",
						"...5.....",
						".........",
						"........."};
		char[][] board2 = new char[9][];
		for(int i = 0; i < 9; i++){
			board2[i] = str[i].toCharArray();
		}
		System.out.println(isValidSudoku(board2));
	}

	static public boolean isValidSudoku(char[][] board){
		final int SIZE = 9;
		boolean[][] yMarked = new boolean[SIZE][SIZE];
		boolean[][] sqMarked = new boolean[SIZE][SIZE];

		for(int x = 0; x < SIZE; x++){
			boolean[] isMarked = new boolean[SIZE];
			for(int y = 0; y < SIZE; y++){
				char c = board[x][y];
				if(c != '.'){
					int i = c - '0' - 1;
					int sqi = x / 3 * 3 + y / 3;
					if(isMarked[i] || yMarked[y][i] || 
						sqMarked[sqi][i]){
						return false;
					}
					isMarked[i] = true;
					yMarked[y][i] = true;
					sqMarked[sqi][i] = true;
				}
			}
		}

		return true;
	}
}