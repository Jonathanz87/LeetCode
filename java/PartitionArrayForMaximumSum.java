/*
    1043. Partition Array for Maximum Sum
    Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  
    After partitioning, each subarray has their values changed to become the maximum value of that subarray.
    Return the largest sum of the given array after partitioning.
    Example 1:
        Input: A = [1,15,7,9,2,5,10], K = 3
        Output: 84
        Explanation: A becomes [15,15,15,9,10,10,10]
    Note:
        1 <= K <= A.length <= 500
        0 <= A[i] <= 10^6
*/

public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[] { 1, 15, 7, 9, 2, 5, 10, 1, 1, 1, 4, 3, 6, 87, 4, 33, 4, 6,
                4, 7, 5, 3, 2, 3, 6, 8, 7, 9, 9, 6, 4, 3, 3, 3, 33, 123, 7, 8, 8 }, 3));
    }

    public static int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length];
        int[] biggestQueue = new int[A.length];
        int first = -1, last = 0;
        biggestQueue[0] = A[0];
        dp[0] = A[0];

        for (int i = 1, len = Math.min(A.length, K); i < len; i++) {
            while (last > first && A[i] > biggestQueue[last]) {
                last--;
            }

            biggestQueue[++last] = A[i];

            dp[i] = biggestQueue[first + 1] * (i + 1);
        }

        for (int i = K; i < A.length; i++) {
            if (A[i - K] == biggestQueue[first + 1]) {
                first++;
            }

            while (last > first && A[i] > biggestQueue[last]) {
                last--;
            }

            biggestQueue[++last] = A[i];

            int tempFirst = first + 1;

            for (int count = K; count > 0; count--) {
                int biggest = biggestQueue[tempFirst];
                dp[i] = Math.max(dp[i], biggest * count + dp[i - count]);

                if (biggestQueue[tempFirst] == A[i - count + 1]) {
                    tempFirst++;
                }
            }

        }

        return dp[dp.length - 1];
    }

    public static int maxSumAfterPartitioning2(int[] A, int K) {
        int[] dp = new int[A.length];
        dp[0] = A[0];

        for (int i = 1, max = A[0], len = Math.min(A.length, K); i < len; i++) {
            max = Math.max(max, A[i]);
            dp[i] = max * (i + 1);
        }

        for (int i = K; i < A.length; i++) {
            for (int count = 1, max = A[i]; count <= K; count++) {

                dp[i] = Math.max(dp[i], max * count + dp[i - count]);
                max = Math.max(A[i - count], max);
            }

        }

        return dp[dp.length - 1];
    }
}