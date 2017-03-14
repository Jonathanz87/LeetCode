/*
	problem 27
	Given an array and a value,
	remove all instances of that value in place and return the new length.
	Do not allocate extra space for another array,
	you must do this in place with constant memory.
	The order of elements can be changed.
	It doesn't matter what you leave beyond the new length.

	Example:
	Given input array nums = [3,2,2,3], val = 3
	Your function should return length = 2,
	with the first two elements of nums being 2.
*/

public class RemoveElement{
	static public void main(String[] args){
		int[] nums = new int[args.length - 1];
		for(int i = 0; i < nums.length; i++){
			nums[i] = Integer.parseInt(args[i]);
		}

		int size = removeElement2(nums, Integer.parseInt(args[args.length - 1]));

		for(int i = 0; i < size; i++){
			System.out.print(nums[i] + " ");
		}

		System.out.println();
	}

	static public int removeElement(int[] nums, int val) {
		int index = 0;

		for(int n : nums){
			if(n != val){
				nums[index++] = n;
			}
		}

		return index;
	}
	static public int removeElement2(int[] nums, int val) {
		if(nums.length <= 0) return 0;

		int i = 0;
		int bIndex = nums.length - 1;

		while(i <= bIndex){
			if(nums[i] == val){
				nums[i] = nums[bIndex--];
			}else{
				i++;
			}
		}

		return bIndex + 1;
	}
}