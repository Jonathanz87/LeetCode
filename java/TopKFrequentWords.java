/*
	problem 692
	Given a non-empty list of words, return the k most frequent elements.
	Your answer should be sorted by frequency from highest to lowest. 
	If two words have the same frequency, then the word with the lower alphabetical order comes first.
	Example 1:
		Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
		Output: ["i", "love"]
		Explanation: "i" and "love" are the two most frequent words.
    	Note that "i" comes before "love" due to a lower alphabetical order.
	Example 2:
		Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
		Output: ["the", "is", "sunny", "day"]
		Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
		with the number of occurrence being 4, 3, 2 and 1 respectively.
	Note:
		You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
		Input words contain only lowercase letters.
		Follow up:
		Try to solve it in O(n log k) time and O(n) extra space.
*/

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> frequentmap = new HashMap<>();
		List<String> result = new LinkedList<>();
		int max = Integer.MIN_VALUE;

		for (String word : words) {
			Integer ct = frequentmap.getOrDefault(word, 0) + 1;
			frequentmap.put(word, ct);
			max = Math.max(ct, max);
		}

		List<String>[] bucket = new LinkedList[max + 1];

		for (Map.Entry<String, Integer> e : frequentmap.entrySet()) {
			Integer i = e.getValue();

			if (bucket[i] == null) {
				bucket[i] = new LinkedList<>();
			}

			bucket[i].add(e.getKey());
		}

		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != null) {
				Collections.sort(bucket[i]);
				for (String word : bucket[i]) {
					result.add(word);
					if (result.size() >= k) {
						return result;
					}
				}
			}
		}

		return result;

	}
}
