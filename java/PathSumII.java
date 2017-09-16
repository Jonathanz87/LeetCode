/*
	problem 113
	Given a binary tree and a sum,
	find all root-to-leaf paths where each path's sum equals the given sum.
	For example:
	Given the below binary tree and sum = 22,
		      5
		     / \
		    4   8
		   /   / \
		  11  13  4
		 /  \    / \
		7    2  5   1
	return
	[
		[5,4,11,2],
		[5,8,4,5]
	]
*/

import java.util.List;
import java.util.LinkedList;
public class PathSumII {
	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return new LinkedList<>();
		}
        List<List<Integer>> list = pathSum(root, sum, 0);
		return list == null ? new LinkedList<>() : list;
	}

	public static List<List<Integer>> pathSum(TreeNode node, int sum, int currentSum) {
		currentSum += node.val;
		if (node.left == null && node.right == null && sum == currentSum) {
			List<Integer> numList = new LinkedList<>();
			numList.add(node.val);
			List<List<Integer>> list = new LinkedList<>();
			list.add(numList);
			return list;
		}
		List<List<Integer>> left = null;
		List<List<Integer>> right = null;
		if (node.left != null) {
			left = pathSum(node.left, sum, currentSum);
		}

		if (node.right != null) {
			right = pathSum(node.right, sum, currentSum);
		}

		List<List<Integer>> returnList = null;

		if (left != null && right != null) {
			left.addAll(right);
			returnList = left;
		} else {
			returnList = left != null ? left : right;
		}

		if (returnList != null) {
			for (List<Integer> list : returnList) {
				list.add(0, node.val);
			}
		}

		return returnList;
	}
}