/*
	problem 506
	Given scores of N athletes,
	find their relative ranks and the people with the top three highest scores,
	who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
	Example 1:
		Input: [5, 4, 3, 2, 1]
		Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
	Explanation: The first three athletes got the top three highest scores,
	so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
	For the left two athletes,
	you just need to output their relative ranks according to their scores.
	Note:
		N is a positive integer and won't exceed 10,000.
		All the scores of athletes are guaranteed to be unique.
*/

public class RelativeRanks {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		for (String str : findRelativeRanks(nums)) {
			System.out.println(str);
		}
	}

	public static String[] findRelativeRanks(int[] nums) {
		int[] indexArray = new int[nums.length];
		String[] result = new String[nums.length];

		for (int i = 0; i < indexArray.length; i++) {
			indexArray[i] = i;
		}

		sort(nums, indexArray, 0, indexArray.length - 1);

		if (nums.length >= 1) {
			result[indexArray[0]] = "Gold Medal";
		}
		if (nums.length >= 2) {
			result[indexArray[1]] = "Silver Medal";
		}
		if (nums.length >= 3) {
			result[indexArray[2]] = "Bronze Medal";
		}

		for (int i = 3; i < nums.length; i++) {
			result[indexArray[i]] = Integer.toString(i + 1);
		}

		return result;
	}

	private static void sort(int[] valueArray, int[] indexArray, int leftIndex, int rightIndex) {
		if (rightIndex <= leftIndex) return;

		int swapIndex = leftIndex;
		for (int i = leftIndex; i < rightIndex; i++) {
			if (valueArray[indexArray[i]] > valueArray[indexArray[rightIndex]]) {
				int temp = indexArray[i];
				indexArray[i] = indexArray[swapIndex];
				indexArray[swapIndex] = temp;
				swapIndex++;
			}
		}
		int temp = indexArray[rightIndex];
		indexArray[rightIndex] = indexArray[swapIndex];
		indexArray[swapIndex] = temp;

		sort(valueArray, indexArray, leftIndex, swapIndex - 1);
		sort(valueArray, indexArray, swapIndex + 1, rightIndex);
	}
}