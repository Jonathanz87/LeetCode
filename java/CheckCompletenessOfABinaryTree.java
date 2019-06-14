
/*
    958. Check Completeness of a Binary Tree
    Given a binary tree, determine if it is a complete binary tree.
    Definition of a complete binary tree from Wikipedia:
    In a complete binary tree every level, except possibly the last, 
    is completely filled, and all nodes in the last level are as far left as possible. 
    It can have between 1 and 2h nodes inclusive at the last level h.
    Example 1:
        Input: [1,2,3,4,5,6]
        Output: true
        Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), 
        and all nodes in the last level ({4, 5, 6}) are as far left as possible.
    Example 2:
        Input: [1,2,3,4,5,null,7]
        Output: false
        Explanation: The node with value 7 isn't as far left as possible.
    Note:
        The tree will have between 1 and 100 nodes.
*/

import javax.swing.tree.TreeNode;

public class CheckCompletenessOfABinaryTree {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        int count = nodeCount(root);
        TreeNode[] nodeQueue = new TreeNode[count];
        int left = -1, right = 0;
        nodeQueue[right] = root;
        while (left < right) {
            TreeNode node = nodeQueue[++left];
            if (node.left == null) {
                break;
            }
            nodeQueue[++right] = node.left;

            if (node.right == null) {
                break;
            }
            nodeQueue[++right] = node.right;

        }
        return count == right + 1;
    }

    private static int nodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return nodeCount(root.left) + nodeCount(root.right) + 1;
    }
}
