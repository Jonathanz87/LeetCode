/*
	problem 94
	Given a binary tree,
	return the inorder traversal of its nodes' values.
	For example:
	Given binary tree [1,null,2,3],
		1
		 \
		  2
		 /
		3
	return [1,3,2].
*/

import java.util.List;
import java.util.LinkedList;
public class BinaryTreeInorderTraversal {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> numList = new LinkedList<>();
		inorderTraversal(numList, root);
		return numList;
	}

	public void inorderTraversal(List<Integer> numList, TreeNode root) {
		if (root == null) {
			return;
		}

		inorderTraversal(numList, root.left);
		numList.add(root.val);
		inorderTraversal(numList, root.right);

	}
}