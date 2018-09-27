/*
	problem 872
	Consider all the leaves of a binary tree.
	From left to right order, the values of those leaves form a leaf value sequence.
		  3
	   /    \
	  5      1
	 / \    / \
	6   2  9   8
	   / \
	  7   4
	For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
	Two binary trees are considered leaf-similar if their leaf value sequence is the same.
	Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
	Note:
	Both of the given trees will have between 1 and 100 nodes.
*/

import java.util.LinkedList;

public class LeafSimilarTrees {
	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		TreeNode[] leftQueue = new TreeNode[100];
		TreeNode[] rightQueue = new TreeNode[100];
		int leftIndex = -1, rightIndex = -1;

		if (root1 != null) {
			leftQueue[++leftIndex] = root1;
		}
		if (root2 != null) {
			rightQueue[++rightIndex] = root2;
		}
		TreeNode left = null, right = null;
		do {
			if (leftIndex < 0) {
				left = null;
			} else {
				left = leftQueue[leftIndex--];
				while (left.left != null || left.right != null) {
					if (left.right != null) {
						leftQueue[++leftIndex] = left.right;
					}
					if (left.left != null) {
						leftQueue[++leftIndex] = left.left;
					}
					left = leftQueue[leftIndex--];
				}
			}

			if (rightIndex < 0) {
				right = null;
			} else {
				right = rightQueue[rightIndex--];
				while (right.left != null || right.right != null) {
					if (right.right != null) {
						rightQueue[++rightIndex] = right.right;
					}
					if (right.left != null) {
						rightQueue[++rightIndex] = right.left;
					}
					right = rightQueue[rightIndex--];
				}
			}
			if(left != null && right != null && left.val != right.val){
				return false;
			}
		} while (left != null && right != null);


		return left == null && right == null;
	}

	private static TreeNode nextLeaf(LinkedList<TreeNode> nodeQueue) {
		if (nodeQueue.isEmpty()) {
			return null;
		}
		TreeNode node = null;
		for (node = nodeQueue.pollLast(); node.left != null || node.right != null; node = nodeQueue.pollLast()) {
			if (node.right != null) {
				nodeQueue.add(node.right);
			}
			if (node.left != null) {
				nodeQueue.add(node.right);
			}
		}

		return node;
	}
}
