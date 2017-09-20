/*
	problem 95
	Given an integer n,
	generate all structurally unique BST's (binary search trees) that store values 1...n.
	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.
		1         3     3      2      1
		 \       /     /      / \      \
		  3     2     1      1   3      2
		 /     /       \                 \
		2     1         2                 3
*/

import java.util.List;
import java.util.LinkedList;

public class UniqueBinarySearchTreesII {
	//	Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

   public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }
    
  	public List<TreeNode> generateTrees(int start, int end) {
		if (start > end) {
			List<TreeNode> treeList = new LinkedList<TreeNode>();
			treeList.add(null);
			return treeList;
		}

		List<TreeNode> treeList = new LinkedList<TreeNode>();
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftTree = generateTrees(start, i - 1);
			List<TreeNode> rightTree = generateTrees(i + 1, end);
			for (TreeNode leftNode : leftTree) {
				for (TreeNode rightNode : rightTree) {
					TreeNode root = new TreeNode(i);
					root.left = leftNode;
					root.right = rightNode;
					treeList.add(root);
				}
			}
		}
		return treeList;
	}
}