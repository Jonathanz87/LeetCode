/*
	problem 199
	Given a binary tree,
	imagine yourself standing on the right side of it,
	return the values of the nodes you can see ordered from top to bottom.
	For example:
	Given the following binary tree,
		   1            <---
		 /   \
		2     3         <---
		 \     \
		  5     4       <---
	You should return [1, 3, 4].
*/
import java.util.List;
import java.util.ArrayList;
public class BinaryTreeRightSideView {
	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> resultList = new ArrayList<>();
		rightSideView(resultList, root, 0);
		return resultList;
	}

	public static void rightSideView(List<Integer> resultList, TreeNode node, int level) {
		if (node == null) return;

		if (level >= resultList.size()) {
			resultList.add(node.val);
		}

		rightSideView(resultList, node.right, level + 1);
		rightSideView(resultList, node.left, level + 1);
	}
}