/*
	problem 378
	Given a n x n matrix where each of the rows and columns are sorted in ascending order,
	find the kth smallest element in the matrix.
	Note that it is the kth smallest element in the sorted order,
	not the kth distinct element.
	Example:
		matrix = [
			[ 1,  5,  9],
			[10, 11, 13],
			[12, 13, 15]
		],
		k = 8,
		return 13.
	Note:
		You may assume k is always valid, 1 ≤ k ≤ n2.
*/

public class KthSmallestElementInASortedMatrix {
	public static int kthSmallest(int[][] matrix, int k) {
		int small = matrix[0][0];
		int big = matrix[matrix.length - 1][matrix.length - 1];

		while (small < big) {
			int mid = (small + big + 1) >> 1;
			int n = lessThan(matrix, mid);
			if (n < k) {
				small = mid;
			} else {
				big = mid - 1;
			}
		}

		return small;
	}
	public static int lessThan(int[][] matrix, int num) {
		int count = 0;
		int x = matrix.length - 1;

		for (int y = 0; y < matrix.length; y++) {
			while (x >= 0 && matrix[x][y] >= num) {
				x--;
			}
			count += x + 1;
		}
		return count;
	}
}