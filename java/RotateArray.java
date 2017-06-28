/*
	problem 189
	Rotate an array of n elements to the right by k steps.
	For example, with n = 7 and k = 3, 
	the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	Note:
	try to come up as many solutions as you can, 
	there are at least 3 different ways to solve this problem.
*/


public class RotateArray{
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		rotate(nums, 3);
		for(int i : nums){
			System.out.print(i + " ");
		}
	}
	public static void rotate(int[] nums, int k) {
		final int SIZE = nums.length;
		int temp;
		boolean[] isMoved = new boolean[SIZE];
		k = k % SIZE;

		for(int i = 0; i < SIZE; i++){
			temp = nums[i];
			while(!isMoved[i]){
				isMoved[i] = true;
				i = (i + k) % SIZE;

				nums[i] = nums[i] ^ temp;
				temp = nums[i] ^ temp;
				nums[i] = nums[i] ^ temp;
			}
		}
	}
}