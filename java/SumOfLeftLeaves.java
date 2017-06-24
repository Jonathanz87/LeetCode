/*
	problem 404
	Find the sum of all left leaves in a given binary tree.
	Example:
	    3
	   / \
	  9  20
	    /  \
	   15   7
	There are two left leaves in the binary tree,
	with values 9 and 15 respectively.
	Return 24.
*/

public class SumOfLeftLeaves{
	public static main(String[] args){

	}

	public static int sumOfLeftLeaves(TreeNode root) {
		return root == null ? 0 : sumOfLeftLeaves(root, false);
	}

	public static int sumOfLeftLeaves(TreeNode root, boolean isLeft){
		if(root.left == null && root.right == null){
			return isLeft ? root.val : 0;
		}

		int val = 0;
		if(root.left != null){
			val += sumOfLeftLeaves(root.left, true);
		}
		if(root.right != null){
			val += sumOfLeftLeaves(root.right, false);
		}
		return val;
	}

	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}