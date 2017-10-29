/*
	problem 82
	Given a sorted linked list,
	delete all nodes that have duplicate numbers,
	leaving only distinct numbers from the original list.
	For example,
		Given 1->2->3->3->4->4->5, return 1->2->5.
		Given 1->1->1->2->3, return 2->3.
*/

public class RemoveDuplicatesFromSortedListII {
	public static void main(String[] args) {
		ListNode beforeHead = new ListNode(0);
		ListNode current = beforeHead;
		for (String num : args) {
			ListNode node = new ListNode(Integer.parseInt(num));
			current.next = node;
			current = current.next;
		}

		ListNode node = deleteDuplicates(beforeHead.next);

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	//Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode beforeHead = new ListNode(0);
		ListNode current = beforeHead;
		beforeHead.next = head;

		while (current.next != null && current.next.next != null) {
			if (current.next.val != current.next.next.val) {
				current = current.next;
			} else {
				ListNode duplicate = current.next.next;
				do {
					duplicate = duplicate.next;
				} while (duplicate != null && duplicate.val == current.next.val);

				current.next = duplicate;
			}
		}

		return beforeHead.next;
	}


}