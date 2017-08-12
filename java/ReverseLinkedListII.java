/*
	problem 92
	Reverse a linked list from position m to n.
	Do it in-place and in one-pass.
	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	return 1->4->3->2->5->NULL.
	Note:
	Given m, n satisfy the following condition:
	1 ? m ? n ? length of list.
*/

public class ReverseLinkedListII{
	public static void main(String[] args){
		ListNode beforeHead = new ListNode(0);
		ListNode node = beforeHead;
		for(int i = 0; i < args[0].length(); i++){
			ListNode temp = new ListNode(args[0].charAt(i) - '0');
			node.next = temp;
			node = node.next;
		}

		node = reverseBetween2(beforeHead.next, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		while(node != null){
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		final int SIZE = n - m + 1;
		if(SIZE < 2){
			return head;
		}
		ListNode[] nodeStack = new ListNode[SIZE];
		ListNode beforeHead = new ListNode(0);
		ListNode tail = null;
		beforeHead.next = head;
		head = beforeHead;
		int nodeIndex = 0;

		for(int i = 0, len = m - 1; i < len; i++){
			head = head.next;
		}
		tail = head;

		while(nodeIndex < SIZE){
			nodeStack[nodeIndex++] = tail.next;
			tail = tail.next;
		}
		tail = tail.next;

		while(--nodeIndex >= 0){
			head.next = nodeStack[nodeIndex];
			head = head.next;
		}

		head.next = tail;

		return beforeHead.next;
	}

	public static ListNode reverseBetween2(ListNode head, int m, int n) {
		ListNode beforeHead = new ListNode(0);
		ListNode tail = null, pre = null, last = null;
		beforeHead.next = head;
		head = beforeHead;

		for(int i = 0, len = m - 1; i < len; i++){
			head = head.next;
		}
		last = head.next;
		pre = head.next;
		for(int i = 0, len = n - m + 1; i < len; i++){
			ListNode temp = pre.next;
			pre.next = tail;
			tail = pre;
			pre = temp;
		}
		head.next = tail;
		last.next = pre;

		return beforeHead.next;
	}

	//Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}