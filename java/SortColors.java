/*
	problem 75
	Given an array with n objects colored red, white or blue,
	sort them so that objects of the same color are adjacent,
	with the colors in the order red, white and blue.
	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	Note:
	You are not suppose to use the library's sort function for this problem.
*/

public class SortColors{
	public static void main(String[] args){
		int[] nums = new int[args[0].length()];
		for(int i = 0, len = args[0].length(); i < len; i++){
			nums[i] = args[0].charAt(i) - '0';
		}
		sortColors(nums);

		for(int i : nums){
			System.out.print(i);
		}
		System.out.println();
	}

	public static void sortColors(int[] nums){
		int zeroCt = 0, oneCt = 0, twoCt = 0, index = 0;

		for(int i : nums){
			if(i == 0) zeroCt++;
			else if(i == 1) oneCt++;
			else if (i == 2) twoCt++;
		}

		for(int i = 0; i < zeroCt; nums[index++] = 0, i++);
		for(int i = 0; i < oneCt; nums[index++] = 1, i++);
		for(int i = 0; i < twoCt; nums[index++] = 2, i++);
	}
}