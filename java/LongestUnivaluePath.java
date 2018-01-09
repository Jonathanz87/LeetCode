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

		return longestUnivaluePath(root, 1);
	}

	public int longestUnivaluePath(TreeNode root, int degree) {
		if (root.left != null) {
			if (root.left.val == root.val) {
				degree = longestUnivaluePath(root.left, degree + 1);
			} else {
				degree = Math.max(longestUnivaluePath(root.left, 1), degree);
			}
		}

		if (root.right != null) {
			if (root.right.val == root.val) {
				degree = longestUnivaluePath(root.right, degree + 1);
			} else {
				degree = Math.max(longestUnivaluePath(root.right, degree, 1), degree);
			}
		}

		return degree;
	}
}
}