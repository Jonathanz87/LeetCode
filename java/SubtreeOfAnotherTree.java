/*
	problem 572
	Given two non-empty binary trees s and t,
	check whether tree t has exactly the same structure
	and node values with a subtree of s.
	A subtree of s is a tree consists of a node in s
	and all of this node's descendants.
	The tree s could also be considered as a subtree of itself.
	Example 1:
		Given tree s:
			    3
			   / \
			  4   5
			 / \
			1   2
		Given tree t:
			  4
			 / \
			1   2
		Return true,
		because t has the same structure and node values with a subtree of s.
	Example 2:
		Given tree s:
			    3
			   / \
			  4   5
			 / \
			1   2
			   /
			  0
		Given tree t:
			  4
			 / \
			1   2
		Return false.
*/

public class SubtreeOfAnotherTree {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        return equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean equals(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null || s.val != t.val) {
            return false;
        }

        return equals(s.left, t.left) && equals(s.right, t.right);
    }
}