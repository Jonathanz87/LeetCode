/*
	problem 896
	An array is monotonic if it is either monotone increasing or monotone decreasing.
	An array A is monotone increasing if for all i <= j, A[i] <= A[j].
	An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
	Return true if and only if the given array A is monotonic.
	Example 1:
		Input: [1,2,2,3]
		Output: true
	Example 2:
		Input: [6,5,4,4]
		Output: true
	Example 3:
		Input: [1,3,2]
		Output: false
	Example 4:
		Input: [1,2,4,5]
		Output: true
	Example 5:
		Input: [1,1,1]
		Output: true
	Note:
		1 <= A.length <= 50000
		-100000 <= A[i] <= 100000
*/

public class MonotonicArray {
	public static void main(String[] args) {
		int[] nums = new int[args.length];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(isMonotonic(nums));
	}

	public static boolean isMonotonic(int[] A) {
		if (A.length < 3) return true;

		boolean isIncreasing = A[A.length - 1] - A[0] > 0;

		for (int i = 1; i < A.length; i++) {
			int diff = A[i] - A[i - 1];
			if (diff != 0 && diff > 0 != isIncreasing) {
				return false;
			}
		}

		return true;
	}
}