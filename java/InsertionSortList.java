/*
	problem 147
	Sort a linked list using insertion sort.
*/

public class InsertionSortList {
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);

		head = insertionSortList(head);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	//Definition for singly - linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode insertionSortList(ListNode head) {
		ListNode beforeHead = new ListNode(0);

		while (head != null) {
			ListNode current = beforeHead;
			ListNode temp = head;
			head = head.next;
			temp.next = null;
			while (current.next != null && current.next.val < temp.val) {
				current = current.next;
			}
			temp.next = current.next;
			current.next = temp;
		}
		return beforeHead.next;
	}
}