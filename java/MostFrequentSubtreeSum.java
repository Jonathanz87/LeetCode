/*
	problem 508
	Given the root of a tree, you are asked to find the most frequent subtree sum. 
	The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at 
	that node (including the node itself). 
	So what is the most frequent subtree sum value? 
	If there is a tie, return all the values with the highest frequency in any order.
	Examples 1
		Input:
		  5
		 /  \
		2   -3
		return [2, -3, 4], since all the values happen only once, return all of them in any order.
	Examples 2
		Input:
		  5
		 /  \
		2   -5
		return [2], since 2 happens twice, however -5 only occur once.
	Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
*/

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class MostFrequentSubtreeSum {
	private int ct = 0;
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int[] findFrequentTreeSum(TreeNode root) {
		ct = 0;
		LinkedList<Integer> list = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		sum(root, map);
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if(e.getValue() == this.ct){
				list.add(e.getKey());
			}
		}

		int[] result = new int[list.size()];

		for(int i = 0; i < result.length; i++){
			result[i] = list.get(i);
		}

		return result;

	}

	private Integer sum(TreeNode root, HashMap<Integer, Integer> map) {
		if (root == null) {
			return 0;
		}
		Integer sum = root.val + sum(root.left, map) + sum(root.right, map);
		int ct = map.getOrDefault(sum, 0) + 1;
		this.ct = Math.max(ct, this.ct);
		map.put(sum, ct);
		return sum;
	}
}