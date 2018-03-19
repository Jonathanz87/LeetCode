/*
	problem 334
	Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
	Formally the function should:
	Return true if there exists i, j, k
	such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
	Your algorithm should run in O(n) time complexity and O(1) space complexity.
	Examples:
		Given [1, 2, 3, 4, 5],
		return true.
		Given [5, 4, 3, 2, 1],
		return false.
*/

public class Increasing Triplet Subsequence {
    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }

        System.out.println(increasingTriplet(nums));
    }
    public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 2) {
            return false;
        }

        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;

        for(int num : nums) {
            if(num <= small) {
                small = num;
            } else if(num <= big) {
                big = num;
            } else {
                return true;
            }
        }
        return false;
    }
}