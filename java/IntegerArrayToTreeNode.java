import java.util.Queue;

public class IntegerArrayToTreeNode {
	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode integerArrayToTreeNode(Integer[] integerArray) {
		if (integerArray == null || integerArray.length <= 0) {
			return null;
		}
		if (integerArray[0] == null) {
			throw new RuntimeException();
		}

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(integerArray[0]);
		queue.add(root);
		int index = 1;

		while (index < integerArray.length && !queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (integerArray[index] != null) {
				node.left = new TreeNode(integerArray[index]);
				queue.add(node.left);
			}
			index++;
			if (index < integerArray.length && integerArray[index] != null) {
				node.right = new TreeNode(integerArray[index]);
				queue.add(node.right);
			}
			index++;
		}

		if (index < integerArray.length) {
			throw new RuntimeException();
		}

		return root;
	}
}