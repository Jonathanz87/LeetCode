/*
	problem 350
	Given two arrays, write a function to compute their intersection.
	Example:
		Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	Note:
		Each element in the result should appear as many times as it shows in both arrays.
		The result can be in any order.
	Follow up:
		What if the given array is already sorted?
		How would you optimize your algorithm?
		What if nums1's size is small compared to nums2's size?
		Which algorithm is better?
		What if elements of nums2 are stored on disk,
		and the memory is limited such that you cannot load all elements into the memory at once?
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] small = null, large = null;
        if(nums1.length < nums2.length) {
            small = nums1;
            large = nums2;
        } else {
            small = nums2;
            large = nums1;
        }

        Map<Integer, Integer> numMap = new HashMap<>();
        List<Integer> resultList = new LinkedList<>();
        int[] result = null;
        for(int n : small) {
            if(numMap.containsKey(n)) {
                numMap.put(n, numMap.get(n) + 1);
            } else {
                numMap.put(n, 1);
            }
        }

        for(int n : large) {
            if(numMap.containsKey(n) && numMap.get(n) > 0) {
                numMap.put(n, numMap.get(n) - 1);
                resultList.add(n);
            }
        }

        result = new int[resultList.size()];

        for(int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}