import java.util.LinkedList;

/*
    934. Shortest Bridge
    In a given 2D binary array A, there are two islands.
    (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
    Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
    Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
    Example 1:
        Input: [[0,1],[1,0]]
        Output: 1
    Example 2:
        Input: [[0,1,0],[0,0,0],[0,0,1]]
        Output: 2
    Example 3:
        Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
        Output: 1
    Note:
        1 <= A.length = A[0].length <= 100
        A[i][j] == 0 or A[i][j] == 1
 */

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] A = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 } };
        System.out.println(shortestBridge(A));
    }

    public static int shortestBridge(int[][] A) {
        if(A.length == 1) throw new RuntimeException(); 
        LinkedList<int[]> edgeQueue = new LinkedList<>();

        outerloop: for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i][j] == 1) {
                    getEdgesIsland(A, i, j, edgeQueue);
                    break outerloop;
                }
            }
        }

        int shortest = buildBrige(A, edgeQueue);

        return shortest - 2;
    }

    private static int buildBrige(int[][] A, LinkedList<int[]> edgeQueue) {
        int shortest = Integer.MAX_VALUE;

        while (!edgeQueue.isEmpty()) {
            int[] coordinate = edgeQueue.pop();
            int x = coordinate[0];
            int y = coordinate[1];
            int steps = A[x][y];
            if (isLanded(A, x + 1, y, steps + 1, edgeQueue)) {
                shortest = Math.min(shortest, steps);
            }

            if (isLanded(A, x - 1, y, steps + 1, edgeQueue)) {
                shortest = Math.min(shortest, steps);
            }

            if (isLanded(A, x, y + 1, steps + 1, edgeQueue)) {
                shortest = Math.min(shortest, steps);
            }

            if (isLanded(A, x, y - 1, steps + 1, edgeQueue)) {
                shortest = Math.min(shortest, steps);
            }
        }
        return shortest;
    }

    private static boolean isLanded(int[][] A, int x, int y, int steps, LinkedList<int[]> edgeQueue) {
        System.out.println("x " + x + " y " + y + " steps " + steps);
        if (x < 0 || x >= A.length || y < 0 || y >= A.length || A[x][y] == 2) {
            return false;
        }

        System.out.println(" v " + A[x][y]);

        if (A[x][y] == 1) {
            return true;
        }

        if (steps < A[x][y] || A[x][y] == 0) {
            edgeQueue.add(new int[] { x, y });
            A[x][y] = steps;
            System.out.println("called");
        }
        return false;

    }

    private static int getEdgesIsland(int[][] A, int x, int y, LinkedList<int[]> edgeQueue) {
        if (x < 0 || x >= A.length || y < 0 || y >= A.length) {
            return 2;
        }

        if (A[x][y] != 1) {
            return A[x][y];
        }

        A[x][y] = 2;

        if (getEdgesIsland(A, x + 1, y, edgeQueue) == 0 | getEdgesIsland(A, x - 1, y, edgeQueue) == 0
                | getEdgesIsland(A, x, y + 1, edgeQueue) == 0 | getEdgesIsland(A, x, y - 1, edgeQueue) == 0) {
            edgeQueue.add(new int[] { x, y });
        }
        return 2;
    }

}
