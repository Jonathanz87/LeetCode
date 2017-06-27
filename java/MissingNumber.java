/*
	problem 268
	Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
	find the one that is missing from the array.
	For example,
	Given nums = [0, 1, 3] return 2.
	Note:
	Your algorithm should run in linear runtime complexity. 
	Could you implement it using only constant extra space complexity?
*/

public class MissingNumber{
	public static void main(String[] args){
		final int SIZE = 10000000;
		final int MISS = Integer.parseInt(args[0]);
		int[] nums = new int[SIZE];
		int i = 0;
		for(int n = 0; n <= SIZE; n++){
			if(n != MISS){
				nums[i++] = n;
			}
		}
		long start = System.nanoTime();
		System.out.println(missingNumber(nums) + " Time: " + (System.nanoTime() - start));

		start = System.nanoTime();
		System.out.println(missingNumber2(nums) + " Time: " + (System.nanoTime() - start));

		start = System.nanoTime();
		System.out.println(missingNumber3(nums) + " Time: " + (System.nanoTime() - start));
	}

	public static int missingNumber(int[] nums) {
		for(int i  = 0, len = nums.length + 1; i < len; i++){
			if(i != nums[i]) return i;
		}
		return -1;
	}

	public static int missingNumber2(int[] nums) {
		int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}

		return xor ^ i;
	}

	public static int missingNumber3(int[] nums){
		if(nums.length - 1 == nums[nums.length - 1]){
			return nums.length + 1;
		}
		int fIndex = 0, bIndex = nums.length - 1;
		while(fIndex < bIndex){
			int mIndex = (fIndex + bIndex) / 2;
			if(mIndex == nums[mIndex]){
				fIndex = mIndex + 1;
			}else{
				bIndex = mIndex;
			}
		}
		return fIndex;
	}
}
