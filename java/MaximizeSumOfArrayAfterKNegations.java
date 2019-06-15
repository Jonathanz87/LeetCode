
/*
    1005. Maximize Sum Of Array After K Negations
    Given an array A of integers, we must modify the array in the following way: 
    we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.
    (We may choose the same index i multiple times.)
    Return the largest possible sum of the array after modifying it in this way.
    Example 1:
        Input: A = [4,2,3], K = 1
        Output: 5
        Explanation: Choose indices (1,) and A becomes [4,-2,3].
    Example 2:
        Input: A = [3,-1,0,2], K = 3
        Output: 6
        Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
    Example 3:
        Input: A = [2,-3,-1,5,-4], K = 2
        Output: 13
        Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
    Note:
        1 <= A.length <= 10000
        1 <= K <= 10000
        -100 <= A[i] <= 100
*/

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[] {2,-3,-1,5,-4}, 3));
    }
    public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;

        for (int i = 0, len = A.length - 1; i < len; i++) {
            if (K > 0) {
                if (-A[i] < A[i + 1]) { // >=0
                    sum += K % 2 == 1 ? -A[i] : A[i];
                    K = 0;
                } else { // <0
                    sum -= A[i];
                    K--;
                }
            } else {
                sum += A[i];
            }
        }

        sum += K % 2 == 1 ? -A[A.length - 1] : A[A.length - 1];

        return sum;
    }
}