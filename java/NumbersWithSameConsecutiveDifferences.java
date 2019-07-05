/*
    967. Numbers With Same Consecutive Differences
    Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
    Note that every number in the answer must not have leading zeros except for the number 0 itself. 
    For example, 01 has one leading zero and is invalid, but 0 is valid.
    You may return the answer in any order.
    Example 1:
        Input: N = 3, K = 7
        Output: [181,292,707,818,929]
        Explanation: Note that 070 is not a valid number, because it has leading zeroes.
    Example 2:
        Input: N = 2, K = 1
        Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
    Note:
        1 <= N <= 9
        0 <= K <= 9
*/

import java.util.LinkedList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        }
        if (K == 0) {
            int[] result = new int[9];
            for (int i = 1; i <= 9; i++) {
                result[i - 1] = getNumber(i, N);
            }
            return result;
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            dsf(1, N, K, i, i, result);
        }

        int[] arrayResult = new int[result.size()];

        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = result.get(i);
        }
        return arrayResult;
    }

    private static void dsf(int currentDegit, int N, int K, int value, int last, List<Integer> result) {
        if (currentDegit == N) {
            result.add(value);
            return;
        }

        if (last + K <= 9) {
            dsf(currentDegit + 1, N, K, value * 10 + last + K, last + K, result);
        }
        if (last - K >= 0) {
            dsf(currentDegit + 1, N, K, value * 10 + last - K, last - K, result);
        }
    }

    private static int getNumber(int digit, int digitCount) {
        int n = digit;

        for (int i = 1; i < digitCount; i++) {
            n = n * 10 + digit;
        }
        return n;
    }
}
