/*
    912. Sort an Array
    Given an array of integers nums, sort the array in ascending order.
    Example 1:
        Input: [5,2,3,1]
        Output: [1,2,3,5]
    Example 2:
        Input: [5,1,1,2,0,0]
        Output: [0,0,1,1,2,5]
    Note:
        1 <= A.length <= 10000
        -50000 <= A[i] <= 50000
*/

public class SortAnArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 1, 1, 2, 5 };
        for (int n : sortArray(nums)) {
            System.out.println(n);
        }
    }

    public static int[] sortArray(int[] nums) {
        int small = nums[0], large = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < small) {
                small = nums[i];
            } else if (nums[i] > large) {
                large = nums[i];
            }
        }

        int[] bucket = new int[large - small + 1];

        for (int n : nums) {
            bucket[n - small]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            int n = bucket[i];

            for (int j = 0; j < n; j++) {
                nums[index++] = i + small;
            }
        }

        return nums;
    }
}