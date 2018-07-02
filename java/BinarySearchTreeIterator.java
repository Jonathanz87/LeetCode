/*
	problem 173
	Implement an iterator over a binary search tree (BST).
	Your iterator will be initialized with the root node of a BST.
	Calling next() will return the next smallest number in the BST.
	Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
	where h is the height of the tree.
*/

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class BinarySearchTreeIterator {
	// Definition for binary tree
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static class BSTIterator {
		private int index = -1;
		private TreeNode[] nodeList;

		public BSTIterator(TreeNode root) {
			nodeList = new TreeNode[findHeight(root)];
			while (root != null) {
				nodeList[++index] = root;
				root = root.left;
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return index >= 0;
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode node = nodeList[index--];
			int val = node.val;

			node = node.right;
			while (node != null) {
				nodeList[++index] = node;
				node = node.left;
			}
			return val;
		}

		private int findHeight(TreeNode root) {
			if (root == null) {
				return 0;
			}

			return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
		}
	}
}