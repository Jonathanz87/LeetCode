/*
	problem 384
	// Init an array with set 1, 2, and 3.
	int[] nums = {1,2,3};
	Solution solution = new Solution(nums);

	// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
	solution.shuffle();

	// Resets the array back to its original configuration [1,2,3].
	solution.reset();

	// Returns the random shuffling of array [1,2,3].
	solution.shuffle();
*/

public class ShuffleAnArray {
	private int[] nums;

	public ShuffleAnArray(int[] nums) {
		this.nums = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return this.nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int size = nums.length;
		int[] copy = new int[size];
		for (int i = 0; i < size; i++) {
			copy[i] = nums[i];
		}

		for (int i = 0; i < size; i++) {
			int j = (int)(Math.random() * size);
			if (i != j) {
				copy[i] = copy[i] ^ copy[j];
				copy[j] = copy[i] ^ copy[j];
				copy[i] = copy[i] ^ copy[j];
			}
		}

		return copy;
	}
}
