public class QuickSort{
	static public void main(String[] args){
		int[] nums = {2,4,6,8,0,9,6,7,8,7,5,3,1};
		QuickSortk(nums, 0, nums.length - 1);
		for(int i : nums){
			System.out.print(i + " ");
		}
	}

	static public void QuickSortk(final int[] arr, final int fIndex, final int bIndex){
		if(fIndex < bIndex){
			int p = arr[bIndex];
			int swapIndex = fIndex, trackIndex = fIndex;
			while(trackIndex < bIndex){
				if(arr[trackIndex] < p){
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

	String[] strs


	strs[0].compareTo(strs[1])
}