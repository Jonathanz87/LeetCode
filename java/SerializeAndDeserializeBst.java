/*
    problem 449
    Serialization is the process of converting a data structure or object into a sequence of bits so
    that it can be stored in a file or memory buffer,
    or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
    Design an algorithm to serialize and deserialize a binary search tree.
    There is no restriction on how your serialization/deserialization algorithm should work.
    You just need to ensure that a binary search tree can be serialized to a string and this string
    can be deserialized to the original tree structure.
    The encoded string should be as compact as possible.
    Note: Do not use class member/global/static variables to store states.
    Your serialize and deserialize algorithms should be stateless.
 */

import java.util.LinkedList;

public class SerializeAndDeserializeBst {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        two.left = one;
        two.right = three;
        System.out.println(serialize(two));
        TreeNode root = deserialize("4,2,1,3,5");
        System.out.println(1);
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(null);

        while (root != null) {
            builder.append(root.val).append(',');
            if (root.left == null) {
                if (root.right == null) {
                    root = nodeQueue.pollLast();
                } else {
                    root = root.right;
                }
            } else {
                if (root.right != null) {
                    nodeQueue.add(root.right);
                }
                root = root.left;
            }
        }
        if (builder.length() <= 0) return "";
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == null || data.equals("")) return null;
        String[] values = data.split(",");
        TreeNode[] nodeStack = new TreeNode[values.length];
        int stackIndex = -1;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        nodeStack[++stackIndex] = root;
        TreeNode node = root;

        for (int i = 1; i < values.length; i++) {
            TreeNode newNode = new TreeNode(Integer.parseInt(values[i]));

            if (newNode.val < nodeStack[stackIndex].val) {
                nodeStack[stackIndex].left = newNode;
                nodeStack[++stackIndex] = newNode;
            } else {
                while (stackIndex > 0 && nodeStack[stackIndex - 1].val < newNode.val) {
                    stackIndex--;
                }
                nodeStack[stackIndex].right = newNode;
                nodeStack[stackIndex] = newNode;
            }
        }

        return root;
    }
}
