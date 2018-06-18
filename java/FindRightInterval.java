/*
    problem 436
    Given a set of intervals, for each of the interval i,
    check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i,
    which can be called that j is on the "right" of i.
    For any interval i, you need to store the minimum interval j's index,
    which means that the interval j has the minimum start point to build the "right" relationship for interval i.
    If the interval j doesn't exist, store -1 for the interval i. Finally,
    you need output the stored value of each interval as an array.
    Note:
    You may assume the interval's end point is always bigger than its start point.
    You may assume none of these intervals have the same start point.
    Example 1:
        Input: [ [1,2] ]
        Output: [-1]
        Explanation: There is only one interval in the collection, so it outputs -1.
    Example 2:
        Input: [ [3,4], [2,3], [1,2] ]
        Output: [-1, 0, 1]
        Explanation: There is no satisfied "right" interval for [3,4].
        For [2,3], the interval [3,4] has minimum-"right" start point;
        For [1,2], the interval [2,3] has minimum-"right" start point.
    Example 3:
        Input: [ [1,4], [2,3], [3,4] ]
        Output: [-1, 2, -1]
        Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
        For [2,3], the interval [3,4] has minimum-"right" start point.
 */


import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
    // Definition for an interval.
    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args){
        Interval[] intervals = new Interval[]{new Interval(1,4), new Interval(2,3), new Interval(3, 4)};
        for(int i : findRightInterval(intervals)){
            System.out.println(i);
        }
    }

    public static int[] findRightInterval(Interval[] intervals) {
        int[][] startIndexArray = new int[intervals.length][2];
        int[] result = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startIndexArray[i][0] = intervals[i].start;
            startIndexArray[i][1] = i;
        }

        Arrays.sort(startIndexArray, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < result.length; i++){
            result[i] = findGreatOrEqual(startIndexArray, intervals[i].end);
        }

        return result;
    }

    private static int findGreatOrEqual(int[][] startIndexArray, int targetStart) {
        int l = 0, r = startIndexArray.length - 1;

        while (l < r) {
            int m = (l + r) >> 1;

            if(startIndexArray[m][0] >= targetStart){
                r = m;
            }else{
                l = m + 1;
            }
        }

        return targetStart > startIndexArray[l][0] ? -1 : startIndexArray[l][1];
    }


}
