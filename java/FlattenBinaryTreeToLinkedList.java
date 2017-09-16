/*
	problem 114
	Given a binary tree,
	flatten it to a linked list in-place.
	For example,
	Given
	    1
	   / \
	  2   5
	 / \   \
	3   4   6
	The flattened tree should look like:
	1
	 \
	  2
	   \
	    3
	     \
	      4
	       \
	        5
	         \
	          6
*/

public class FlattenBinaryTreeToLinkedList {

	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x;}
	}

	public static TreeNode tail = null;

	public static void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = temp;
		}
		flatten(root.right);

		if(root.left != null){
			tail.right = root.left;
			root.left = null;
			flatten(tail.right);
		}

		if(root.right == null){
			tail = root;
		}
	}
}











