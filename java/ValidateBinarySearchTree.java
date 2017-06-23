/*
	problem 98
	Given a binary tree, determine if it is a valid binary search tree (BST).
	Assume a BST is defined as follows:
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	Example 1:
	    2
	   / \
	  1   3
	Binary tree [2,1,3], return true.
	Example 2:
	    1
	   / \
	  2   3
	Binary tree [1,2,3], return false.
*/

public class ValidateBinarySearchTree{
	public static void main(String[] args){

	}

	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isValidBST(TreeNode root, int lowerBoundary, int upperBoundary){
		if(root == null) return true;
		return root.val > lowerBoundary 
		&& root.val < upperBoundary 
		&& isValidBST(root.left, lowerBoundary, root.val) 
		&& isValidBST(root.right, root.val, upperBoundary);
	}

	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}