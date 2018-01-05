/*
	problem 653
	Given a Binary Search Tree and a target number,
	return true if there exist two elements in the BST such that their sum is equal to the given target.
	Example 1:
		Input:
		    5
		   / \
		  3   6
		 / \   \
		2   4   7
		Target = 9
		Output: True
	Example 2:
		Input:
		    5
		   / \
		  3   6
		 / \   \
		2   4   7
		Target = 28
		Output: False
*/
import java.util.Stack;

public class TwoSumIV {
	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean findTarget(TreeNode root, int k) {
		if (root == null) return false;
		Stack<TreeNode> leftStack = new Stack<>();
		Stack<TreeNode> rightStack = new Stack<>();

		leftStack.add(root);
		rightStack.add(root);
		TreeNode leftNode = root;
		TreeNode rightNode = root;

		while (leftNode.left != null) {
			leftStack.add(leftNode.left);
			leftNode = leftNode.left;
		}

		while (rightNode.right != null) {
			rightStack.add(rightNode.right);
			rightNode = rightNode.right;
		}

		while (leftNode != rightNode) {
			int sum = leftNode.val + rightNode.val;
			if (sum = k) {
				return true;
			} else if (sum < k) {
				if (leftNode.right != null) {
					leftNode = leftNode.right;
					while (leftNode.left != null) {
						leftStack.add(leftNode);
						leftNode = leftNode.left;
					}
				} else {
					leftNode = leftStack.pop();
				}
			} else {
				if (rightNode.left != null) {
					rightNode = rightNode.left;
					while (rightNode.right != null) {
						rightStack.add(rightNode);
						rightNode = rightNode.right;
					}
				} else {
					rightNode = rightStack.pop();
				}
			}
		}

		return false;

	}
}