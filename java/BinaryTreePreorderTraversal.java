/*
	problrm 144
	Given a binary tree, return the preorder traversal of its nodes' values.
	For example:
	Given binary tree {1,#,2,3},
		1
		 \
		  2
		 /
		3
	return [1,2,3].	
	Note: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreePreorderTraversal{
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<Integer> preorderTraversalIteratively(TreeNode root) {
		if(root == null) return new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> resultList = new LinkedList<>();

		do{
			if(root == null){
				root = stack.pop();
				root = root.right;
			}else{
				resultList.add(root.val);
				stack.push(root);
				root = root.left;
			}
		}while(root != null || !stack.empty());

		return resultList;
	}

	public List<Integer> preorderTraversalRecursive(TreeNode root) {
		List<Integer> resultList = new LinkedList<>();
		preorderTraversalRecursive(resultList, root);
		return resultList;
	}

	public static void preorderTraversalRecursive(List<Integer> resultList, TreeNode node){
		if(node == null) return;
		resultList.add(node.val);
		preorderTraversalRecursive(resultList, node.left);
		preorderTraversalRecursive(resultList, node.right);
	}
}