/*
    977. Squares of a Sorted Array
    Given an array of integers A sorted in non-decreasing order, 
    return an array of the squares of each number, also in sorted non-decreasing order.
    Example 1:
        Input: [-4,-1,0,3,10]
        Output: [0,1,9,16,100]
    Example 2:
        Input: [-7,-3,2,3,11]
        Output: [4,9,9,49,121]
    Note:
        1 <= A.length <= 10000
        -10000 <= A[i] <= 10000
        A is sorted in non-decreasing order.
*/

public class SquaresOfASortedArray {
    public static final void main(String[] args) {
        int[] A = new int[] { 0 };
        for (int n : sortedSquares(A)) {
            System.out.println(n);
        }
    }

    public static final int[] sortedSquares(int[] A) {
        if (A == null) {
            return null;
        }
        int[] result = new int[A.length];
        int positiveIndex = 0;
        int negativeIndex = 0;
        int index = 0;

        while (positiveIndex < A.length && A[positiveIndex] < 0) {
            positiveIndex++;
        }
        negativeIndex = positiveIndex - 1;

        while (positiveIndex < A.length && negativeIndex >= 0) {
            if (Math.abs(A[positiveIndex]) < Math.abs(A[negativeIndex])) {
                result[index++] = A[positiveIndex] * A[positiveIndex];
                positiveIndex++;
            } else {
                result[index++] = A[negativeIndex] * A[negativeIndex];
                negativeIndex--;
            }
        }

        while (positiveIndex < A.length) {
            result[index++] = A[positiveIndex] * A[positiveIndex];
            positiveIndex++;
        }

        while (negativeIndex >= 0) {
            result[index++] = A[negativeIndex] * A[negativeIndex];
            negativeIndex--;
        }

        return result;
    }
}