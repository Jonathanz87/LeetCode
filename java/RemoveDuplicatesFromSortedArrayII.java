/*
	problem 80
	Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	For example,
	Given sorted array nums = [1,1,1,2,2,3],
	Your function should return length = 5, 
	with the first five elements of nums being 1, 1, 2, 2 and 3. 
	It doesn't matter what you leave beyond the new length.
*/

public class RemoveDuplicatesFromSortedArrayII{
	public static void main(String[] args){
		int len = args[0].length();
		int[] nums = new int[len];
		for(int i = 0; i < len; i++){
			nums[i] = args[0].charAt(i) - '0';
		}

		for(int i = 0, l = removeDuplicates(nums); i < l; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	public static int removeDuplicates(int[] nums) {
		int len = nums.length;
		if(len <= 2){
			return len;
		}
		boolean isDuplicatable = true;
		int index = 1;

		len--;
		for(int i = 0; i < len; i++){
			if(nums[i] == nums[i + 1]){
				if(isDuplicatable){
					nums[index++] = nums[i + 1];
					isDuplicatable = false;
				}
			}else{
				nums[index++] = nums[i + 1];
				isDuplicatable = true;
			}
		}
		return index;
	}
}