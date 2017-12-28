/*
	problem 373
	You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
	Define a pair (u,v) which consists of one element
	from the first array and one element from the second array.
	Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
	Example 1:
		Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
		Return: [1,2],[1,4],[1,6]
		The first 3 pairs are returned from the sequence:
		[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
	Example 2:
		Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
		Return: [1,1],[1,1]
		The first 2 pairs are returned from the sequence:
		[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
	Example 3:
		Given nums1 = [1,2], nums2 = [3],  k = 3
		Return: [1,3],[2,3]
		All possible pairs are returned from the sequence:
		[1,3],[2,3]
*/

/*
	solution
	example nums1 = {1,2,3,4,5} nums2 = {1,2,3,4,5}
	table 		1	2	3	4	5
			1	2	3	4	5	6			<-- init the first line into PriorityQueue
			2	3	4	5	6	7				for every pop out, add the one below it into queue
			3	4	5	6	7	8				right always bigger than left
			4	5	6	7	8	9				down always bigger than up
			5	6	7	8	9	10
*/

import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new LinkedList<>();

        if (nums1 == null || nums2 == null || nums1.length <= 0 || nums2.length <= 0 || k <= 0) {
            return result;
        }
        PriorityQueue<Pair> pQueue = new PriorityQueue<>();

        for (int i = 0, len = Math.min(k, nums2.length); i < len; i++) {
            pQueue.add(new Pair(0, i, nums1[0] + nums2[i]));
        }

        while (k > 0 && !pQueue.isEmpty()) {
            Pair pair = pQueue.poll();
            result.add(new int[] { nums1[pair.getX()], nums2[pair.getY()] });
            if (pair.getX() + 1 < nums1.length) {
                pQueue.add(new Pair(pair.getX() + 1, pair.getY(), nums1[pair.getX() + 1] + nums2[pair.getY()]));
            }
            k--;
        }

        return result;
    }

    private static class Pair implements Comparable<Pair> {
        private final int x;
        private final int y;
        private final int value;

        public Pair(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }
}