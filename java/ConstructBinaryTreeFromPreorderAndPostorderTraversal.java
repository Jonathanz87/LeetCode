/*
	problem 889
	Return any binary tree that matches the given preorder and postorder traversals.
	Values in the traversals pre and post are distinct positive integers.
	Example 1:
		Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
		Output: [1,2,3,4,5,6,7]
	Note:
		1 <= pre.length == post.length <= 30
		pre[] and post[] are both permutations of 1, 2, ..., pre.length.
		It is guaranteed an answer exists.
		If there exists multiple answers, you can return any of them.
*/

import java.util.LinkedList;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		if (post.length <= 0) return null;

		int preIndex = pre.length - 1;
		TreeNode root = new TreeNode(post[post.length - 1]);
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.add(root);

		for (int postIndex = post.length - 2; postIndex >= 0; postIndex--) {
			TreeNode node = new TreeNode(post[postIndex]);
			TreeNode current =  stack.peekLast();
			if (current.right == null) {
				current.right = node;
			} else {
				current.left = node;
			}

			stack.add(node);
			while (stack.size() > 0 && preIndex >= 0 && pre[preIndex] == stack.peekLast().val) {
				preIndex--;
				stack.pollLast();
			}
		}

		return root;
	}
}