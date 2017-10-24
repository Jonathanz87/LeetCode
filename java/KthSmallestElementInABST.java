/*
	problem 230
	Given a binary search tree,
	write a function kthSmallest to find the kth smallest element in it.
	Note:
	You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
	Follow up:
	What if the BST is modified (insert/delete operations) often and
	you need to find the kth smallest frequently?
	How would you optimize the kthSmallest routine?
*/

import java.util.Stack;

public class KthSmallestElementInABST {
	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> nodeList = new Stack<>();
		int count = 0;
		TreeNode current = root;

		while (!nodeList.empty() || current != null) {
			if (current != null) {
				nodeList.push(current);
				current = current.left;
			} else {
				current = nodeList.pop();
				if (++count == k) {
					return current.val;
				}
				current = current.right;
			}
		}
		return 0;
	}

}