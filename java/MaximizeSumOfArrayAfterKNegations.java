
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
        System.out.println(largestSumAfterKNegationsN(new int[] { 4, 2, 3 }, 2));
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

    public static int largestSumAfterKNegations2(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        int smallest = Integer.MAX_VALUE;

        for (int n : A) {
            if (n < 0 && K > 0) {
                sum -= n;
                K--;
                smallest = Math.min(smallest, -n);
            } else {
                sum += n;
                smallest = Math.min(smallest, n);
            }
        }

        if (K % 2 == 1) {
            sum -= smallest * 2;
        }

        return sum;
    }

    public static int largestSumAfterKNegationsN(int[] A, int K) {
        int[] numberCount = new int[201];
        int sum = 0;
        int shift = 100;
        int smallest = Integer.MAX_VALUE;

        for (int n : A) {
            numberCount[n + shift]++;
        }

        for (int i = 0; i < 100; i++) {
            if (numberCount[i] > 0) {
                int n = K >= numberCount[i] ? numberCount[i] : K;
                int num = i - shift;
                sum -= num * n;
                sum += num * (numberCount[i] - n);
                K -= n;
                smallest = Math.min(smallest, -num);
            }
        }

        for (int i = 100; i < 201; i++) {
            if (numberCount[i] > 0) {
                int num = i - shift;
                sum += num * numberCount[i];
                smallest = Math.min(smallest, num);
            }
        }

        if (K % 2 == 1) {
            sum -= smallest * 2;
        }

        return sum;
    }
}