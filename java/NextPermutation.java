/*
	problem 31
	Implement next permutation,
	which rearranges numbers into the lexicographically next greater permutation of numbers.
	If such arrangement is not possible,
	it must rearrange it as the lowest possible order (ie, sorted in ascending order).
	The replacement must be in-place,
	do not allocate extra memory.
	Here are some examples.
	Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
		1,2,3 → 1,3,2
		3,2,1 → 1,2,3
		1,1,5 → 1,5,1
*/

public class NextPermutation{
	static public void main(String[] args){
		int[] nums = new int[args.length];

		for(int i = 0; i < args.length; i++){
			nums[i] = Integer.parseInt(args[i]);
		}

		for(int i : nums){
			System.out.print(i + " ");
		}
		System.out.println();

		nextPermutation(nums);

		for(int i : nums){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	static public void nextPermutation(int[] nums){
		if(nums.length <= 1) return;

		int pIndex = -1, swapIndex = -1;

		//find p
		for(int i = nums.length - 2; i >= 0; i--){
			if(nums[i] < nums[i + 1]){
				pIndex = i;
				break;
			}
		}

		if(pIndex == -1){
			reverse(nums, 0, nums.length - 1);
			return;
		}

		//find swap
		for(int i = nums.length - 1; i > pIndex; i--){
			if(nums[i] > nums[pIndex]){
				swapIndex = i;
				break;
			}
		}

		nums[pIndex] = nums[pIndex] ^ nums[swapIndex];
		nums[swapIndex] = nums[pIndex] ^ nums[swapIndex];
		nums[pIndex] = nums[pIndex] ^ nums[swapIndex];

		//reverse
		reverse(nums, pIndex + 1, nums.length - 1);
	}

	static public void reverse(int[] nums, int fIndex, int bIndex){
		while(fIndex < bIndex){
			nums[fIndex] = nums[fIndex] ^ nums[bIndex];
			nums[bIndex] = nums[fIndex] ^ nums[bIndex];
			nums[fIndex] = nums[fIndex] ^ nums[bIndex];
			fIndex++;
			bIndex--;
		}
	}
}