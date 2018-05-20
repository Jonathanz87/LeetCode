/*
	problem 662
	Given a binary tree, write a function to get the maximum width of the given tree. 
	The width of a tree is the maximum width among all levels. 
	The binary tree has the same structure as a full binary tree, but some nodes are null.
	The width of one level is defined as the length between the end-nodes 
	(the leftmost and right most non-null nodes in the level, 
	where the null nodes between the end-nodes are also counted into the length calculation.
	Example 1:
		Input: 
		     1
		   /   \
		  3     2
		 / \     \  
		5   3     9 
		Output: 4
		Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
	Example 2:
		Input: 
		    1
		   /  
		  3    
		 / \       
		5   3     
		Output: 2
		Explanation: The maximum width existing in the third level with the length 2 (5,3).
	Example 3:
		Input: 
		    1
		   / \
		  3   2 
		 /        
		5      
		Output: 2
		Explanation: The maximum width existing in the second level with the length 2 (3,2).
	Example 4:
		Input: 
		      1
		     / \
		    3   2
		   /     \  
		  5       9 
		 /         \
		6           7
		Output: 8
		Explanation:The maximum width existing in the fourth level with the length 8 
		(6,null,null,null,null,null,null,7).
*/

import java.util.Queue;
import java.util.LinkedList;

public class MaximumWidthOfBinaryTree {
	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static int widthOfBinaryTree(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Queue<Integer> positionQueue = new LinkedList<>();

		int maxWidth = 1;
		int layerSize = 1;
		nodeQueue.add(root);
		positionQueue.add(1);

		while (!nodeQueue.isEmpty()) {
			int l = Integer.MAX_VALUE;
			int r = Integer.MIN_VALUE;
			int size = 0;
			while (layerSize-- > 0) {
				root = nodeQueue.poll();
				int p = positionQueue.poll();
				l = Math.min(l, p);
				r = Math.max(r, p);

				if (root.left != null) {
					nodeQueue.add(root.left);
					positionQueue.add(p * 2 - 1);
					size++;
				}
				if (root.right != null) {
					nodeQueue.add(root.right);
					positionQueue.add(p * 2);
					size++;
				}
			}
			layerSize = size;
			maxWidth = Math.max(r - l + 1, maxWidth);
		}

		return maxWidth;
	}
}