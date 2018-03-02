/*
	problem 199
	Given a complete binary tree, count the number of nodes.
	In a complete binary tree every level,
	except possibly the last, is completely filled,
	and all nodes in the last level are as far left as possible.
	It can have between 1 and 2h nodes inclusive at the last level h.
*/
public class CountCompleteTreeNodes {
	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static int countNodes(TreeNode root) {
		return countNodes(root, -1, -1);
	}
	// O(log2(n)^2)
	private static int countNodes(TreeNode root, int left, int right) {
		if (left < 0) {
			left = leftDeepth(root);
		}
		if (right < 0) {
			right = rightDeepth(root);
		}

		if (left == right) {
			return (int)(Math.pow(2, left) - 1);
		} else {
			int l = (int)(Math.pow(2, left - 1) - 1);
			int countL = countNodes(root.left, left - 1, -1);
			if (l == countL) {
				return 1 + countL + countNodes(root.right, -1, right - 1);
			} else {
				return 1 + countL + (int)(Math.pow(2, right - 1) - 1);
			}
		}
	}

	private static int leftDeepth(TreeNode node) {
		int deepth = 0;
		while (node != null) {
			deepth++;
			node = node.left;
		}
		return deepth;
	}

	private static int rightDeepth(TreeNode node) {
		int deepth = 0;
		while (node != null) {
			deepth++;
			node = node.right;
		}
		return deepth;
	}
}
