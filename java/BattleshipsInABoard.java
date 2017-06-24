/*
	Given an 2D board, count how many battleships are in it. 
	The battleships are represented with 'X's, 
	empty slots are represented with '.'s. 
	You may assume the following rules:
	You receive a valid board, 
	made of only battleships or empty slots.
	Battleships can only be placed horizontally or vertically. 
	In other words, they can only be made of the shape 1xN (1 row, N columns) 
	or Nx1 (N rows, 1 column), where N can be of any size.
	At least one horizontal or vertical cell separates between two battleships
	- there are no adjacent battleships.
		Example:
		X..X
		...X
		...X
	In the above board there are 2 battleships.
		Invalid Example:
		...X
		XXXX
		...X
	This is an invalid board that you will not receive 
	- as battleships will always have a cell separating between them.
	Follow up:
	Could you do it in one-pass, using only O(1) extra memory 
	and without modifying the value of the board?
*/

public class BattleshipsInABoard{
	public static void main(String[] args){
		char[][] board = new char[args.length][];

		for(int i = 0; i < board.length; i++){
			board[i] = args[i].toCharArray();
		}

		System.out.println(countBattleships(board));
	}

	public static int countBattleships(char[][] board) {
		if(board == null){
			return 0;
		}
		boolean isValidCount = true;
		int ct = 0;

		for(int r = 0; r < board.length; r++, isValidCount = true){
			for(int c = 0; c < board[r].length; c++){
				if(board[r][c] == '.'){
					isValidCount = true;
				}else if(board[r][c] == 'X' && isValidCount && (r <= 0 || board[r - 1][c] != 'X')){
					isValidCount = false;
					ct++;
				}
			}
		}
		return ct;
	}
}