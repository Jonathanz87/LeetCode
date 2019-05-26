public class ConstructBinarySearchTreeFromPreorderTraversal {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode[] nodeStack = new TreeNode[preorder.length + 1];
        int index = 0;

        nodeStack[0] = new TreeNode(Integer.MAX_VALUE);

        for (int n : preorder) {
            TreeNode nNode = new TreeNode(n);
            if (n < nodeStack[index].val) {
                nodeStack[++index] = nNode;
                nodeStack[index - 1].left = nNode;
            } else {
                while (nodeStack[index - 1].val < n) {
                    index--;
                }
                nodeStack[index].right = nNode;
                nodeStack[index] = nNode;
            }
        }
        return nodeStack[0].left;
    }

}