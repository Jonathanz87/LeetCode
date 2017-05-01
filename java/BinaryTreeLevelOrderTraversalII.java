/*
	problem 107
	Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
	(ie, from left to right, level by level from leaf to root).
	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its bottom-up level order traversal as:
	[
		[15,7],
		[9,20],
		[3]
	]
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII{
	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(root == null) return result;
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		int size = 0;
		nodes.add(root);

		while((size = nodes.size()) > 0){
			List<Integer> list = new LinkedList<Integer>();
			for(int i = 0; i < size; i++){
				TreeNode node = nodes.poll();
				list.add(node.val);
				if(node.left != null)
					nodes.add(node.left);
				if(node.right != null)
					nodes.add(node.right);
			}
			result.add(0, list);
		}

		return result;
	}
}