/*
	problem 142
	Given a linked list, return the node where the cycle begins.
	If there is no cycle, return null.
	Note: Do not modify the linked list.
	Follow up:
	Can you solve it without using extra space?
*/

/*
	solution
			a          b
		A ------ B --------+
		         |         |
		       c |         |
		         +-------- C

		* A: 起始点
		* B: Cycle Begins
		* C: 1st 快慢指针相遇点
		* 环的长度 (b+c) = R
		第一次相遇时，慢指针所走步数为
		a + b
		快指针走的步数为
		a + b + nR
		我们知道快指针是慢指针速度的2倍，因此
		2(a + b) = a + b + nR
		那么
		a + b = nR
		同时
		b + c = R
		所以
		a = (n - 1)R + c;
		也就是说，从A点和C点同时出发，以相同的速度前进，那么下一次相遇的位置将是B。
*/

public class LinkedListCycleII {
	//Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode slow2 = head;
				while (slow != slow2) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow;
			}
		}

		return null;
	}

}