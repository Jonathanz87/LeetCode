/*
	problem 2
	You are given two non-empty linked lists representing two non-negative integers.
	The digits are stored in reverse order and each of their nodes contain a single digit.
	Add the two numbers and return it as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
*/

public class AddTwoNumbers{
	public static void main(String[] args){

	}

	// Definition for singly-linked list.
	static private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode beforeHead = new ListNode(0);
		ListNode tail = beforeHead;
		int digit = 0;

		while(l1 != null && l2 != null){
			digit = l1.val + l2.val + digit;
			tail.next = new ListNode(digit % 10);
			tail = tail.next;
			l1 = l1.next;
			l2 = l2.next;
			digit /= 10;
		}

		while(digit == 1){
			if(l1 != null){
				digit = l1.val + digit;
				tail.next = new ListNode(digit % 10);
				tail = tail.next;
				l1 = l1.next;
				digit /= 10;
			}else if(l2 != null){
				digit = l2.val + digit;
				tail.next = new ListNode(digit % 10);
				tail = tail.next;
				l2 = l2.next;
				digit /= 10;
			}else{
				tail.next = new ListNode(digit);
				digit = 0;
			}
		}

		while(l1 != null){
			tail.next = new ListNode(l1.val );
			tail = tail.next; 
			l1 = l1.next;
		}

		while(l2 != null){
			tail.next = new ListNode(l2.val );
			tail = tail.next; 
			l2 = l2.next;
		}
		return beforeHead.next;

	}
}