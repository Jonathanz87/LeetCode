/*
	problem 24
	Given a linked list, swap every two adjacent nodes and return its head.

	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.

	Your algorithm should use only constant space. 
	You may not modify the values in the list, 
	only nodes itself can be changed.
*/

public class SwapNodesinPairs{

	static public void main(String[] args){
		int len = args[0].length();
		ListNode beforeHead = new ListNode(0);
		ListNode tail = beforeHead;

		for(int i = 0; i < len; i++){
			tail.next = new ListNode(Character.getNumericValue(args[0].charAt(i)));
			tail = tail.next;
		}

		ListNode temp = swapPairs(beforeHead.next);
		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// Definition for singly-linked list.
	static public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	static public ListNode swapPairs(ListNode head) {
		ListNode beforeHead = new ListNode(0);
		beforeHead.next = head;
		head = beforeHead;
		ListNode first, second;

		while(	(first = head.next) != null && 
				(second = head.next.next) != null){
			head.next = second;
			first.next = second.next;
			second.next = first;
			head = first;
		}

		return beforeHead.next;
	}
}