/*
	problem 347
	Given a non-empty array of integers, return the k most frequent elements.
	For example,
		Given [1,1,1,2,2,3] and k = 2, return [1,2].
	Note:
		You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
		Your algorithm's time complexity must be better than O(n log n),
		where n is the array's size.
*/


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class TopKFrequentElements {
	public static void main(String[] args) {
		int[] nums = new int[args.length - 1];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		System.out.println(topKFrequent(nums, Integer.parseInt(args[args.length - 1])));
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequentMap = new HashMap<>();
		List<Integer> result = new LinkedList<>();

		int max = Integer.MIN_VALUE;

		for (int n : nums) {
			Integer ct = frequentMap.getOrDefault(n, 0) + 1;
			frequentMap.put(n, ct);
			max = Math.max(ct, max);
		}

		List<Integer>[] bucket = new LinkedList[max + 1];

		for (Map.Entry<Integer, Integer> e : frequentMap.entrySet()) {
			Integer i = e.getValue();
			if (bucket[i] == null) {
				bucket[i] = new LinkedList<>();
			}
			bucket[i].add(e.getKey());
		}

		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != null) {
				for (int j = 0, len = bucket[i].size(); k > 0 && j < len; j++) {
					result.add(bucket[i].get(j));
					k--;
				}
			}
		}

		return result;
	}
}
