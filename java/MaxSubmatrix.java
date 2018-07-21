// find the max sum of submatrix in a given matrix

public class MaxSubmatrix {
	public static void main(String[] args) {
		int[][] m = {{2,1,-3,-4,5},{0,6,3,4,1},{2,-2,-1,4,-5},{-3,3,1,0,3}};
		System.out.println(maxSubmatrix(m));
	}

	public static int maxSubmatrix(int[][] matrix) {
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
			throw new RuntimeException();
		}
		int max = Integer.MIN_VALUE;


		for (int x = 0; x < matrix.length; x++) {
			int[] rowSum = new int[matrix[0].length];

			for ( int i = x; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					rowSum[j] += matrix[i][j];
				}
				max = Math.max(max, maxSubarray(rowSum));
			}
		}
		return max;

	}

	private static int maxSubarray(int[] arr) {
		int max = arr[0];
		int sum = max;

		for (int i = 1; i < arr.length; i++) {
			sum = Math.max(0, sum) + arr[i];
			max = Math.max(max, sum);
		}

		return max;
	}
}