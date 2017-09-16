/*
	Given a binary tree,
	determine if it is height-balanced.
	For this problem, a height-balanced binary tree is defined as a binary tree in which
	the depth of the two subtrees of every node never differ by more than 1.
*/

public class BalancedBinaryTree {
	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static boolean isBalanced(TreeNode root) {
		return getTreeHeight(root) >= 0;

	}

	public static int getTreeHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftHeight = 0;
		int rightHeight = 0;

		if ((leftHeight = getTreeHeight(node.left)) < 0
		        || (rightHeight = getTreeHeight(node.right)) < 0
		        || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}

		return Math.max(leftHeight, rightHeight) + 1;
	}
}