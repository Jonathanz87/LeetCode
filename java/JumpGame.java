/*
	problem 55
	Given an array of non-negative integers,
	you are initially positioned at the first index of the array.
	Each element in the array represents your maximum jump length at that position.
	Determine if you are able to reach the last index.
	For example:
		A = [2,3,1,1,4], return true.
		A = [3,2,1,0,4], return false.
*/

public class JumpGame{
	public static void main(String[] args){
		int[] nums = new int[args[0].length()];

		for(int i = 0, len = args[0].length(); i < len; i++){
			nums[i] = args[0].charAt(i) - '0';
		}

		System.out.println(canJump(nums));
	}

	public static boolean canJump(int[] nums){
		final int FINAL_INDEX = nums.length - 1;
		int lastReachableIndex = FINAL_INDEX;

		for(int i = nums.length - 2; i >= 0; i--){
			if(nums[i] + i >= lastReachableIndex){
				lastReachableIndex = i;
			}
		}

		return lastReachableIndex == 0 ? true : false;
	}

	public static boolean canJump2(int[] nums){
	    int reachable = 0;
    	for (int i=0; i<nums.length; ++i) {
        	if (i > reachable) return false;
        	reachable = Math.max(reachable, i + nums[i]);
    	}
    	return true;
    }
}