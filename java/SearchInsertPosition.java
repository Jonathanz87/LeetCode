/*
	problem 35
	Given a sorted array and a target value,
	return the index if the target is found. 
	If not, return the index where it would be if it were inserted in order.
	You may assume no duplicates in the array.
	Here are few examples.
		[1,3,5,6], 5 → 2
		[1,3,5,6], 2 → 1
		[1,3,5,6], 7 → 4
		[1,3,5,6], 0 → 0
*/

public class SearchInsertPosition{
	static public void main(String[] args){
		int[] nums = {1,3,5,6};

		System.out.println(searchInsert(nums, 5));
		System.out.println(searchInsert(nums, 2));
		System.out.println(searchInsert(nums, 7));
		System.out.println(searchInsert(nums, 0));
	}

	static public int searchInsert(int[] nums, int target) {
		int fIndex = 0, bIndex = nums.length - 1;
		if(nums == null || nums.length == 0 || target <= nums[0]){
			return 0;
		}
		if(target > nums[bIndex]){
			return nums.length;
		}

		while(fIndex < bIndex){
			int mIndex = (fIndex + bIndex) / 2;
			if(target > nums[mIndex]){
				fIndex = mIndex + 1;
			}else{
				bIndex = mIndex;
			}
		}

		return fIndex;
	}

	static public int searchInsert2(int[] nums, int target) {
		if(nums == null || nums.length == 0 || target <= nums[0]){
			return 0;
		}
		if(target > nums[nums.length - 1]){
			return nums.length;
		}
		return searchInsert(nums, 0, nums.length - 1, target);
	}

	static public int searchInsert(int[] nums, int fIndex, int bIndex, int target){
		if(fIndex >= bIndex){
			if(target > nums[fIndex])
				return fIndex + 1;
			else
				return fIndex;
		}

		int mIndex = (bIndex + fIndex + 1) / 2 + fIndex;

		if(target < nums[mIndex]){
			return searchInsert(nums, fIndex, mIndex - 1, target);
		}
		else{
			return searchInsert(nums, mIndex, bIndex, target);
		}
	}
}