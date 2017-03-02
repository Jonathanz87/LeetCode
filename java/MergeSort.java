public class MergeSort{
	public static void main(String[] args){
		int[] nums = {2,4,6,8,0,9,7,6,4,3,1,3,6,8};
		nums = MergeSort(nums, 0, nums.length - 1);

		for(int i : nums){
			System.out.print(i + " ");
		}
	}

	public static int[] MergeSort(final int[] arr, final int fIndex, final int bIndex){
		final int size = bIndex - fIndex + 1;
		if(size <= 1){
			int[] temp = new int[size];
			for(int i = 0; i < size; i++){
				temp[i] = arr[fIndex + i];
			}
			return temp;
		}
		int midIndex = fIndex + (size - 1) / 2;

		int[] a1 = MergeSort(arr, fIndex, midIndex);
		int[] a2 = MergeSort(arr, midIndex + 1, bIndex);
		int[] temp = new int[a1.length + a2.length];
		int a1Index = 0, a2Index = 0, tempIndex = 0;

		while(a1Index < a1.length && a2Index < a2.length){
			if(a1[a1Index] < a2[a2Index]){
				temp[tempIndex++] = a1[a1Index++];
			}else{
				temp[tempIndex++] = a2[a2Index++];
			}
		}

		while(a1Index < a1.length){
			temp[tempIndex++] = a1[a1Index++];
		}
		while(a2Index < a2.length){
			temp[tempIndex++] = a2[a2Index++];
		}

		return temp;

	}

}