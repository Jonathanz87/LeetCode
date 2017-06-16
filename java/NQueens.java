/*
	problem 51
	The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
	such that no two queens attack each other.
	Given an integer n, return all distinct solutions to the n-queens puzzle.
	Each solution contains a distinct board configuration of the n-queens' placement, 
	where 'Q' and '.' both indicate a queen and an empty space respectively.
	For example,
	There exist two distinct solutions to the 4-queens puzzle:
	[
		[".Q..",  // Solution 1
		"...Q",
		"Q...",
		"..Q."],

		["..Q.",  // Solution 2
		"Q...",
		"...Q",
		".Q.."]
	]
*/
import java.util.List;
import java.util.LinkedList;

public class NQueens{
	private static final int[][] DIRECTION = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}};

	public static void main(String[] args) {
		solveNQueens2(13).forEach(System.out::println);
	}

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> boardList = new LinkedList<>();
		if(n > 1 && n <= 3){
			return boardList;
		}

		char[][] board = new char[n][n];
		for(int r = 0; r < n; r++){
			for(int c = 0; c < n; c++){
				board[r][c] = ' ';
			}
		}

		NQueens(boardList, board, 0);
		return boardList;
	}

	public static void NQueens(List<List<String>> boardList, char[][] board, final int rowIndex) {
		int size = board.length;
		if(rowIndex >= size){
			List<String> result = new LinkedList<>();
			for(int r = 0; r < size; r++){
				result.add(new String(board[r]));
			}
			boardList.add(result);
		}else{
			for(int c = 0; c < size; c++){
				if(board[rowIndex][c] == ' '){
					char[][] newBoard = copyBoard(board);
					newBoard[rowIndex][c] = 'Q';
					occupy(newBoard, rowIndex, c);
					NQueens(boardList, newBoard, rowIndex + 1);
				}
			}
		}
	}

	private static void occupy(char[][] board, final int rIndex, final int cIndex){
		int size = board.length;
		for(int[] d : DIRECTION){
			int r = rIndex + d[0], c = cIndex + d[1];
			while(r >= 0 && r < size && c >= 0 && c < size){
				board[r][c] = '.';
				r += d[0];
				c += d[1];
			}
		}
	}

	private static char[][] copyBoard(char[][] board){
		char[][] newBoard = new char[board.length][board.length];
		for(int r = 0, size = board.length; r < size; r++){
			for(int c = 0; c < size; c++){
				newBoard[r][c] = board[r][c];
			}
		}
		return newBoard;
	}


	
	//solution 2

	private static char[] columnTemplate;
	public static List<List<String>> solveNQueens2(int n) {
		List<List<String>> boardList = new LinkedList<>();
		if(n > 1 && n <= 3){
			return boardList;
		}

		columnTemplate = new char[n];
		int[] columnIndexs = new int[n];

		for(int i = 0; i < n; i++){
			columnTemplate[i] = '.';
		}

		NQueens(boardList, columnIndexs, 0, n);

		return boardList;
	}


	public static void NQueens(List<List<String>> solutionList, int[] columnIndexs, final int rowIndex, final int size){
		if(rowIndex >= size){
			List<String> temp = new LinkedList<>();
			for(int i : columnIndexs){
				columnTemplate[i] = 'Q';
				temp.add(new String(columnTemplate));
				columnTemplate[i] = '.';
			}
			solutionList.add(temp);
		}else{
			for(int i = 0; i < size; i++){
				columnIndexs[rowIndex] = i;
				if(isValid(columnIndexs, rowIndex, size)){
					NQueens(solutionList, columnIndexs, rowIndex + 1, size);
				}
			}
		}
	}

	public static boolean isValid(int[] columnIndexs, int rowIndex, int size){
		int leftIndex = columnIndexs[rowIndex];
		int rightIndex = columnIndexs[rowIndex];
		int middleIndex = columnIndexs[rowIndex];

		while(--rowIndex >= 0){
			if((--leftIndex >= 0 && columnIndexs[rowIndex] == leftIndex)
					|| (++rightIndex < size && columnIndexs[rowIndex] == rightIndex)
					|| (middleIndex == columnIndexs[rowIndex])){
				return false;
			}
		}
		return true;
	}
}