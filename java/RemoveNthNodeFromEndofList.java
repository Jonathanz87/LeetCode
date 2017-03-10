/*
	problem 19
	Given a linked list, remove the nth node from the end of list and return its head.

	For example,
		Given linked list: 1->2->3->4->5, and n = 2.
		After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	Given n will always be valid.
	Try to do this in one pass.
*/

public class RemoveNthNodeFromEndofList{
	static public void main(String[] args){

	}

	// Definition for singly-linked list.
	static private class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	static public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode faster = head, slower = head;
		for(int i = 0; i < n; i++){
			faster = faster.next;
		}

		if(faster == null){
			return head.next;
		}

		while(faster.next != null){
			faster = faster.next;
			slower = slower.next;
		}

		slower.next = slower.next.next;
		return head;
	}
}