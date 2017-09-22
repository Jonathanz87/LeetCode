/*
	problem 203
	Remove all elements from a linked list of integers that have value val.
	Example
	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	Return: 1 --> 2 --> 3 --> 4 --> 5
*/

public class RemoveLinkedListElements {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode removeElements(ListNode head, int val) {
		ListNode beforeHead = new ListNode(0);
		beforeHead.next = head;
		head = beforeHead;
		while (head.next != null) {
			if (head.next.val == val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return beforeHead.next;
	}
}