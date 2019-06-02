/*
    1014. Best Sightseeing Pair    
    Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two sightseeing spots i and j have distance j - i between them.
    The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sightseeing spots, minus the distance between them.
    Return the maximum score of a pair of sightseeing spots.
    Example 1:
        Input: [8,1,5,2,6]
        Output: 11
        Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
    Note:
        2 <= A.length <= 50000
        1 <= A[i] <= 1000
*/

public class BestSightseeingPair {
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPairSlow(new int[] { 8, 1, 5, 2, 6 }));
    }

    public static int maxScoreSightseeingPairSlow(int[] A) {
        int[] weightIndexQueue = new int[A.length];
        int head = 0, tail = 0;
        int max = Integer.MIN_VALUE;
        weightIndexQueue[tail] = 0;

        for (int i = 1; i < A.length; i++) {
            int weight = A[i] - i;
            int tailIndex = weightIndexQueue[tail];
            if (weight <= A[tailIndex] - tailIndex) {
                weightIndexQueue[++tail] = i;
                continue;
            }

            while (weight > A[tailIndex] - tailIndex && --tail >= 0) {
                tailIndex = weightIndexQueue[tail];
            }

            weightIndexQueue[++tail] = i;
        }

        for (int i = 0, len = A.length - 1; i < len; i++) {
            if (i == weightIndexQueue[head]) {
                head++;
            }
            max = Math.max(max, A[i] + A[weightIndexQueue[head]] + i - weightIndexQueue[head]);
        }
        return max;
    }
}