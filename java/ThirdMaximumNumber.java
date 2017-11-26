/*
	problem 414
	Given a non-empty array of integers,
	return the third maximum number in this array.
	If it does not exist, return the maximum number.
	The time complexity must be in O(n).
	Example 1:
		Input: [3, 2, 1]
		Output: 1
		Explanation: The third maximum is 1.
	Example 2:
		Input: [1, 2]
		Output: 2
		Explanation: The third maximum does not exist,
		so the maximum (2) is returned instead.
	Example 3:
		Input: [2, 2, 3, 1]
		Output: 1
		Explanation: Note that the third maximum here means
		the third maximum distinct number.
		Both numbers with value 2 are both considered as second maximum.
*/

public class ThirdMaximumNumber {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(thirdMax(nums));
	}
	public int thirdMax2(int[] nums) {
		long first = Long.MIN_VALUE;
		long second = Long.MIN_VALUE;
		long third = Long.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > first) {
				third = second;
				second = first;
				first = nums[i];
			} else if (nums[i] > second && nums[i] < first) {
				third = second;
				second = nums[i];
			} else if ( nums[i] > third && nums[i] < second) {
				third = nums[i];
			}
		}
		return third == Long.MIN_VALUE ? (int)first : (int)third;
	}

	public static int thirdMax(int[] nums) {
		int[] maxNums = new int[3];
		int count = 1;
		int index = 1;
		maxNums[0] = nums[0];
		maxNums[1] = Integer.MIN_VALUE;
		maxNums[2] = Integer.MIN_VALUE;

		while (index < nums.length && count < 3) {
			if (maxNums[0] == nums[index] || (count >= 2 && maxNums[1] == nums[index])) {
				index++;
				continue;
			}
			if (count <= 1) {
				if (maxNums[0] < nums[index]) {
					maxNums[1] = maxNums[0];
					maxNums[0] = nums[index];
				} else {
					maxNums[1] = nums[index];
				}
			} else {
				if (maxNums[0] < nums[index]) {
					maxNums[2] = maxNums[1];
					maxNums[1] = maxNums[0];
					maxNums[0] = nums[index];
				} else if (maxNums[1] < nums[index]) {
					maxNums[2] = maxNums[1];
					maxNums[1] = nums[index];
				} else {
					maxNums[2] = nums[index];
				}
			}
			count++;
			index++;
		}

		while (index < nums.length ) {
			if (maxNums[0] == nums[index] || maxNums[1] == nums[index] || maxNums[2] == nums[index]) {
				index++;
				continue;
			}
			if (maxNums[0] < nums[index]) {
				maxNums[2] = maxNums[1];
				maxNums[1] = maxNums[0];
				maxNums[0] = nums[index];
			} else if (maxNums[1] < nums[index]) {
				maxNums[2] = maxNums[1];
				maxNums[1] = nums[index];
			} else if (maxNums[2] < nums[index]) {
				maxNums[2] = nums[index];
			}
			index++;
		}


		return count >= 3 ? Math.min(Math.min(maxNums[0], maxNums[1]), maxNums[2])
		       : maxNums[0];
	}
}