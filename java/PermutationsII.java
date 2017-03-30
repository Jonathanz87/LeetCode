/*
	problem 47
	Given a collection of numbers that might contain duplicates,
	return all possible unique permutations.
	For example,
	[1,1,2] have the following unique permutations:
		[
			[1,1,2],
			[1,2,1],
			[2,1,1]
		]
*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PermutationsII{
	static public void main(String[] args){
		int[] nums = new int[args[0].length()];
		for(int i = 0, len = nums.length; i < len; i++){
			nums[i] = args[0].charAt(i) - '0';
		}
		System.out.println(permuteUnique(nums));
	}

	static public List<List<Integer>> permuteUnique(int[] nums){
		if(nums.length <= 0)
			return new ArrayList<List<Integer>>();

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		do{
			result.add(intToList(nums));
		}while((nums = next(nums)) != null);

		return result;
	}

	static private List<Integer> intToList(int[] nums){
		List<Integer> list = new ArrayList<Integer>();
		for(int i : nums){
			list.add(i);
		}
		return list;
	}

	static private int[] next(int[] nums){
		if(nums.length <= 1){
			return null;
		}
		int pIndex = -1, swapIndex;
		for(int i = nums.length - 2; i >= 0; i--){
			if(nums[i] < nums[i + 1]){
				pIndex = i;
				break;
			}
		}

		if(pIndex == -1){
			return null;
		}

		swapIndex = nums.length - 1;
		while(swapIndex > pIndex){
			if(nums[swapIndex] > nums[pIndex]){
				break;
			}
			swapIndex--;
		}

		nums[pIndex]	= nums[pIndex] ^ nums[swapIndex];
		nums[swapIndex]	= nums[pIndex] ^ nums[swapIndex];
		nums[pIndex]	= nums[pIndex] ^ nums[swapIndex];

		int fIndex = pIndex + 1, bIndex = nums.length - 1;

		while(fIndex < bIndex){
			nums[fIndex] = nums[fIndex] ^ nums[bIndex];
			nums[bIndex] = nums[fIndex] ^ nums[bIndex];
			nums[fIndex] = nums[fIndex] ^ nums[bIndex];
			fIndex++;
			bIndex--;
		}

		return nums;
	}
}