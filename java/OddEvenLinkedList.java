/*
	problem 328
	Given a singly linked list,
	group all odd nodes together followed by the even nodes.
	Please note here we are talking about the node number and not the value in the nodes.
	You should try to do it in place.
	The program should run in O(1) space complexity and O(nodes) time complexity.
	Example:
		Given 1->2->3->4->5->NULL,
		return 1->3->5->2->4->NULL.
	Note:
		The relative order inside both the even and odd groups should remain as it was in the input.
		The first node is considered odd, the second node even and so on ...
*/

public class OddEvenLinkedList {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;

        while(evenTail != null && evenTail.next != null) {
        	oddTail.next = oddTail.next.next;
        	oddTail = oddTail.next;
        	evenTail.next = evenTail.next.next;
        	evenTail = evenTail.next;
        }

        oddTail.next = evenHead;
        return head;
    }
}