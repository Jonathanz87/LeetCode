/*
	problem 117
	Follow up for problem "Populating Next Right Pointers in Each Node".
	What if the given tree could be any binary tree?
	Would your previous solution still work?
	Note:
	You may only use constant extra space.
	For example,
	Given the following binary tree,
		     1
		   /  \
		  2    3
		 / \    \
		4   5    7
	After calling your function, the tree should look like:
		     1 -> NULL
		   /  \
		  2 -> 3 -> NULL
		 / \    \
		4-> 5 -> 7 -> NULL
*/

public class PopulatingNextRightPointersInEachNodeII {
	//Definition for binary tree with next pointer.
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode beforeHead = new TreeLinkNode(0);
		TreeLinkNode current = beforeHead;

		for (; root != null; root = root.next) {
			if (root.left != null) {
				current.next = root.left;
				current = root.left;
			}
			if (root.right != null) {
				current.next = root.right;
				current = root.right;
			}
		}
		connect(beforeHead.next);
	}
}