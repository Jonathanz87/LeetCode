/*
	problem 136
	Given an array of integers, 
	every element appears twice except for one. 
	Find that single one.
	Your algorithm should have a linear runtime complexity.
	Could you implement it without using extra memory?
*/

public class SingleNumber{
	public static void main(String[] args){
		int[] nums = new int[args.length];
		for(int i = 0; i < nums.length; i++){
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		int num = 0;
		for(int i = 0, len = nums.length; i < len; i++){
			num ^= nums[i];
		}

		return num;
	}
}