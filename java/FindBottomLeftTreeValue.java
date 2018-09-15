/*
	problem 513
	Given a binary tree, find the leftmost value in the last row of the tree.
	Example 1:
		Input:
		  2
		 / \
		1   3

		Output: 1
	Example 2:
		Input:
		    1
		   / \
		  2   3
		 /   / \
		4   5   6
		   /
		  7
		Output: 7
Note: You may assume the tree (i.e., the given root node) is not NULL.
*/

import java.util.Queue;
import java.util.LinkedList;

public class FindBottomLeftTreeValue {
	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
			root = queue.poll();
			if (root.right != null) {
				queue.add(root.right);
			}
			if (root.left != null) {
				queue.add(root.left);
			}
		}
		return root.val;
	}
}