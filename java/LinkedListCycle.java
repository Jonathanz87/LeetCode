/*
	problem 141
	Given a linked list, determine if it has a cycle in it.
	Follow up:
	Can you solve it without using extra space?
*/

public class LinkedListCycle{

	public static void main(String[] args){

	}

	// Definition for singly-linked list.
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static boolean hasCycle(ListNode head){
		ListNode tracker = head;

		do{
			if(head == null || head.next == null){
				return false;
			}
			head = head.next.next;
			tracker = tracker.next;
		}while (head != tracker);

		return true;
	}
}