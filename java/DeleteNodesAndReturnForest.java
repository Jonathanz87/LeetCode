import java.util.HashSet;
import java.util.List;

/*
    1110. Delete Nodes And Return Forest
    Given the root of a binary tree, each node in the tree has a distinct value.
    After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
    Return the roots of the trees in the remaining forest.  You may return the result in any order.
    Example 1:
        Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
        Output: [[1,2,null,4],[6],[7]]
    Constraints:
        The number of nodes in the given tree is at most 1000.
        Each node has a distinct value between 1 and 1000.
        to_delete.length <= 1000
        to_delete contains distinct values between 1 and 1000.
*/

public class DeleteNodesAndReturnForest {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new LinkedList<>();
        Set<Integer> deletionSet = new HashSet<>();

        for (int n : to_delete) {
            deletionSet.add(n);
        }

        dsf(root, deletionSet, result, true);

        return result;
    }

    private static boolean dsf(TreeNode root, Set<Integer> deletionSet, List<TreeNode> result,
            boolean isParentDeleted) {
        if (root == null) {
            return false;
        }

        boolean isDeleted = deletionSet.contains(root.val);

        if (isParentDeleted && !isDeleted) {
            result.add(root);
        }

        if (dsf(root.left, deletionSet, result, isDeleted)) {
            root.left = null;
        }

        if (dsf(root.right, deletionSet, result, isDeleted)) {
            root.right = null;
        }

        return isDeleted;
    }
}