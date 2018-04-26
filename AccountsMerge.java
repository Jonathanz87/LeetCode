/*
	problem 721
	Given a list accounts, each element accounts[i] is a list of strings,
	where the first element accounts[i][0] is a name,
	and the rest of the elements are emails representing emails of the account.
	Now, we would like to merge these accounts.
	Two accounts definitely belong to the same person if there is some email that is common to both accounts.
	Note that even if two accounts have the same name,
	they may belong to different people as people could have the same name.
	A person can have any number of accounts initially,
	but all of their accounts definitely have the same name.
	After merging the accounts, return the accounts in the following format: the first element of each account is the name,
	and the rest of the elements are emails in sorted order.
	The accounts themselves can be returned in any order.
	Example 1:
		Input:
		accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
					["John", "johnnybravo@mail.com"],
					["John", "johnsmith@mail.com", "john_newyork@mail.com"],
					["Mary", "mary@mail.com"]]
		Output: [	["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
					["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
		Explanation:
			The first and third John's are the same person as they have the common email "johnsmith@mail.com".
			The second John and Mary are different people as none of their email addresses are used by other accounts.
			We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
			['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
	Note:
		The length of accounts will be in the range [1, 1000].
		The length of accounts[i] will be in the range [1, 10].
		The length of accounts[i][j] will be in the range [1, 30].
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		int[] groupMap = new int[accounts.size()];
		Map<String, Integer> emailMap = new TreeMap<>();
		List<String>[] emailList = new LinkedList[accounts.size()];
		List<List<String>> result = new LinkedList<>();

		for (int i = 0; i < groupMap.length; i++) {
			groupMap[i] = i;
		}

		for (int i = 0, len = accounts.size(); i < len; i++) {
			List<String> info = accounts.get(i);
			for (int j = 1, jLen = info.size(); j < jLen; j++) {
				String email = info.get(j);
				if (emailMap.containsKey(email)) {
					groupMap[getGroup(groupMap, emailMap.get(email))] = i;
				} else {
					emailMap.put(email, i);
				}
			}
		}

		for (Map.Entry<String, Integer> e : emailMap.entrySet()) {
			int groupIndex = getGroup(groupMap, e.getValue());
			if (emailList[groupIndex] == null) {
				emailList[groupIndex] = new LinkedList<>();
				emailList[groupIndex].add(accounts.get(e.getValue()).get(0));
				result.add(emailList[groupIndex]);
			}
			emailList[groupIndex].add(e.getKey());
		}

		return result;
	}

	private int getGroup(int[] groupMap, int index) {
		while (groupMap[index] != index) {
			index = groupMap[index];
		}

		return index;
	}
}
