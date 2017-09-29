/*
	problem 234
	Given a singly linked list, determine if it is a palindrome.
	Follow up:
	Could you do it in O(n) time and O(1) space?
*/

public class PalindromeLinkedList {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public boolean isPalindrome(ListNode head) {
		int size = 0;
		ListNode currentNode = head;
		ListNode tail = null;
		while (currentNode != null) {
			ListNode temp = new ListNode(currentNode.val);
			temp.next = tail;
			tail = temp;
			size++;
			currentNode = currentNode.next;
		}

		for (int i = 0, len = (size + 1) / 2; i < len; i++) {
			if (head.val != tail.val) {
				return false;
			}
			head = head.next;
			tail = tail.next;
		}
		return true;
	}
	private ListNode node;

	public boolean isPalindrome2(ListNode head) {
		node = head;
		return isPalindromeHelper(head);
	}

	public boolean isPalindromeHelper(ListNode tail) {
		if (tail == null) {
			return true;
		}

		boolean isPalindrome = isPalindromeHelper(tail.next) && node.val == tail.val;
		node = node.next;
		return isPalindrome;
	}

	public boolean isPalindrome3(ListNode head) {
		ListNode slow = head, fast = head, tail = null;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		while (slow != null) {
			ListNode temp = slow.next;
			slow.next = tail;
			tail = slow;
			slow = temp;
		}

		while(tail != null){
			if(tail.val != head.val){
				return false;
			}
			tail = tail.next;
			head = head.next;
		}

		return true;
	}
}