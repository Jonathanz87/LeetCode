public class QuickSort {
	static public void main(String[] args) {
		int[] nums = {2, 4, 6, 8, 0, 9, 6, 7, 8, 7, 5, 3, 1};
		QuickSortk2(nums, 0, nums.length - 1);
		for (int i : nums) {
			System.out.print(i + " ");
		}

		double start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			int[] nums2 = {2, 4, 6, 8, 0, 9, 6, 7, 8, 7, 5, 3, 1};
			QuickSortk2(nums2, 0, nums.length - 1);
		}
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			int[] nums2 = {2, 4, 6, 8, 0, 9, 6, 7, 8, 7, 5, 3, 1};
			QuickSortk(nums2, 0, nums.length - 1);
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	static public void QuickSortk(final int[] arr, final int fIndex, final int bIndex) {
		if (fIndex < bIndex) {
			int p = arr[bIndex];
			int swapIndex = fIndex, trackIndex = fIndex;
			while (trackIndex < bIndex) {
				if (arr[trackIndex] < p) {
					int temp = arr[trackIndex];
					arr[trackIndex] = arr[swapIndex];
					arr[swapIndex++] = temp;
				}
				trackIndex++;
			}
			arr[bIndex] = arr[swapIndex];
			arr[swapIndex] = p;

			QuickSortk(arr, fIndex, swapIndex - 1);
			QuickSortk(arr, swapIndex + 1, bIndex);
		}
	}


	static public void QuickSortk2(final int[] arr, final int left, final int right) {
		if (left >= right) return;
		int leftIndex = left, rightIndex = right;
		int p = arr[(leftIndex + rightIndex) / 2];
		while (leftIndex <= rightIndex) {
			while (leftIndex <= rightIndex && arr[leftIndex] < p) {
				leftIndex++;
			}
			while (leftIndex <= rightIndex && arr[rightIndex] > p) {
				rightIndex--;
			}
			if (leftIndex <= rightIndex) {

				int temp = arr[leftIndex];
				arr[leftIndex] = arr[rightIndex];
				arr[rightIndex] = temp;
				// if (arr[leftIndex] != arr[rightIndex]) {
				// 	arr[leftIndex] = arr[leftIndex] ^ arr[rightIndex];
				// 	arr[rightIndex] = arr[leftIndex] ^ arr[rightIndex];
				// 	arr[leftIndex] = arr[leftIndex] ^ arr[rightIndex];
				// }
				leftIndex++;
				rightIndex--;
			}
		}
		QuickSortk2(arr, left, rightIndex);
		QuickSortk2(arr, leftIndex, right);
	}

}