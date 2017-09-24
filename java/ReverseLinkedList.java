/*
	problem 206
	Reverse a singly linked list.
	Hint:
	A linked list can be reversed either iteratively or recursively.
	Could you implement both?
*/

public class ReverseLinkedList {

	//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode reverseList(ListNode head) {
		ListNode next = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = next;
			next = head;
			head = temp;
		}

		return next;
	}

}