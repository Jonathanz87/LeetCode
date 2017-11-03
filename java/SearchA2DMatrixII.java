/*
	problem 240
	Write an efficient algorithm that searches for a value in an m x n matrix.
	This matrix has the following properties:
	Integers in each row are sorted in ascending from left to right.
	Integers in each column are sorted in ascending from top to bottom.
	For example,
		Consider the following matrix:
		[
			[1,   4,  7, 11, 15],
			[2,   5,  8, 12, 19],
			[3,   6,  9, 16, 22],
			[10, 13, 14, 17, 24],
			[18, 21, 23, 26, 30]
		]
		Given target = 5, return true.
		Given target = 20, return false.
*/

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		int[][] matrix = {
			{1,   4,  7, 11, 15},
			{2,   5,  8, 12, 19},
			{3,   6,  9, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30}
		};

		System.out.println(searchMatrix(matrix, Integer.parseInt(args[0])));
	}

	//start from top right corner
	//if target is less than curr position then it cannot be in that column
	//as column is sorted in ascending order and
	//all other values in that column would be greater than target so we reduce col
	//if target is greater than curr position then it cannot be in that row
	//as row is sorted and all other values in that
	//row would be smaller than target so we need to increase row
	//O(m+n)
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;

		int col = matrix[0].length - 1;
		int row = 0;

		while (col >= 0 && row <= matrix.length - 1) {
			if (matrix[row][col] == target) return true;
			else if (target > matrix[row][col]) row++;
			else if (target < matrix[row][col]) col--;
		}

		return false;
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length <= 0 || matrix[0].length <= 0) {
			return false;
		}

		final int MAX_X_INDEX = findPredecessor(matrix, target);
		final int MAX_Y_INDEX = findSuccessor(matrix, target);

		if(MAX_Y_INDEX <= -1) return false;
		for(int i = MAX_Y_INDEX; i <= MAX_X_INDEX; i++){
			if(findTarget(matrix[i], target)){
				return true;
			}
		}

		// for (int i = 0; i <= MAX_X_INDEX; i++) {
		// 	if (target <= matrix[i][MAX_Y_INDEX]
		// 	        && findTarget(matrix[i], target)) {
		// 		return true;
		// 	}
		// }

		return false;
	}

	public static boolean findTarget(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				return true;
			}
		}

		return false;
	}

	public static int findPredecessor(int[][] matrix, int target) {
		int left = 0, right = matrix.length - 1;
		while (left < right) {
			int mid = (left + right + 1) >> 1;

			if (matrix[mid][0] > target) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}

		return (matrix[left][0] > target) ? -1 : left;
	}


	public static int findSuccessor(int[][] matrix, int target) {
		final int TARGET_INDEX = matrix[0].length - 1;
		int left = 0, right = matrix.length - 1;

		while (left < right) {
			int mid = (left + right) >> 1;

			if (matrix[mid][TARGET_INDEX] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return matrix[left][TARGET_INDEX] < target ? -1 : left;
	}
}