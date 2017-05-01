/*
	problem 103
	Given a binary tree, return the zigzag level order traversal of its nodes' values. 
	(ie, from left to right, then right to left for the next level and alternate between).
	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
		[3],
		[20,9],
		[15,7]
	]
*/

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeZigzagLevelOrderTraversal{
	public static void main(String[] args){

	}

	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(root == null) return result;
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		boolean isList2Right = true;
		int size = 0;
		nodes.add(root);

		while((size = nodes.size()) > 0){
			List<Integer> temp = new LinkedList<Integer>();
			if(isList2Right){
				for(int i = 0; i < size; i++){
					TreeNode node = nodes.poll();
					temp.add(node.val);
					if(node.left != null)
						nodes.add(node.left);
					if(node.right != null)
						nodes.add(node.right);
				}
			}else{
				getLevelReverseOrder(temp, nodes, size);
			}
			result.add(temp);
			isList2Right = !isList2Right;
		}

		return result;
	}

	private static void getLevelReverseOrder(List<Integer> list, Queue<TreeNode> nodes, int ct){
		if (ct <= 0) return;
		TreeNode node = nodes.poll();
		if(node.left != null)
			nodes.add(node.left);
		if(node.right != null)
			nodes.add(node.right);
		getLevelReverseOrder(list, nodes, ct - 1);
		list.add(node.val);
	}
}