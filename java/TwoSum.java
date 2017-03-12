/*	
	problem 1
	Given an array of integers, 
	return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, 
	and you may not use the same element twice.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
*/
import java.util.Map;
import java.util.HashMap;

public class TwoSum{
	public static void main(String[] args){
		int[] nums = {3,2,4};
		int[] answer = twoSum(nums, 6);
		for(int i : answer){
			System.out.println(i);
		}
	}

	static public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);

		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target - nums[i])){
				int[] result = {map.get(target - nums[i]), i};
				return result;
			}
			map.put(nums[i], i);
		}


		int[] result = {0, 0};
		return result;
	}

/*	static public int[] twoSum(int[] nums, int target) {
		for(int i = 0, len = nums.length - 1; i < len; i++){
			int difference = target - nums[i];
			for(int j = i + 1; j < nums.length; j++){
				if(nums[j] == difference){
					int[] result = {i, j};
					return result;
				}
			}
		}

		int[] result = {0, 0};
		return result;
	}*/
}