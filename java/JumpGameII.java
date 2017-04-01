/*
	problem 45
	Given an array of non-negative integers,
	you are initially positioned at the first index of the array.
	Each element in the array represents your maximum jump length at that position.
	Your goal is to reach the last index in the minimum number of jumps.
	For example:
		Given array A = [2,3,1,1,4]
		The minimum number of jumps to reach the last index is 2.
		(Jump 1 step from index 0 to 1,
		then 3 steps to the last index.)
*/


public class JumpGameII{
	public static void main(String[] args){
		int[] nums = new int[args[0].length()];

		for(int i = 0, len = args[0].length(); i < len; i++){
			nums[i] = args[0].charAt(i) - '0';
		}

		System.out.println(jumpGreedy(nums));
	}

	public static int jump(int[] nums){
		final int LAST_INDEX = nums.length - 1;
		nums[LAST_INDEX] = 0;
		for(int i = LAST_INDEX - 1; i >= 0; i--){
			int shortest = Integer.MAX_VALUE;
			for(int j = 1, len = nums[i]; i + j <= LAST_INDEX && j <= len ; j++){
				if(shortest > nums[i + j]){
					shortest = nums[i + j];
				}
			}
			if(shortest == Integer.MAX_VALUE)
				nums[i] = Integer.MAX_VALUE;
			else
				nums[i] = shortest + 1;
		}

		return nums[0];
	}

	public static int jumpGreedy(int[] nums){
		int jumps = 0, farthest = 0, end = 0;

		for(int i = 0; i < nums.length - 1; i++){
			farthest = Math.max(farthest, nums[i] + i);
			if(i == end){
				jumps++;
				end = farthest;
			}
		}
		return jumps;
	}
}