/*
	problem 52
	Follow up for N-Queens problem.
	Now, instead outputting board configurations,
	return the total number of distinct solutions.
*/
import java.util.List;
import java.util.LinkedList;

public class NQueensII{
	public static void main(String[] args) {
		System.out.println(totalNQueens(13));
	}

	public static int totalNQueens(int n) {
		if(n > 1 && n <= 3){
			return 0;
		}

		int[] columnIndexs = new int[n];
		int ct = NQueens(columnIndexs, 0, n);

		return ct;
	}

	public static int NQueens(int[] columnIndexs, final int rowIndex, final int size){
		if(rowIndex >= size){
			return 1;
		}else{
			int ct = 0;
			for(int i = 0; i < size; i++){
				columnIndexs[rowIndex] = i;
				if(isValid(columnIndexs, rowIndex, size)){
					ct += NQueens(columnIndexs, rowIndex + 1, size);
				}
			}
			return ct;
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