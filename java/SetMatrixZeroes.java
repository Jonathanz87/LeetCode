/*
	problem 73
	Given a m x n matrix, if an element is 0, 
	set its entire row and column to 0. Do it in place.
	Follow up:
	Did you use extra space?
	A straight forward solution using O(mn) space is probably a bad idea.
	A simple improvement uses O(m + n) space, 
	but still not the best solution.
	Could you devise a constant space solution?
*/

public class SetMatrixZeroes{
	public static void main(String[] args){
		int[][] matrix = {	{1, 1, 1, 1},
							{1, 1, 0, 1},
							{1, 1, 1, 1},
							{1, 0, 1, 1},
							{1, 1, 1, 1}};
		setZeroes(matrix);

		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void setZeroes(int[][] matrix) {
		if(matrix.length <= 0 || matrix[0].length <= 0){
			return;
		}
		final int ROW_LENGTH = matrix.length;
		final int COLUMN_LENGTH = matrix[0].length;
		boolean isRowZeroes = false;
		boolean isColumnZeors = false;

		for(int r = 0; !isRowZeroes && r < ROW_LENGTH; r++){
			isRowZeroes = isRowZeroes || matrix[r][0] == 0;
		}

		for(int c = 0; !isColumnZeors && c < COLUMN_LENGTH; c++){
			isColumnZeors = isColumnZeors || matrix[0][c] == 0;
		}


		for(int r = 0; r < ROW_LENGTH; r++){
			for(int c = 0; c < COLUMN_LENGTH; c++){
				if(matrix[r][c] == 0){
					matrix[0][c] = 0;
					matrix[r][0] = 0;
				}
			}
		}

		for(int r = 1; r < ROW_LENGTH; r++){
			if(matrix[r][0] == 0){
				for(int c = 1; c < COLUMN_LENGTH; c++){
					matrix[r][c] = 0;
				}
			}
		}

		for(int c = 1; c < COLUMN_LENGTH; c++){
			if(matrix[0][c] == 0){
				for(int r = 1; r < ROW_LENGTH; r++){
					matrix[r][c] = 0;
				}
			}
		}

		if(isRowZeroes){
			for(int r = 1; r < ROW_LENGTH; r++){
				matrix[r][0] = 0;
			}
		}
		if(isColumnZeors){
			for(int c = 1; c < COLUMN_LENGTH; c++){
				matrix[0][c] = 0;
			}
		}
	}
}