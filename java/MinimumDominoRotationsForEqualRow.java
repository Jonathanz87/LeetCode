import javax.lang.model.element.Element;

/*
    1007. Minimum Domino Rotations For Equal Row
    In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.
    (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
    We may rotate the i-th domino, so that A[i] and B[i] swap values.
    Return the minimum number of rotations so that all the values in A are the same, 
    or all the values in B are the same.
    If it cannot be done, return -1.

    Example 1:
        Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
        Output: 2
        Explanation: 
        The first figure represents the dominoes as given by A and B: before we do any rotations.
        If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, 
        as indicated by the second figure.

    Example 2:
        Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
        Output: -1
        Explanation: 
        In this case, it is not possible to rotate the dominoes to make one row of values equal.

    Note:
        1 <= A[i], B[i] <= 6
        2 <= A.length == B.length <= 20000
*/

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int a = A[0];
        int b = B[0];

        int[] top = new int[2];
        int[] bottom = new int[2];

        for (int i = 0, len = A.length; i < len; i++) {
            if (a != A[i] && a != B[i]) {
                top[0] = Integer.MIN_VALUE;
                bottom[0] = Integer.MIN_VALUE;
            } else if (a == A[i] && a == B[i]) {
            } else if (a != A[i]) {
                top[0]++;
            } else {
                bottom[0]++;
            }

            if (b != A[i] && b != B[i]) {
                top[1] = Integer.MIN_VALUE;
                bottom[1] = Integer.MIN_VALUE;
            } else if (b == A[i] && b == B[i]) {
            } else if (b != B[i]) {
                bottom[1]++;
            } else {
                top[1]++;
            }

            if (top[0] < 0 && top[1] < 0 && bottom[0] < 0 && bottom[1] < 0) {
                return -1;
            }
        }

        int minFlip = Integer.MAX_VALUE;

        if (top[0] >= 0) {
            minFlip = Math.min(top[0], minFlip);
        }
        if (top[1] >= 0) {
            minFlip = Math.min(top[1], minFlip);
        }

        if (bottom[0] >= 0) {
            minFlip = Math.min(bottom[0], minFlip);
        }

        if (bottom[1] >= 0) {
            minFlip = Math.min(bottom[1], minFlip);
        }

        return minFlip == Integer.MAX_VALUE ? -1 : minFlip;
    }

    public int minDominoRotations2(int[] A, int[] B) {
        int flip = Integer.MAX_VALUE;

        int tmp = flitCount(A[0], A, B);
        if (tmp != -1) {
            flip = Math.min(flip, tmp);
        }

        tmp = flitCount(B[0], A, B);
        if (tmp != -1) {
            flip = Math.min(flip, tmp);
        }

        tmp = flitCount(A[0], B, A);
        if (tmp != -1) {
            flip = Math.min(flip, tmp);
        }

        tmp = flitCount(B[0], B, A);
        if (tmp != -1) {
            flip = Math.min(flip, tmp);
        }

        return flip == Integer.MAX_VALUE ? -1 : flip;
    }

    private static int flitCount(int n, int[] A, int[] B) {
        int flip = 0;
        for (int i = 0, len = A.length; i < len; i++) {
            if (n == A[i]) {

            } else if (n == B[i]) {
                flip++;
            } else {
                return -1;
            }
        }

        return flip;
    }

}