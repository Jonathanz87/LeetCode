/*
	problem 590
	Given an n-ary tree, return the postorder traversal of its nodes' values.
	For example, given a 3-ary tree:
	        1
	     /  |  \
	    3   2   4
	  /  \
	 5    6
	Return its postorder traversal as: [5,6,3,2,4,1].
	Note: Recursive solution is trivial, could you do it iteratively?
*/
 import java.util.List;
import java.util.LinkedList;
 public class NaryTreePostorderTraversal {
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
 	public List<Integer> postorder(Node root) {
		LinkedList<Integer> result = new LinkedList<>();
		LinkedList<Node> queue = new LinkedList<>();
 		if (root != null) {
			queue.add(root);
		}
 		while (!queue.isEmpty()) {
			Node node = queue.removeLast();
			result.addFirst(node.val);
			for(Node n : node.children){
				queue.add(n);
			}
		}
 		return result;
	}

	public List<Integer> postorder2(Node root) {
		LinkedList<Integer> result = new LinkedList<>();
		postorderHelper(result, root);
		return result;
	}

	public void postorderHelper(LinkedList<Integer> result, Node root) {
		if(root == null){
			return;
		}
		for(Node n : root.children){
			postorderHelper(result, n);
		}
		result.add(root.val);
	}
}
