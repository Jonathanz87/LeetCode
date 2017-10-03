/*
	Deque interview
	Give an array of umbers, return 2 numbers that has sum of a given number, or empty array if no valid answer,
	for example
		input = {1, 2, 3, 7, 10}, sum = 13, result: {3, 10}
		input = {4, 6, 8, 9}, sum = 23, result: {}
*/

/*
	Instead of 2 numbers, return n numbers that has sum of a given number
	example
		input = {1,2,3,4,5,7}, sum = 11, result = {1,2,3,5}
		input = {2,4,6,25}, sum = 25, result = {25}
		input = {2,4,-6,3,34}, sum = 1, result = {4, -6, 3}
	In the case of multiple solutions, only need to return the first one found.
*/

/*
	time O(n), use bitMapto reduse memery usage
*/
public class FindNumber {
	public static void main(String[] args) {
		int[] input = new int[args.length - 1];
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(args[i]);
		}

		int[] result = findNumbers(input, Integer.parseInt(args[args.length - 1]));
		System.out.println(result[0] + " " + result[1]);
	}

	public static int[] findNumbers(int[] input, int sum) {
		final int LONG_SIZE = 64, RANGE;
		final long[] BIT_MAP;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		for (int i = 0, len = input.length; i < len; i++) {
			if (input[i] > max) max = input[i];
			if (input[i] < min) min = input[i];
		}
		RANGE = max - min + 1;
		BIT_MAP = new long[(max - min) / LONG_SIZE + 1];

		for (int i = 0, len = input.length; i < len; i++) {
			int target = sum - input[i];
			int index = target - min;
			if (index < RANGE) {
				int mapIndex = index / LONG_SIZE;
				int bitIndex = index % LONG_SIZE;
				if (((BIT_MAP[mapIndex] >> bitIndex) & 1) == 1) {
					return new int[] {target, input[i]};
				}
			}
			long filter = 1 << ((input[i] - min) % LONG_SIZE);
			BIT_MAP[(input[i] - min) / LONG_SIZE] |= filter;
		}
		return new int[0];
	}


	// problem 2
	public static int[] findNumbers2(int[] input, int sum) {
		int[] result = findNumbersHelper(input, sum, 0);
		return result == null ? new int[0] : result;
	}

	public static int[] findNumbersHelper(int[] input, int sum, int startIndex) {
		if (startIndex >= input.length) return null;
		if (sum == 0) return new int[startIndex];

		int[] result = findNumbersHelper(input, sum - input[startIndex], startIndex + 1);
		if (result != null) {
			result[startIndex] = input[startIndex];
			return result;
		}

		for (int i = startIndex + 1; i < input.length; i++) {
			input[i] = input[i] ^ input[startIndex];
			input[startIndex] = input[i] ^ input[startIndex];
			input[i] = input[i] ^ input[startIndex];

			result = findNumbersHelper(input, sum - input[startIndex], startIndex + 1);
			if (result != null) {
				result[startIndex] = input[startIndex];
				return result;
			}

			input[i] = input[i] ^ input[startIndex];
			input[startIndex] = input[i] ^ input[startIndex];
			input[i] = input[i] ^ input[startIndex];
		}

		return null;
	}

}
