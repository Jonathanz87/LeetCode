/*
	problem 377
	Given an integer array with all positive numbers and no duplicates,
	find the number of possible combinations that add up to a positive integer target.
	Example:
		nums = [1, 2, 3]
		target = 4
		The possible combination ways are:
		(1, 1, 1, 1)
		(1, 1, 2)
		(1, 2, 1)
		(1, 3)
		(2, 1, 1)
		(2, 2)
		(3, 1)
		Note that different sequences are counted as different combinations.
		Therefore the output is 7.
*/

import java.util.Arrays;

public class CombinationSumIV {
	public int combinationSum4(int[] nums, int target) {

	}

	public int combinationSum4(int[] nums, int targer, int index) {
		if(targer == 0){
			return 1;
		}
		if(targer < 0){
			return 0;
		}

		
	}
}