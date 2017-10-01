/*
	problem 257
	Given a binary tree, return all root-to-leaf paths.
	For example, given the following binary tree:
		   1
		 /   \
		2     3
		 \
		  5
	All root-to-leaf paths are:
	["1->2->5", "1->3"]
*/

import java.util.List;
import java.util.LinkedList;

public class BinaryTreePaths {
	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> resultList = new LinkedList<>();
		if (root == null) return resultList;
		binaryTreePaths(resultList, "", root);
		return resultList;
	}

	public static void binaryTreePaths(List<String> resultList, String path, TreeNode root) {
		if (root.left == null && root.right == null) {
			resultList.add(path + root.val);
		}

		path = path + root.val + "->";

		if (root.left != null) {
			binaryTreePaths(resultList, path, root.left);
		}

		if (root.right != null) {
			binaryTreePaths(resultList, path, root.right);
		}
	}
}