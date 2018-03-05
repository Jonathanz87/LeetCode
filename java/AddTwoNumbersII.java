/*
	problem 445
	You are given two non-empty linked lists representing two non-negative integers.
	The most significant digit comes first and each of their nodes contain a single digit.
	Add the two numbers and return it as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	Follow up:
		What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
	Example:
		Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
		Output: 7 -> 8 -> 0 -> 7
*/

import java.util.Stack;

public class AddTwoNumbersII {
	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();

		while (l1 != null) {
			stack1.push(l1);
			l1 = l1.next;
		}

		while (l2 != null) {
			stack2.push(l2);
			l2 = l2.next;
		}

		int carry = 0;
		ListNode node = null;
		while (!stack1.empty() && !stack2.empty()) {
			int n = stack1.pop().val + stack2.pop().val + carry;
			carry = n / 10;
			ListNode temp = new ListNode(n % 10);
			temp.next = node;
			node = temp;
		}

		while (!stack1.empty()) {
			int n = stack1.pop().val + carry;
			carry = n / 10;
			ListNode temp = new ListNode(n % 10);
			temp.next = node;
			node = temp;
		}

		while (!stack2.empty()) {
			int n = stack2.pop().val + carry;
			carry = n / 10;
			ListNode temp = new ListNode(n % 10);
			temp.next = node;
			node = temp;
		}

		if(carry > 0){
			ListNode temp = new ListNode(1);
			temp.next = node;
			node = temp;
		}

		return node;
	}
}
