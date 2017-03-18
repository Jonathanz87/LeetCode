/*
	problem 33
	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	You are given a target value to search.
	If found in the array return its index, otherwise return -1.
	You may assume no duplicate exists in the array.
*/

public class SearchinRotatedSortedArray{
	static public void main(String[] args){
		int length = args.length - 1;
		int[] nums = new int[length];
		for(int i = 0; i < length; i++){
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(search(nums, Integer.parseInt(args[length])));
	}

	static public int search(int[] nums, int target){
		if(nums == null || nums.length <= 0) return -1;
		int fIndex = 0, lastIndex = nums.length - 1;
		int lastElement = nums[lastIndex];
		boolean inFirstPart = target > lastElement;

		while(fIndex < lastIndex){
			int mIndex = (fIndex + lastIndex) / 2;

			if(nums[mIndex] > lastElement == inFirstPart){
				if(target > nums[mIndex]){
					fIndex = mIndex + 1;
				}else{
					lastIndex = mIndex;
				}
			}else if(inFirstPart){
				lastIndex = mIndex - 1;
			}else{
				fIndex = mIndex + 1;
			}
		}
		return nums[fIndex] == target ? fIndex : -1;
	}
}