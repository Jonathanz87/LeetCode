/*
    problem 852
    Let's call an array A a mountain if the following properties hold:
    A.length >= 3
    There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
    Given an array that is definitely a mountain, 
    return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
    Example 1:
        Input:  [0,1,0]
        Output: 1
    Example 2:
        Input:  [0,2,1,0]
        Output: 1
    Note:
        3 <= A.length <= 10000
        0 <= A[i] <= 10^6
        A is a mountain, as defined above.
 */

public class PeakIndexInAMountainArray {
    public static void main(String[] args){
        System.out.println(peakIndexInMountainArray(new int[]{12,13,19,41,55,69,70,71,96,72}));
    }
    public static int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1;

        if (A[0] > A[1]) return 0;
        if (A[r] > A[r - 1]) return r;

        while (l < r) {
            int m = (l + r) >> 1;
            if (A[m - 1] > A[m]) {
                r = m - 1;
            } else if (A[m + 1] > A[m]) {
                l = m + 1;
            } else {
                l = m;
                break;
            }
        }

        return l;
    }
}
