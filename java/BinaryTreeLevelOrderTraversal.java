/*
	problem 102
	Given a binary tree, return the level order traversal of its nodes' values. 
	(ie, from left to right, level by level).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
		    3
		   / \
		  9  20
		    /  \
		   15   7
	return its level order traversal as:
		[
			[3],
			[9,20],
			[15,7]
		]
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal{

	//Definition for a binary tree node.
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		int size;
		nodeQueue.add(root);
		while((size = nodeQueue.size()) > 0){
			List<Integer> temp = new ArrayList<Integer>();
			for(int i = 0; i < size; i++){
				TreeNode node = nodeQueue.poll();
				temp.add(node.val);
				if(node.left != null)
					nodeQueue.add(node.left);
				if(node.right != null)
					nodeQueue.add(node.right);
			}
			result.add(temp);
		}
		return result;
	}
}