/*	Given an array of integers, 
	return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, 
	and you may not use the same element twice.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
*/
import java.util.Arrays;

public class TwoSum{
	public static void main(String[] args){
		int[] nums = {3,2,4};
		int[] answer = twoSum(nums, 6);
		for(int i : answer){
			System.out.println(i);
		}
	}

	static public int[] twoSum(int[] nums, int target) {
		Arrays.sort(nums);

		for(int i = 0, j, len = nums.length; i < len; i++){
			System.out.println(i);
			if((j = Arrays.binarySearch(nums, target - nums[i])) != -1 && j != i){
				int[] result = {i, j};
				return result;
			}
		}
		return new int[0];
	}
}