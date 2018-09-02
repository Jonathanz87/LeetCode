/*
	problem 894
	A full binary tree is a binary tree where each node has exactly 0 or 2 children.
	Return a list of all possible full binary trees with N nodes.
	Each element of the answer is the root node of one possible tree.
	Each node of each tree in the answer must have node.val = 0.
	You may return the final list of trees in any order.
	Example 1:
		Input: 7
		Output: [
					[0,0,0,null,null,0,0,null,null,0,0],
					[0,0,0,null,null,0,0,0,0],
					[0,0,0,0,0,0,0],
					[0,0,0,0,0,null,null,null,null,0,0],
					[0,0,0,0,0,null,null,0,0]
				]

*/

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class AllPossibleFullBinaryTrees {

	public static void main(String[] args) {
		System.out.println(allPossibleFBT(Integer.parseInt(args[0])).size());
	}

	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static List<TreeNode> allPossibleFBT(int N) {
		if (N % 2 == 0) return new LinkedList<>();

		Map<Integer, List<TreeNode>> rootMap = new HashMap<>();
		TreeNode oneNode = new TreeNode(0);
		List<TreeNode> oneList = new LinkedList<>();
		oneList.add(oneNode);
		rootMap.put(1, oneList);

		for (int i = 3; i <= N; i += 2) {
			List<TreeNode> rootList = new LinkedList<>();
			rootMap.put(i, rootList);
			for (int j = 1; j < i; j += 2) {
				for (TreeNode left : rootMap.get(j)) {
					for (TreeNode right : rootMap.get(i - j - 1)) {
						TreeNode node = new TreeNode(0);
						node.left = left;
						node.right = right;
						rootList.add(node);
					}
				}
			}
		}

		return rootMap.get(N);
	}
}