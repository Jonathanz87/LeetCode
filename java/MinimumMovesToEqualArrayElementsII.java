/*
	problem 462
	Given a non-empty integer array,
	find the minimum number of moves required to make all array elements equal,
	where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
	You may assume the array's length is at most 10,000.
	Example:
		Input: [1,2,3]
		Output: 2
		Explanation:
		Only two moves are needed (remember each move increments or decrements one element):
		[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
*/

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
	public static void main(String[] args) {
		int[] nums = new int[args.length];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(minMoves2(nums));
	}
	public static int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int targetIndex = nums.length / 2;
		int moves = 0;
		for (int i = targetIndex - 1; i >= 0; i--) {
			moves += nums[targetIndex] - nums[i];
		}

		for (int i = targetIndex + 1; i < nums.length; i++) {
			moves += nums[i] - nums[targetIndex];
		}

		return moves;
	}
}