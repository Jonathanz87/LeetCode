/*
	problem 145
	Given a binary tree, return the postorder traversal of its nodes' values.
	For example:
	Given binary tree {1,#,2,3},
		1
		 \
		  2
		 /
		3
	return [3,2,1].
	Note: Recursive solution is trivial, could you do it iteratively?
*/

/*
	solution 
		    1
		   / \
		  2   3
		 / \ / \
		4  5 6  7
	reverse right preorder 1 3 7 6 2 5 4 to post order 4 5 2 6 7 3 1
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static List<Integer> postorderTraversalIterative(TreeNode root) {
		if (root == null) return new LinkedList<>();
		List<Integer> resultList = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();

		do {
			if (root == null) {
				root = stack.pop().left;
			} else {
				resultList.add(0, root.val);
				stack.push(root);
				root = root.right;
			}
		} while (root != null || !stack.empty());
		return resultList;
	}

	public static List<Integer> postorderTraversalRecursive(TreeNode root) {
		List<Integer> resultList = new LinkedList<>();
		postorderTraversalRecursive(resultList, root);
		return resultList;
	}

	public static void postorderTraversalRecursive(List<Integer> resultList, TreeNode node) {
		if (node == null) return;

		postorderTraversalRecursive(resultList, node.left);
		postorderTraversalRecursive(resultList, node.right);
		resultList.add(node.val);
	}
}