/*
	problem 671
	Given a non-empty special binary tree consisting of nodes with the non-negative value,
	where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes,
	then this node's value is the smaller value among its two sub-nodes.
	Given such a binary tree,
	you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
	If no such second minimum value exists, output -1 instead.
	Example 1:
		Input:
		  2
		 / \
		2   5
		   / \
		  5   7
		Output: 5
		Explanation: The smallest value is 2, the second smallest value is 5.
	Example 2:
		Input:
		  2
		 / \
		2   2

		Output: -1
		Explanation: The smallest value is 2,
		but there isn't any second smallest value.
*/

public class SecondMinimumNodeInABinaryTree {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static int findSecondMinimumValue(TreeNode root) {
		return findMinimumValueGreaterThan(root, root.val);

	}
	public static int findMinimumValueGreaterThan(TreeNode root, int val) {
		if (root == null) {
			return -1;
		}

		if (root.val > val) {
			return root.val;
		}

		int left = findMinimumValueGreaterThan(root.left, val);
		int right = findMinimumValueGreaterThan(root.right, val);
		int min = -1;

		if (left > val) {
			min = left;
		}

		if (right > val) {
			min = min == -1 ? right : Math.min(min, right);
		}

		return min;
	}
}