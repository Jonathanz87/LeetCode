/*
	problem 687
	Given a binary tree,
	find the length of the longest path
	where each node in the path has the same value.
	This path may or may not pass through the root.
	Note: The length of path between two nodes is represented by the number of edges between them.
	Example 1:
		Input:
				    5
				   / \
				  4   5
				 / \   \
				1   1   5
		Output: 2
	Example 2:
		Input:
				    1
				   / \
				  4   5
				 / \   \
				4   4   5
		Output: 2
*/

import java.util.Queue;
import java.util.LinkedList;

public class LongestUnivaluePath {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int longestUnivaluePath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxPath = 0;
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.IllegalStateExceptionmpty()) {
			TreeNode node = queue.poll();
			maxPath = Math.max(longestUnivaluePath(node.left, node.val, queue) + longestUnivaluePath(node.right, node.val, queue), maxPath);
		}

		return maxPath;
	}

	public int longestUnivaluePath(TreeNode root, int target, Queue<TreeNode> queue) {
		if (root == null) {
			return 0;
		}

		if (root.val != target) {
			queue.add(root);
			return 0;
		}

		return Math.max(longestUnivaluePath(root.left, target, queue), longestUnivaluePath(root.right, target, queue)) + 1;
	}

}