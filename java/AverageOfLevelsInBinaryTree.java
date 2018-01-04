/*
	problem 637
	Given a non-empty binary tree,
	return the average value of the nodes on each level in the form of an array.
	Example 1:
		Input:
		    3
		   / \
		  9  20
		    /  \
		   15   7
		Output: [3, 14.5, 11]
		Explanation:
		The average value of nodes on level 0 is 3,
		on level 1 is 14.5,
		and on level 2 is 11.
		Hence return [3, 14.5, 11].
	Note:
	The range of node's value is in the range of 32-bit signed integer.
*/

import java.util.List;
import java.util.LinkedList;

public class AverageOfLevelsInBinaryTree {
	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<TreeNode> queue = new LinkedList<>();
		List<Double> averageList = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		double average = 0;
		int count = 0;

		while (queue.size() > 0) {
			TreeNode node = queue.get(0);
			queue.remove(0);

			if (node == null) {
				if (queue.size() != 0) {
					queue.add(null);
				}
				averageList.add(average /= count);
				average = 0;
				count = 0;
			} else {
				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}

				average += node.val;
				count++;
			}
		}

		return averageList;
	}
}