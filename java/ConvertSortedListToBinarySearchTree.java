/*
	problem 109
	Given a singly linked list where elements are sorted in ascending order, 
	convert it to a height balanced BST.
	For this problem, a height-balanced binary tree is defined as a binary tree in 
	which the depth of the two subtrees of every node never differ by more than 1.
	Example:
		Given the sorted linked list: [-10,-3,0,5,9],
		One possible answer is: [0,-3,9,-10,null,5], 
		which represents the following height balanced BST:
			     0
			    / \
			  -3   9
			  /   /
			-10  5
*/


public class ConvertSortedListToBinarySearchTree {
	// Definition for singly - linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode beforeHead = new ListNode(0);
		ListNode slow = beforeHead, fast = head;
		beforeHead.next = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode m = slow.next;
		ListNode r = m.next;
		slow.next = null;
		m.next = null;

		TreeNode root = new TreeNode(m.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(r);

		return root;
	}
}