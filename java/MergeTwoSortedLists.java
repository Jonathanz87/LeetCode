/*
	problem 21
	Merge two sorted linked lists and return it as a new list. 
	The new list should be made by splicing together the nodes of the first two lists.
*/

public class MergeTwoSortedLists{
	static public void main(String[] args){

	}

	// Definition for singly-linked list.
	static public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode beforeHead = new ListNode(0);
		ListNode cursor = beforeHead;

		while (l1 != null && l2 != null){
			if(l1.val < l2.val){
				cursor.next = l1;
				l1 = l1.next;
			}else{
				cursor.next = l2;
				l2 = l2.next;
			}
			cursor = cursor.next;
		}

		cursor.next = l1 != null ? l1 : l2;

		return beforeHead.next;
	}
}