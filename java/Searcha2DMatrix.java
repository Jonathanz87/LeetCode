/*
	problem 74
	Write an efficient algorithm that searches for a value in an m x n matrix.
	This matrix has the following properties:
	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,
	Consider the following matrix:
		[
			[1,   3,  5,  7],
			[10, 11, 16, 20],
			[23, 30, 34, 50]
		]
	Given target = 3, return true.
*/

public class Searcha2DMatrix{
	public static void main(String[] args){
		int[][] matrix = {	{1,   3,  5,  7},
							{10, 11, 16, 20},
							{23, 30, 34, 50}};
		System.out.println(searchMatrix(matrix, Integer.parseInt(args[0])));
	}

	public static boolean searchMatrix(int[][] matrix, int target){
		if(matrix.length <= 0 || matrix[0].length <= 0){
			return false;
		}

		int m;
		int fIndex = 0, bIndex = matrix.length - 1;

		while(fIndex < bIndex){
			int mIndex = (fIndex + bIndex) / 2 + 1;
			if(target < matrix[mIndex][0]){
				bIndex = mIndex - 1;
			}else{
				fIndex = mIndex;
			}
		}

		m = fIndex;

		fIndex = 0;
		bIndex = matrix[m].length - 1;

		while(fIndex < bIndex) {
			int mIndex = (fIndex + bIndex) / 2 + 1;
			if(target < matrix[m][mIndex]){
				bIndex = mIndex - 1;
			}else {
				fIndex = mIndex;
			}
		}
		return target == matrix[m][fIndex];
	}
}