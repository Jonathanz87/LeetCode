/*
	problem 739
	Given a list of daily temperatures, produce a list that, for each day in the input,
	tells you how many days you would have to wait until a warmer temperature.
	If there is no future day for which this is possible, put 0 instead.
	For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73],
	your output should be [1, 1, 4, 2, 1, 1, 0, 0].
	Note: The length of temperatures will be in the range [1, 30000].
	Each temperature will be an integer in the range [30, 100].
*/

public class DailyTemperatures {
	public static void main(String[] args) {
		IntStream
		.of(dailyTemperatures(Stream.of(args).mapToInt(s -> Integer.parseInt(s)).toArray()))
		.forEach(System.out::println);
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		int[] result = new int[temperatures.length];
		int[] stack = new int[temperatures.length];
		int stackIndex = -1;

		for (int i = temperatures.length - 1; i >= 0; i--) {
			int days = 0;
			while (stackIndex >= 0 && temperatures[stack[stackIndex]] <= temperatures[i]) {
				stackIndex--;
			}
			if (stackIndex >= 0) {
				days = stack[stackIndex] - i;
			}
			stack[++stackIndex] = i;
			result[i] = days;
		}
		return result;
	}
}
