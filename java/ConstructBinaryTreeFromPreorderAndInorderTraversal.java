/*
	problem 105
	Given preorder and inorder traversal of a tree,
	construct the binary tree.
	Note:
	You may assume that duplicates do not exist in the tree.
*/

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private static int index = 0;

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, inorder, 0, preorder.length - 1);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder, int startIndex, int endIndex) {
		if(index >= preorder.length || startIndex > endIndex){
			return null;
		}
		int num = preorder[index++];

		for(int i = startIndex; i <= endIndex; i++) {
			if(inorder[i] == num){
				TreeNode node = new TreeNode(num);
				node.left = buildTree(preorder, inorder, startIndex, i - 1);
				node.right = buildTree(preorder, inorder, i + 1, endIndex);
				return node;
			}
		}

		return null;
	}
}