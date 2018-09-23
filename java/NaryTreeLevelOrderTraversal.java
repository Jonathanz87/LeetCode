/*
	problem 429
	Given an n-ary tree, return the level order traversal of its nodes' values.
	(ie, from left to right, level by level).
	For example, given a 3-ary tree:
			1
		  / | \
		 3	2  4
		/ \
	   5   6
	We should return its level order traversal:
	[
		[1],
		[3,2,4],
		[5,6]
	]
	Note:
		The depth of the tree is at most 1000.
		The total number of nodes is at most 5000.
*/
import java.util.List;
import java.util.LinkedList;

public class NaryTreeLevelOrderTraversal {
	// Definition for a Node.
	private static class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public static List<List<Integer>> levelOrder(Node root) {
		if (root == null) return new LinkedList<>();

		LinkedList<Node> queue = new LinkedList<>();
		List<List<Integer>> result = new LinkedList<>();
		int levelSize = 1;

		queue.addLast(root);

		while (levelSize > 0) {
			int size = 0;
			List<Integer> levelList = new LinkedList<>();
			while (levelSize-- > 0) {
				Node current = queue.pollFirst();
				levelList.add(current.val);
				for(Node n : current.children){
					queue.addLast(n);
					size++;
				}
			}
			levelSize = size;
			result.add(levelList);
		}
		return result;	
	}
}










