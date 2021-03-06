/*
	problem 274
	Given an array of citations (each citation is a non-negative integer) of a researcher,
	write a function to compute the researcher's h-index.
	According to the definition of h-index on Wikipedia:
	"A scientist has index h if h of his/her N papers have at least h citations each,
	and the other N − h papers have no more than h citations each."
	For example,
		given citations = [3, 0, 6, 1, 5],
		which means the researcher has 5 papers in total and
		each of them had received 3, 0, 6, 1, 5 citations respectively.
		Since the researcher has 3 papers with at least 3 citations each and
		the remaining two with no more than 3 citations each, his h-index is 3.
	Note: If there are several possible values for h,
	the maximum one is taken as the h-index.
*/

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		int[] citations = new int[args.length];

		for (int i = 0; i < citations.length; i++) {
			citations[i] = Integer.parseInt(args[i]);
		}

		System.out.println(hIndex(citations));
	}

	public static int hIndex(int[] citations) {
		int size = citations.length;
		if (size <= 0) return 0;
		Arrays.sort(citations);
		int leftIndex = 0, rightIndex = size - 1;

		while (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) >> 1;

			if ((size - mid) <= citations[mid]) {
				rightIndex = mid;
			} else {
				leftIndex = mid + 1;
			}
		}
		int hIndex = size - leftIndex;
		return hIndex <= citations[leftIndex] ? hIndex : 0;
	}

	/*
		solution
		get count for each number of citation and count of sum of all citations > than size
	*/

	public static int hIndex2(int[] citations) {
		int size = citations.length;
		int[] count = new int[size + 1];
		int sum = 0;

		for (int citation : citations) {
			if (citation >= size) {
				count[size]++;
			} else {
				count[citation]++;
			}
		}

		for (int i = size; i >= 0; i--) {
			sum += count[i];
			if (sum >= i)
				return i;
		}
		return 0;
	}
}