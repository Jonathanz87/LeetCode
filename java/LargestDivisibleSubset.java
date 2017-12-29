/*
	problem 368
	Given a set of distinct positive integers,
	find the largest subset such that every pair (Si, Sj) of elements
	in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
	If there are multiple solutions, return any subset is fine.
	Example 1:
		nums: [1,2,3]
		Result: [1,2] (of course, [1,3] will also be ok)
	Example 2:
		nums: [1,2,4,8]
		Result: [1,2,4,8]
*/

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> resultList = new LinkedList<>();
        if (nums == null || nums.length <= 0) return resultList;
        Arrays.sort(nums);
        final int LEN = nums.length;
        int[] degreeArray = new int[LEN];
        int[] indexArray = new int[LEN];
        int maxDegree = 0;
        int maxIndex = 0;

        for (int i = 0; i < LEN; i++) {
            int index = i;
            int degree = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (degree < degreeArray[j]) {
                        degree = degreeArray[j];
                        index = j;
                    }
                }
            }
            degree++;
            degreeArray[i] = degree;
            indexArray[i] = index;

            if (degree > maxDegree) {
                maxDegree = degree;
                maxIndex = i;
            }
        }

        for (int count = maxDegree; count > 0; count--) {
            resultList.add(0, nums[maxIndex]);
            maxIndex = indexArray[maxIndex];
        }

        return resultList;
    }
}