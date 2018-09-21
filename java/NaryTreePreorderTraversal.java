/*
	problem 589
	Given an n-ary tree, return the preorder traversal of its nodes' values.
	or example, given a 3-ary tree:
			1
		 /	|  \
		3 	2 	4
	   / \
	  5   6
	Return its preorder traversal as: [1,3,5,6,2,4].
	Note: Recursive solution is trivial, could you do it iteratively?
*/

public class NaryTreePreorderTraversal{
	// Definition for a Node.
	private static class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val,List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public List<Integer> preorder(Node root) {
		List<Integer> result = new LinkedList<>();
		dsf(result, root);
		return result;
	}

	public void dsf(List<Integer> result, Node root) {
		if(root == null) return;
		result.add(root.val);
		for(Node node : root.children){
			dsf(result, node);
	}
}
