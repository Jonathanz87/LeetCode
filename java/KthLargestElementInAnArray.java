/*
	problem 215
	Find the kth largest element in an unsorted array.
	Note that it is the kth largest element in the sorted order,
	not the kth distinct element.
	For example,
	Given [3,2,1,5,6,4] and k = 2, return 5.
*/

public class KthLargestElementInAnArray {
	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] {1, 2, 3, 5, 4}, 1));
	}

	public static int findKthLargest(int[] nums, int k) {
		quickSelect2(nums, k, 0, nums.length - 1);
		return nums[k - 1];
	}

	// O(n)
	public static int quickSelect(int[] nums, int target, int fIndex, int bIndex) {
		int s = fIndex;
		for (int i = fIndex; i < bIndex; i++) {
			if (nums[i] > nums[bIndex]) {
				if (nums[i] != nums[s]) {
					nums[i] = nums[i] ^ nums[s];
					nums[s] = nums[i] ^ nums[s];
					nums[i] = nums[i] ^ nums[s];
				}
				s++;
			}
		}
		if (nums[bIndex] != nums[s]) {
			nums[bIndex] = nums[bIndex] ^ nums[s];
			nums[s] = nums[bIndex] ^ nums[s];
			nums[bIndex] = nums[bIndex] ^ nums[s];
		}

		if ((s + 1) == target) return nums[s];

		if ((s + 1) < target) {
			return quickSelect(nums, target, s + 1, bIndex);
		} else {
			return quickSelect(nums, target, fIndex, s - 1);
		}
	}

	public static void quickSelect2(int[] nums, int target, int fIndex, int bIndex) {
		if(fIndex > bIndex) return;
		int leftIndex = fIndex, rightIndex = bIndex;
		int p = nums[(fIndex + bIndex) / 2];

		while (leftIndex <= rightIndex) {

			while (leftIndex <= rightIndex && nums[leftIndex] > p) {
				leftIndex++;
			}
			while (leftIndex <= rightIndex && nums[rightIndex] < p) {
				rightIndex--;
			}

			if (leftIndex <= rightIndex) {
				if (nums[leftIndex] != nums[rightIndex]) {
					nums[leftIndex] = nums[leftIndex] ^ nums[rightIndex];
					nums[rightIndex] = nums[leftIndex] ^ nums[rightIndex];
					nums[leftIndex] = nums[leftIndex] ^ nums[rightIndex];
				}
				leftIndex++;
				rightIndex--;
			}
		}

		if(target >= leftIndex + 1){
			quickSelect2(nums, target, leftIndex, bIndex);
		}else{
			quickSelect2(nums, target, fIndex, rightIndex);
		}
	}
}
