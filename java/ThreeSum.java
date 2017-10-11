/*
	Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
	Find all unique triplets in the array which gives the sum of zero.
	Note: The solution set must not contain duplicate triplets.
	For example, 
		given array S = [-1, 0, 1, 2, -1, -4],
		A solution set is:
		[
			[-1, 0, 1],
			[-1, -1, 2]
		]
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class ThreeSum {
	public static void main(String[] args){
		int[] nums = new int[args.length];

		for(int i = 0; i < args.length; i++){
			nums[i] = Integer.parseInt(args[i]);
		}
		List<List<Integer>> resultList = threeSum(nums);

		for(List<Integer> result : resultList){
			for(Integer i : result){
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		Arrays.sort(nums);
		for(int i = 0, len = nums.length - 2; i < len; i++){
			if(i > 0 && nums[i] == nums[i - 1]){
				continue;
			}

			int j = i + 1, k = nums.length - 1;
			int target = -nums[i];
			while(j < k){
				int sum = nums[j] + nums[k];
				if(sum == target){
					List<Integer> temp = new LinkedList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					result.add(temp);
					j++;
					k--;
					while(j < k && nums[j] == nums[j - 1]) j++;
					while(j < k && nums[k] == nums[k + 1]) k--;
				}else if(sum > target){
					k--;
					while(j < k && nums[k] == nums[k + 1]) k--;
				}else{
					j++;
					while(j < k && nums[j] == nums[j - 1]) j++;
				}
			}
		}
		return result;
	}
}