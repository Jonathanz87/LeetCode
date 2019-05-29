
/*
    873. Length of Longest Fibonacci Subsequence
    A sequence X_1, X_2, ..., X_n is fibonacci-like if:
    n >= 3
    X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
    Given a strictly increasing array A of positive integers forming a sequence, 
    find the length of the longest fibonacci-like subsequence of A.
    If one does not exist, return 0.
    (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, 
    without changing the order of the remaining elements.  
    For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
    Example 1:
        Input: [1,2,3,4,5,6,7,8]
        Output: 5
        Explanation:
        The longest subsequence that is fibonacci-like: [1,2,3,5,8].
    Example 2:
        Input: [1,3,7,11,12,14,18]
        Output: 3
        Explanation:
        The longest subsequence that is fibonacci-like:
        [1,11,12], [3,11,14] or [7,11,18].
    3 <= A.length <= 1000
    1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
    (The time limit has been reduced by 50% for submissions in Java, C, and C++.)
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseqFastestSaveMemery(new int[] { 2, 4, 5, 6, 7, 8, 11, 13, 14, 15, 21, 22, 24 }));
    }

    public static int lenLongestFibSubseq(int[] A) {
        int longest = 0;
        int max = A[A.length - 1];
        Map<Integer, Integer> numberMap = new HashMap<>();
        boolean[][] visited = new boolean[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            numberMap.put(A[i], i);
        }

        for (int i = 0; i < A.length - longest - 2; i++) {
            for (int j = i + 1; A[i] + A[j] <= max; j++) {
                longest = Math.max(longest, count(A, i, j, visited, max, numberMap));
            }
        }
        return longest == 0 ? 0 : longest + 2;
    }

    public static int count(int[] A, int i, int j, boolean[][] visited, int max, Map<Integer, Integer> numberMap) {
        if (visited[i][j] || A[i] + A[j] > max || !numberMap.containsKey(A[i] + A[j])) {
            return 0;
        }
        visited[i][j] = true;
        return count(A, j, numberMap.get(A[i] + A[j]), visited, max, numberMap) + 1;
    }

    public static int lenLongestFibSubseqSlow100ms(int[] A) {
        int longest = 0;
        int max = A[A.length - 1];
        boolean[][] visited = new boolean[A.length][A.length];

        for (int i = 0; i < A.length - longest - 2; i++) {
            for (int j = i + 1; A[i] + A[j] <= max; j++) {
                longest = Math.max(longest, count2(A, i, j, visited, max));
            }
        }
        return longest == 0 ? 0 : longest + 2;
    }

    public static int count2(int[] A, int i, int j, boolean[][] visited, int max) {
        int nextIndex = Arrays.binarySearch(A, A[i] + A[j]);
        if (visited[i][j] || A[i] + A[j] > max || nextIndex < 0) {
            return 0;
        }
        visited[i][j] = true;
        return count2(A, j, nextIndex, visited, max) + 1;
    }

    public static int lenLongestFibSubseqFastestSaveMemery(int[] A) {
        int longest = 0;
        int max = A[A.length - 1];
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            numberMap.put(A[i], i);
        }

        for (int i = 0; i < A.length - longest - 2; i++) {
            for (int j = i + 1; A[i] + A[j] <= max; j++) {
                longest = Math.max(longest, count3(A, i, j, max, numberMap));
            }
        }
        return longest == 0 ? 0 : longest + 2;
    }

    public static int count3(int[] A, int i, int j, int max, Map<Integer, Integer> numberMap) {
        if (A[i] + A[j] > max || !numberMap.containsKey(A[i] + A[j])) {
            return 0;
        }
        return count3(A, j, numberMap.get(A[i] + A[j]), max, numberMap) + 1;
    }
}