/*
	problem 654
	Given an integer array with no duplicates.
	A maximum tree building on this array is defined as follow:
	The root is the maximum number in the array.
	The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
	The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
	Construct the maximum tree by the given array and output the root node of this tree.
	Example 1:
		Input: [3,2,1,6,0,5]
		Output: return the tree root node representing the following tree:
			   6
			 /   \
			3     5
			 \    /
			  2  0
			   \
			    1
	Note:
		The size of the given array will be in the range [1,1000].
*/

public class MaximumBinaryTree {
	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree(nums, 0, nums.length - 1);
	}

	private static TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int target = start;
		int biggest = nums[start];
		for (int i = start + 1; i <= end; i++) {
			if (nums[i] > biggest) {
				biggest = nums[i];
				target = i;
			}
		}
		TreeNode root = new TreeNode(nums[target]);
		root.left = constructMaximumBinaryTree(nums, start, target - 1);
		root.right = constructMaximumBinaryTree(nums, target + 1, end);
		return root;
	}
}