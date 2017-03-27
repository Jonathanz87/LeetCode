/*
	problem 46
	Given a collection of distinct numbers,
	return all possible permutations.

	For example,
	[1,2,3] have the following permutations:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutations{
	static public void main(String[] args){
		int[] nums = {1,2,3};
		System.out.println(permute(nums));
	}
	static public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> numList = new ArrayList<List<Integer>>();
		permute(numList, nums, 0, nums.length - 1);
		return numList;
	}

	static private void permute(List<List<Integer>> numList, int[] nums, int fIndex, int bIndex){
		if(fIndex == bIndex){
			List<Integer> list = new ArrayList<Integer>();
			for(int n : nums){
				list.add(n);
			}
			numList.add(list);
			return;
		}

		int i = fIndex + 1;
		permute(numList, nums, i, bIndex);
		while(i <= bIndex){
			nums[i] 		= nums[i] ^ nums[fIndex];
			nums[fIndex]	= nums[i] ^ nums[fIndex];
			nums[i]			= nums[i] ^ nums[fIndex];

			permute(numList, Arrays.copyOf(nums, nums.length), fIndex + 1, bIndex);

			nums[i]			= nums[i] ^ nums[fIndex];
			nums[fIndex]	= nums[i] ^ nums[fIndex];
			nums[i]			= nums[i] ^ nums[fIndex];
			i++;
		}
	}
}