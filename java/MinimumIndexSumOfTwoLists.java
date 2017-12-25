/*
	problem 599
	Suppose Andy and Doris want to choose a restaurant for dinner,
	and they both have a list of favorite restaurants represented by strings.
	You need to help them find out their common interest with the least list index sum.
	If there is a choice tie between answers,
	output all of them with no order requirement.
	You could assume there always exists an answer.
	Example 1:
		Input:
		["Shogun", "Tapioca Express", "Burger King", "KFC"]
		["Piatti", "The Grill at Torrey Pines",
		"Hungry Hunter Steakhouse", "Shogun"]
		Output: ["Shogun"]
		Explanation: The only restaurant they both like is "Shogun".
	Example 2:
		Input:
		["Shogun", "Tapioca Express", "Burger King", "KFC"]
		["KFC", "Shogun", "Burger King"]
		Output: ["Shogun"]
		Explanation: The restaurant they both like and
		have the least index sum is "Shogun" with index sum 1 (0+1).
	Note:
		The length of both lists will be in the range of [1, 1000].
		The length of strings in both lists will be in the range of [1, 30].
		The index is starting from 0 to the list length minus 1.
		No duplicates in both lists.
*/

import java.util.Map;
import java.util.HashMap;

public class MinimumIndexSumOfTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
		String[] longerList;
		String[] shortList;
		int minimumSum = Integer.MAX_VALUE;
		Map<String, Integer> restaurantMap = new HashMap<>();

		if (list1.length < list2.length) {
			shortList = list1;
			longerList = list2;
		} else {
			shortList = list2;
			longerList = list1;
		}

		for (int i = 0; i < shortList.length; i++) {
			restaurantMap.put(shortList[i], i);
		}
		List<String> resultList = new LinkedList<>();
		for (int i = 0, len = longerList.length; i < len; i++) {
			if (restaurantMap.containsKey(longerList[i])) {
				int sum = restaurantMap.get(longerList[i]) + i;
				if (sum < minimumSum) {
					minimumSum = sum;
					resultList.clear();
					resultList.add(longerList[i]);
				} else if (sum == minimumSum) {
					resultList.add(longerList[i]);
				}
			}
		}
		String[] result = new String[resultList.size()];
		for (int i = 0, len = resultList.size(); i < len; i++) {
			result[i] = resultList.get(i);
		}

		return result;
	}
}