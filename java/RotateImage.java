/*
	You are given an n x n 2D matrix representing an image.
	Rotate the image by 90 degrees (clockwise).
	Follow up:
	Could you do this in-place?
*/
public class RotateImage{
	static public void main(String[] args){
/*		int[][] m = {	{0,1,2,3},
						{4,5,6,7},
						{8,9,10,11},
						{12,13,14,15}};*/
		int[][] m = {	{0,1,2},
						{4,5,6},
						{8,9,10}};
//		int[][] m = {{1}};
		rotate(m);
		for(int x = 0, n = m.length; x < n; x++){
			for(int y = 0; y < n; y++){
				System.out.print(m[x][y] + " ");
			}
			System.out.println();
		}
	}

	static public void rotate(int[][] matrix) {
		final int N = matrix.length, TEMP_SIZE = 4;

		for(int x = 0, n = N / 2; x < n; x++){
			for(int y = 0; y < n; y++){
				int[][] temp = new int[TEMP_SIZE][2];
				temp[0][0] = x;
				temp[0][1] = y;
				for(int i = 1; i < TEMP_SIZE; i++){
					temp[i][0] = temp[i - 1][1];
					temp[i][1] = N - 1 - temp[i - 1][0]; 
				}
				matrix[temp[0][0]][temp[0][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[1][0]][temp[1][1]];
				matrix[temp[1][0]][temp[1][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[1][0]][temp[1][1]];
				matrix[temp[0][0]][temp[0][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[1][0]][temp[1][1]];

				matrix[temp[2][0]][temp[2][1]] = matrix[temp[2][0]][temp[2][1]] ^ matrix[temp[3][0]][temp[3][1]];
				matrix[temp[3][0]][temp[3][1]] = matrix[temp[2][0]][temp[2][1]] ^ matrix[temp[3][0]][temp[3][1]];
				matrix[temp[2][0]][temp[2][1]] = matrix[temp[2][0]][temp[2][1]] ^ matrix[temp[3][0]][temp[3][1]];

				matrix[temp[0][0]][temp[0][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[2][0]][temp[2][1]];
				matrix[temp[2][0]][temp[2][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[2][0]][temp[2][1]];
				matrix[temp[0][0]][temp[0][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[2][0]][temp[2][1]];
			}
		}
		if(N % 2 == 1){
			int n = N / 2;
			for(int j = 0; j < n; j++){
				int[][] temp = new int[TEMP_SIZE][2];
				temp[0][0] = j;
				temp[0][1] = n;
				for(int i = 1; i < TEMP_SIZE; i++){
					temp[i][0] = temp[i - 1][1];
					temp[i][1] = N - 1 - temp[i - 1][0]; 
				}
				matrix[temp[0][0]][temp[0][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[1][0]][temp[1][1]];
				matrix[temp[1][0]][temp[1][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[1][0]][temp[1][1]];
				matrix[temp[0][0]][temp[0][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[1][0]][temp[1][1]];

				matrix[temp[2][0]][temp[2][1]] = matrix[temp[2][0]][temp[2][1]] ^ matrix[temp[3][0]][temp[3][1]];
				matrix[temp[3][0]][temp[3][1]] = matrix[temp[2][0]][temp[2][1]] ^ matrix[temp[3][0]][temp[3][1]];
				matrix[temp[2][0]][temp[2][1]] = matrix[temp[2][0]][temp[2][1]] ^ matrix[temp[3][0]][temp[3][1]];

				matrix[temp[0][0]][temp[0][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[2][0]][temp[2][1]];
				matrix[temp[2][0]][temp[2][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[2][0]][temp[2][1]];
				matrix[temp[0][0]][temp[0][1]] = matrix[temp[0][0]][temp[0][1]] ^ matrix[temp[2][0]][temp[2][1]];
			}
		}
	}

	static public int[][] rotateTest(int[][] matrix) {
		final int N = matrix.length;
		int[][] result = new int[N][N];

		for(int x = 0; x < N; x++){
			for(int y = 0; y < N; y++){
				result[y][N - x - 1] = matrix[x][y];
			}
		}

		return result;
	}
}