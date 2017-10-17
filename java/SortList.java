/*
	problem 148
	Sort a linked list in O(n log n) time using constant space complexity.
*/

public class SortList {
	//Definition for singly - linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode sortList(ListNode head) {
		int size = 0;
		ListNode slow = head, fast = head, tail = head;
		while (fast != null && fast.next != null) {
			tail = slow;
			slow = slow.next;
			fast = fast.next.next;
			size++;
		}
		if (size == 0) {
			return head;
		}
		tail.next = null;

		ListNode node1 = sortList(head);
		ListNode node2 = sortList(slow);
		ListNode beforeHead = new ListNode(0);
		ListNode current = beforeHead;

		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				current.next = node1;
				node1 = node1.next;
			} else {
				current.next = node2;
				node2 = node2.next;
			}
			current = current.next;
		}

		if (node1 != null) {
			current.next = node1;
		}

		if (node2 != null) {
			current.next = node2;
		}

		return beforeHead.next;
	}
}