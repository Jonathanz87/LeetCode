/*
    973. K Closest Points to Origin
    We have a list of points on the plane.  
    Find the K closest points to the origin (0, 0).
    (Here, the distance between two points on a plane is the Euclidean distance.)
    You may return the answer in any order.  
    The answer is guaranteed to be unique (except for the order that it is in.)
    Example 1:
        Input: points = [[1,3],[-2,2]], K = 1
        Output: [[-2,2]]
        Explanation: 
        The distance between (1, 3) and the origin is sqrt(10).
        The distance between (-2, 2) and the origin is sqrt(8).
        Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
        We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
    Example 2:
        Input: points = [[3,3],[5,-1],[-2,4]], K = 2
        Output: [[3,3],[-2,4]]
        (The answer [[-2,4],[3,3]] would also be accepted.)
    Note:
        1 <= K <= points.length <= 10000
        -10000 < points[i][0] < 10000
        -10000 < points[i][1] < 10000
*/

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        quickSortKth(points, K);
        for (int i = 0; i < K; i++) {
            result[i] = points[i];
        }
        return result;
    }

    private static void quickSortKth(int[][] points, int K) {
        K--;
        int k = -1;
        int left = 0, right = points.length - 1;

        while (k != K) {
            int l, p;
            if (k < K) {
                l = k + 1;
                p = right;
            } else {
                l = left;
                p = k - 1;
            }
            int pValue = valueOf(points, p);
            for (int i = l; i < p; i++) {
                if (valueOf(points, i) <= pValue) {
                    swap(points, i, l);
                    l++;
                }
            }
            swap(points, p, l);
            k = l;
            if(k > K){
                right = k - 1;
            }else if(k < K){
                left = k + 1;
            }
        }
    }

    private static int valueOf(int[][] points, int p) {
        return points[p][0] * points[p][0] + points[p][1] * points[p][1];
    }

    private static void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}