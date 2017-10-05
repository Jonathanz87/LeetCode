/*
	problem 143
	Given a singly linked list L: L0, L1, …Ln-1, Ln,
	reorder it to: L0, Ln, L1, Ln-1, L2, Ln-2…
	You must do this in-place without altering the nodes' values.
	For example,
		Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

/*
	solution 3 steps
	1. find middle of the linked list
	2. reverse the second half of the linked list
	3. reorder the list
*/
public class ReorderList {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};

		ListNode head = new ListNode(nums[0]);
		ListNode current = head;
		for (int i = 1; i < nums.length; i++) {
			ListNode temp = new ListNode(nums[i]);
			current.next = temp;
			current = temp;
		}

		reorderList(head);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}
	// Definition for singly - linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null) return;
		ListNode slow = head;
		ListNode fast = head;
		ListNode beforeSlow = null;
		while (fast != null && fast.next != null) {
			beforeSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		beforeSlow.next = null;

		ListNode secondHead = null;
		while (slow != null) {
			ListNode next = slow.next;
			slow.next = secondHead;
			secondHead = slow;
			slow = next;
		}

		ListNode beforeHead = new ListNode(0);
		while (head != null) {
			ListNode t1 = head.next;
			ListNode t2 = secondHead.next;

			beforeHead.next = head;
			head.next = secondHead;
			beforeHead = secondHead;
			head = t1;
			secondHead = t2;
		}
	}
}