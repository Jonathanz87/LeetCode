/*
	problem 49
	Given an array of strings, group anagrams together.
	For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	Return:
	[
	  ["ate", "eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	Note: All inputs will be in lower-case.
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class GroupAnagrams{
	public static void main(String[] args){

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for(String str : strs){
			String key = getKey(str);
			List<String> strList = map.get(key);
			if(strList == null){
				strList = new ArrayList<>();
				map.put(key, strList);
			}

			strList.add(str);
		}

		return new ArrayList<List<String>>(map.values());
	}

	private static String getKey(String value){
		char[] arr = value.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

	public static List<List<String>> groupAnagrams2(String[] strs){
		int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
		HashMap<Integer, List<String>> map = new HashMap<>();
		for (String str : strs) {
			int key = 1;
			for (char c : str.toCharArray()) {
				key *= prime[c - 'a'];
			}

			List<String> strList = map.get(key);
			if(strList == null){
				strList = new ArrayList<>();
				map.put(key, strList);
			}

			strList.add(str);
		}
		return new ArrayList<List<String>>(map.values());
	}
}