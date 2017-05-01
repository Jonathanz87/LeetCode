/*
	problem 108
	Given an array where elements are sorted in ascending order, 
	convert it to a height balanced BST.
*/

public class ConvertSortedArraytoBinarySearchTree{
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length <= 0) return null;
		return getRoot(nums, 0, nums.length - 1);
	}

	public static TreeNode getRoot(int[] nums, int fIndex, int bIndex){
		if(fIndex > bIndex) return null;
		int mIndex = (fIndex + bIndex) / 2;
		TreeNode root = new TreeNode(nums[mIndex]);
		root.left = getRoot(nums, fIndex, mIndex - 1);
		root.right = getRoot(nums, mIndex + 1, bIndex);
		return root;
	}
}