/*
	problem 179
	Given a list of non negative integers,
	arrange them such that they form the largest number.
	For example, given [3, 30, 34, 5, 9],
	the largest formed number is 9534330.
	Note: The result may be very large,
	so you need to return a string instead of an integer.
*/

/*
	weight of each number
	54565	6
	55555	4
	567		2
	535		7
	5		3
	598		1
	5533	5
	598567555555553354565535
*/

public class LargestNumber {
	public static void main(String[] args) {
		System.out.println(compare(args[0], args[1]));

		// int[] nums = new int[args.length];
		// for (int i = 0; i < nums.length; i++) {
		// 	nums[i] = Integer.parseInt(args[i]);
		// }
		// System.out.println(largestNumber(nums));
	}

	public static String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];

		for (int i = 0, len = strs.length; i < len; i++) {
			strs[i] = Integer.toString(nums[i]);
		}

		quickSort(strs, 0, strs.length - 1);

		if ("0".equals(strs[0])) return "0";

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			builder.append(strs[i]);
		}

		return builder.toString();
	}

	private static void quickSort(String[] strs, int fIndex, int bIndex) {
		if (fIndex >= bIndex) {
			return;
		}
		int swapIndex = fIndex;

		for (int i = fIndex; i < bIndex; i++) {
			if (compare(strs[i], strs[bIndex]) < 0) {
				String temp = strs[i];
				strs[i] = strs[swapIndex];
				strs[swapIndex++] = temp;
			}
		}
		String temp = strs[bIndex];
		strs[bIndex] = strs[swapIndex];
		strs[swapIndex] = temp;

		quickSort(strs, fIndex, swapIndex - 1);
		quickSort(strs, swapIndex + 1, bIndex);
	}

	private static int compare(String str1, String str2) {
		return (str2 + str1).compareTo(str1 + str2);
		// int i = 0;
		// for (int len = Math.min(str1.length(), str2.length()); i < len; i++) {
		// 	if (str1.charAt(i) > str2.charAt(i)) return 1;
		// 	if (str1.charAt(i) < str2.charAt(i)) return -1;
		// }

		// char c = str1.charAt(0);
		// while (i < str1.length()) {
		// 	if (str1.charAt(i) > c) return 1;
		// 	if (str1.charAt(i) < c) return -1;
		// 	i++;
		// }

		// while (i < str2.length()) {
		// 	if (str2.charAt(i) > c) return -1;
		// 	if (str2.charAt(i) < c) return 1;
		// 	i++;
		// }

		// return str2.length() - str1.length();
	}
}