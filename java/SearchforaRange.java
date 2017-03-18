/*
	problem 34
	Given an array of integers sorted in ascending order,
	find the starting and ending position of a given target value.
	Your algorithm's runtime complexity must be in the order of O(log n).
	If the target is not found in the array, return [-1, -1].
	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
*/

public class SearchforaRange{
	static public void main(String[] args){
		int length = args.length - 1;
		int[] nums = new int[length];
		for(int i = 0; i < length; i++){
			nums[i] = Integer.parseInt(args[i]);
		}

		nums = searchRange(nums, Integer.parseInt(args[length]));
		System.out.println("[" + nums[0] + "," + nums[1] + "]");
	}

	static public int[] searchRange(int[] nums, int target) {
		int[] range = {-1, -1};
		if(nums.length <= 0) return range;

		int fIndex = 0, bIndex = nums.length - 1;

		while(fIndex < bIndex){
			int mIndex = (fIndex + bIndex) / 2;
			if(target > nums[mIndex]){
				fIndex = mIndex + 1;
			}else{
				bIndex = mIndex;
			}
		}
		if(nums[fIndex] != target){
			return range;
		}
		range[0] = fIndex;
		bIndex = nums.length - 1;

		while(fIndex < bIndex){
			int mIndex = (fIndex + bIndex) / 2 + 1;
			if(target < nums[mIndex]){
				bIndex = mIndex - 1;
			}else{
				fIndex = mIndex;
			}
		}

		range[1] = fIndex;
		return range;
	}
}