/*
	problem 234
	Given a singly linked list, determine if it is a palindrome.
	Follow up:
	Could you do it in O(n) time and O(1) space?
*/

public class PalindromeLinkedList{
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
		while(currentNode != null){
			ListNode temp = new ListNode(currentNode.val);
			temp.next = tail;
			tail = temp;
			size++;
		}

		for(int i = 0, len = (size + 1) / 2; i < len; i++){
			if(head.val != tail.val){
				return false;
			}
			head = head.next;
			tail = tail.next;
		}
		return true;
	}
}